// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        val nav_version = "2.7.1"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.47")

    }
}
plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "8.1.0" apply false
//    id("org.jetbrains.kotlin.android") version "1.5.31" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
    id("com.google.devtools.ksp") version "1.9.10-1.0.13" apply false
    id("com.android.dynamic-feature") version "8.1.0" apply false
    id("org.jetbrains.kotlin.jvm") version "1.9.0" apply false


}