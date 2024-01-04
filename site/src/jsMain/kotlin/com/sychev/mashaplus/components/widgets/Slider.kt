package com.sychev.mashaplus.components.widgets

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiKeyboardArrowLeft
import com.varabyte.kobweb.silk.components.icons.mdi.MdiKeyboardArrowRight
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val DotsIndicatorStyle by ComponentStyle {
    base { Modifier.size(12.px) }
    Breakpoint.LG { Modifier.size(18.px) }
}

@Composable
inline fun <reified T> Slider(
    modifier: Modifier = Modifier,
    items: List<T>,
    crossinline content: @Composable (T) -> Unit,
) {
    val sitePalette = ColorMode.current.toSitePalette()
    var selectedIndex by remember { mutableStateOf(0) }
    LaunchedEffect(selectedIndex) {
        //TODO
    }
    key(selectedIndex) {
        Box(modifier = modifier) {
            items.getOrNull(selectedIndex)?.let {
                content(it)
            }
            Box(Modifier.padding(left = MediumPadding).align(Alignment.CenterStart)) {
                Box(
                    modifier = Modifier
                        .borderRadius(100.percent, 100.percent)
                        .background(sitePalette.brand.background)
                        .opacity(0.9f)
                        .padding(XXXXSmallPadding)
                        .onClick {
                            if (selectedIndex == 0) {
                                selectedIndex = items.lastIndex
                            } else {
                                selectedIndex--
                            }
                        }
                ) {
                    MdiKeyboardArrowLeft()
                }
            }
            Box(Modifier.padding(right = MediumPadding).align(Alignment.CenterEnd)) {
                Box(
                    modifier = Modifier
                        .borderRadius(100.percent, 100.percent)
                        .background(sitePalette.brand.background)
                        .opacity(0.9f)
                        .padding(XXXXSmallPadding)
                        .onClick {
                            if (selectedIndex == items.lastIndex) {
                                selectedIndex = 0
                            } else {
                                selectedIndex++
                            }
                        }
                ) {
                    MdiKeyboardArrowRight()
                }
            }
            Row(modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 1.1.cssRem).paddingInline { }) {
                items.forEachIndexed { index, _ ->
                    val selected = index == selectedIndex
                    Box(
                        modifier = DotsIndicatorStyle.toModifier()
                            .borderRadius(100.percent, 100.percent)
                            .border(1.px, style = LineStyle.Solid, color = DesignWhiteText)
                            .background(
                                if (selected) Colors.White else Colors.Transparent
                            )
                            .onClick {
                                selectedIndex = index
                            }
                    )
                    Box(Modifier.width(XXSmallPadding))
                }
            }
        }
    }
}