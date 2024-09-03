package com.sychev.mashaplus.pages.main.hybrid

import androidx.compose.runtime.*
import com.sychev.mashaplus.*
import com.sychev.mashaplus.components.widgets.Card
import com.sychev.mashaplus.components.widgets.SliderSimpleArrow
import com.sychev.mashaplus.http.RequestSender
import com.sychev.mashaplus.models.Vocalist
import com.sychev.mashaplus.models.duetList
import com.sychev.mashaplus.models.vocalistkyList
import com.sychev.mashaplus.models.vocalistyList
import com.sychev.mashaplus.pages.HeroContainerStyle
import com.sychev.mashaplus.pages.LogoStyle
import com.sychev.mashaplus.pages.LogoStyleSmall
import com.sychev.mashaplus.pages.MainPhotoSlideInAnim
import com.sychev.mashaplus.pages.main.desktop.PartnersSection
import com.sychev.mashaplus.pages.main.widgets.*
import com.sychev.mashaplus.provider.ScrollToViewEventProvider
import com.sychev.mashaplus.utils.Resources
import com.sychev.mashaplus.utils.VideoFrameStyleHybrid
import com.sychev.mashaplus.utils.VideoYT
import com.sychev.mashaplus.utils.fadeInAnimation
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.rememberPageContext
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
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import org.w3c.dom.ScrollToOptions

@Composable
fun MainScreenHybrid() {
    Row(HeroContainerStyle.toModifier()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.gap(2.cssRem).width(100.percent)) {
                ImageHeaderWithLogoHybrid()
                Box(Modifier.height(XXXLargePadding))
                OurServicesHybrid(modifier = Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXLargePadding))
                CreatorSectionHybrid(modifier = Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXLargePadding))
                Box(ref = ref {
                    ScrollToViewEventProvider.setVocalistScrollEvent {
                        it.scrollIntoView()
                    }
                })
                VocalistsSectionHybrid(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vocalistky_uppercase,
                    vocalistkyList
                )
                Box(Modifier.height(XXXLargePadding))
                VocalistsSectionHybrid(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vocalisty_uppercase,
                    vocalistyList
                )
                Box(Modifier.height(XXXLargePadding))
                DuetsSectionHybrid(Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXXLargePadding))
                PartnersSection(Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                VideosSectionHybrid(Modifier.fillMaxWidth())
                Box(Modifier.height(XXXLargePadding))
                BottomSectionHybrid(Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
private fun ImageHeaderWithLogoHybrid() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            Resources.Images.main_photo,
            "Main photo",
            MainPhotoStyle
                .toModifier()
                .padding(top = 16.cssRem)
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = XXLargePadding, leftRight = LeftRightPadding)
                    .gap(2.2.cssRem),
                horizontalAlignment = Alignment.Start
            ) {
                Div(MainTitleTextStyleHybrid.toAttrs()) {
                    SpanText(
                        Resources.Strings.sozday_meropriyatie.replace("по своим", "по\nсвоим"),
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .color(palette.brand.whiteText)
                            .fadeInAnimation()
                            .textShadow(offsetY = 1.px, offsetX = 1.px, blurRadius = 1.px, color = Colors.Black)
                    )
                }
                Div(SubheadlineRegularStyleHybrid.toAttrs()) {
                    SpanText(
                        Resources.Strings.muzik_project.replace("выступлений.", "выступлений.\n")
                            .replace("который ", "который\n"),
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .color(palette.brand.whiteText)
                            .fadeInAnimation()
                            .textShadow(offsetY = 1.px, offsetX = 1.px, blurRadius = 1.px, color = Colors.Black)
                    )
                }
                Spacer()
                var isInMouse by remember { mutableStateOf(false) }
                ShadowedLink(
                    "https://vk.com/masha_plus_band",
                    modifier = Modifier
                        .onMouseEnter { isInMouse = true }
                        .onMouseLeave { isInMouse = false }
                ) {
                    Button(ButtonStyle.toAttrs(if (isInMouse) OutlinedGradientCircularButtonVariant else GradientCircularButtonVariant)) {
                        Div(OutlineButtonTextStyle.toAttrs()) {
                            SpanText(
                                Resources.Strings.ostavit_zayavku,
                                modifier = Modifier
                                    .color(if (isInMouse) palette.brand.text else palette.brand.textReversed)
                                    .fillMaxWidth()
                                    .textAlign(TextAlign.Center)
                            )
                        }
                    }
                }
            }
            Box(Modifier.height(16.cssRem))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                MembersCountSectionHybrid(modifier = Modifier.width(78.percent))
            }
        }
    }
}

