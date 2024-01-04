package com.sychev.mashaplus.models

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint

private val mainPhotosBigScreen = listOf(
    "/main_photo_1.png",
    "/main_photo_2.png",
    "/main_photo_3.png",
    "/main_photo_6.png",
)

private val mainPhotosSmallScreen = listOf(
    "/main_photo_1.png",
    "/main_photo_2.png",
    "/main_photo_3.png",
    "/main_photo_4.png",
    "/main_photo_5.png",
    "/main_photo_6.png",
)

@Composable
fun getMainPhotos(): List<String> {
    val bp = rememberBreakpoint()
    return if (bp > Breakpoint.LG) {
        mainPhotosBigScreen
    } else {
        mainPhotosSmallScreen
    }
}