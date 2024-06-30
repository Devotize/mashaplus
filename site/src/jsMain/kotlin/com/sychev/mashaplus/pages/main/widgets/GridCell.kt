package com.sychev.mashaplus.pages.main.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gridItem
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.dom.Div

val HomeGridCellStyle by ComponentStyle.base {
    Modifier
}

@Composable
fun GridCell(
    row: Int,
    column: Int,
    width: Int? = null,
    height: Int? = null,
    zIndex: Int = 1,
    content: @Composable () -> Unit,
) {
    Div(
        HomeGridCellStyle.toModifier()
            .zIndex(zIndex)
            .gridItem(row, column, width, height)
            .toAttrs()
    ) {
        content.invoke()
    }
}