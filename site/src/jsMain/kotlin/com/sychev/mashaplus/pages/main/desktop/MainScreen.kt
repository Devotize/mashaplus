package com.sychev.mashaplus.pages.main.desktop

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.widgets.Card
import com.sychev.mashaplus.components.widgets.SliderSimpleArrow
import com.sychev.mashaplus.models.Vocalist
import com.sychev.mashaplus.models.vokalistkyList
import com.sychev.mashaplus.models.vokalistyList
import com.sychev.mashaplus.pages.HeroContainerStyle
import com.sychev.mashaplus.pages.LogoStyle
import com.sychev.mashaplus.pages.LogoStyleSmall
import com.sychev.mashaplus.pages.MainPhotoSlideInAnim
import com.sychev.mashaplus.pages.main.widgets.*
import com.sychev.mashaplus.provider.ScrollToViewEventProvider
import com.sychev.mashaplus.utils.Resources
import com.sychev.mashaplus.utils.VideoYT
import com.sychev.mashaplus.utils.fadeInAnimation
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.animation.toAnimation
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.forms.Input
import com.varabyte.kobweb.silk.components.forms.InputDefaults
import com.varabyte.kobweb.silk.components.forms.InputSize
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div


@Composable
fun MainScreenDesktop() {
    Row(HeroContainerStyle.toModifier()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.gap(2.cssRem).width(100.percent)) {
                ImageHeaderWithLogo()
                Box(Modifier.height(XXXLargePadding))
                OurServicesSections(modifier = Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXXXLargePadding))
                Box(ref = ref {
                    ScrollToViewEventProvider.setVocalistScrollEvent {
                        it.scrollIntoView()
                    }
                })
                VocalistySection(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vokalistky_uppercase,
                    vokalistkyList
                )
                Box(Modifier.height(XXXXXLargePadding))
                VocalistySection(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vokalisty_uppercase,
                    vokalistyList
                )
                Box(Modifier.height(XXXXXLargePadding))
                DuetsSection(Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXXXLargePadding))
                VideosSection(Modifier.fillMaxWidth())
                Box(Modifier.height(XXXXXLargePadding))
                BottomSection(Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
private fun MembersCountSection(modifier: Modifier = Modifier) {
    @Composable
    fun TextWithNum(
        title: String,
        num: String
    ) {
        Column {
            Div(SmallTitleStyle.toAttrs()) {
                SpanText(
                    text = title,
                    modifier = Modifier
                        .fadeInAnimation()
                )
            }
            Div(HugeTextStyle.toAttrs()) {
                SpanText(
                    num,
                    modifier = Modifier
                        .fadeInAnimation()
                )
            }
        }
    }
    Box(modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxWidth().backdropFilter(blur(10.px)),
            color = MembersSectionCard,
            paddingValues = XXXXLargePadding - XXLargePadding
        ) {
            Row(
                modifier = Modifier.gap(5.5.cssRem),
            ) {
                TextWithNum(
                    Resources.Strings.vokalisty,
                    Resources.Strings.text_14
                )
                TextWithNum(
                    Resources.Strings.instrymentalisty,
                    Resources.Strings.text_10,
                )
                TextWithNum(
                    Resources.Strings.let_text,
                    Resources.Strings.text_5,
                )
            }
        }
    }
}

