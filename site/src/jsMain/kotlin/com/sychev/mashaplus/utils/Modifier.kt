package com.sychev.mashaplus.utils

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import org.jetbrains.compose.web.css.*

@Composable
fun Modifier.stubAnimation() = animation(
    StubAnimation.toAnimation(
        duration = 1.ms,
        timingFunction = AnimationTimingFunction.EaseIn,
        direction = AnimationDirection.Normal,
        fillMode = AnimationFillMode.Forwards
    )
)

val StubAnimation by Keyframes {
    from {
        Modifier.translateY(-(100).percent)
    }

    to {
        Modifier
    }
}