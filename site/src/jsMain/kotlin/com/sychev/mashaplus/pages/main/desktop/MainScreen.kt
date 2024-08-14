package com.sychev.mashaplus.pages.main.desktop

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
import com.sychev.mashaplus.pages.MainPhotoSlideInAnim
import com.sychev.mashaplus.pages.main.widgets.*
import com.sychev.mashaplus.provider.ScrollToViewEventProvider
import com.sychev.mashaplus.utils.Resources
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
fun MainScreenDesktop() {
    Row(HeroContainerStyle.toModifier()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.gap(2.cssRem).width(100.percent)) {
                ImageHeaderWithLogo()
                Box(Modifier.height(XXXLargePadding))
                OurServices(modifier = Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXLargePadding))
                CreatorSection(modifier = Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXXXLargePadding))
                Box(ref = ref {
                    ScrollToViewEventProvider.setVocalistScrollEvent {
                        it.scrollIntoView()
                    }
                })
                VocalistsSection(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vocalistky_uppercase,
                    vocalistkyList
                )
                Box(Modifier.height(XXXXXLargePadding))
                VocalistsSection(
                    modifier = Modifier.fillMaxWidth(),
                    Resources.Strings.vocalisty_uppercase,
                    vocalistyList
                )
                Box(Modifier.height(XXXXXLargePadding))
                DuetsSection(Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
                Box(Modifier.height(XXXXLargePadding))
                PartnersSection(Modifier.fillMaxWidth().padding(leftRight = LeftRightPadding))
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
fun OurServices(modifier: Modifier = Modifier) {
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
                Div(TitleStyle.toModifier().align(Alignment.TopEnd).toAttrs()) {
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
                    ) {
                        Div(GridTextTitle.toAttrs()) {
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
                    ) {
                        Div(GridTextTitle.toAttrs()) {
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
                    ) {
                        Div(GridTextTitle.toAttrs()) {
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
                    ) {
                        Div(GridTextTitle.toAttrs()) {
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
fun CreatorSection(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Box(modifier) {
        Div(
            CreatorSectionGridStyle.toModifier()
                .grid {
                    rows {
                        repeat(8) { size(1.fr) }
                    }
                    columns {
                        repeat(3) { size(1.fr) }
                    }
                }
                .toAttrs()
        ) {
            GridCell(2, 1, 2, 3) {
                Div(CreatorTextStyle.toAttrs()) {
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
            GridCell(1, 3, 1, 8) {
                Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    Image(
                        Resources.Images.maria_boronina,
                        "null",
                        CreatorPhotoStyle
                            .toModifier().fadeInAnimation(),
                    )
                }
            }
            GridCell(6, 1, 1, 3) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 2.2.cssRem, leftRight = 1.1.cssRem),
                ) {
                    Div(CreatorCardTextStyle.toAttrs()) {
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
            GridCell(6, 2, 1, 3) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 2.2.cssRem, leftRight = 1.1.cssRem),
                ) {
                    Div(CreatorCardTextStyle.toAttrs()) {
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
            GridCell(6, 3, 1, 3) {
                ShadowedCard(
                    Modifier.fillMaxSize()
                        .padding(topBottom = 2.2.cssRem, leftRight = 1.1.cssRem),
                ) {
                    Div(CreatorCardTextStyle.toAttrs()) {
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
fun PartnersSection(modifier: Modifier) {
    Column(modifier = modifier) {
        Div(CreatorCardTextStyle.toAttrs()) {
            SpanText(
                Resources.Strings.partners_title,
                modifier = Modifier
                    .color(DesignYellow)
                    .fadeInAnimation()
            )
        }

        Div(
            PartnersSectionGridStyle.toModifier()
                .padding(top = XXLargePadding)
                .grid {
                    rows {
                        repeat(8) { size(.3.fr) }
                    }
                    columns {
                        repeat(13) { size(.3.fr) }
                    }
                }
                .toAttrs()
        ) {
            GridCell(1, 1, 3, 3) {
                Image(
                    src = Resources.Images.partner_bahroma_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(1, 6, 3, 3) {
                Image(
                    src = Resources.Images.partner_mamaliga_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(1, 11, 3, 3) {
                Image(
                    src = Resources.Images.partner_feromon_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(3, 3, 2, 3) {
                Image(
                    src = Resources.Images.partner_peperoni_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(4, 6, 2, 3) {
                Image(
                    src = Resources.Images.partner_hochy_harcho_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(3, 9, 3, 3) {
                Image(
                    src = Resources.Images.partner_kind_gruzin_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(5, 1, 4, 3) {
                Image(
                    src = Resources.Images.partner_vse_horosho_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
            GridCell(5, 10, 4, 3) {
                Image(
                    src = Resources.Images.partner_grill_house_logo,
                    description = "null",
                    modifier = InsidePhotoStyle
                        .toModifier().fadeInAnimation(),
                )
            }
        }
    }
}

@Composable
private fun VocalistsSection(modifier: Modifier, title: String, list: List<Vocalist>) {
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
                        description = "Main photo",
                        modifier = ArrowImageStyle
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
                        .gap(3.cssRem)
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
                        VocalistCard(
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
                        description = "Main photo",
                        modifier = ArrowImageStyle
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
private fun VocalistCard(
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
fun VideosSection(modifier: Modifier) {
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
            VideoYT("https://www.youtube.com/embed/B2peeQmgBKA?si=HeJUlueJ8IHm8MK1")
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
            VideoYT("https://www.youtube.com/embed/nXraKPsLyXc?si=b38wiQvWQFHYYqRR")
        }
    }
}

@Composable
fun ImageHeaderWithLogo() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            Resources.Images.main_photo,
            "Main photo",
            MainPhotoStyle
                .toModifier()
                .padding(right = 2.5.vw)
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
                        Resources.Strings.sozday_meropriyatie.replace("по своим", "по\nсвоим"),
                        modifier = Modifier
                            .whiteSpace(WhiteSpace.PreLine)
                            .color(palette.brand.whiteText)
                            .fadeInAnimation()
                            .textShadow(offsetY = 1.px, offsetX = 1.px, blurRadius = 1.px, color = Colors.Black)
                    )
                }
                Div(SubheadlineRegularStyle.toAttrs()) {
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
            Box(Modifier.height(XXXXLargePadding))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                MembersCountSection(modifier = Modifier.width(70.percent))
            }
        }
    }
}

@Composable
private fun DuetsSection(modifier: Modifier) {
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
                }
            }
        }
        GridCell(1, 4, 2, 1) {
            Box(modifier = Modifier.padding(right = XXXXLargePadding)) {
                Image(
                    Resources.Images.clyaksa_2,
                    modifier = Clyaks2ImageStyle.toModifier()
                        .padding(right = XXLargePadding)
                        .align(Alignment.TopEnd)
                )
                SliderSimpleArrow(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    hasDotsIndicator = false,
                    items = duetList,
                ) { value, _ ->
                    Box(
                        Modifier
                            .minWidth(500.px).minHeight(740.px)
                            .align(Alignment.Center)
                    ) {
                        Image(
                            src = value,
                            description = "null",
                            modifier = DuetPhotoStyle
                                .toModifier().fadeInAnimation(),
                        )
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
        verticalAlignment = Alignment.Bottom,
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
            Div(BottomCaptionTitle.toAttrs()) {
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