@Composable
fun OurServicesSections(modifier: Modifier = Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Box(Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.padding(left = XXXXLargePadding - MediumPadding, top = LargePadding)) {
            Image(
                Resources.Images.clyaksa,
                modifier = ClyaksImageStyle.toModifier()
            )
        }
        Box(
            modifier = modifier,
        ) {
            Column(Modifier.fillMaxWidth().gap(3.5.cssRem)) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Div(TitleStyle.toModifier().align(Alignment.TopEnd).toAttrs()) {
                        SpanText(
                            Resources.Strings.nashi_yslygi,
                            modifier = Modifier
                                .fadeInAnimation()
                        )
                    }
                }
                val cardHeight = 45.cssRem
                Column(Modifier.fillMaxWidth().height(cardHeight)) {
                    @Composable
                    fun ServiceCard(text: String, weight: Int) {
                        var showBackgroundShadow by remember { mutableStateOf(false) }
                        Card(
                            modifier = Modifier.fillMaxHeight().weight(weight)
                                .onMouseEnter { showBackgroundShadow = true }
                                .onMouseLeave { showBackgroundShadow = false }
                                .boxShadow(
                                    offsetX = 1.px,
                                    offsetY = 1.px,
                                    blurRadius = 5.px,
                                    spreadRadius = 5.px,
                                    color = if (showBackgroundShadow) DesignShadow else Colors.Transparent
                                ),
                            color = DesignSurface,
                            paddingValues = XXXXLargePadding - XXLargePadding
                        ) {
                            Div(GritTextTitle.toAttrs()) {
                                SpanText(
                                    text,
                                    modifier = Modifier
                                        .color(palette.brand.textReversed)
                                        .fadeInAnimation()
                                )
                            }
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth().weight(14)) {
                        ServiceCard(Resources.Strings.ultima_band, 25)
                        Box(Modifier.weight(1.5))
                        ServiceCard(Resources.Strings.duet_uppercase, 3)
                    }
                    Box(Modifier.fillMaxWidth().weight(1.5))
                    Row(modifier = Modifier.fillMaxWidth().weight(14)) {
                        ServiceCard(Resources.Strings.vokalisty_uppercase, 3)
                        Box(Modifier.fillMaxHeight().weight(1.5))
                        ServiceCard(Resources.Strings.vacalnoye_show, 25)
                    }
                }
            }
        }
    }
}

