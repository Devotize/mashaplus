package com.sychev.mashaplus.components.widgets

import androidx.compose.runtime.*
import com.sychev.mashaplus.DesignWhiteText
import com.sychev.mashaplus.XXSmallPadding
import com.sychev.mashaplus.pages.main.widgets.ArrowImageStyle
import com.sychev.mashaplus.utils.Resources
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

val DotsIndicatorStyle by ComponentStyle {
    base { Modifier.size(12.px) }
    Breakpoint.LG { Modifier.size(18.px) }
}

@Composable
fun <T> SliderSimpleArrow(
    modifier: Modifier = Modifier,
    items: List<T>,
    hasDotsIndicator: Boolean = true,
    leftArrow: (@Composable () -> Unit)? = null,
    rightArrow: (@Composable () -> Unit)? = null,
    content: @Composable (T, index: Int) -> Unit,
) {
    var selectedIndex by remember { mutableStateOf(0) }
    var leftEnter by remember { mutableStateOf(false) }
    var rightEnter by remember { mutableStateOf(false) }
    Box(modifier = modifier) {
        key(selectedIndex) {
            items.getOrNull(selectedIndex)?.let {
                content(it, selectedIndex)
            }
        }
        Row(Modifier.fillMaxWidth().align(Alignment.Center)) {
            Box(
                Modifier
                    .zIndex(3)
                    .onMouseEnter { leftEnter = true }
                    .onMouseLeave { leftEnter = false }
                    .onClick {
                        if (selectedIndex == 0) {
                            return@onClick
                        } else {
                            selectedIndex--
                        }
                    }) {
                leftArrow?.invoke() ?: Image(
                    if (selectedIndex > 0 && leftEnter) Resources.Images.arrow_left_painted else Resources.Images.arrow_left,
                    "Main photo",
                    ArrowImageStyle
                        .toModifier()
                )
            }
            Spacer()
            Box(Modifier
                .zIndex(3)
                .onMouseEnter { rightEnter = true }
                .onMouseLeave { rightEnter = false }
                .onClick {
                    if (selectedIndex == items.lastIndex) {
                        return@onClick
                    } else {
                        selectedIndex++
                    }
                }) {
                rightArrow?.invoke() ?: Image(
                    if (selectedIndex < items.lastIndex && rightEnter) Resources.Images.arrow_right_painted else Resources.Images.arrow_right,
                    "Main photo",
                    ArrowImageStyle
                        .toModifier()
                )
            }
        }
        if (hasDotsIndicator) {
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