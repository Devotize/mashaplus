package com.sychev.mashaplus.pages.main.desktop

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.widgets.Divider
import com.sychev.mashaplus.components.widgets.VocalistWidget
import com.sychev.mashaplus.models.getFemaleVocalists
import com.sychev.mashaplus.models.getMainPhotos
import com.sychev.mashaplus.models.getMaleVocalists
import com.sychev.mashaplus.models.getVocalistsCouples
import com.sychev.mashaplus.pages.*
import com.sychev.mashaplus.pages.main.widgets.*
import com.sychev.mashaplus.provider.ScrollToViewEventProvider
import com.sychev.mashaplus.utils.Resources
import com.sychev.mashaplus.utils.VideoYT
import com.sychev.mashaplus.utils.fadeInAnimation
import com.sychev.mashaplus.utils.stubAnimation
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIfAtLeast
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
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


@Composable
fun MainScreenDesktop() {
    Row(HeroContainerStyle.toModifier()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.gap(2.cssRem).width(100.percent)) {
                val palette = ColorMode.current.toSitePalette()
                ImageHeaderWithLogo()
                MembersCountSection(modifier = Modifier.fillMaxWidth().padding(leftRight = XXXXXLargePadding))
                Box(Modifier.height(XXXLargePadding))
                OurServicesSections(modifier = Modifier.fillMaxWidth().padding(leftRight = XXXXXLargePadding))
                VocalistkySection(modifier = Modifier.fillMaxWidth().padding(leftRight = XXXLargePadding))
                Column(modifier = Modifier.padding(XXSmallPadding).fillMaxWidth()) {
                    FeaturesTopSection()
                    Divider(width = 100.percent)
                    Box(Modifier.height(XXLargePadding))
                    VideosSection()
                    Box(Modifier.height(XXLargePadding + XSmallPadding))
                }
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        Resources.Images.vocal_show,
                        "Main photo",
                        MainPhotoStyle
                            .toModifier()
                            .fadeInAnimation(),
                    )
                    Box(
                        modifier = Modifier
                            .width(820.px)
                            .padding(LargePadding).align(Alignment.TopStart)
                            .align(Alignment.BottomCenter)
                    ) {
                        Div(ModalTitleTextStyle.toAttrs()) {
                            SpanText(
                                Resources.Strings.yarkost_blesk,
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
                    Row(
                        modifier = Modifier.width(100.percent),
                    ) {
                        Spacer()
                        VocalistWidget(
                            Resources.Strings.vokalisty,
                            getMaleVocalists(),
                            modifier = Modifier,
                            sliderModifier = Modifier.width(420.px)
                        )
                        Box(Modifier.width(XXXLargePadding))
                        VocalistWidget(
                            Resources.Strings.vokalistky,
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
                                            Resources.Strings.minimalniy_komplekt,
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
                                            Resources.Strings.kolichestvo_blokov,
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
                                Resources.Strings.duet,
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
                                    Resources.Strings.ogromnym_priemushestvom,
                                    modifier = Modifier
                                        .color(palette.brand.text)
                                )
                            }
                        }
                        Spacer()
                    }
                    Box(Modifier.height(MediumPadding))
                    Column(modifier = Modifier.fillMaxWidth()) {
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
                    Row(modifier = Modifier.fillMaxWidth()) {
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

@Composable
private fun MembersCountSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.gap(1.4.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(TitleOutlinedStyle.toAttrs()) {
            SpanText(
                text = Resources.Strings.sostav_gruppy,
                modifier = Modifier
                    .fadeInAnimation()
            )
        }
        Div(TitleOutlinedStyle.toAttrs()) {
            SpanText(
                Resources.Strings.sostav_gruppy,
                modifier = Modifier
                    .fadeInAnimation()
                    .opacity(.6)
            )
        }
        Div(TitleOutlinedStyle.toAttrs()) {
            SpanText(
                Resources.Strings.sostav_gruppy,
                modifier = Modifier
                    .fadeInAnimation()
                    .opacity(.33)
            )
        }
    }
}

@Composable
fun OurServicesSections(modifier: Modifier = Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Column(
        modifier = modifier.gap(2.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(TitleStyle.toAttrs()) {
            SpanText(
                Resources.Strings.nashi_yslygi,
                modifier = Modifier
                    .fadeInAnimation()
            )
        }
        SimpleGrid(
            numColumns = numColumns(4),
            modifier = Modifier
                .background(palette.brand.text)
                .borderRadius(3.6.cssRem, 3.6.cssRem)
                .boxShadow(
                    offsetX = 1.px,
                    offsetY = 1.px,
                    blurRadius = 20.px,
                    spreadRadius = 3.px,
                    color = palette.brand.shadow,
                    inset = false,
                ),
        ) {
            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                Div(GritTextTitle.toAttrs()) {
                    SpanText(
                        Resources.Strings.nashi_yslygi,
                        modifier = Modifier
                            .fadeInAnimation()
                            .color(palette.brand.textReversed)
                    )
                }
            }
            Image(
                Resources.Images.two_girls,
                "Main photo",
                GridPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                Div(GritTextTitle.toAttrs()) {
                    SpanText(
                        Resources.Strings.vacalnoye_show,
                        modifier = Modifier
                            .fadeInAnimation()
                            .color(palette.brand.textReversed)
                    )
                }
            }
            Image(
                Resources.Images.three_girls,
                "Main photo",
                GridPhotoStyle
                    .toModifier()
                    .fadeInAnimation()
                    .borderRadius(topRight = 3.6.cssRem),
            )
            Image(
                Resources.Images.one_girl,
                "Main photo",
                GridPhotoStyle
                    .toModifier()
                    .borderRadius(bottomLeft = 3.6.cssRem)
                    .fadeInAnimation(),
            )
            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                Div(GritTextTitle.toAttrs()) {
                    SpanText(
                        Resources.Strings.duet_uppercase,
                        modifier = Modifier
                            .fadeInAnimation()
                            .color(palette.brand.textReversed)
                    )
                }
            }
            Image(
                Resources.Images.band,
                "Main photo",
                GridPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
            Box(modifier = Modifier, contentAlignment = Alignment.Center) {
                Div(GritTextTitle.toAttrs()) {
                    SpanText(
                        Resources.Strings.ultima_band,
                        modifier = Modifier
                            .fadeInAnimation()
                            .color(palette.brand.textReversed)
                    )
                }
            }
        }
    }
}

@Composable
private fun VocalistkySection(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Div(CarouselTextTitle.toModifier().padding(right = XXLargePadding).toAttrs()) {
            SpanText(
                Resources.Strings.vokalistky_uppercase,
                modifier = Modifier
                    .fadeInAnimation()
                    .color(palette.brand.text)
            )
        }
        Box(modifier = Modifier.padding(bottom = carouselPhotoHeight * 2.5, left = carouselPhotoWidth.div(2))) {
            Image(
                Resources.Images.ula_silhouette,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(bottom = carouselPhotoHeight * 2.5, right = carouselPhotoWidth)) {
            Image(
                Resources.Images.tanya_silhouette,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(bottom = carouselPhotoHeight * 1.8, right = carouselPhotoWidth * 2.5)) {
            Image(
                Resources.Images.liza_silhouette,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(right = carouselPhotoWidth * 3.2)) {
            Image(
                Resources.Images.devochka_left,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(top = carouselPhotoHeight * 1.5, right = carouselPhotoWidth * 2.4)) {
            Image(
                Resources.Images.carousel_girl_1,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(top = carouselPhotoHeight * 2.5, right = carouselPhotoWidth)) {
            Image(
                Resources.Images.carousel_girl_4,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(top = carouselPhotoHeight * 2.1, left = carouselPhotoWidth.div(2.5))) {
            Image(
                Resources.Images.carousel_girl_3,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(top = carouselPhotoHeight * 1.6, left = carouselPhotoWidth.times(1.4))) {
            Image(
                Resources.Images.carousel_girl_2,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(top = carouselPhotoHeight.div(3), left = carouselPhotoWidth.times(2.3))) {
            Image(
                Resources.Images.devochka_right,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
        Box(modifier = Modifier.padding(bottom = carouselPhotoHeight * 1.5, left = carouselPhotoWidth.times(1.8))) {
            Image(
                Resources.Images.sasha_silhouette,
                "",
                CarouselPhotoStyle
                    .toModifier()
                    .fadeInAnimation(),
            )
        }
    }
}

@Composable
private fun FeaturesTopSection() {
    val palette = ColorMode.current.toSitePalette()
    Row(
        Modifier.padding(top = XXXXLargePadding, left = XXXXLargePadding * 1.5, right = XLargePadding).fillMaxWidth()
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
private fun VariousEventsSection() {
    val palette = ColorMode.current.toSitePalette()
    Column(modifier = SectionContainerStyle.toModifier().fillMaxWidth()) {
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
            Column(
                ref = ref {
                    ScrollToViewEventProvider.setContactsScrollEvent {
                        it.scrollIntoView()
                    }
                },
                modifier = Modifier.width(SectionPhotoWidthMD)
            ) {
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
private fun VideosSection() {
    val palette = ColorMode.current.toSitePalette()
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
        Box(modifier = Modifier.padding(XLargePadding).zIndex(2)) {
            Image(
                Resources.Images.masha_logo,
                "Logo icon",
                LogoStyle
                    .toModifier()
                    .fadeInAnimation()
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
                .padding(bottom = XXXXLargePadding, leftRight = XXXXXLargePadding)
                .gap(1.cssRem)
                .zIndex(2f),
            horizontalAlignment = Alignment.Start
        ) {
            Div(MainTitleTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.sozday_meropriyatie,
                    modifier = Modifier
                        .color(palette.brand.whiteText)
                        .fadeInAnimation()
                        .textShadow(offsetY = 1.px, offsetX = 1.px, blurRadius = 1.px, color = Colors.Black)
                )
            }
            Div(SubheadlineRegularStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.muzik_project,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .color(palette.brand.whiteText)
                        .fadeInAnimation()
                        .textShadow(offsetY = 1.px, offsetX = 1.px, blurRadius = 1.px, color = Colors.Black)
                )
            }
            Spacer()
            Button(ButtonStyle.toAttrs(OutlinedCircularButtonVariant)) {
                Div(OutlineButtonTextStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.ostavit_zayavku,
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