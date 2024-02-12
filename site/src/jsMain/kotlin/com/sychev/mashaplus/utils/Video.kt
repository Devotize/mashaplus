package com.sychev.mashaplus.utils

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.XXXXLargePadding
import com.varabyte.kobweb.compose.css.BoxSizing
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Iframe

val VideoFrameStyle by ComponentStyle {
    base {
        Modifier.height(180.px).width(320.px)
    }
    Breakpoint.LG {
        Modifier.width(1340.px).height(690.px).boxSizing(BoxSizing.BorderBox).borderRadius(0.9.cssRem, 0.9.cssRem)
            .padding(leftRight = XXXXLargePadding)
    }
}

@Composable
fun VideoVK(
    sourceEmbedLink: String,
    autoplay: Boolean = true,
    loop: Boolean = true
) {
    Iframe(attrs = VideoFrameStyle.toAttrs {
        attr("width", "320")
        attr("height", "180")
        val fullLinkSB = StringBuilder()
        fullLinkSB.append(sourceEmbedLink)
        if (autoplay) fullLinkSB.append("&autoplay=1")
        if (loop) fullLinkSB.append("&loop=1")
        attr("src", fullLinkSB.toString())
        attr("frameborder", "0")
        attr("allow", "autoplay; encrypted-media")
    })
}

@Composable
fun VideoYT(
    sourceEmbedLink: String,
    autoplay: Boolean = true,
    loop: Boolean = true
) {
    Iframe(attrs = VideoFrameStyle.toAttrs {
        val fullLinkSB = StringBuilder()
        fullLinkSB.append(sourceEmbedLink)
        if (autoplay) fullLinkSB.append("&autoplay=1")
        if (loop) fullLinkSB.append("&loop=1")
        fullLinkSB.append("&mute=1")
        val videoId = sourceEmbedLink.substringAfter("embed/").substringBefore("?")
        fullLinkSB.append("&playlist=$videoId")
        fullLinkSB.append("&origin=https://https://masha-plus.ru/")
        attr("src", fullLinkSB.toString())
        attr("frameborder", "0")
        attr("allow", "autoplay; encrypted-media; picture-in-picture")
    })
}