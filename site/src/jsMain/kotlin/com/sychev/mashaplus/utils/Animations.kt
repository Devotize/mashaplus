package com.sychev.mashaplus.utils

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.translateX
import com.varabyte.kobweb.compose.ui.modifiers.translateY
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.animation.toAnimation
import org.jetbrains.compose.web.css.*


val StubAnimation by Keyframes {
    from {
        Modifier.translateY(-(100).percent)
    }

    to {
        Modifier
    }
}
@Composable
fun Modifier.stubAnimation() = animation(
    StubAnimation.toAnimation(
        duration = 1.ms,
        timingFunction = AnimationTimingFunction.EaseIn,
        direction = AnimationDirection.Normal,
        fillMode = AnimationFillMode.Forwards
    )
)

val FadeInAnim by Keyframes {
    from {
        Modifier.opacity(.0)
    }
    to {
        Modifier
    }
}

@Composable
fun Modifier.fadeInAnimation() = animation(
    FadeInAnim.toAnimation(
        duration = 300.ms,
        timingFunction = AnimationTimingFunction.EaseIn,
        direction = AnimationDirection.Normal,
        fillMode = AnimationFillMode.Forwards
    )
)

val SlideRightAnim by Keyframes {
    from {
        Modifier.translateX((-100).percent)
    }
    to {
        Modifier
    }
}

@Composable
fun Modifier.slideRightAnimation() = animation(
    SlideRightAnim.toAnimation(
        duration = 300.ms,
        timingFunction = AnimationTimingFunction.EaseIn,
        direction = AnimationDirection.Normal,
        fillMode = AnimationFillMode.Forwards
    )
)

val SlideLeftAnim by Keyframes {
    from {
        Modifier.translateX(100.percent)
    }
    to {
        Modifier
    }
}

@Composable
fun Modifier.slideLeftAnimation() = animation(
    SlideLeftAnim.toAnimation(
        duration = 300.ms,
        timingFunction = AnimationTimingFunction.EaseIn,
        direction = AnimationDirection.Normal,
        fillMode = AnimationFillMode.Forwards
    )
)
