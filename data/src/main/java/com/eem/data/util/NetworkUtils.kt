package com.eem.data.util

import com.eem.data.source.ApiConfig.IMAGES_ORIGINAL_BASE_URL

/**
 * Converts a nullable [String] representing an image path into a full image URL
 * by appending it to the [IMAGES_ORIGINAL_BASE_URL].
 *
 * If the string is `null`, the resulting URL will include the literal `"null"` string.
 * It's recommended to check for null before using this method if that behavior is undesired.
 *
 * @return The full image URL as a [String].
 */
fun String?.toImageData(): String {
    return IMAGES_ORIGINAL_BASE_URL.plus(this)
}
