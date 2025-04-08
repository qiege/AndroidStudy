package com.example.leeplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/6/25.
 */
class MyPluginFirst: Plugin<Project> {
    override fun apply(project: Project) {
        println("MyPluginFirst apply")
        val task = project.task("MyPluginTask") {
            it.doFirst {
                println("MyPluginFirst do first")
            }
            it.doLast {
                println("MyPluginFirst do last")
            }
        }
        //task.dependsOn(project.tasks.named("build"))
    }
}