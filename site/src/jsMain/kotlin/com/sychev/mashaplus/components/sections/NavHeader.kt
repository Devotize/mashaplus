package com.sychev.mashaplus.components.sections

import androidx.compose.runtime.*
import com.sychev.mashaplus.NavigationHeadlineTextStyle
import com.sychev.mashaplus.components.widgets.IconButton
import com.sychev.mashaplus.pages.LogoStyleSmall
import com.sychev.mashaplus.provider.ScrollToViewEventProvider
import com.sychev.mashaplus.toSitePalette
import com.sychev.mashaplus.utils.Resources
import com.sychev.mashaplus.utils.fadeInAnimation
import com.sychev.mashaplus.utils.stubAnimation
import com.varabyte.kobweb.compose.css.functions.clamp
import com.varabyte.kobweb.compose.dom.ElementTarget
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.CloseIcon
import com.varabyte.kobweb.silk.components.icons.HamburgerIcon
import com.varabyte.kobweb.silk.components.icons.MoonIcon
import com.varabyte.kobweb.silk.components.icons.SunIcon
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.navigation.UndecoratedLinkVariant
import com.varabyte.kobweb.silk.components.overlay.Overlay
import com.varabyte.kobweb.silk.components.overlay.OverlayVars
import com.varabyte.kobweb.silk.components.overlay.PopupPlacement
import com.varabyte.kobweb.silk.components.overlay.Tooltip
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

val NavHeaderStyle by ComponentStyle.base {
    Modifier.fillMaxWidth().padding(1.cssRem)
}

@Composable
private fun NavLink(path: String, text: String) {
    Link(
        path,
        text,
        variant = UndecoratedLinkVariant.then(UncoloredLinkVariant),
        modifier = Modifier.color(Color.white)
    )
}

@Composable
private fun MenuItems() {
    NavLink("/", "Home")
    NavLink("/about", "About")
}

@Composable
private fun ColorModeButton() {
    var colorMode by ColorMode.currentState
    IconButton(onClick = { colorMode = colorMode.opposite }) {
        if (colorMode.isLight) MoonIcon(Modifier.color(Color.white).zIndex(2)) else SunIcon(
            (Modifier.color(Color.white).zIndex(2))
        )
    }
    Tooltip(ElementTarget.PreviousSibling, "Toggle color mode", placement = PopupPlacement.BottomRight)
}

@Composable
private fun HamburgerButton(onClick: () -> Unit) {
    IconButton(onClick) {
        HamburgerIcon(Modifier.color(Color.white))
    }
}

@Composable
private fun CloseButton(onClick: () -> Unit) {
    IconButton(onClick) {
        CloseIcon()
    }
}

val SideMenuSlideInAnim by Keyframes {
    from {
        Modifier.translateX((-100).percent)
    }

    to {
        Modifier
    }
}

// Note: When the user closes the side menu, we don't immediately stop rendering it (at which point it would disappear
// abruptly). Instead, we start animating it out and only stop rendering it when the animation is complete.
enum class SideMenuState {
    CLOSED,
    OPEN,
    CLOSING;

    fun close() = when (this) {
        CLOSED -> CLOSED
        OPEN -> CLOSING
        CLOSING -> CLOSING
    }
}

