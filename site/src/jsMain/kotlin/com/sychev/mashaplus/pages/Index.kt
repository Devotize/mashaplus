package com.sychev.mashaplus.pages

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.layouts.PageLayout
import com.sychev.mashaplus.components.widgets.Card
import com.sychev.mashaplus.components.widgets.Divider
import com.sychev.mashaplus.components.widgets.VocalistWidget
import com.sychev.mashaplus.models.getFemaleVocalists
import com.sychev.mashaplus.models.getMaleVocalists
import com.sychev.mashaplus.utils.*
import com.varabyte.kobweb.compose.css.BackgroundSize
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
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
                            Div(ModalDescriptionTextStyleCentered.toAttrs()) {
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
                            Div(ModalDescriptionTextStyleCentered.toAttrs()) {
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
                            Div(ModalDescriptionTextStyleCentered.toAttrs()) {
                                SpanText(
                                    "От уютного вечера в ресторане до свадеб и юбилеев, а также выступления на концертных площадках города и за его пределами",
                                    modifier = Modifier.color(palette.brand.greyText)
                                )
                            }
                        }
                        Box(Modifier.height(XLargePadding))
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
                            VideoYT("https://www.youtube.com/embed/_c2B9DN_khg?si=eVhKkAczzjP_Afsm")
                        }
                        Box(Modifier.height((XXLargePadding + XSmallPadding) * 2))
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
                            VideoYT("https://www.youtube.com/embed/aEh4p6dUbvU?si=sZIsdey5lwHZ-rBx")
                        }
                        Box(Modifier.height(XXLargePadding + XSmallPadding))
                    }
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            "/vocal_show.png",
                            "Main photo",
                            MainPhotoStyle
                                .toModifier()
                                .fadeInAnimation(),
                        )
                        Box(modifier = Modifier.padding(LargePadding).align(Alignment.TopStart)) {
                            Div(ModalDescriptionTextStyle.toAttrs()) {
                                SpanText(
                                    "Яркость, блеск и целое музыкальное представление для вас и ваших гостей. Два блока — мировые хиты всех времен и любимые песни 90-ых в новой аранжировке от наших вокалистов и музыкантов, энергичные танцы и шикарные костюмы — вам точно нужно это прочувствовать!",
                                    modifier = Modifier
                                        .color(palette.brand.greyText)
                                        .opacity(.8f)
                                        .fadeInAnimation()
                                )
                            }
                        }
                    }
                    Column(modifier = Modifier.width(100.percent)) {
                        VocalistWidget("Вокалисты", getMaleVocalists())
                        Box(Modifier.height(XLargePadding))
                        VocalistWidget("Вокалистки", getFemaleVocalists())
                        Box(modifier = Modifier.padding(leftRight = XXLargePadding, top = XSmallPadding)) {
                            Column(
                                modifier = Modifier.borderRadius(0.5.cssRem, 0.5.cssRem)
                                    .border(1.px, LineStyle.Solid, palette.brand.text)
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxWidth()
                                        .padding(leftRight = LargePadding, top = XSmallPadding)
                                        .fadeInAnimation()
                                ) {
                                    Div(ModalDescriptionTextStyle.toAttrs()) {
                                        SpanText(
                                            "У вокалиста есть минимальный комплект оборудования, необходимый для подзвучивания",
                                            modifier = Modifier
                                                .color(palette.brand.text)
                                        )
                                    }
                                }
                                Box(
                                    modifier = Modifier.fillMaxWidth()
                                        .padding(
                                            leftRight = LargePadding,
                                            top = XSmallPadding,
                                            bottom = XXXSmallPadding
                                        )
                                        .fadeInAnimation()
                                ) {
                                    Div(ModalDescriptionTextStyle.toAttrs()) {
                                        SpanText(
                                            "Количество блоков оговаривется заранее, возможны любые варианты",
                                            modifier = Modifier
                                                .color(palette.brand.text)
                                        )
                                    }
                                }
                                Box(
                                    modifier = Modifier.align(Alignment.CenterHorizontally)
                                        .padding(bottom = XXSmallPadding)
                                ) {
                                    Div(Headline2TextStyle.toAttrs()) {
                                        SpanText(
                                            "Цена: 10 000₽",
                                            modifier = Modifier
                                                .color(palette.brand.text)
                                                .padding(leftRight = LargePadding)
                                                .fadeInAnimation()
                                        )
                                    }
                                }
                            }
                        }
                    }
                    Box(modifier = Modifier.fillMaxWidth().padding(XXSmallPadding)) {
                        Divider(width = 100.percent)
                    }
                    Column {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Div(HeadlineTextStyle.toAttrs()) {
                                SpanText(
                                    "Разнообразные события",
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                        .fadeInAnimation()
                                )
                            }
                            Spacer()
                        }
                        Image(
                            "/club_dance.png",
                            "Main photo",
                            MainPhotoStyle
                                .toModifier().padding(LargePadding).fadeInAnimation(),
                        )
                        Div(Headline2TextStyle.toAttrs()) {
                            SpanText(
                                "Идеальный выпускной",
                                modifier = Modifier
                                    .color(palette.brand.text)
                                    .padding(leftRight = LargePadding)
                                    .fadeInAnimation()
                            )
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth().padding(leftRight = XXLargePadding, top = XSmallPadding)
                                .fadeInAnimation()
                        ) {
                            Div(ModalDescriptionTextStyle.toAttrs()) {
                                SpanText(
                                    "Последний звонок, последний урок, вручение аттестатов... Наша команда готова сделать ваш выпускной неповторимым. Особенный ведущий, эмоциональный диджей и талантливые вокалисты создадут вечер, который запомнится на всю жизнь. Доверьтесь нам и создайте самую невероятную ночь вашего выпускного!",
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                )
                            }
                        }
                        Box(Modifier.height(XXLargePadding))
                        Box(Modifier.height(XXLargePadding))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Div(HeadlineTextStyle.toAttrs()) {
                                SpanText(
                                    "Широкий репертуар",
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                        .fadeInAnimation()
                                )
                            }
                            Spacer()
                        }
                        Image(
                            "/repertoire.png",
                            "Main photo",
                            MainPhotoStyle
                                .toModifier().padding(LargePadding).fadeInAnimation(),
                        )
                        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                            Link("https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg") {
                                Button(ButtonStyle.toAttrs(DefaultButtonVariant)) {
                                    Div(ButtonTextStyle.toAttrs()) {
                                        SpanText(
                                            "Посмотреть репертуар",
                                            modifier = Modifier
                                                .color(palette.brand.text)
                                                .fillMaxWidth()
                                                .textAlign(TextAlign.Center)
                                        )
                                    }
                                }
                            }
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth().padding(leftRight = XXLargePadding, top = XSmallPadding)
                                .fadeInAnimation()
                        ) {
                            Div(ModalDescriptionTextStyle.toAttrs()) {
                                SpanText(
                                    "Репертуар наших артистов весьма широк! Вы можете насладиться своим ужином под ненавязчивый лаунж или же зарядиться качевыми треками.\n" +
                                            "Полный плейлист наших вокалистов смотрите в прикрепленном файле. И не спешите расстраиваться, если не увидите в нем свой любимый трек — ребята с удовольствием выучат его ради вас и вашего праздника! \uD83D\uDE09",
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                )
                            }
                        }
                        Box(Modifier.height(XXLargePadding))
                    }
                    Column(modifier = Modifier.fillMaxWidth().backgroundColor(palette.brand.background)) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Div(HeadlineTextStyle.toAttrs()) {
                                SpanText(
                                    "Остались вопросы?",
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                        .fadeInAnimation()
                                )
                            }
                            Spacer()
                        }
                        Box(Modifier.height(MediumPadding))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Link("https://vk.com/masha_plus_band?w=app6013442_-218638803%2523form_id%253D1") {
                                Button(ButtonStyle.toAttrs(DefaultButtonVariant)) {
                                    Div(ButtonTextStyle.toAttrs()) {
                                        SpanText(
                                            "Оставить заявку",
                                            modifier = Modifier
                                                .color(palette.brand.text)
                                                .fillMaxWidth()
                                                .textAlign(TextAlign.Center)
                                        )
                                    }
                                }
                            }
                            Spacer()
                        }
                    }
                    Box(Modifier.height(MediumPadding))
                    Column(modifier = Modifier.fillMaxWidth().backgroundColor(palette.brand.surface)) {
                        Box(Modifier.height(MediumPadding))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Div(SubheadlineTextStyle.toAttrs()) {
                                SpanText(
                                    "Музыкальный проект \"Маша+\"",
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                        .fadeInAnimation()
                                )
                            }
                            Spacer()
                        }
                        Box(Modifier.height(MediumPadding))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Link("https://vk.com/masha_plus_band") {
                                Image(
                                    "/vk_logo.png",
                                    "",
                                    LogoStyleSmall
                                        .toModifier(),
                                )
                            }
                            Box(Modifier.width(XXSmallPadding))
                            Image(
                                "/inst_logo.png",
                                "",
                                LogoStyleSmall
                                    .toModifier(),
                            )
                            Spacer()
                        }
                        Box(Modifier.height(MediumPadding))
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
    base { Modifier.width(11.cssRem) }
}

val LogoStyleSmall by ComponentStyle {
    base { Modifier.width(2.cssRem) }
}

private val MainPhotoHeightBase = 320.px
private val MainPhotoHeightMD = 660.px
private val SliderPhotoHeightBase = 380.px
private val SliderPhotoHeightMD = 620.px

val MainPhotoStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover) }
    Breakpoint.MD { Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Cover) }
}

val BottomPhotoGradientStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Fill) }
    Breakpoint.MD { Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Fill) }
}

val SliderPhotoStyle by ComponentStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(SliderPhotoHeightBase)
            .objectFit(ObjectFit.Cover)
            .backgroundSize(BackgroundSize.Cover)
    }
    Breakpoint.MD { Modifier.fillMaxWidth().height(SliderPhotoHeightMD).objectFit(ObjectFit.Cover) }
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