@Composable
fun OurServicesHybrid(modifier: Modifier = Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Box(Modifier.fillMaxWidth()) {
        Box(modifier = Modifier.padding(left = LargePadding, top = LargePadding)) {
            Image(
                Resources.Images.clyaksa1,
                modifier = ClyaksImageStyle.toModifier()
            )
        }
        Column(modifier.fillMaxWidth().gap(3.5.cssRem)) {
            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Div(TitleStyleHybrid.toModifier().align(Alignment.TopEnd).toAttrs()) {
                    SpanText(
                        Resources.Strings.nashi_yslygi,
                        modifier = Modifier
                            .fadeInAnimation()
                    )
                }
            }
            Div(
                OurServicesGridStyle.toModifier()
                    .grid {
                        rows {
                            repeat(2) { size(1.fr) }
                        }
                        columns {
                            repeat(4) { size(1.fr) }
                        }
                    }
                    .toAttrs()
            ) {
                GridCell(1, 1, 3, 1) {
                    ShadowedCard(
                        modifier = Modifier.fillMaxWidth().onClick {
                            ScrollToViewEventProvider.sendUltimaBandScrollEvent()
                        },
                        contentAlignment = Alignment.CenterHorizontally,
                        paddingValues = 1.9.vh,
                        borderRadius = 2.cssRem,
                    ) {
                        Div(GridTextTitleHybrid.toAttrs()) {
                            SpanText(
                                Resources.Strings.ultima_band,
                                modifier = Modifier
                                    .color(palette.brand.textReversed)
                                    .fadeInAnimation()
                            )
                        }
                    }
                }
                GridCell(1, 4, 1, 1) {
                    ShadowedCard(
                        modifier = Modifier.fillMaxWidth().onClick {
                            ScrollToViewEventProvider.sendDuetScrollEvent()
                        },
                        contentAlignment = Alignment.CenterHorizontally,
                        paddingValues = 1.9.vh,
                        borderRadius = 2.cssRem,
                    ) {
                        Div(GridTextTitleHybrid.toAttrs()) {
                            SpanText(
                                Resources.Strings.duet_uppercase,
                                modifier = Modifier
                                    .color(palette.brand.textReversed)
                                    .fadeInAnimation()
                            )
                        }
                    }
                }
                GridCell(2, 1, 2, 1) {
                    ShadowedCard(
                        modifier = Modifier.fillMaxWidth().onClick {
                            ScrollToViewEventProvider.sendVocalistScrollEvent()
                        },
                        contentAlignment = Alignment.CenterHorizontally,
                        paddingValues = 1.9.vh,
                        borderRadius = 2.cssRem,
                    ) {
                        Div(GridTextTitleHybrid.toAttrs()) {
                            SpanText(
                                Resources.Strings.vocalisty_uppercase,
                                modifier = Modifier
                                    .color(palette.brand.textReversed)
                                    .fadeInAnimation()
                            )
                        }
                    }
                }
                GridCell(2, 3, 2, 1) {
                    ShadowedCard(
                        modifier = Modifier.fillMaxWidth()
                            .onClick { ScrollToViewEventProvider.sendVocalShowScrollEvent() },
                        contentAlignment = Alignment.CenterHorizontally,
                        paddingValues = 1.9.vh,
                        borderRadius = 2.cssRem,
                    ) {
                        Div(GridTextTitleHybrid.toAttrs()) {
                            SpanText(
                                Resources.Strings.vocalnoye_show_uppercase,
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
}

@Composable
private fun MembersCountSectionHybrid(modifier: Modifier = Modifier) {
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
            paddingValues = 2.cssRem,
            borderRadius = 2.1.cssRem
        ) {
            Row(
                modifier = Modifier.gap(5.5.cssRem),
            ) {
                TextWithNum(
                    Resources.Strings.vocalisty,
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
private fun CreatorSectionHybrid(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Box(modifier) {
        Div(
            CreatorSectionGridStyleLaptop.toModifier()
                .grid {
                    rows {
                        repeat(4) { size(1.fr) }
                    }
                    columns {
                        repeat(7) { size(1.fr) }
                    }
                }
                .gap(2.cssRem)
                .toAttrs()
        ) {
            GridCell(1, 1, 7, 2) {
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
            GridCell(2, 1, 5, 1) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 0.4.cssRem, leftRight = 1.1.cssRem),
                    borderRadius = 2.cssRem,
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
            GridCell(3, 3, 5, 1) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 0.4.cssRem, leftRight = 1.1.cssRem),
                    borderRadius = 2.cssRem,
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
            GridCell(4, 1, 5, 1) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 0.4.cssRem, leftRight = 1.1.cssRem),
                    borderRadius = 2.cssRem,
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
private fun VocalistsSectionHybrid(modifier: Modifier, title: String, list: List<Vocalist>) {
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
                    var leftEnter by remember { mutableStateOf(false) }
                    Image(
                        src = if (leftEnter && currentPosition != 0) Resources.Images.arrow_left_painted else Resources.Images.arrow_left,
                        description = "left",
                        modifier = ArrowImageStyleLaptop
                            .toModifier()
                            .align(Alignment.Center)
                            .onMouseEnter { leftEnter = true }
                            .onMouseLeave { leftEnter = false }
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
                    var rightEnter by remember { mutableStateOf(false) }
                    Image(
                        src = if (rightEnter && list.lastIndex != currentPosition + 2) Resources.Images.arrow_right_painted else Resources.Images.arrow_right,
                        description = "right",
                        modifier = ArrowImageStyleLaptop
                            .toModifier()
                            .align(Alignment.Center)
                            .onMouseEnter { rightEnter = true }
                            .onMouseLeave { rightEnter = false }
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
            val cardHeight = 268.px
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
private fun DuetsSectionHybrid(modifier: Modifier) {
    Column(modifier = modifier.gap(3.5.cssRem)) {
        Div(TitleStyle.toAttrs()) {
            SpanText(
                Resources.Strings.duet_uppercase,
                modifier = Modifier
                    .fadeInAnimation()
            )
        }
        Div(SubheadlineRegularStyleLaptop.toAttrs()) {
            SpanText(
                Resources.Strings.princip_constryktora
                    .replace("когда ", "когда\n")
                    .replace("любых ", "любых\n")
                    .replace("вокалистов ", "вокалистов\n"),
                modifier = Modifier
                    .whiteSpace(WhiteSpace.PreLine)
                    .fadeInAnimation()
            )
        }
    }
    Div(
        DuetSectionGridStyleHybrid.toModifier()
            .grid {
                auto {
                    rows {
                        repeat(2) { size(1.fr) }
                    }
                    columns {
                        repeat(8) { size(1.fr) }
                    }
                }
            }
            .toAttrs()
    ) {
        GridCell(1, 1, 4, 1) {
            Box(
                modifier = modifier,
                ref = ref {
                    ScrollToViewEventProvider.setDuetSectionEvent {
                        it.scrollIntoView()
                    }
                }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.gap(3.5.cssRem)) {
                        @Composable
                        fun tripleDuetsColumn(duets: List<String>) {
                            Column {
                                duets.forEach {
                                    Div(SubheadlineBoldStyleHybrid.toAttrs()) {
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
        GridCell(1, 4, 2, 2) {
            Box(modifier = Modifier) {
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
fun BottomSectionHybrid(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    //Divider
    Box(Modifier.fillMaxWidth().height(3.px).backgroundColor(DesignDivider))
    Row(
        modifier = modifier.padding(XXLargePadding),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
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
                Link("https://www.instagram.com/masha_plus_band?igsh=cnNhY3JqNnZxMWc1&utm_source=qr") {
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
                    "",
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                ) {
                    var showPhone by remember { mutableStateOf(false) }
                    Image(
                        Resources.Images.ic_phone,
                        "",
                        LogoStyleSmall
                            .toModifier()
                            .onClick {
                                window.alert("Номер телефона скопирован")
                                window.navigator.clipboard.writeText(Resources.Strings.phone_num)
                            }
                            .onMouseEnter { showPhone = true }
                            .onMouseLeave { showPhone = false },
                    )
                    if (showPhone) {
                        Box(modifier = Modifier.position(Position.Absolute)) {
                            Div(SmallRegularTextStyle.toModifier().toAttrs()) {
                                SpanText(
                                    text = Resources.Strings.phone_num,
                                    modifier = Modifier
                                        .color(palette.brand.whiteText)
                                        .fadeInAnimation()
                                )
                            }
                        }
                    }
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
            val ctx = rememberPageContext()
            Button(
                ButtonStyle.toAttrs(OutlinedCircularButtonVariant) {
                    onClick {
                        if (isValid && inputText.isNotEmpty()) {
                            RequestSender.sendTgMessage(
                                inputPrefix + inputText,
                                onSuccess = {
                                    ctx.router.navigateTo("/success")
                                    inputText = ""
                                },
                                onError = {
                                    window.alert("Произошла ошибка при отправке телефона")
                                }
                            )
                        }
                    }
                },
            ) {
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
        Box(modifier = Modifier.width(2.5.cssRem))
        Column {
            ShadowedLink(
                "https://vk.com/album-218638803_304260826",
                modifier = Modifier.color(DesignWhiteText)
            ) {
                Div(SmallRegularTextStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.photo,
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .fadeInAnimation()
                    )
                }
            }
            Box(Modifier.height(XSmallPadding))
            ShadowedLink(
                "https://t.me/masha_plus_portfolio",
                modifier = Modifier.color(DesignWhiteText)
            ) {
                Div(SmallRegularTextStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.jiviye_vystuplenya,
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .fadeInAnimation()
                    )
                }
            }
            Box(Modifier.height(XSmallPadding))
            ShadowedLink(
                path = "https://drive.google.com/drive/folders/1-0Tf-QdBAP7xsra3CpC1r8hhNZJYMDgH",
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
            ShadowedLink(
                "https://vk.com/masha_plus_band",
                modifier = Modifier.color(DesignWhiteText)
            ) {
                Div(SmallRegularTextStyle.toAttrs()) {
                    SpanText(
                        Resources.Strings.prices,
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .fadeInAnimation()
                    )
                }
            }
            Box(Modifier.height(XSmallPadding))
            ShadowedLink(
                "https://m.vk.com/@masha_plus_band-samoe-vremya-otvetit-na-chastye-voprosy",
                modifier = Modifier.color(DesignWhiteText)
            ) {
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
}

@Composable
fun VideosSectionHybrid(modifier: Modifier) {
    Column(
        modifier = modifier.gap(3.5.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(TitleStyle.toAttrs()) {
            SpanText(
                Resources.Strings.ultima_band,
                modifier = Modifier,
                ref = ref {
                    ScrollToViewEventProvider.setUltimaBandSectionEvent {
                        it.scrollIntoView()
                    }
                }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            VideoYT("https://www.youtube.com/embed/B2peeQmgBKA?si=HeJUlueJ8IHm8MK1", style = VideoFrameStyleHybrid)
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
            VideoYT("https://www.youtube.com/embed/nXraKPsLyXc?si=b38wiQvWQFHYYqRR", style = VideoFrameStyleHybrid)
        }
    }
}