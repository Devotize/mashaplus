package com.sychev.mashaplus.pages

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.layouts.PageLayout
import com.sychev.mashaplus.components.widgets.Card
import com.sychev.mashaplus.components.widgets.Divider
import com.sychev.mashaplus.components.widgets.SliderSimpleArrow
import com.sychev.mashaplus.components.widgets.VocalistWidget
import com.sychev.mashaplus.models.*
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
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.mdi.MdiStar
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.coroutines.delay
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import kotlin.time.Duration.Companion.seconds

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.LG { Modifier.fillMaxWidth() }
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
                        FeaturesTopSection(modifier = Modifier.fillMaxWidth())
                        Divider(width = 100.percent)
                        Box(Modifier.height(XXLargePadding))
                        VideosSection()
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
                        Box(
                            modifier = Modifier.displayUntil(Breakpoint.LG).padding(LargePadding)
                                .align(Alignment.TopStart)
                        ) {
                            Div(ModalDescriptionTextStyle.toAttrs()) {
                                SpanText(
                                    "Яркость, блеск и целое музыкальное представление для вас и ваших гостей. Два блока — мировые хиты всех времен и любимые песни 90-ых в новой аранжировке от наших вокалистов и музыкантов, энергичные танцы и шикарные костюмы — вам точно нужно это прочувствовать!",
                                    modifier = Modifier
                                        .color(palette.brand.greyText)
                                        .opacity(.8f)
                                        .fadeInAnimation()
                                        .textShadow(
                                            offsetY = .5.px,
                                            offsetX = .5.px,
                                            blurRadius = 1.px,
                                            color = Colors.White
                                        )
                                )
                            }
                        }
                        Box(
                            modifier = Modifier.displayIfAtLeast(Breakpoint.LG)
                                .width(820.px)
                                .padding(LargePadding).align(Alignment.TopStart)
                                .align(Alignment.BottomCenter)
                        ) {
                            Div(ModalTitleTextStyle.toAttrs()) {
                                SpanText(
                                    "Яркость, блеск и целое музыкальное представление для вас и ваших гостей. Два блока — мировые хиты всех времен и любимые песни 90-ых в новой аранжировке от наших вокалистов и музыкантов, энергичные танцы и шикарные костюмы — вам точно нужно это прочувствовать!",
                                    modifier = Modifier
                                        .color(palette.brand.greyText)
                                        .opacity(.8f)
                                        .fadeInAnimation()
                                        .textShadow(
                                            offsetY = .5.px,
                                            offsetX = .5.px,
                                            blurRadius = 1.px,
                                            color = Colors.White
                                        )
                                )
                            }
                        }
                    }
                    Column(modifier = Modifier.width(100.percent)) {
                        Column(modifier = Modifier.width(100.percent).displayUntil(Breakpoint.LG)) {
                            VocalistWidget("Вокалисты", getMaleVocalists())
                            Box(Modifier.height(XLargePadding))
                            VocalistWidget("Вокалистки", getFemaleVocalists())
                        }
                        Row(
                            modifier = Modifier.width(100.percent).displayIfAtLeast(Breakpoint.LG),
                        ) {
                            Spacer()
                            VocalistWidget(
                                "Вокалисты",
                                getMaleVocalists(),
                                modifier = Modifier,
                                sliderModifier = Modifier.width(420.px)
                            )
                            Box(Modifier.width(XXXLargePadding))
                            VocalistWidget(
                                "Вокалистки",
                                getFemaleVocalists(),
                                modifier = Modifier,
                                sliderModifier = Modifier.width(420.px)
                            )
                            Spacer()
                        }
                        Row(Modifier.fillMaxWidth()) {
                            Spacer()
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
                                    Box(modifier = Modifier.height(XSmallPadding))
                                }
                            }
                            Spacer()
                        }
                    }
                    Box(modifier = Modifier.fillMaxWidth().padding(XXSmallPadding)) {
                        Divider(width = 100.percent)
                    }
                    Column(Modifier.fillMaxWidth()) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Div(HeadlineTextStyle.toAttrs()) {
                                SpanText(
                                    "Дуэт",
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                        .fadeInAnimation()
                                )
                            }
                            Spacer()
                        }
                        Row(Modifier.fillMaxWidth()) {
                            Spacer()
                            Box(
                                modifier = Modifier.padding(leftRight = XXLargePadding, top = XSmallPadding)
                                    .fadeInAnimation()
                            ) {
                                Div(ModalDescriptionTextStyleCentered.toAttrs()) {
                                    SpanText(
                                        "Огромным приемуществом нашего проекта является взаимозаменяемость",
                                        modifier = Modifier
                                            .color(palette.brand.text)
                                    )
                                }
                            }
                            Spacer()
                        }
                        Box(Modifier.height(MediumPadding))
                        Column(modifier = Modifier.fillMaxWidth().displayUntil(Breakpoint.LG)) {
                            VocalistWidget(null, getVocalistsCouples())
                        }
                        Column(modifier = Modifier.fillMaxWidth().displayIfAtLeast(Breakpoint.LG)) {
                            VocalistWidget(null, getVocalistsCouples(), sliderModifier = Modifier.width(620.px))
                        }
                        Row(Modifier.fillMaxWidth()) {
                            Spacer()
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
                                                "Есть возможность выбрать репертуар и внешний вид вокалистов специально под ваше мероприятие (заранее)",
                                                modifier = Modifier
                                                    .color(palette.brand.text)
                                            )
                                        }
                                    }
                                    Box(modifier = Modifier.height(XSmallPadding))
                                }
                            }
                            Spacer()
                        }
                    }
                    Box(modifier = Modifier.fillMaxWidth().padding(XXSmallPadding)) {
                        Divider(width = 100.percent)
                    }
                    VariousEventsSection()
                    TestimonialsSection(Modifier.fillMaxWidth().padding(leftRight = LargePadding))
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
                        Row(modifier = Modifier.fillMaxWidth().displayUntil(Breakpoint.LG)) {
                            Spacer()
                            Link("https://api.whatsapp.com/send/?phone=%2B79052629514&text&type=phone_number&app_absent=0") {
                                Button(ButtonStyle.toAttrs(DefaultButtonVariant)) {
                                    Div(ButtonTextStyle.toAttrs()) {
                                        SpanText(
                                            "Оставить заявку",
                                            modifier = Modifier
                                                .color(palette.brand.whiteText)
                                                .fillMaxWidth()
                                                .textAlign(TextAlign.Center)
                                        )
                                    }
                                }
                            }
                            Spacer()
                        }
                        Row(modifier = Modifier.fillMaxWidth().displayIfAtLeast(Breakpoint.LG)) {
                            Spacer()
                            Link("https://vk.com/masha_plus_band?w=app6013442_-218638803%2523form_id%253D1") {
                                Button(ButtonStyle.toAttrs(DefaultButtonVariant)) {
                                    Div(ButtonTextStyle.toAttrs()) {
                                        SpanText(
                                            "Оставить заявку",
                                            modifier = Modifier
                                                .color(palette.brand.whiteText)
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
                            Div(SubheadlineBoldTextStyle.toAttrs()) {
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
                                val imgResVK = if (ColorMode.current.isDark) {
                                    "/vk_logo.png"
                                } else {
                                    "/vk_logo_black.png"
                                }
                                Image(
                                    imgResVK,
                                    "",
                                    LogoStyleSmall
                                        .toModifier(),
                                )
                            }
                            Box(Modifier.width(XXSmallPadding))
                            Link("https://instagram.com/masha_plus_band?igshid=OGQ5ZDc2ODk2ZA==") {
                                val imgResInst = if (ColorMode.current.isDark) {
                                    "/inst_logo.png"
                                } else {
                                    "/inst_logo_black.png"
                                }
                                Image(
                                    imgResInst,
                                    "",
                                    LogoStyleSmall
                                        .toModifier(),
                                )
                            }
                            Spacer()
                        }
                        Box(Modifier.height(XXSmallPadding))
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Spacer()
                            Link(
                                "tel:+79319512000",
                                openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                                openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                            ) {
                                Div(SubheadlineBoldTextStyle.toAttrs()) {
                                    SpanText(
                                        "8 (931) 951-20-00",
                                        modifier = Modifier
                                            .color(palette.brand.text)
                                            .fadeInAnimation()
                                    )
                                }
                            }
                            Spacer()
                        }
                        Box(Modifier.height(MediumPadding))
                    }
                }
            }
        }
    }
}

