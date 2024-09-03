import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.div
import kotlinx.html.link
import kotlinx.html.meta
import kotlin.time.Duration.Companion.seconds

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "com.sychev.mashaplus"
version = "1.1"

kobweb {
    app {
        index {
            faviconPath.set("/favicon.ico")
            description.set("Musical Band")
            head.add {
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(rel = "preconnect", href = "https://fonts.gstatic.com") { attributes["crossorigin"] = "" }
                link(
                    href = "https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;600;700;800;900;905&display=swap",
                    rel = "stylesheet",
                )
                meta("og:image", "/masha_logo.png")
            }
        }
        export {
            timeout = 120.seconds
            enableTraces()
        }
    }
}

rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().version = "1.22.21"
}

kotlin {
    // This example is frontend only. However, for a fullstack app, you can uncomment the includeServer parameter
    // and the `jvmMain` source set below.
    configAsKobwebApplication("mashaplus" /*, includeServer = true*/)

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(compose.html.core)
                implementation(libs.kobweb.core)
                implementation(libs.kobweb.silk)
                // This default template uses built-in SVG icons, but what's available is limited.
                // Uncomment the following if you want access to a large set of font-awesome icons:
                // implementation(libs.silk.icons.fa)
                implementation(libs.kobwebx.markdown)
                implementation(libs.silk.icons.mdi)
            }
        }

        // Uncomment the following if you pass `includeServer = true` into the `configAsKobwebApplication` call.
//        val jvmMain by getting {
//            dependencies {
//                implementation(libs.kobweb.api)
//            }
//        }
    }
}
