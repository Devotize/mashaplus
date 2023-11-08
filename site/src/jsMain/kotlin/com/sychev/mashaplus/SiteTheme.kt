package com.sychev.mashaplus

import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.color

/**
 * @property nearBackground A useful color to apply to a container that should differentiate itself from the background
 *   but just a little.
 */
class SitePalette(
    val nearBackground: Color,
    val cobweb: Color,
    val brand: Brand,
) {
    class Brand(
        val primary: Color,
        val accent: Color,
        val background: Color,
        val whiteText: Color,
        val text: Color,
        val greyText: Color,
        val surface: Color,
    )
}

object SitePalettes {
    val light = SitePalette(
        nearBackground = Color.rgb(0xF4F6FA),
        cobweb = Colors.LightGray,
        brand = SitePalette.Brand(
            primary = Color.rgb(0x3C83EF),
            accent = DesignAccent,
            background = DesignBackgroundLight,
            whiteText = DesignWhiteText,
            text = DesignTextLight,
            greyText = DesignGreyTextLight,
            surface = DesignSurfaceLight
        )
    )
    val dark = SitePalette(
        nearBackground = Color.rgb(0x13171F),
        cobweb = Colors.LightGray.inverted(),
        brand = SitePalette.Brand(
            primary = Color.rgb(0x3C83EF),
            accent = DesignAccent,
            background = DesignBackgroundDark,
            whiteText = DesignWhiteText,
            text = DesignTextDark,
            greyText = DesignGreyTextDark,
            surface = DesignSurfaceDark
        )
    )
}

fun ColorMode.toSitePalette(): SitePalette {
    return when (this) {
        ColorMode.LIGHT -> SitePalettes.light
        ColorMode.DARK -> SitePalettes.dark
    }
}

@InitSilk
fun initTheme(ctx: InitSilkContext) {
    ctx.theme.palettes.light.background = DesignBackgroundLight
    ctx.theme.palettes.light.color = Colors.Black
    ctx.theme.palettes.dark.background = DesignBackgroundDark
    ctx.theme.palettes.dark.color = Colors.White
}

//dark
val DesignBackgroundDark = Color.rgb(0x1c1829)
val DesignTextDark = Color.rgb(0xffffff)
val DesignGreyTextDark = Color.rgb(0x828287)
val DesignSurfaceDark = Color.rgb(0x312a47)

//shared
val DesignWhiteText = Color.rgb(0xffffff)
val DesignAccent = Color.rgb(0x5bf6f6)

//light
val DesignSurfaceLight = Color.rgb(0xd9d5e6)
val DesignGreyTextLight = Color.rgb(0x343436)
val DesignTextLight = Color.rgb(0x0e0c14)
val DesignBackgroundLight = Color.rgb(0xededed)



