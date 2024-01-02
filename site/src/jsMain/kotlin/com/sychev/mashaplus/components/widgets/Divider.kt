package com.sychev.mashaplus.components.widgets

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.LargePadding
import com.sychev.mashaplus.toSitePalette
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun Divider(width: CSSLengthOrPercentageValue) {
    Box(
        modifier = Modifier
            .width(width)
            .height(1.px)
            .borderRadius(0.5.cssRem, 0.5.cssRem)
            .backgroundColor(ColorMode.current.toSitePalette().brand.greyText)
            .padding(leftRight = LargePadding)
    )
}