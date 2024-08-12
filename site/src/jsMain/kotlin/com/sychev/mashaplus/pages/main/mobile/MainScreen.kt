package com.sychev.mashaplus.pages.main.mobile

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
import com.sychev.mashaplus.utils.VideoFrameStyleMobile
import com.sychev.mashaplus.utils.VideoYT
import com.sychev.mashaplus.utils.fadeInAnimation
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.dom.ref
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
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
import org.w3c.dom.HTMLElement

@Composable
fun MainScreenMobile() {
    Row(HeroContainerStyle.toModifier()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.gap(2.cssRem).width(100.percent).padding(top = 2.2.cssRem)) {
                val leftRightMarginDefault = remember { 1.5.cssRem }
                HeaderMobile(modifier = Modifier.fillMaxWidth().padding(leftRight = leftRightMarginDefault))
                OurServicesMobile(modifier = Modifier.fillMaxWidth().padding(leftRight = 2.2.cssRem))
                CreatedBySectionMobile(modifier = Modifier.fillMaxWidth().padding(leftRight = leftRightMarginDefault))
                VocalistsSectionMobile(
                    modifier = Modifier.fillMaxWidth().padding(leftRight = leftRightMarginDefault),
                    title = Resources.Strings.vocalistky_uppercase,
                    list = vocalistkyList,
                )
                VocalistsSectionMobile(
                    modifier = Modifier.fillMaxWidth().padding(leftRight = leftRightMarginDefault),
                    title = Resources.Strings.vocalisty_uppercase,
                    list = vocalistyList,
                )
                DuetSectionMobile(Modifier.fillMaxWidth().padding(leftRight = leftRightMarginDefault))
                PartnersSectionMobile(modifier = Modifier.fillMaxWidth().padding(leftRight = leftRightMarginDefault))
                VideosSectionMobile(Modifier.fillMaxWidth())
                Box(Modifier.fillMaxWidth().height(4.px).backgroundColor(DesignBottomDivider))
                BottomSectionMobile(modifier = Modifier.fillMaxWidth().padding(leftRight = leftRightMarginDefault))
            }
        }
    }
}

