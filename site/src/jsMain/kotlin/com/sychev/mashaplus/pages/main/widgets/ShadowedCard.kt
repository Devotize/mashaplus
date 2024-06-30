package com.sychev.mashaplus.pages.main.widgets

import androidx.compose.runtime.*
import com.sychev.mashaplus.DesignShadow
import com.sychev.mashaplus.DesignSurface
import com.sychev.mashaplus.XXSmallPadding
import com.sychev.mashaplus.components.widgets.Card
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun ShadowedCard(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    paddingValues: CSSLengthOrPercentageValue = XXSmallPadding,
    borderRadius: CSSLengthOrPercentageValue = 2.7.vh,
    content: @Composable () -> Unit,
) {
    var showBackgroundShadow by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .onMouseEnter { showBackgroundShadow = true }
            .onMouseLeave { showBackgroundShadow = false }
            .boxShadow(
                offsetX = 1.px,
                offsetY = 1.px,
                blurRadius = 5.px,
                spreadRadius = 5.px,
                color = if (showBackgroundShadow) DesignShadow else Colors.Transparent
            ),
        color = DesignSurface,
        paddingValues = paddingValues,
        contentAlignment = contentAlignment,
        borderRadius = borderRadius,
    ) {
        content.invoke()
    }
}