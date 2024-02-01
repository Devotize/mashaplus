package com.sychev.mashaplus.pages.main.widgets

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.widgets.SliderSimpleArrow
import com.sychev.mashaplus.models.getMainPhotos
import com.sychev.mashaplus.models.testimonials
import com.sychev.mashaplus.pages.*
import com.sychev.mashaplus.utils.fadeInAnimation
import com.sychev.mashaplus.utils.stubAnimation
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiStar
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import kotlin.time.Duration.Companion.seconds

private val MainPhotoHeightBase = 320.px
private val MainPhotoHeightMD = 720.px
private val SliderPhotoHeightBase = 380.px
private val SliderPhotoHeightMD = 620.px
private val SectionPhotoHeightBase = 245.px
private val SectionPhotoHeightMD = 490.px
private val SectionPhotoWidthBase = 345.px
val SectionPhotoWidthMD = 690.px

val SectionPhotoStyle by ComponentStyle {
    base {
        Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover)
            .borderRadius(0.9.cssRem, 0.9.cssRem)
    }
    Breakpoint.LG {
        Modifier.height(SectionPhotoHeightMD).width(SectionPhotoWidthMD).objectFit(ObjectFit.Cover)
            .borderRadius(0.9.cssRem, 0.9.cssRem)
    }
}


val MainPhotoStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover) }
    Breakpoint.LG { Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Cover) }
}

val SecondaryPhotoStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover) }
    Breakpoint.LG {
        Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Cover)
            .padding(leftRight = XXXLargePadding)
    }
}

val BottomPhotoGradientStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Fill) }
    Breakpoint.LG { Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Fill) }
}

val SliderPhotoStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(SliderPhotoHeightBase)
            .objectFit(ObjectFit.Cover)
            .backgroundSize(BackgroundSize.Cover)
    }
    Breakpoint.LG { Modifier.fillMaxWidth().height(SliderPhotoHeightMD).objectFit(ObjectFit.Cover) }
}

@Composable
fun ImageHeaderWithLogo() {
    Box(modifier = Modifier.fillMaxWidth()) {
        val mainPhotos = getMainPhotos()
        var mainPhoto by remember { mutableStateOf(mainPhotos.first()) }
        var previousMainPhoto by remember { mutableStateOf<String?>(null) }
        LaunchedEffect(true) {
            var i = 1
            while (true) {
                delay(2.seconds)
                mainPhoto = mainPhotos[i]
                if (i == mainPhotos.lastIndex) {
                    i = 0
                } else {
                    i++
                }
            }
        }
        previousMainPhoto?.let {
            Image(
                it,
                "Main photo",
                MainPhotoStyle
                    .toModifier(),
            )
        }

        key(mainPhoto) {
            Image(
                mainPhoto,
                "Main photo",
                MainPhotoStyle
                    .toModifier()
                    .animation(
                        MainPhotoSlideInAnim.toAnimation(
                            duration = 300.ms,
                            timingFunction = AnimationTimingFunction.EaseIn,
                            direction = AnimationDirection.Normal,
                            fillMode = AnimationFillMode.Backwards,
                        )
                    )
                    .onAnimationEnd {
                        previousMainPhoto = mainPhoto
                    },
            )
        }

        val mainPhotoGradientRes = when (ColorMode.current) {
            ColorMode.DARK -> "/main_image_gradient_dark.png"
            ColorMode.LIGHT -> "/main_image_gradient_light.png"
        }
        Image(
            mainPhotoGradientRes,
            "gradient dark",
            BottomPhotoGradientStyle.toModifier()
                .align(Alignment.BottomCenter).stubAnimation(),
        )
        val palette = ColorMode.current.toSitePalette()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .zIndex(2f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                "/masha_logo.png",
                "Logo icon",
                LogoStyle.toModifier().fadeInAnimation()
            )
            Div(SubheadlineTextStyle.toAttrs()) {
                SpanText(
                    "Уникальный музыкальный проект, аналогов которого нет в Санкт-Петербурге.",
                    modifier = Modifier
                        .color(palette.brand.whiteText)
                        .fadeInAnimation()
                        .textShadow(offsetY = 1.px, offsetX = 1.px, blurRadius = 1.px, color = Colors.Black)
                )
            }
        }

    }
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