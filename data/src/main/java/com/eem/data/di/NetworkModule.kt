package com.eem.data.di

import com.eem.data.BuildConfig
import com.eem.data.api.MoviesApi
import com.google.gson.GsonBuilder
import com.google.gson.Strictness
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    @Named(BASIC_AUTH_INTERCEPTOR)
    fun providesHeaderInterceptor(): Interceptor {
        return Interceptor { chain ->
            val request = chain.request()
            val newRequest =
                request.newBuilder()
                    .addHeader("Authorization", "Bearer ${BuildConfig.API_READ_TOKEN}")
                    .build()
            chain.proceed(newRequest)
        }
    }

    @Provides
    @Singleton
    @Named(LOGGER_INTERCEPTOR)
    fun providesHttpLoggingInterceptor(): Interceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Provides
    @Singleton
    fun provideGsonBuilder(): GsonBuilder = GsonBuilder()

    @Provides
    @Singleton
    fun providesBaseClient(
        @Named(LOGGER_INTERCEPTOR)
        loggingInterceptor: Interceptor,
        @Named(BASIC_AUTH_INTERCEPTOR)
        basicAuthInterceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(basicAuthInterceptor)
            .followRedirects(false)
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun providesRetrofitClient(
        client: OkHttpClient,
        gsonBuilder: GsonBuilder,
    ): Retrofit {
        val gson = gsonBuilder.setStrictness(Strictness.LENIENT).create()

        return Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .callFactory { client.newCall(it) }
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit): MoviesApi = retrofit.create(MoviesApi::class.java)

    private const val TIMEOUT = 60L
    private const val LOGGER_INTERCEPTOR = "LOGGER_INTERCEPTOR"
    private const val BASIC_AUTH_INTERCEPTOR = "BASIC_AUTH_INTERCEPTOR"
}