@Composable
private fun HeaderMobile(
    modifier: Modifier,
) {
    val palette = ColorMode.current.toSitePalette()
    Column(modifier = modifier.overflow(Overflow.Hidden)) {
        Row(modifier = Modifier.width(80.percent)) {
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
        }
        Box(Modifier.height(1.2.cssRem))
        Div(SubheadlineRegularStyleMobile.toAttrs()) {
            SpanText(
                Resources.Strings.muzik_project,
                modifier = Modifier
                    .whiteSpace(WhiteSpace.PreLine)
                    .color(palette.brand.whiteText)
                    .fadeInAnimation()
                    .textShadow(offsetY = 1.px, offsetX = 1.px, blurRadius = 1.px, color = Colors.Black)
            )
        }
        Box(Modifier.height(3.cssRem))
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            var isInMouse by remember { mutableStateOf(false) }
            Link(
                "https://vk.com/masha_plus_band",
                modifier = Modifier
                    .onMouseEnter { isInMouse = true }
                    .onMouseLeave { isInMouse = false }
            ) {
                Button(ButtonStyle.toAttrs(if (isInMouse) OutlinedGradientCircularButtonVariant else GradientCircularButtonVariant)) {
                    Div(OutlineButtonTextStyleMobile.toAttrs()) {
                        SpanText(
                            Resources.Strings.ostavit_zayavku,
                            modifier = Modifier
                                .color(if (isInMouse) palette.brand.text else palette.brand.textReversed)
                                .fillMaxWidth()
                                .textAlign(TextAlign.Center)
                                .padding(leftRight = 2.cssRem)
                        )
                    }
                }
            }
        }
        Box(Modifier.height(3.cssRem))
        Image(
            Resources.Images.main_photo_mobile,
            "Main photo",
            MainPhotoStyleMobile
                .toModifier()
                .animation(
                    MainPhotoSlideInAnim.toAnimation(
                        duration = 300.ms,
                        timingFunction = AnimationTimingFunction.EaseIn,
                        direction = AnimationDirection.Normal,
                        fillMode = AnimationFillMode.Backwards,
                    )
                ),
        )
        Box(Modifier.height(4.cssRem))
        Box(Modifier.fillMaxWidth().padding(leftRight = 4.cssRem)) {
            Card(
                modifier = Modifier.fillMaxWidth().backdropFilter(blur(10.px)),
                color = MembersSectionCardMobile,
                paddingValues = 1.5.cssRem,
                borderRadius = 2.5.cssRem
            ) {
                @Composable
                fun TextWithNum(
                    title: String,
                    num: String
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Div(SmallTitleStyle.toAttrs()) {
                            SpanText(
                                text = "${title}: ",
                                modifier = Modifier
                                    .fadeInAnimation()
                            )
                        }
                        Div(SmallTitleStyle.toAttrs()) {
                            SpanText(
                                num,
                                modifier = Modifier
                                    .fadeInAnimation()
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier.gap(1.cssRem),
                ) {
                    TextWithNum(
                        Resources.Strings.instrymentalisty,
                        Resources.Strings.text_10,
                    )
                    TextWithNum(
                        Resources.Strings.let_text,
                        Resources.Strings.text_5,
                    )
                    TextWithNum(
                        Resources.Strings.vocalisty,
                        Resources.Strings.text_14
                    )
                }
            }
        }
    }
}

@Composable
private fun OurServicesMobile(modifier: Modifier) {
    val palette = ColorMode.current.toSitePalette()
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            Resources.Images.clyaksa1,
            modifier = ClyaksImageStyleMobile.toModifier().padding(top = 4.cssRem, left = 0.2.cssRem).rotateZ(20.grad)
                .zIndex(0)
        )
        Column(
            modifier = modifier.gap(2.cssRem).zIndex(1),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Div(TitleStyleMobile.toModifier().toAttrs()) {
                SpanText(
                    Resources.Strings.nashi_yslygi,
                    modifier = Modifier
                        .fadeInAnimation()
                )
            }
            Box(modifier = Modifier.height(1.cssRem))
            ShadowedCard(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterHorizontally,
                paddingValues = 1.3.vh,
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
            ShadowedCard(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterHorizontally,
                paddingValues = 1.3.vh,
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
            ShadowedCard(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterHorizontally,
                paddingValues = 1.3.vh,
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
            ShadowedCard(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterHorizontally,
                paddingValues = 1.3.vh,
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
    }
}

@Composable
private fun CreatedBySectionMobile(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val palette = ColorMode.current.toSitePalette()
        Box(Modifier.height(2.cssRem))
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
        Box(Modifier.height(1.cssRem))
        Image(
            Resources.Images.maria_boronina,
            "null",
            CreatorPhotoStyleMobile
                .toModifier()
                .padding(leftRight = 2.cssRem)
                .fadeInAnimation(),
        )
        ShadowedCard(
            Modifier.fillMaxSize()
                .padding(topBottom = 1.2.cssRem, leftRight = 0.5.cssRem),
            borderRadius = 3.1.vh,
        ) {
            Div(CreatorCardTextStyleMobile.toAttrs()) {
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
        Box(Modifier.height(0.9.cssRem))
        ShadowedCard(
            Modifier.fillMaxSize()
                .padding(topBottom = 1.2.cssRem, leftRight = 0.5.cssRem),
            borderRadius = 3.1.vh,
        ) {
            Div(CreatorCardTextStyleMobile.toAttrs()) {
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
        Box(Modifier.height(0.9.cssRem))
        ShadowedCard(
            Modifier.fillMaxSize()
                .padding(topBottom = 1.2.cssRem, leftRight = 0.5.cssRem),
            borderRadius = 3.1.vh,
        ) {
            Div(CreatorCardTextStyleMobile.toAttrs()) {
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

@Composable
private fun VocalistsSectionMobile(
    modifier: Modifier,
    title: String,
    list: List<Vocalist>
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        ref = ref {
            ScrollToViewEventProvider.setVocalistScrollEvent {
                it.scrollIntoView()
            }
        }
    ) {
        Div(TitleStyleMobile.toAttrs()) {
            SpanText(
                title,
                modifier = Modifier
                    .fadeInAnimation()
            )
        }
        var selectedIndex by remember { mutableStateOf(0) }
        Box(Modifier.height(1.5.cssRem))
        SliderSimpleArrow(
            modifier = Modifier,
            hasDotsIndicator = false,
            leftArrow = {
                Image(
                    if (selectedIndex > 0) Resources.Images.arrow_left_painted else Resources.Images.arrow_left,
                    "Main photo",
                    ArrowImageStyleMobile
                        .toModifier()
                        .fadeInAnimation(),
                )
            },
            rightArrow = {
                Image(
                    if (selectedIndex < list.lastIndex) Resources.Images.arrow_right_painted else Resources.Images.arrow_right,
                    "Main photo",
                    ArrowImageStyleMobile
                        .toModifier()
                        .fadeInAnimation(),
                )
            },
            items = list,
        ) { value, index ->
            selectedIndex = index
            Column(
                Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VocalistCardMobile(
                    Modifier.padding(leftRight = 2.5.cssRem),
                    value.name,
                    value.imgRes,
                )
            }
        }
    }
}

@Composable
private fun VocalistCardMobile(
    modifier: Modifier,
    name: String,
    photoRes: String,
    ref: ElementRefScope<HTMLElement>? = null
) {
    Column(
        modifier = modifier.gap(2.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier,
            ref = ref,
            contentAlignment = Alignment.BottomCenter
        ) {
            val cardHeight = 360.px
            Card(
                modifier = Modifier.width(100.percent).height(cardHeight)
                    .backgroundImage(linearGradient(LinearGradient.Direction.ToRight, GradientLeft, GradientRight)),
                borderRadius = 3.5.cssRem,
            ) {}
            Image(
                photoRes,
                "Main photo",
                PersonWithCardPhotoStyleMobile
                    .toModifier().fadeInAnimation(),
            )
        }
        Div(VocalistTextTitleMobile.toAttrs()) {
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
private fun DuetSectionMobile(modifier: Modifier) {
    Column(
        modifier = modifier.gap(1.8.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
        ref = ref {
            ScrollToViewEventProvider.setDuetSectionEvent {
                it.scrollIntoView()
            }
        }
    ) {
        Box(modifier.height(0.5.cssRem))
        Div(TitleStyleMobile.toAttrs()) {
            SpanText(
                Resources.Strings.duet_uppercase,
                modifier = Modifier
                    .fadeInAnimation()
            )
        }
        Div(SubheadlineRegularStyleMobile.toAttrs()) {
            SpanText(
                Resources.Strings.princip_constryktora,
                modifier = Modifier
                    .whiteSpace(WhiteSpace.PreLine)
                    .fadeInAnimation()
            )
        }
        Box(modifier = Modifier) {
            Image(
                Resources.Images.clyaksa_2,
                modifier = Clyaks2ImageStyleMobile.toModifier()
                    .padding(right = XXLargePadding, top = XXLargePadding)
                    .align(Alignment.TopEnd)
            )
            var selectedIndex by remember { mutableStateOf(0) }
            SliderSimpleArrow(
                modifier = Modifier,
                hasDotsIndicator = false,
                leftArrow = {
                    Image(
                        if (selectedIndex > 0) Resources.Images.arrow_left_painted else Resources.Images.arrow_left,
                        "Main photo",
                        ArrowImageStyleMobile
                            .toModifier()
                            .fadeInAnimation(),
                    )
                },
                rightArrow = {
                    Image(
                        if (selectedIndex < duetList.lastIndex) Resources.Images.arrow_right_painted else Resources.Images.arrow_right,
                        "Main photo",
                        ArrowImageStyleMobile
                            .toModifier()
                            .fadeInAnimation(),
                    )
                },
                items = duetList,
            ) { value, index ->
                selectedIndex = index
                Column(
                    Modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        src = value,
                        description = "null",
                        modifier = DuetPhotoStyleMobile
                            .toModifier()
                            .padding(leftRight = 1.5.cssRem)
                            .fadeInAnimation(),
                    )
                }
            }
        }
        @Composable
        fun DoubleDuetsColumn(duets: List<String>) {
            Column {
                duets.forEach {
                    Div(SubheadlineBoldStyleMobile.toAttrs()) {
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
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DoubleDuetsColumn(
                listOf(
                    Resources.Strings.sasha_plus_alya,
                    Resources.Strings.lena_plus_liza,
                    Resources.Strings.ula_plus_yla
                )
            )
            DoubleDuetsColumn(
                listOf(
                    Resources.Strings.milana_plus_jia,
                    Resources.Strings.lena_plus_andrey,
                    Resources.Strings.alya_plus_diana
                )
            )
        }

    }
}

@Composable
private fun PartnersSectionMobile(
    modifier: Modifier
) {
    Column(
        modifier = modifier.gap(1.8.cssRem),
    ) {
        Box(Modifier.height(1.cssRem))
        Div(PartnersTitleTextStyleMobile.toAttrs()) {
            SpanText(
                Resources.Strings.partners_title,
                modifier = Modifier
                    .color(DesignYellow)
                    .fadeInAnimation()
            )
        }
        Div(
            PartnersSectionGridStyle.toModifier()
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
fun VideosSectionMobile(modifier: Modifier) {
    Column(
        modifier = modifier.gap(3.5.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Div(TitleStyleMobile.toAttrs()) {
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
            VideoYT("https://www.youtube.com/embed/_c2B9DN_khg?si=eVhKkAczzjP_Afsm", style = VideoFrameStyleMobile)
        }
        Div(TitleStyleMobile.toAttrs()) {
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
            VideoYT("https://www.youtube.com/embed/aEh4p6dUbvU?si=sZIsdey5lwHZ-rBx", style = VideoFrameStyleMobile)
        }
    }
}

@Composable
private fun BottomSectionMobile(
    modifier: Modifier,
) {
    val palette = ColorMode.current.toSitePalette()
    Column(
        modifier = modifier.gap(0.2.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
        ref = ref {
            ScrollToViewEventProvider.setContactsScrollEvent {
                it.scrollIntoView()
            }
        }
    ) {
        Div(BottomCaptionTitleMobile.toAttrs()) {
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
        Box(Modifier.height(1.3.cssRem))
        Input(
            modifier = Modifier
                .width(324.px)
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
        Box(Modifier.height(1.1.cssRem))
        Button(ButtonStyle.toAttrs(OutlinedCircularButtonVariantMobile)) {
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
        Box(Modifier.height(1.8.cssRem))
        Link(
            path = "https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg",
            modifier = Modifier.color(DesignWhiteText),
        ) {
            Div(BottomPromoItemTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.photo,
                    modifier = Modifier
                        .color(palette.brand.text)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
        Link(
            path = "https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg",
            modifier = Modifier.color(DesignWhiteText),
        ) {
            Div(BottomPromoItemTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.live_perfomances,
                    modifier = Modifier
                        .color(palette.brand.text)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
        Link(
            path = "https://vk.com/doc160634310_670249096?hash=7CtPzagSz8E3ehIhq5vPBeEZSmdX2LVceNKUOxo1NKc&dl=4hyXQEjQnTZZZDXjxwG4oIoR1EQwmoqY4qoySjZzeLg",
            modifier = Modifier.color(DesignWhiteText)
        ) {
            Div(BottomPromoItemTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.repertuar_uppercase,
                    modifier = Modifier
                        .color(palette.brand.text)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
        Link(
            "https://vk.com/masha_plus_band",
            modifier = Modifier.color(DesignWhiteText)
        ) {
            Div(BottomPromoItemTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.prices,
                    modifier = Modifier
                        .color(palette.brand.text)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
        Link(
            "https://vk.com/masha_plus_band",
            modifier = Modifier.color(DesignWhiteText)
        ) {
            Div(BottomPromoItemTextStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.important_questions,
                    modifier = Modifier
                        .color(palette.brand.text)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
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
        Image(
            Resources.Images.masha_logo,
            "Logo icon",
            LogoStyle
                .toModifier()
                .fadeInAnimation()
        )
    }
}