import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("currency-generator")
}

description = "A kotlin multiplatform library to deal with money"

val dir = layout.buildDirectory.dir("generated/builders/kotlin")
val generate by tasks.registering(MoneyBuildersGenerator::class) {
    outputDir.set(dir)
}

kotlin {
    jvm { library() }
    if (Targeting.JS) js(IR) { library() }
    if (Targeting.WASM) wasmJs { library() }
    if (Targeting.WASM) wasmWasi { library() }
    if (Targeting.OSX) osxTargets() else listOf()
//    if (Targeting.NDK) ndkTargets() else listOf()
    if (Targeting.LINUX) linuxTargets() else listOf()
    if (Targeting.MINGW) mingwTargets() else listOf()

    targets.configureEach {
        compilations.all {
            compileTaskProvider.dependsOn(generate)
        }
    }

    sourceSets {
        val commonMain by getting {
            kotlin.srcDir(dir)
            dependencies {
                api(projects.kashCents)
                api(projects.kashCurrency)
                api(libs.neat.formatting)
                api(libs.kollections.interoperable)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kommander.core)
                implementation(kotlinx.serialization.json)
            }
        }
    }
}
