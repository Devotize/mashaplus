package com.sychev.mashaplus.components.widgets

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.XXSmallPadding
import com.sychev.mashaplus.toSitePalette
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.cssRem

@Composable
fun Card(
    modifier: Modifier = Modifier,
    color: Color = ColorMode.current.toSitePalette().brand.surface,
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    paddingValues: CSSLengthOrPercentageValue = XXSmallPadding,
    borderRadius: CSSLengthOrPercentageValue = 1.5.cssRem,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .borderRadius(borderRadius, borderRadius)
            .backgroundColor(color)
    ) {
        Column(
            modifier = Modifier
                .padding(paddingValues),
            horizontalAlignment = contentAlignment,
        ) {
            content.invoke()
        }
    }

}