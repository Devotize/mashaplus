package com.sychev.mashaplus.pages.main.widgets

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.widgets.SliderSimpleArrow
import com.sychev.mashaplus.models.testimonials
import com.sychev.mashaplus.utils.fadeInAnimation
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.mdi.MdiStar
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div

private val MainPhotoHeightBase = 320.px
private val MainPhotoHeightLG = 1026.px
private val MainPhotoWidthLG = 1078.px
private val SliderPhotoHeightBase = 380.px
private val SliderPhotoHeightLG = 620.px
private val SectionPhotoHeightBase = 245.px
private val SectionPhotoHeightLG = 490.px
private val SectionPhotoWidthBase = 345.px
val SectionPhotoWidthMD = 690.px

val SectionPhotoStyle by ComponentStyle {
    base {
        Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover)
            .borderRadius(0.9.cssRem, 0.9.cssRem)
    }
    Breakpoint.LG {
        Modifier.height(SectionPhotoHeightLG).width(SectionPhotoWidthMD).objectFit(ObjectFit.Cover)
            .borderRadius(0.9.cssRem, 0.9.cssRem)
    }
}

val MainPhotoStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover) }
    Breakpoint.LG { Modifier.width(MainPhotoWidthLG).height(MainPhotoHeightLG).objectFit(ObjectFit.Cover) }
}

val SecondaryPhotoStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover) }
    Breakpoint.LG {
        Modifier.fillMaxWidth().height(MainPhotoHeightLG).objectFit(ObjectFit.Cover)
            .padding(leftRight = XXXLargePadding)
    }
}

val BottomPhotoGradientStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Fill) }
    Breakpoint.LG { Modifier.fillMaxWidth().height(MainPhotoHeightLG).objectFit(ObjectFit.Fill) }
}

val SliderPhotoStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(SliderPhotoHeightBase)
            .objectFit(ObjectFit.Cover)
            .backgroundSize(BackgroundSize.Cover)
    }
    Breakpoint.LG { Modifier.fillMaxWidth().height(SliderPhotoHeightLG).objectFit(ObjectFit.Cover) }
}

val GridPhotoStyle by ComponentStyle.base {
    Modifier
        .width(375.px)
        .height(399.px)
        .objectFit(ObjectFit.Cover)
        .backgroundSize(BackgroundSize.Inherit)
}

val carouselPhotoWidth = 285.px
val carouselPhotoHeight = 365.px

val CarouselPhotoStyle by ComponentStyle.base {
    Modifier
        .width(carouselPhotoWidth)
        .height(carouselPhotoHeight)
        .objectFit(ObjectFit.ScaleDown)
        .backgroundSize(BackgroundSize.Cover)
}

@Composable
fun TestimonialsSection(modifier: Modifier = Modifier) {
    val palette = ColorMode.current.toSitePalette()
    val breakpoint = rememberBreakpoint()
    val sidePadding = if (breakpoint > Breakpoint.LG) {
        XXXXLargePadding
    } else {
        XXXXSmallPadding
    }
    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Div(HeadlineTextStyle.toAttrs()) {
            SpanText(
                "Отзывы",
                modifier = Modifier
                    .color(palette.brand.text)
                    .fadeInAnimation()
            )
        }
        Box(Modifier.height(LargePadding))
        Div(SectionTitleStyle.toAttrs()) {
            SpanText(
                "Посмотрите, что говорят люди!",
                modifier = Modifier
                    .color(palette.brand.text)
                    .fadeInAnimation()
            )
        }
        Box(Modifier.height(XXLargePadding))
        SliderSimpleArrow(
            modifier = Modifier.fillMaxWidth().padding(leftRight = sidePadding),
            items = testimonials,
            hasDotsIndicator = false
        ) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Div(ModalDescriptionTextStyleCentered.toAttrs()) {
                    SpanText(
                        it.text,
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(XXXLargePadding))
                Row {
                    repeat(5) {
                        MdiStar(Modifier.size(24.px).fadeInAnimation())
                    }
                }
                Box(Modifier.height(XXXSmallPadding))
                Div(ModalDescriptionTextStyleCentered.toAttrs()) {
                    SpanText(
                        it.name,
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
            }
        }
    }
}