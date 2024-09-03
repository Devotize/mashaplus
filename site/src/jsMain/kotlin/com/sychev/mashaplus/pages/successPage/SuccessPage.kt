package com.sychev.mashaplus.pages.successPage

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.pages.successPage.desktop.SuccessPageDesktop
import com.varabyte.kobweb.core.Page
import kotlinx.browser.window

@Page("/success")
@Composable
fun SuccessPage() {
    when (window.innerWidth) {
        in (1280..Int.MAX_VALUE) -> {
            SuccessPageDesktop()
        }

        in (800..1280) -> {
            SuccessPageDesktop()
        }

        in (500..800) -> {
            SuccessPageDesktop()
        }

        else -> {
            SuccessPageDesktop()
        }
    }
}