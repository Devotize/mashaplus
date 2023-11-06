package com.sychev.mashaplus.pages

import androidx.compose.runtime.*
import com.sychev.mashaplus.HeadlineTextStyle
import com.sychev.mashaplus.MediumPadding
import com.sychev.mashaplus.SubheadlineTextStyle
import com.sychev.mashaplus.components.layouts.PageLayout
import com.sychev.mashaplus.toSitePalette
import com.sychev.mashaplus.utils.stubAnimation
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.ColorSchemes
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import kotlin.time.Duration.Companion.seconds

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.fillMaxWidth() }
}

// A demo grid that appears on the homepage because it looks good
val HomeGridStyle by ComponentStyle.base(extraModifiers = Modifier.displayIfAtLeast(Breakpoint.MD)) {
    Modifier
        .grid {
            rows { repeat(3) { size(1.fr) } }
            columns { repeat(5) { size(1.fr) } }
        }
        .gap(0.5.cssRem)
        .width(70.cssRem)
        .height(18.cssRem)
}

private val GridCellColorVar by StyleVariable<Color>()
val HomeGridCellStyle by ComponentStyle.base {
    Modifier
        .backgroundColor(GridCellColorVar.value())
        .boxShadow(blurRadius = 0.6.cssRem, color = GridCellColorVar.value())
        .borderRadius(1.cssRem)
}

@Composable
private fun GridCell(color: Color, row: Int, column: Int, width: Int? = null, height: Int? = null) {
    Div(
        HomeGridCellStyle.toModifier()
            .setVariable(GridCellColorVar, color)
            .gridItem(row, column, width, height)
            .toAttrs()
    )
}

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Row(HeroContainerStyle.toModifier()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                val sitePalette = ColorMode.current.toSitePalette()
                Column(Modifier.gap(2.cssRem).width(100.percent)) {
                    ImageHeaderWithLogo()
                    Div(HeadlineTextStyle.toAttrs()) {
                        SpanText(
                            "Use this template as your starting point ", Modifier.color(
                                when (ColorMode.current) {
                                    ColorMode.LIGHT -> Colors.Black
                                    ColorMode.DARK -> Colors.White
                                }
                            )
                        )
                        SpanText(
                            "Kobweb",
                            Modifier
                                .color(sitePalette.brand.accent)
                                // Use a shadow so this light-colored word is more visible in light mode
                                .textShadow(0.px, 0.px, blurRadius = 0.5.cssRem, color = Colors.Gray)
                        )
                    }

                    Div(SubheadlineTextStyle.toAttrs()) {
                        SpanText("Eblan ")
                        Link("/about", "About")
                        SpanText(" page for more information.")
                    }

                    val ctx = rememberPageContext()
                    Button(onClick = {
                        // Change this click handler with your call-to-action behavior
                        // here. Link to an order page? Open a calendar UI? Play a movie?
                        // Up to you!
                        ctx.router.tryRoutingTo("/about")
                    }, colorScheme = ColorSchemes.Blue) {
                        Text("This could be your CTA")
                    }
                }
            }

//            Div(HomeGridStyle.toAttrs()) {
//                val sitePalette = ColorMode.current.toSitePalette()
//                GridCell(sitePalette.brand.primary, 1, 1, 2, 2)
//                GridCell(ColorSchemes.Monochrome._600, 1, 3)
//                GridCell(ColorSchemes.Monochrome._100, 1, 4, width = 2)
//                GridCell(sitePalette.brand.accent, 2, 3, width = 2)
//                GridCell(ColorSchemes.Monochrome._300, 2, 5)
//                GridCell(ColorSchemes.Monochrome._800, 3, 1, width = 5)
//            }
        }
    }
}

val LogoSlideInAnim by Keyframes {
    from {
        Modifier.translateX(100.percent)
    }

    to {
        Modifier
    }
}

val MainPhotoSlideInAnim by Keyframes {
    from {
        Modifier.translateY(-(100).percent)
    }

    to {
        Modifier
    }
}

val LogoStyle by ComponentStyle {
    base { Modifier.width(85.px) }
    Breakpoint.MD { Modifier.width(240.px) }
}

private val MainPhotoHeightBase = 240.px
private val MainPhotoHeightMD = 660.px

val MainPhotoStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover) }
    Breakpoint.MD { Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Cover) }
}

val BottomPhotoGradientStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Fill) }
    Breakpoint.MD { Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Fill) }
}

private val mainPhotos = listOf(
    "/main_photo_1.png",
    "/main_photo_2.png",
    "/main_photo_3.png",
    "/main_photo_4.png",
    "/main_photo_5.png",
    "/main_photo_6.png",
)

@Composable
private fun ImageHeaderWithLogo() {
    Box(modifier = Modifier.fillMaxWidth()) {
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
        Image(
            "/masha_logo.png",
            "Logo icon",
            LogoStyle.toModifier()
                .padding(top = MediumPadding, left = MediumPadding)
                .align(Alignment.TopEnd)
                .animation(
                    LogoSlideInAnim.toAnimation(
                        duration = 400.ms,
                        timingFunction = AnimationTimingFunction.EaseIn,
                        direction = AnimationDirection.Normal,
                        fillMode = AnimationFillMode.Forwards
                    )
                )
        )
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
    }
}

