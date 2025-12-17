package com.example.petshopapptp3.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


enum class PhoneSize { Small, Normal, Large }

data class PhoneDimens(

    val pad: Dp,
    val topBarPad: Dp,
    val gap: Dp,
    val gapLg: Dp,


    val inputHeight: Dp,
    val buttonHeight: Dp,


    val cardRadius: Dp,
    val cardPad: Dp,


    val iconSize: Dp
)

@Composable
fun rememberPhoneSize(): PhoneSize {
    val cfg = LocalConfiguration.current
    val w = cfg.screenWidthDp
    val h = cfg.screenHeightDp


    return when {
        w <= 360 || h <= 640 -> PhoneSize.Small
        w >= 411 && h >= 800 -> PhoneSize.Large
        else -> PhoneSize.Normal
    }
}

@Composable
fun rememberPhoneDimens(): PhoneDimens {
    val size = rememberPhoneSize()
    return remember(size) {
        when (size) {
            PhoneSize.Small -> PhoneDimens(
                pad = 12.dp,
                topBarPad = 8.dp,
                gap = 8.dp,
                gapLg = 12.dp,
                inputHeight = 48.dp,
                buttonHeight = 48.dp,
                cardRadius = 14.dp,
                cardPad = 10.dp,
                iconSize = 20.dp
            )

            PhoneSize.Normal -> PhoneDimens(
                pad = 16.dp,
                topBarPad = 12.dp,
                gap = 12.dp,
                gapLg = 16.dp,
                inputHeight = 52.dp,
                buttonHeight = 52.dp,
                cardRadius = 16.dp,
                cardPad = 12.dp,
                iconSize = 22.dp
            )

            PhoneSize.Large -> PhoneDimens(
                pad = 20.dp,
                topBarPad = 16.dp,
                gap = 14.dp,
                gapLg = 18.dp,
                inputHeight = 56.dp,
                buttonHeight = 56.dp,
                cardRadius = 18.dp,
                cardPad = 14.dp,
                iconSize = 24.dp
            )
        }
    }
}
