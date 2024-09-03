package com.sychev.mashaplus.pages.successPage.desktop

import androidx.compose.runtime.Composable
import com.sychev.mashaplus.*
import com.sychev.mashaplus.utils.Resources
import com.sychev.mashaplus.utils.fadeInAnimation
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div

@Composable
fun SuccessPageDesktop() {
    val ctx = rememberPageContext()
    val palette = ColorMode.current.toSitePalette()
    Column(
        modifier = Modifier.fillMaxSize().padding(top = 5.cssRem),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Div(SuccessTitle.toAttrs()) {
            SpanText(
                Resources.Strings.success_thx_message,
                modifier = Modifier
                    .whiteSpace(WhiteSpace.PreLine)
                    .fadeInAnimation()
            )
        }
        Box(Modifier.height(.4.cssRem))
        Div(SuccessTitle.toAttrs()) {
            SpanText(
                Resources.Strings.success_message,
                modifier = Modifier
                    .whiteSpace(WhiteSpace.PreLine)
                    .fadeInAnimation()
            )
        }
        Box(Modifier.height(1.2.cssRem))
        Button(
            ButtonStyle.toAttrs(OutlinedCircularButtonVariant) {
                onClick {
                    ctx.router.navigateTo(
                        "../",
                        openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                        openExternalLinksStrategy = OpenLinkStrategy.IN_PLACE,
                    )
                }
            },
        ) {
            Div(OutlineButtonTextSmallStyle.toAttrs()) {
                SpanText(
                    Resources.Strings.go_back,
                    modifier = Modifier
                        .color(palette.brand.textReversed)
                        .fillMaxWidth()
                        .textAlign(TextAlign.Center)
                )
            }
        }
    }
}