package com.sychev.mashaplus.pages.main.laptop

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.widgets.Card
import com.sychev.mashaplus.components.widgets.SliderSimpleArrow
import com.sychev.mashaplus.models.Vocalist
import com.sychev.mashaplus.models.duetList
import com.sychev.mashaplus.models.vocalistkyList
import com.sychev.mashaplus.models.vocalistyList
import com.sychev.mashaplus.pages.HeroContainerStyle
import com.sychev.mashaplus.pages.LogoStyle
import com.sychev.mashaplus.pages.LogoStyleSmall
import com.sychev.mashaplus.pages.main.desktop.ImageHeaderWithLogo
import com.sychev.mashaplus.pages.main.desktop.OurServices
import com.sychev.mashaplus.pages.main.desktop.PartnersSection
import com.sychev.mashaplus.pages.main.widgets.*
import com.sychev.mashaplus.provider.ScrollToViewEventProvider
import com.sychev.mashaplus.utils.Resources
import com.sychev.mashaplus.utils.VideoFrameStyleLaptop
import com.sychev.mashaplus.utils.VideoYT
import com.sychev.mashaplus.utils.fadeInAnimation
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
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
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.ScrollToOptions

@Composable
fun MainScreenLaptop() {
    Row(HeroContainerStyle.toModifier()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.gap(2.cssRem).width(100.percent)) {
                ImageHeaderWithLogo()
                Box(Modifier.height(XXXLargePadding))
                OurServices(modifier = Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXLargePadding))
                CreatorSectionLaptop(modifier = Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXLargePadding))
                Box(ref = ref {
                    ScrollToViewEventProvider.setVocalistScrollEvent {
                        it.scrollIntoView()
                    }
                })
                VocalistsSectionLaptop(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vocalistky_uppercase,
                    vocalistkyList
                )
                Box(Modifier.height(XXXLargePadding))
                VocalistsSectionLaptop(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vocalisty_uppercase,
                    vocalistyList
                )
                Box(Modifier.height(XXXLargePadding))
                DuetsSectionLaptop(Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXXLargePadding))
                PartnersSection(Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                VideosSectionLaptop(Modifier.fillMaxWidth())
                Box(Modifier.height(XXXLargePadding))
                BottomSectionLaptop(Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
private fun CreatorSectionLaptop(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Box(modifier) {
        Div(
            CreatorSectionGridStyleLaptop.toModifier()
                .grid {
                    auto {
                        rows {
                            repeat(5) { size(1.fr) }
                        }
                        columns {
                            repeat(6) { size(1.fr) }
                        }
                    }

                }
                .toAttrs()
        ) {
            GridCell(1, 1, 4, 2) {
                Div(CreatorTextStyleMobile.toAttrs()) {
                    SpanText(
                        Resources.Strings.created_by1,
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                    SpanText(
                        Resources.Strings.created_by2,
                        modifier = Modifier
                            .fontWeight(FontWeight.Bold)
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                    SpanText(
                        Resources.Strings.created_by3,
                        modifier = Modifier
                            .color(palette.brand.text)
                            .fadeInAnimation()
                    )
                    SpanText(
                        Resources.Strings.created_by4,
                        modifier = Modifier
                            .color(DesignYellow)
                            .fontWeight(FontWeight.Bold)
                            .fadeInAnimation()
                    )
                }
            }
            GridCell(1, 5, 2, 4) {
                Image(
                    Resources.Images.maria_boronina,
                    "null",
                    CreatorPhotoStyleLaptop
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(3, 1, 4, 1) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 0.4.cssRem, leftRight = 1.1.cssRem),
                ) {
                    Div(CreatorTextStyleLaptop.toAttrs()) {
                        SpanText(
                            Resources.Strings.bak_vocalistka,
                            modifier = Modifier
                                .fontWeight(FontWeight.Bold)
                                .color(palette.brand.textReversed)
                                .fadeInAnimation()
                        )
                        SpanText(
                            Resources.Strings.bak_vocalistka_desc,
                            modifier = Modifier
                                .color(palette.brand.textReversed)
                                .fadeInAnimation()
                        )
                    }
                }
            }
            GridCell(4, 2, 4, 1) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 0.4.cssRem, leftRight = 1.1.cssRem),
                ) {
                    Div(CreatorTextStyleLaptop.toAttrs()) {
                        SpanText(
                            Resources.Strings.studio_bak_vocal,
                            modifier = Modifier
                                .fontWeight(FontWeight.Bold)
                                .color(palette.brand.textReversed)
                                .fadeInAnimation()
                        )
                        SpanText(
                            Resources.Strings.studio_bak_vocal_desc,
                            modifier = Modifier
                                .color(palette.brand.textReversed)
                                .fadeInAnimation()
                        )
                    }
                }
            }
            GridCell(5, 3, 4, 1) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 0.4.cssRem, leftRight = 1.1.cssRem),
                ) {
                    Div(CreatorTextStyleLaptop.toAttrs()) {
                        SpanText(
                            Resources.Strings.bolee_ten,
                            modifier = Modifier
                                .fontWeight(FontWeight.Bold)
                                .color(palette.brand.textReversed)
                                .fadeInAnimation()
                        )
                        SpanText(
                            Resources.Strings.bolee_ten_desc,
                            modifier = Modifier
                                .color(palette.brand.textReversed)
                                .fadeInAnimation()
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun VocalistsSectionLaptop(modifier: Modifier, title: String, list: List<Vocalist>) {
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
        Div(
            PartnersSectionGridStyle.toModifier()
                .grid {
                    rows {
                        repeat(1) { size(1.fr) }
                    }
                    columns {
                        repeat(10) { size(1.fr) }
                    }
                }
                .toAttrs()
        ) {
            val itemsLeftPoints = remember { mutableStateListOf<Double>() }
            var currentPosition by remember { mutableStateOf(0) }
            var rowElement by remember { mutableStateOf<Element?>(null) }
            GridCell(1, 1, 1, 1) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        src = Resources.Images.arrow_left,
                        description = "left",
                        modifier = ArrowImageStyleLaptop
                            .toModifier()
                            .align(Alignment.Center)
                            .fadeInAnimation(),
                        ref = ref { element ->
                            element.onclick = {
                                val index = if (currentPosition == 0) {
                                    0
                                } else {
                                    --currentPosition
                                }
                                itemsLeftPoints[index].let {
                                    rowElement?.scrollTo(
                                        ScrollToOptions(it)
                                    )
                                }
                            }
                        }
                    )
                }
            }
            GridCell(1, 2, 8, 1) {
                ScrollToViewEventProvider
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .overflow(Overflow.Hidden)
                        .gap(1.6.cssRem)
                        .scrollBehavior(ScrollBehavior.Smooth)
                        .styleModifier {
                            property("display", "-webkit-box")
                            property("-webkit-box-pack", "center")
                        },
                    horizontalArrangement = Arrangement.Center,
                    ref = ref {
                        rowElement = it
                    }
                ) {
                    list.forEachIndexed { index, vocalist ->
                        VocalistCardLaptop(
                            Modifier,
                            vocalist.name,
                            vocalist.imgRes,
                            ref = ref { element ->
                                val rect = element.getBoundingClientRect()
                                if (index == 0) {
                                    itemsLeftPoints.add(0.0)
                                } else {
                                    itemsLeftPoints.add(rect.left)
                                }
                            }
                        )
                    }
                }
            }
            GridCell(1, 10, 1, 1) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        src = Resources.Images.arrow_right,
                        description = "right",
                        modifier = ArrowImageStyleLaptop
                            .toModifier()
                            .align(Alignment.Center)
                            .fadeInAnimation(),
                        ref = ref { element ->
                            element.onclick = {
                                val index = if (list.lastIndex == currentPosition + 2) {
                                    list.lastIndex
                                } else {
                                    ++currentPosition
                                }
                                itemsLeftPoints[index].let {
                                    rowElement?.scrollTo(
                                        ScrollToOptions(it)
                                    )
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun VocalistCardLaptop(
    modifier: Modifier,
    name: String,
    photoRes: String,
    ref: ElementRefScope<HTMLElement>? = null
) {
    Column(modifier.gap(2.5.cssRem)) {
        Box(
            modifier = Modifier,
            ref = ref,
            contentAlignment = Alignment.BottomCenter
        ) {
            val cardWidth = 238.px
            val cardHeight = 304.px
            Card(
                modifier = Modifier.width(cardWidth).height(cardHeight)
                    .backgroundImage(linearGradient(LinearGradient.Direction.ToRight, GradientLeft, GradientRight)),
                borderRadius = 3.cssRem
            ) {}
            Image(
                photoRes,
                "null",
                PersonWithCardPhotoStyleLaptop
                    .toModifier().fadeInAnimation(),
            )
        }
        Div(VocalistTextTitle.toAttrs()) {
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
private fun DuetsSectionLaptop(modifier: Modifier) {
    Div(
        DuetSectionGridStyle.toModifier()
            .grid {
                rows {
                    repeat(1) { size(1.fr) }
                }
                columns {
                    repeat(5) { size(1.fr) }
                }
            }
            .toAttrs()
    ) {
        GridCell(1, 1, 3, 1) {
            Box(
                modifier = modifier,
                ref = ref {
                    ScrollToViewEventProvider.setDuetSectionEvent {
                        it.scrollIntoView()
                    }
                }
            ) {
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
                        Div(SubheadlineRegularStyleLaptop.toAttrs()) {
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
                                    Div(SubheadlineBoldStyleLaptop.toAttrs()) {
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
                        Row(Modifier.gap(2.cssRem)) {
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
                }
            }
        }
        GridCell(1, 4, 2, 1) {
            Box(modifier = Modifier.padding(right = XXLargePadding)) {
                Image(
                    Resources.Images.clyaksa_2,
                    modifier = Clyaks2ImageLaptop.toModifier()
                        .padding(right = XLargePadding)
                        .align(Alignment.TopEnd)
                )
                var selectedIndex by remember { mutableStateOf(0) }
                SliderSimpleArrow(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    hasDotsIndicator = false,
                    items = duetList,
                    leftArrow = {
                        Image(
                            if (selectedIndex > 0) Resources.Images.arrow_left_painted else Resources.Images.arrow_left,
                            "Main photo",
                            ArrowImageStyleLaptop
                                .toModifier()
                                .fadeInAnimation(),
                        )
                    },
                    rightArrow = {
                        Image(
                            if (selectedIndex < duetList.lastIndex) Resources.Images.arrow_right_painted else Resources.Images.arrow_right,
                            "Main photo",
                            ArrowImageStyleLaptop
                                .toModifier()
                                .fadeInAnimation(),
                        )
                    },
                ) { value, index ->
                    selectedIndex = index
                    Box(
                        Modifier
                            .align(Alignment.Center)
                    ) {
                        Image(
                            src = value,
                            description = "null",
                            modifier = DuetPhotoStylLaptop
                                .toModifier()
                                .fadeInAnimation(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomSectionLaptop(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    //Divider
    Box(Modifier.fillMaxWidth().height(3.px).backgroundColor(DesignDivider))
    Row(
        modifier = modifier.padding(XXLargePadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        ref = ref {
            ScrollToViewEventProvider.setContactsScrollEvent {
                it.scrollIntoView()
            }
        }
    ) {
        Column(
            modifier = Modifier.gap(1.1.cssRem),
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
                modifier = Modifier.gap(1.1.cssRem),
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

            Div(SubheadlineRegularStyleLaptop.toAttrs()) {
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
            Div(BottomCaptionTitleLaptop.toAttrs()) {
                SpanText(
                    Resources.Strings.ostavte_nomer.replace("создадим ваше", "создадим\nваше"),
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
            Div(GridTextTitle.toAttrs()) {
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
                    Resources.Strings.prices,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fadeInAnimation()
                )
            }
            Box(Modifier.height(XSmallPadding))
            Div(SmallRegularTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.important_questions,
                    modifier = Modifier
                        .whiteSpace(WhiteSpace.PreLine)
                        .fadeInAnimation()
                )
            }
        }
    }
}

@Composable
fun VideosSectionLaptop(modifier: Modifier) {
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
            VideoYT("https://www.youtube.com/embed/_c2B9DN_khg?si=eVhKkAczzjP_Afsm", style = VideoFrameStyleLaptop)
        }
        Box(Modifier.height(XXXLargePadding))
        Div(TitleStyle.toAttrs()) {
            SpanText(
                Resources.Strings.vocalnoye_show_uppercase,
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
            VideoYT("https://www.youtube.com/embed/aEh4p6dUbvU?si=sZIsdey5lwHZ-rBx", style = VideoFrameStyleLaptop)
        }
    }
}