val SectionContainerStyle by ComponentStyle {
    base { Modifier.padding(leftRight = LargePadding) }
    Breakpoint.LG { Modifier.padding(leftRight = XXXXLargePadding * 1.5) }
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
private val MainPhotoHeightMD = 720.px
private val SliderPhotoHeightBase = 380.px
private val SliderPhotoHeightMD = 620.px
private val SectionPhotoHeightBase = 245.px
private val SectionPhotoHeightMD = 490.px
private val SectionPhotoWidthBase = 345.px
private val SectionPhotoWidthMD = 690.px

val MainPhotoStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().height(MainPhotoHeightBase).objectFit(ObjectFit.Cover) }
    Breakpoint.LG { Modifier.fillMaxWidth().height(MainPhotoHeightMD).objectFit(ObjectFit.Cover) }
}

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
private fun ImageHeaderWithLogo() {
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
private fun FeaturesTopSection(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Column(modifier = modifier.displayUntil(Breakpoint.LG)) {
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
                    "В активе музпроекта 15 профессиональных вокалистов и 10 инструменталистов",
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
    }
    // After Breakpoint.LG
    Row(
        Modifier.padding(top = XXXXLargePadding, left = XXXXLargePadding * 1.5, right = XLargePadding).fillMaxWidth()
            .displayIfAtLeast(Breakpoint.LG)
    ) {
        Box(Modifier.width(660.px)) {
            Div(SectionTitleStyle.toAttrs()) {
                SpanText(
                    "О нас",
                    modifier = Modifier
                        .color(palette.brand.text)
                        .fadeInAnimation()
                )
            }
        }
        Spacer()
        Column(modifier = Modifier) {
            Div(Headline2TextStyle.toAttrs()) {
                SpanText(
                    "Masha+» – это не просто музыкальный проект, это волшебное слияние талантливых вокалистов и музыкантов, создающих атмосферу, которая словно воплощает в себе саму суть ваших мечтаний.",
                    modifier = Modifier
                        .color(palette.brand.text)
                        .fadeInAnimation()
                )
            }
            Box(Modifier.height(48.px))
            Row(Modifier.fillMaxWidth()) {
                Box(Modifier.width(40.percent)) {
                    Div(ModalDescriptionTextStyle.toAttrs()) {
                        SpanText(
                            "Каждый заказчик сам может выбрать себе исполнителей на свой праздник. Мы - не просто агенство с подборкой незнакомых вокалистов, мы - коллестив, где все знают друг друга и много лет работают вместе",
                            modifier = Modifier
                                .color(palette.brand.text)
                        )
                    }
                }
                Box(Modifier.width(XXXLargePadding))
                Box(Modifier.width(45.percent).padding()) {
                    Div(ModalDescriptionTextStyle.toAttrs()) {
                        SpanText(
                            "От уютного вечера в ресторане до свадеб и юбилеев, а также выступления на концертных площадках города и за его пределами. Репертуар наших артистов весьма широк! Вы можете насладиться своим ужином под ненавязчивый лаунж или же зарядиться качевыми треками.",
                            modifier = Modifier
                                .color(palette.brand.text)
                        )
                    }
                }
            }
        }
    }
    Box(Modifier.height(XLargePadding))
}

@Composable
fun VideosSection() {
    val palette = ColorMode.current.toSitePalette()
    Column(modifier = Modifier.fillMaxWidth().displayUntil(Breakpoint.LG)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer()
            Div(HeadlineTextStyle.toAttrs()) {
                SpanText(
                    "Коллектив молодых, ярких вокалистов",
                    modifier = Modifier
                        .color(palette.brand.text)
                        .align(Alignment.CenterVertically)
                )
            }
            Spacer()
        }
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = XLargePadding)
                .fadeInAnimation()
        ) {
            VideoYT("https://www.youtube.com/embed/_c2B9DN_khg?si=eVhKkAczzjP_Afsm")
        }
        Box(Modifier.height((XXLargePadding + XSmallPadding) * 2))
        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer()
            Div(HeadlineTextStyle.toAttrs()) {
                SpanText(
                    "Мы можем устроить любой праздник",
                    modifier = Modifier
                        .color(palette.brand.text)
                        .align(Alignment.CenterVertically)
                )
            }
            Spacer()
        }
        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = XLargePadding)
                .fadeInAnimation()
        ) {
            VideoYT("https://www.youtube.com/embed/aEh4p6dUbvU?si=sZIsdey5lwHZ-rBx")
        }
    }
    // After Breakpoint.LG
    Column(modifier = SectionContainerStyle.toModifier().fillMaxWidth().displayIfAtLeast(Breakpoint.LG)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.width(460.px)) {
                Div(SectionTitleStyle.toAttrs()) {
                    SpanText(
                        "Коллектив молодых, ярких вокалистов",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(48.px))
                Div(Headline2TextStyle.toAttrs()) {
                    SpanText(
                        "Концерный формат выступлений",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
            }
            Spacer()
            Box(
                modifier = Modifier
                    .fadeInAnimation()
            ) {
                VideoYT("https://www.youtube.com/embed/_c2B9DN_khg?si=eVhKkAczzjP_Afsm")
            }
        }
        Box(Modifier.height(XXXXLargePadding))
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fadeInAnimation()
            ) {
                VideoYT("https://www.youtube.com/embed/aEh4p6dUbvU?si=sZIsdey5lwHZ-rBx")
            }
            Spacer()
            Column(modifier = Modifier.width(460.px)) {
                Div(SectionTitleStyle.toAttrs()) {
                    SpanText(
                        "Мы можем устроить любой праздник",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(48.px))
                Div(Headline2TextStyle.toAttrs()) {
                    SpanText(
                        "Широкий репертуар: от лаунжа до современных композиций",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
            }
        }
    }
}

@Composable
private fun VariousEventsSection() {
    val palette = ColorMode.current.toSitePalette()
    // Until MD
    Column(modifier = SectionContainerStyle.toModifier().displayUntil(Breakpoint.LG)) {
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
        Box(Modifier.height(LargePadding))
        Image(
            "/club_dance.png",
            "Main photo",
            SectionPhotoStyle
                .toModifier().fadeInAnimation(),
        )
        Box(Modifier.height(LargePadding))
        Div(Headline2TextStyle.toAttrs()) {
            SpanText(
                "Идеальный выпускной",
                modifier = Modifier
                    .color(palette.brand.text)
                    .fadeInAnimation()
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = XSmallPadding)
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
        Box(Modifier.height(XXLargePadding * 1.5))
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
        Box(Modifier.height(LargePadding))
        Image(
            "/repertoire.png",
            "Main photo",
            SectionPhotoStyle
                .toModifier().fadeInAnimation(),
        )
        Box(Modifier.height(LargePadding))
        Box(modifier = Modifier.align(Alignment.Start)) {
            Link("https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg") {
                Button(ButtonStyle.toAttrs(DefaultButtonVariant)) {
                    Div(ButtonTextStyle.toAttrs()) {
                        SpanText(
                            "Посмотреть репертуар",
                            modifier = Modifier
                                .color(palette.brand.whiteText)
                                .fillMaxWidth()
                                .textAlign(TextAlign.Center)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = XSmallPadding)
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
    // After MD
    Column(modifier = SectionContainerStyle.toModifier().displayIfAtLeast(Breakpoint.LG).fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.width(460.px)) {
                Div(SectionTitleStyle.toAttrs()) {
                    SpanText(
                        "Разнообразные события",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(48.px))
                Div(Headline2TextStyle.toAttrs()) {
                    SpanText(
                        "Наши профессиональные музыканты – это не просто исполнители, а хранители музыкальной магии, готовые воплотить вашу музыкальную фантазию в неповторимый момент.",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(48.px))
                Div(ModalDescriptionTextStyle.toAttrs()) {
                    SpanText(
                        "Последний звонок, последний урок, вручение аттестатов... Наша команда готова сделать ваш выпускной неповторимым. Особенный ведущий, эмоциональный диджей и талантливые вокалисты создадут вечер, который запомнится на всю жизнь. Доверьтесь нам и создайте самую невероятную ночь вашего выпускного!",
                        modifier = Modifier
                            .color(palette.brand.text)
                    )
                }
            }
            Spacer()
            Image(
                "/club_dance.png",
                "Main photo",
                SectionPhotoStyle
                    .toModifier().fadeInAnimation(),
            )
        }
        Box(Modifier.height(XXXXLargePadding))
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.width(460.px)) {
                Div(SectionTitleStyle.toAttrs()) {
                    SpanText(
                        "Исполнители",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
            }
            Spacer()
            Column(Modifier.width(SectionPhotoWidthMD)) {
                Div(HeadlineTextStyle.toAttrs()) {
                    SpanText(
                        "Разнообразный состав",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(XXXLargePadding))
                Div(ModalDescriptionTextStyle.toAttrs()) {
                    SpanText(
                        "Активные и молодые музыканты",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(XXXLargePadding))
                Row(Modifier.fillMaxWidth()) {
                    Column {
                        Divider(310.px)
                        Box(Modifier.height(XXSmallPadding))
                        Div(HugeThinTextStyle.toAttrs()) {
                            SpanText(
                                "13",
                                modifier = Modifier
                                    .color(palette.brand.text)
                                    .fadeInAnimation()
                            )
                        }
                        Box(Modifier.height(XXXXSmallPadding))
                        Div(ModalDescriptionTextStyle.toAttrs()) {
                            SpanText(
                                "Профессиональных вокалистов",
                                modifier = Modifier
                                    .color(palette.brand.text)
                                    .fadeInAnimation()
                            )
                        }
                    }
                    Spacer()
                    Column {
                        Divider(310.px)
                        Box(Modifier.height(XXSmallPadding))
                        Div(HugeThinTextStyle.toAttrs()) {
                            SpanText(
                                "10",
                                modifier = Modifier
                                    .color(palette.brand.text)
                                    .fadeInAnimation()
                            )
                        }
                        Box(Modifier.height(XXXXSmallPadding))
                        Div(ModalDescriptionTextStyle.toAttrs()) {
                            SpanText(
                                "Инструменталистов",
                                modifier = Modifier
                                    .color(palette.brand.text)
                                    .fadeInAnimation()
                            )
                        }
                    }
                }
            }
        }
        Box(Modifier.height(XXXXLargePadding))
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                "/repertoire.png",
                "Main photo",
                SectionPhotoStyle
                    .toModifier().fadeInAnimation(),
            )
            Spacer()
            Column(modifier = Modifier.width(460.px)) {
                Div(SectionTitleStyle.toAttrs()) {
                    SpanText(
                        "Широкий репертуар",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(48.px))
                Div(Headline2TextStyle.toAttrs()) {
                    SpanText(
                        "У каждого из наших вокалистов огромный репертуар и " +
                                "большое количество интересных аранжировок, так же " +
                                "мы можем выучить какую-то композицию лично для вас",
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                }
                Box(Modifier.height(48.px))
                Box(modifier = Modifier.align(Alignment.Start)) {
                    Link("https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg") {
                        Button(ButtonStyle.toAttrs(DefaultButtonVariant)) {
                            Div(ButtonTextStyle.toAttrs()) {
                                SpanText(
                                    "Посмотреть репертуар",
                                    modifier = Modifier
                                        .color(palette.brand.whiteText)
                                        .fillMaxWidth()
                                        .textAlign(TextAlign.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TestimonialsSection(modifier: Modifier = Modifier) {
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