@Composable
fun NavHeader() {
    val palette = ColorMode.current.toSitePalette()
    Row(
        NavHeaderStyle.toModifier().fillMaxWidth().zIndex(2),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fontSize(1.5.cssRem)
                .gap(1.cssRem)
                .displayUntil(Breakpoint.LG)
                .stubAnimation(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var menuState by remember { mutableStateOf(SideMenuState.CLOSED) }

            if (menuState != SideMenuState.CLOSED) {
                SideMenu(
                    menuState,
                    close = { menuState = menuState.close() },
                    onAnimationEnd = { if (menuState == SideMenuState.CLOSING) menuState = SideMenuState.CLOSED }
                )
            }
            Row(
                Modifier.width(100.percent),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer()
                Div(NavigationHeadlineTextStyle.toAttrs()) {
                    SpanText(
                        "8 (931) 951-20-00",
                        modifier = Modifier
                            .color(palette.brand.whiteText)
                            .fadeInAnimation(),
                    )
                }
            }

        }

        Row(
            modifier = Modifier
                .gap(4.5.cssRem)
                .fillMaxWidth()
                .displayIfAtLeast(Breakpoint.LG),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                Modifier.gap(1.7.cssRem).weight(4),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
            ) {
                Link(
                    path = "",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    ref = ref { element ->
                        element.onclick = {
                            ScrollToViewEventProvider.sendContactsScrollEvent()
                        }
                    }) {
                    Div(NavigationHeadlineTextStyle.toAttrs()) {
                        SpanText(
                            "Контакты",
                            modifier = Modifier
                                .color(palette.brand.whiteText)
                                .fadeInAnimation(),
                        )
                    }
                }
                Link(
                    path = "",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    ref = ref { element ->
                        element.onclick = {
                            ScrollToViewEventProvider.sendVocalistScrollEvent()
                        }
                    }) {
                    Div(NavigationHeadlineTextStyle.toAttrs()) {
                        SpanText(
                            "Вокалист",
                            modifier = Modifier
                                .color(palette.brand.whiteText)
                                .fadeInAnimation()
                        )
                    }
                }
                Link(
                    path = "",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    ref = ref { element ->
                        element.onclick = {
                            ScrollToViewEventProvider.sendDuetScrollEvent()
                        }
                    }) {
                    Div(NavigationHeadlineTextStyle.toAttrs()) {
                        SpanText(
                            "Дуэт",
                            modifier = Modifier
                                .color(palette.brand.whiteText)
                                .fadeInAnimation()
                        )
                    }
                }
                Link(
                    path = "",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    ref = ref { element ->
                        element.onclick = {
                            ScrollToViewEventProvider.sendVocalShowScrollEvent()
                        }
                    }) {
                    Div(NavigationHeadlineTextStyle.toAttrs()) {
                        SpanText(
                            "Вокальное шоу",
                            modifier = Modifier
                                .color(palette.brand.whiteText)
                                .fadeInAnimation()
                        )
                    }
                }
                Link(
                    path = "",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    ref = ref { element ->
                        element.onclick = {
                            ScrollToViewEventProvider.sendUltimaBandScrollEvent()
                        }
                    }) {
                    Div(NavigationHeadlineTextStyle.toAttrs()) {
                        SpanText(
                            "ULTIMA BAND",
                            modifier = Modifier
                                .color(palette.brand.whiteText)
                                .fadeInAnimation()
                        )
                    }
                }
                Link("https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg") {
                    Div(NavigationHeadlineTextStyle.toAttrs()) {
                        SpanText(
                            "Репертуар",
                            modifier = Modifier
                                .color(palette.brand.whiteText)
                                .fadeInAnimation()
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.gap(1.7.cssRem).weight(3),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Link("https://vk.com/masha_plus_band") {
                    val imgResVK = if (ColorMode.current.isDark) {
                        "/vk_logo.png"
                    } else {
                        "/vk_logo_black.png"
                    }
                    Image(
                        imgResVK,
                        "",
                        LogoStyleSmall
                            .toModifier(),
                    )
                }
                Link("https://instagram.com/masha_plus_band?igshid=OGQ5ZDc2ODk2ZA==") {
                    val imgResInst = if (ColorMode.current.isDark) {
                        "/inst_logo.png"
                    } else {
                        "/inst_logo_black.png"
                    }
                    Image(
                        imgResInst,
                        "",
                        LogoStyleSmall
                            .toModifier(),
                    )
                }
                Link(
                    "tel:+79319512000",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                ) {
                    val imgResInst = Resources.Images.ic_phone
                    Image(
                        imgResInst,
                        "",
                        LogoStyleSmall
                            .toModifier(),
                    )
                }
            }
        }
    }
}

@Composable
private fun SideMenu(menuState: SideMenuState, close: () -> Unit, onAnimationEnd: () -> Unit) {
    Overlay(
        Modifier
            .setVariable(OverlayVars.BackgroundColor, Colors.Transparent)
            .onClick { close() }
    ) {
        key(menuState) { // Force recompute animation parameters when close button is clicked
            Column(
                Modifier
                    .fillMaxHeight()
                    .width(clamp(8.cssRem, 33.percent, 10.cssRem))
                    .align(Alignment.CenterStart)
                    // Close button will appear roughly over the hamburger button, so the user can close
                    // things without moving their finger / cursor much.
                    .padding(top = 1.cssRem, leftRight = 1.cssRem)
                    .gap(1.5.cssRem)
                    .backgroundColor(ColorMode.current.toSitePalette().nearBackground)
                    .animation(
                        SideMenuSlideInAnim.toAnimation(
                            duration = 200.ms,
                            timingFunction = if (menuState == SideMenuState.OPEN) AnimationTimingFunction.EaseOut else AnimationTimingFunction.EaseIn,
                            direction = if (menuState == SideMenuState.OPEN) AnimationDirection.Normal else AnimationDirection.Reverse,
                            fillMode = AnimationFillMode.Forwards
                        )
                    )
                    .borderRadius(topRight = 2.cssRem)
                    .onClick { it.stopPropagation() }
                    .onAnimationEnd { onAnimationEnd() },
                horizontalAlignment = Alignment.Start
            ) {
                CloseButton(onClick = { close() })
                Column(
                    Modifier.padding(right = 0.75.cssRem).gap(1.5.cssRem).fontSize(1.4.cssRem),
                    horizontalAlignment = Alignment.Start
                ) {
                    MenuItems()
                }
            }
        }
    }
}
