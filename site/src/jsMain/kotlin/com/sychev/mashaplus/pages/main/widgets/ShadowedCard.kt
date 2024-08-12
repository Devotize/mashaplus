package com.sychev.mashaplus.pages.main.widgets

import androidx.compose.runtime.*
import com.sychev.mashaplus.DesignShadow
import com.sychev.mashaplus.DesignSurface
import com.sychev.mashaplus.DesignWhiteText
import com.sychev.mashaplus.XXSmallPadding
import com.sychev.mashaplus.components.widgets.Card
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import org.jetbrains.compose.web.css.CSSLengthOrPercentageValue
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.w3c.dom.HTMLElement

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

@Composable
fun ShadowedLink(
    path: String,
    modifier: Modifier = Modifier,
    openInternalLinksStrategy: OpenLinkStrategy? = null,
    openExternalLinksStrategy: OpenLinkStrategy? = null,
    ref: ElementRefScope<HTMLElement>? = null,
    content: @Composable () -> Unit
) {
    var showBackgroundShadow by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .backgroundColor(if (showBackgroundShadow) DesignShadow else Colors.Transparent),
    ) {
        Link(
            path = path,
            variant = UndecoratedLinkVariant,
            modifier = modifier
                .color(DesignWhiteText)
                .onMouseEnter { showBackgroundShadow = true }
                .onMouseLeave { showBackgroundShadow = false }
                .boxShadow(
                    offsetX = 1.px,
                    offsetY = 1.px,
                    blurRadius = 5.px,
                    spreadRadius = 5.px,
                    color = if (showBackgroundShadow) DesignShadow else Colors.Transparent
                ),
            openInternalLinksStrategy = openInternalLinksStrategy,
            openExternalLinksStrategy = openExternalLinksStrategy,
            ref = ref
        ) {
            content.invoke()
        }
    }
}