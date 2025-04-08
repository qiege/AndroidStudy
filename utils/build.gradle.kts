plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

//repositories {
//    mavenCentral()
//    google()
//}

dependencies {
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.7.3")
    // 如果你需要协程的Android支持，可以添加以下依赖
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}