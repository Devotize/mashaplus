package com.sychev.mashaplus.pages

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.layouts.PageLayout
import com.sychev.mashaplus.components.widgets.Card
import com.sychev.mashaplus.components.widgets.Divider
import com.sychev.mashaplus.utils.*
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import kotlin.time.Duration.Companion.seconds

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.fillMaxWidth() }
}

val VideoStyle by ComponentStyle.base {
    Modifier
        .height(180.px)
        .width(320.px)
}

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Row(HeroContainerStyle.toModifier()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(Modifier.gap(2.cssRem).width(100.percent)) {
                    val palette = ColorMode.current.toSitePalette()
                    ImageHeaderWithLogo()
                    Column(modifier = Modifier.padding(XXSmallPadding).fillMaxWidth()) {
                        Card(modifier = Modifier.width(245.px).slideRightAnimation()) {
                            Div(ModalTitleTextStyle.toAttrs()) {
                                SpanText(
                                    "Принцип конструктора",
                                    modifier = Modifier.color(palette.brand.text)
                                )
                            }
                            Div(ModalDescriptionTextStyle.toAttrs()) {
                                SpanText(
                                    "Каждый заказчик сам может выбрать себе исполнителей на свой праздник",
                                    modifier = Modifier.color(palette.brand.greyText)
                                )
                            }
                        }
                        Box(modifier = Modifier.height(XXSmallPadding))
                        Card(modifier = Modifier.width(245.px).slideLeftAnimation().align(Alignment.End)) {
                            Div(ModalTitleTextStyle.toAttrs()) {
                                SpanText(
                                    "Разнообразный состав",
                                    modifier = Modifier.color(palette.brand.text)
                                )
                            }
                            Div(ModalDescriptionTextStyle.toAttrs()) {
                                SpanText(
                                    "В активе музпроекта 13 профессиональных вокалистов и 10 инструменталистов",
                                    modifier = Modifier.color(palette.brand.greyText)
                                )
                            }
                        }
                        Box(modifier = Modifier.height(XXSmallPadding))
                        Card(modifier = Modifier.width(245.px).slideRightAnimation()) {
                            Div(ModalTitleTextStyle.toAttrs()) {
                                SpanText(
                                    "Формат мероприятий",
                                    modifier = Modifier.color(palette.brand.text)
                                )
                            }
                            Div(ModalDescriptionTextStyle.toAttrs()) {
                                SpanText(
                                    "от уютного вечера в ресторане до свадеб и юбилеев, а также выступления на концертных площадках города и за его пределами",
                                    modifier = Modifier.color(palette.brand.greyText)
                                )
                            }
                        }
                        Box(Modifier.height(XXXLargePadding))
                        Divider(width = 100.percent)
                        Box(Modifier.height(XXLargePadding))
                        Div(HeadlineTextStyle.toAttrs()) {
                            SpanText(
                                "Коллектив молодых, ярких вокалистов",
                                modifier = Modifier
                                    .color(palette.brand.text)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                        Box(
                            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = XLargePadding)
                                .fadeInAnimation()
                        ) {
                            VideoVK("https://vk.com/video_ext.php?oid=-218638803&id=456239071&hd=2")
                        }
                        Box(Modifier.height(XXLargePadding + XSmallPadding))
                        Box(Modifier.height(XXLargePadding + XSmallPadding))
                        Div(HeadlineTextStyle.toAttrs()) {
                            SpanText(
                                "Мы можем устроить любой праздник",
                                modifier = Modifier
                                    .color(palette.brand.text)
                                    .align(Alignment.CenterHorizontally)
                            )
                        }
                        Box(
                            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = XLargePadding)
                                .fadeInAnimation()
                        ) {
                            VideoVK("https://vk.com/video_ext.php?oid=-174061350&id=456292768&hd=2")
                        }
                    }
                }
            }
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
    base { Modifier.width(9.cssRem) }
}

private val MainPhotoHeightBase = 320.px
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
                .align(Alignment.BottomCenter).stubAnimation(),
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
                    modifier = Modifier.color(palette.brand.whiteText).fadeInAnimation()
                )
            }
            Box(modifier = Modifier.height(0.5.cssRem))
        }

    }
}

