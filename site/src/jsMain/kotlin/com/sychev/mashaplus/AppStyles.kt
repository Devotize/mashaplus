package com.sychev.mashaplus

import com.sychev.mashaplus.utils.Fonts
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.forms.ButtonVars
import com.varabyte.kobweb.silk.components.layout.HorizontalDividerStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.addVariantBase
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import com.varabyte.kobweb.silk.theme.modifyComponentStyleBase
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@InitSilk
fun initSiteStyles(ctx: InitSilkContext) {
    ctx.stylesheet.registerStyleBase("body") {
        Modifier
            .fontFamily(
                "-apple-system", "BlinkMacSystemFont", "Segoe UI", "Roboto", "Oxygen", "Ubuntu",
                "Cantarell", "Fira Sans", "Droid Sans", "Helvetica Neue", "sans-serif", Fonts.MainFontName
            )
            .fontSize(16.px)
            .lineHeight(1.5)
    }

    // Silk dividers only extend 90% by default; we want full width dividers in our site
    ctx.theme.modifyComponentStyleBase(HorizontalDividerStyle) {
        Modifier.fillMaxWidth()
    }
}

val HeadlineTextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(1.8.cssRem)
        .textAlign(TextAlign.Center)
        .lineHeight(1.2) //1.5x doesn't look as good on very large text
}

val HugeThinTextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(2.3.cssRem)
        .textAlign(TextAlign.Center)
        .lineHeight(1.5)
        .fontWeight(FontWeight.Thin)
}

val SectionTitleStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(1.2.cssRem)
        .textAlign(TextAlign.Center)
        .lineHeight(0.9)
        .fontWeight(FontWeight.ExtraBold)
}

val Headline2TextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(1.6.cssRem)
        .textAlign(TextAlign.Start)
        .lineHeight(1.1)
}
val NavigationHeadlineTextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(0.9.cssRem)
        .textAlign(TextAlign.Start)
        .fontWeight(FontWeight.Thin)
        .lineHeight(1.1)
}

val ButtonTextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(1.1.cssRem)
        .textAlign(TextAlign.Start)
        .lineHeight(0.9)
}

val SubheadlineBoldTextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(1.cssRem)
        .textAlign(TextAlign.Center)
        .color(colorMode.toPalette().color.toRgb().copyf(alpha = 0.8f))
        .fontWeight(FontWeight.Bold)
}

val ModalTitleTextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(1.1.cssRem)
        .textAlign(TextAlign.Start)
}

val ModalDescriptionTextStyleCentered by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(0.9.cssRem)
        .textAlign(TextAlign.Center)
        .color(colorMode.toPalette().color.toRgb().copyf(alpha = 0.8f))
}

val ModalDescriptionTextStyle by ComponentStyle.base {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(0.9.cssRem)
        .textAlign(TextAlign.Start)
        .color(colorMode.toPalette().color.toRgb().copyf(alpha = 0.8f))
}

val CircleButtonVariant by ButtonStyle.addVariantBase {
    Modifier.padding(0.px).borderRadius(50.percent)
}

val UncoloredButtonVariant by ButtonStyle.addVariantBase {
    Modifier.setVariable(ButtonVars.BackgroundDefaultColor, Colors.Transparent)
}

val DefaultButtonVariant by ButtonStyle.addVariantBase {
    Modifier
        .padding(leftRight = MediumPadding, topBottom = XSmallPadding)
        .lineHeight(1.5)
        .backgroundColor(DesignSurfaceDark)
        .borderRadius(0.9.cssRem, 0.9.cssRem)
}


// New design text styles
val MainTitleTextStyle by ComponentStyle {
    base {
        Modifier
            .fontFamily(Fonts.MainFontName)
            .fontSize(1.3.cssRem)
            .textAlign(TextAlign.Center)
            .fontWeight(FontWeight.ExtraBold)
            .color(colorMode.toPalette().color.toRgb())
    }
    Breakpoint.LG {
        Modifier
            .fontFamily(Fonts.MainFontName)
            .fontSize(2.4.cssRem)
            .textAlign(TextAlign.Center)
            .fontWeight(FontWeight.ExtraBold)
            .color(colorMode.toPalette().color.toRgb())
    }
}

val SubheadlineRegularStyle by ComponentStyle {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .fontSize(1.2.cssRem)
        .textAlign(TextAlign.Start)
        .fontWeight(FontWeight.Medium)
        .color(colorMode.toPalette().color.toRgb())
}

val OutlineButtonTextStyle by ComponentStyle {
    Modifier
        .fontFamily(Fonts.MainFontName)
        .textAlign(TextAlign.Center)
        .color(colorMode.toPalette().color.toRgb())
}

/* New design buttons */
val OutlinedCircularButtonVariant by ButtonStyle.addVariantBase {
    Modifier
        .padding(topBottom = XSmallPadding, leftRight = LargePadding)
        .borderRadius(1.6.cssRem, 1.6.cssRem)
        .backgroundColor(Colors.Transparent)
        .border(width = 2.px, style = LineStyle.Solid, color = colorMode.toPalette().color.toRgb().copyf(alpha = 0.8f))
        .fontSize(1.3.cssRem)
        .fontWeight(FontWeight.SemiBold)
}