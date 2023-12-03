package com.sychev.mashaplus.components.widgets

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.*
import com.sychev.mashaplus.models.Vocalist
import com.sychev.mashaplus.pages.SliderPhotoStyle
import com.sychev.mashaplus.utils.fadeInAnimation
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

@Composable
fun VocalistWidget(
    title: String,
    vocalists: List<Vocalist>
) {
    val palette = ColorMode.current.toSitePalette()
    Row(modifier = Modifier.fillMaxWidth()) {
        Spacer()
        Div(HeadlineTextStyle.toAttrs()) {
            SpanText(
                title,
                modifier = Modifier
                    .color(palette.brand.text)
                    .fadeInAnimation()
            )
        }
        Spacer()
    }
    Box(Modifier.height(XXSmallPadding))
    Slider(
        modifier = Modifier.width(100.percent).padding(leftRight = XXLargePadding),
        items = vocalists
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                it.imgRes,
                modifier = SliderPhotoStyle.toModifier().borderRadius(0.5.cssRem, 0.5.cssRem)
            )
            Box(
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = XXXLargePadding)
            ) {
                Div(Headline2TextStyle.toAttrs()) {
                    SpanText(
                        it.name,
                        modifier = Modifier
                            .color(palette.brand.whiteText)
                            .fadeInAnimation()
                            .textShadow(
                                offsetY = 1.px,
                                offsetX = 1.px,
                                blurRadius = 2.px,
                                color = Colors.Black
                            )
                    )
                }
            }
        }
    }
}