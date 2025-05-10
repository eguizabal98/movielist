package com.eem.movielist

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MovieList : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}