@Composable
private fun VocalistySection(modifier: Modifier, title: String, list: List<Vocalist>) {
    Column(
        modifier = modifier.gap(4.5.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(TitleStyle.toAttrs()) {
            SpanText(
                title,
                modifier = Modifier
                    .fadeInAnimation()
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .overflow(Overflow.Scroll)
                .gap(3.cssRem)
                .styleModifier {
                    property("display", "-webkit-box")
                    property("-webkit-box-pack", "center")
                },
            horizontalArrangement = Arrangement.Center
        ) {
            Box(Modifier.width(XXLargePadding))
            list.forEach {
                VocalistCard(Modifier, it.name, it.imgRes)
            }
            Box(Modifier.width(XXLargePadding))
        }
    }
}

@Composable
private fun VocalistCard(modifier: Modifier, name: String, photoRes: String) {
    Column(modifier.gap(2.5.cssRem)) {
        Box(
            modifier = Modifier,
            contentAlignment = Alignment.BottomCenter
        ) {
            val cardWidth = 334.px
            val cardHeight = 430.px
            Card(
                modifier = Modifier.width(cardWidth).height(cardHeight)
                    .backgroundImage(linearGradient(LinearGradient.Direction.ToRight, GradientLeft, GradientRight)),
            ) {}
            Image(
                photoRes,
                "Main photo",
                PersonWithCardPhotoStyle
                    .toModifier().fadeInAnimation(),
            )
        }
        Div(GritTextTitle.toAttrs()) {
            SpanText(
                name,
                modifier = Modifier
                    .fadeInAnimation()
                    .whiteSpace(WhiteSpace.PreLine)
            )
        }
    }

}

@Composable
private fun VideosSection(modifier: Modifier) {
    Column(
        modifier = modifier.gap(3.5.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(TitleStyle.toAttrs()) {
            SpanText(
                Resources.Strings.ultima_band,
                modifier = Modifier
                    .fadeInAnimation(),
                ref = ref {
                    ScrollToViewEventProvider.setUltimaBandSectionEvent {
                        it.scrollIntoView()
                    }
                }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fadeInAnimation(),
            contentAlignment = Alignment.Center,
        ) {
            VideoYT("https://www.youtube.com/embed/_c2B9DN_khg?si=eVhKkAczzjP_Afsm")
        }
        Box(Modifier.height(XXXLargePadding))
        Div(TitleStyle.toAttrs()) {
            SpanText(
                Resources.Strings.vacalnoye_show,
                modifier = Modifier
                    .fadeInAnimation(),
                ref = ref {
                    ScrollToViewEventProvider.setVocalShowSectionEvent {
                        it.scrollIntoView()
                    }
                }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fadeInAnimation(),
            contentAlignment = Alignment.Center,
        ) {
            VideoYT("https://www.youtube.com/embed/aEh4p6dUbvU?si=sZIsdey5lwHZ-rBx")
        }
    }
}

@Composable
private fun ImageHeaderWithLogo() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            Resources.Images.main_photo,
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
                .align(Alignment.TopEnd),
        )
        val palette = ColorMode.current.toSitePalette()
        Column(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter).zIndex(2f)) {
            Box(modifier = Modifier.padding(XLargePadding).zIndex(2)) {
                Image(
                    Resources.Images.masha_logo,
                    "Logo icon",
                    LogoStyle
                        .toModifier()
                        .fadeInAnimation()
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = XXLargePadding, leftRight = LeftRightPadding)
                    .gap(2.2.cssRem),
                horizontalAlignment = Alignment.Start
            ) {
                Div(MainTitleTextStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.sozday_meropriyatie,
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
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
                Link("https://vk.com/masha_plus_band") {
                    Button(ButtonStyle.toAttrs(OutlinedGradientCircularButtonVariant)) {
                        Div(OutlineButtonTextStyle.toAttrs()) {
                            SpanText(
                                Resources.Strings.ostavit_zayavku,
                                modifier = Modifier
                                    .color(palette.brand.textReversed)
                                    .fillMaxWidth()
                                    .textAlign(TextAlign.Center)
                            )
                        }
                    }
                }
            }
            Box(Modifier.height(XXXXXLargePadding))
            MembersCountSection(modifier = Modifier.fillMaxWidth().padding(leftRight = XXXXXLargePadding))
        }
    }
}

@Composable
private fun DuetsSection(modifier: Modifier) {
    Box(
        modifier = modifier,
        ref = ref {
            ScrollToViewEventProvider.setDuetSectionEvent {
                it.scrollIntoView()
            }
        }
    ) {
        Image(
            Resources.Images.clyaksa_2,
            modifier = Clyaks2ImageStyle.toModifier().align(Alignment.TopEnd)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = XXXXLargePadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.gap(3.5.cssRem)) {
                Div(TitleStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.duet_uppercase,
                        modifier = Modifier
                            .fadeInAnimation()
                    )
                }
                Div(SubheadlineRegularStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.princip_constryktora,
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .fadeInAnimation()
                    )
                }
                @Composable
                fun tripleDuetsColumn(duets: List<String>) {
                    Column {
                        duets.forEach {
                            Div(SubheadlineBoldStyle.toAttrs()) {
                                SpanText(
                                    it,
                                    modifier = Modifier
                                        .whiteSpace(WhiteSpace.PreLine)
                                        .fadeInAnimation()
                                )
                            }
                        }
                    }
                }
                Row(Modifier.gap(2.5.cssRem)) {
                    tripleDuetsColumn(
                        listOf(
                            Resources.Strings.sasha_plus_alya,
                            Resources.Strings.lena_plus_liza,
                            Resources.Strings.ula_plus_yla
                        )
                    )
                    tripleDuetsColumn(
                        listOf(
                            Resources.Strings.ilya_plus_andrey,
                            Resources.Strings.dora_plus_alina,
                            Resources.Strings.marat_plus_yla
                        )
                    )
                    tripleDuetsColumn(
                        listOf(
                            Resources.Strings.milana_plus_jia,
                            Resources.Strings.lena_plus_andrey,
                            Resources.Strings.alya_plus_diana
                        )
                    )
                }
            }
            Column(modifier = Modifier.padding(right = XLargePadding)) {
                SliderSimpleArrow(
                    modifier = Modifier,
                    hasDotsIndicator = false,
                    items = listOf(1), //STUB
                    leftArrow = {
                        Image(
                            Resources.Images.arrow_left,
                            "Main photo",
                            ArrowImageStyle
                                .toModifier()
                                .fadeInAnimation(),
                        )
                    },
                    rightArrow = {
                        Image(
                            Resources.Images.arrow_right,
                            "Main photo",
                            ArrowImageStyle
                                .toModifier()
                                .fadeInAnimation(),
                        )
                    }
                ) {
                    Box(Modifier.padding(leftRight = XXXLargePadding + XXLargePadding)) {
                        Card(
                            modifier = Modifier.width(543.px).height(696.px),
                            color = DesignSurface,
                        ) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomSection(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    //Divider
    Box(Modifier.fillMaxWidth().height(4.px).backgroundColor(DesignDivider))
    Row(
        modifier = modifier.padding(XXXLargePadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        ref = ref {
            ScrollToViewEventProvider.setContactsScrollEvent {
                it.scrollIntoView()
            }
        }
    ) {
        Column(
            modifier = Modifier.gap(1.5.cssRem),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                Resources.Images.masha_logo,
                "Logo icon",
                LogoStyle
                    .toModifier()
                    .fadeInAnimation()
            )
            Row(
                modifier = Modifier.gap(1.5.cssRem),
            ) {
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
                Link(
                    "tel:+79319512000",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                ) {
                    val imgResInst = Resources.Images.ic_phone
                    Image(
                        imgResInst,
                        "",
                        LogoStyleSmall
                            .toModifier(),
                    )
                }
            }

            Div(SubheadlineRegularStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.spb,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fontWeight(FontWeight.Light)
                        .fadeInAnimation()
                )
            }
        }
        Column {
            Div(GritTextTitle.toAttrs()) {
                SpanText(
                    Resources.Strings.ostavte_nomer,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fadeInAnimation()
                )
            }
            var inputText by remember { mutableStateOf("") }
            val inputPrefix = remember { "+7 " }
            var inFocus by remember { mutableStateOf(false) }
            val numberThreshold = remember { 10 }
            var isValid by remember { mutableStateOf(true) }
            Box(Modifier.height(XXLargePadding))
            Input(
                modifier = Modifier
                    .width(364.px)
                    .padding(LargePadding)
                    .borderRadius(1.9.cssRem, 1.9.cssRem)
                    .onFocusIn {
                        inFocus = true
                    }
                    .onFocusOut {
                        isValid = inputText.length == numberThreshold || inputText.isEmpty()
                        inFocus = false
                    },
                type = InputType.Tel,
                value = if (inputText.isNotEmpty() || inFocus) {
                    inputPrefix + inputText
                } else {
                    ""
                },
                onValueChanged = { input ->
                    if (input == inputPrefix.trim()) return@Input
                    val plainNumber = input.removePrefix(inputPrefix).filter { it.isDigit() }
                    if (plainNumber.length > numberThreshold) return@Input
                    inputText = plainNumber
                },
                placeholder = Resources.Strings.vvedite_nomer_telefona_hint,
                spellCheck = InputDefaults.SpellCheck,
                focusBorderColor = DesignWhiteText,
                size = InputSize.LG,
                valid = isValid
            )
            Box(Modifier.height(LargePadding))
            Button(ButtonStyle.toAttrs(OutlinedCircularButtonVariant)) {
                Div(OutlineButtonTextSmallStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.otpravit,
                        modifier = Modifier
                            .color(palette.brand.textReversed)
                            .fillMaxWidth()
                            .textAlign(TextAlign.Center)
                    )
                }
            }
        }
        Column {
            Div(GritTextTitle.toAttrs()) {
                SpanText(
                    Resources.Strings.bolshe_o_nas,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fadeInAnimation()
                )
            }
            Box(Modifier.height(XXXLargePadding + LargePadding))
            Div(SmallRegularTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.jiviye_vystuplenya,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fadeInAnimation()
                )
            }
            Box(Modifier.height(XSmallPadding))
            Link(
                path = "https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg",
                modifier = Modifier.color(DesignWhiteText),
            ) {
                Div(SmallRegularTextStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.repertuar_uppercase,
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .fadeInAnimation()
                    )
                }
            }
            Box(Modifier.height(XSmallPadding))
            Div(SmallRegularTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.tseni,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fadeInAnimation()
                )
            }
            Box(Modifier.height(XSmallPadding))
            Div(SmallRegularTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.vajniye_voprosy,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fadeInAnimation()
                )
            }
        }
    }
}