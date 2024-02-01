package com.sychev.mashaplus.pages.main.mobile

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.widgets.Card
import com.sychev.mashaplus.components.widgets.Divider
import com.sychev.mashaplus.components.widgets.VocalistWidget
import com.sychev.mashaplus.models.getFemaleVocalists
import com.sychev.mashaplus.models.getMaleVocalists
import com.sychev.mashaplus.models.getVocalistsCouples
import com.sychev.mashaplus.pages.HeroContainerStyle
import com.sychev.mashaplus.pages.LogoStyleSmall
import com.sychev.mashaplus.pages.SectionContainerStyle
import com.sychev.mashaplus.pages.main.widgets.ImageHeaderWithLogo
import com.sychev.mashaplus.pages.main.widgets.MainPhotoStyle
import com.sychev.mashaplus.pages.main.widgets.SectionPhotoStyle
import com.sychev.mashaplus.pages.main.widgets.TestimonialsSection
import com.sychev.mashaplus.utils.VideoYT
import com.sychev.mashaplus.utils.fadeInAnimation
import com.sychev.mashaplus.utils.slideLeftAnimation
import com.sychev.mashaplus.utils.slideRightAnimation
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayUntil
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div

@Composable
fun MainScreenMobile() {
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
                        modifier = Modifier.padding(LargePadding)
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
                }
                Column(modifier = Modifier.width(100.percent)) {
                    Column(modifier = Modifier.width(100.percent)) {
                        VocalistWidget("Вокалисты", getMaleVocalists())
                        Box(Modifier.height(XLargePadding))
                        VocalistWidget("Вокалистки", getFemaleVocalists())
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
                    Column(modifier = Modifier.fillMaxWidth()) {
                        VocalistWidget(null, getVocalistsCouples())
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
private fun VariousEventsSection() {
    val palette = ColorMode.current.toSitePalette()
    Column(modifier = SectionContainerStyle.toModifier()) {
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
}


@Composable
private fun FeaturesTopSection(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Column(modifier = modifier) {
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
    Box(Modifier.height(XLargePadding))
}

@Composable
private fun VideosSection() {
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
}