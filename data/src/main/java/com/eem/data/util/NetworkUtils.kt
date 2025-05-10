package com.eem.data.util

import com.eem.data.source.ApiConfig.IMAGES_ORIGINAL_BASE_URL

fun String?.toImageData(): String {
    return IMAGES_ORIGINAL_BASE_URL.plus(this)
}
