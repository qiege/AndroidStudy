plugins {
//    kotlin("jvm") version "1.8.10"
//    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
    id("java-gradle-plugin")
    id("org.jetbrains.kotlin.jvm")
    //id("com.gradle.plugin-publish")
    id("maven-publish")
}

group = "com.example.leeplugin"
version = "1.0-SNAPSHOT"

println("运行了插件工程脚本")

repositories {
    mavenCentral()
    google()
}

gradlePlugin {
    this.plugins{
        create("LeePlugin"){
            id = "com.example.leeplugin"
            implementationClass = "com.example.leeplugin.MyPluginFirst"
        }
    }
    repositories {
        maven {
            url = uri(layout.buildDirectory.dir("maven-repo"))
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("LeePlugin") {
            groupId = "com.example.leeplugin"
            artifactId = "leeplugin"
            version = "1.0-SNAPSHOT"
            from(components["java"])
        }
    }

    repositories {
        maven {
            url = uri(layout.buildDirectory.dir("maven-repo"))
        }
    }
}


dependencies {

    //implementation("com.android.tools.build:gradle:8.0.0")
}
