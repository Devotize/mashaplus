package com.sychev.mashaplus.pages

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.LargePadding
import com.sychev.mashaplus.XXXXLargePadding
import com.sychev.mashaplus.components.layouts.PageLayout
import com.sychev.mashaplus.pages.main.desktop.MainScreenDesktop
import com.sychev.mashaplus.pages.main.mobile.MainScreenMobile
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.*

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
        val bp = rememberBreakpoint()
        if (bp > Breakpoint.LG) {
            MainScreenDesktop()
        } else {
            MainScreenMobile()
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

