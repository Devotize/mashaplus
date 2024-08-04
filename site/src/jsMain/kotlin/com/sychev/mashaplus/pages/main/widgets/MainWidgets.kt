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
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

private val MainPhotoHeightBase = 320.px
private val MainPhotoHeightLG = 60.cssRem
private val MainPhotoWidthLG = 60.cssRem
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
    Breakpoint.SM {
        Modifier.width(22.cssRem).objectFit(ObjectFit.Cover)
    }
    Breakpoint.MD {
        Modifier.width(31.cssRem).objectFit(ObjectFit.Cover)
    }
    Breakpoint.LG {
        Modifier.width(42.cssRem).objectFit(ObjectFit.Cover)
    }
    Breakpoint.XL {
        Modifier.width(63.cssRem).objectFit(ObjectFit.Cover)
    }
}

val MainPhotoStyleMobile by ComponentStyle {
    base {
        Modifier.width(100.percent).objectFit(ObjectFit.Contain).scale(1.2f)
    }
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

val ClyaksImageStyle by ComponentStyle.base {
    Modifier
        .width(17.4.vw)
        .height(20.vh)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}
val ClyaksImageStyleMobile by ComponentStyle.base {
    Modifier
        .width(30.4.vw)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}
val Clyaks2ImageStyle by ComponentStyle.base {
    Modifier
        .width(276.px)
        .height(252.px)
        .objectFit(ObjectFit.Cover)
        .backgroundSize(BackgroundSize.Inherit)
}

val Clyaks2ImageLaptop by ComponentStyle.base {
    Modifier
        .width(176.px)
        .height(152.px)
        .objectFit(ObjectFit.Cover)
        .backgroundSize(BackgroundSize.Inherit)
}

val Clyaks2ImageStyleMobile by ComponentStyle.base {
    Modifier
        .width(176.px)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}

val ArrowImageStyle by ComponentStyle.base {
    Modifier
        .size(60.px)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}

val ArrowImageStyleMobile by ComponentStyle.base {
    Modifier
        .size(30.px)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}

val ArrowImageStyleLaptop by ComponentStyle.base {
    Modifier
        .size(45.px)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}

val GridPhotoStyle by ComponentStyle.base {
    Modifier
        .width(375.px)
        .height(399.px)
        .objectFit(ObjectFit.Cover)
        .backgroundSize(BackgroundSize.Inherit)
}

val personWithCardPhotoWidth = 334.px
val personWithCardPhotoHeight = 449.px

val personWithCardPhotoWidthLaptop = 248.px
val personWithCardPhotoHeightLaptop = 360.px

val PersonWithCardPhotoStyle by ComponentStyle.base {
    Modifier
        .width(personWithCardPhotoWidth)
        .height(personWithCardPhotoHeight)
        .objectFit(ObjectFit.Fill)
        .backgroundSize(BackgroundSize.Inherit)
}

val PersonWithCardPhotoStyleMobile by ComponentStyle.base {
    Modifier
        .width(100.percent)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}

val PersonWithCardPhotoStyleLaptop by ComponentStyle.base {
    Modifier
        .width(personWithCardPhotoWidthLaptop)
        .height(personWithCardPhotoHeightLaptop)
        .objectFit(ObjectFit.Contain)
        .backgroundSize(BackgroundSize.Inherit)
}

val WrapPhotoStyle by ComponentStyle.base {
    Modifier
        .objectFit(ObjectFit.Cover)
        .backgroundSize(BackgroundSize.Inherit)
}
val FillPhotoStyle by ComponentStyle.base {
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .objectFit(ObjectFit.Cover)
}

val CreatorPhotoStyle by ComponentStyle.base {
    Modifier
        .height(535.px)
        .objectFit(ObjectFit.Cover)
}

val CreatorPhotoStyleMobile by ComponentStyle.base {
    Modifier
        .width(100.percent)
        .objectFit(ObjectFit.Contain)
}

val CreatorPhotoStyleLaptop by ComponentStyle.base {
    Modifier
        .height(400.px)
        .objectFit(ObjectFit.ScaleDown)
}

val InsidePhotoStyle by ComponentStyle.base {
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .objectFit(ObjectFit.Contain)
}

val DuetPhotoStyle by ComponentStyle.base {
    Modifier
        .objectFit(ObjectFit.Contain)
}

val DuetPhotoStyleMobile by ComponentStyle.base {
    Modifier
        .width(100.percent)
        .objectFit(ObjectFit.Contain)
}

val DuetPhotoStylLaptop by ComponentStyle.base {
    Modifier
        .height(520.px)
        .objectFit(ObjectFit.Contain)
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

val OurServicesGridStyle by ComponentStyle.base {
    Modifier
        .gap(rowGap = 4.6.vh, columnGap = 5.5.vw)
        .width(100.percent)
}

val CreatorSectionGridStyle by ComponentStyle.base {
    Modifier
        .gap(2.cssRem)
        .width(100.percent)
}

val CreatorSectionGridStyleLaptop by ComponentStyle.base {
    Modifier
        .width(100.percent)
}

val PartnersSectionGridStyle by ComponentStyle.base {
    Modifier
        .gap(rowGap = 1.vh, columnGap = 1.vw)
        .width(100.percent)
}

val DuetSectionGridStyle by ComponentStyle.base {
    Modifier
        .gap(rowGap = 1.vh, columnGap = 1.vw)
        .width(100.percent)
}

val VocalistsSectionGridStyle by ComponentStyle.base {
    Modifier
        .gap(rowGap = 1.vh, columnGap = 1.vw)
        .width(100.percent)
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
        ) { value, _ ->
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Div(ModalDescriptionTextStyleCentered.toAttrs()) {
                    SpanText(
                        value.text,
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
                        value.name,
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
            }
        }
    }
}