package com.eem.movielist.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography =
    Typography(
        titleMedium =
            TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
            ),
        bodyMedium =
            TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            ),
        labelSmall =
            TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
            ),
    )
