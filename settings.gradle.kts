pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("./Plugins/build/maven-repo")
        }
    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AndroidStudy"
include(":app")
include(":utils")
gradle.settingsEvaluated {
    println("leeee start init" + pluginManagement)
}

gradle.addListener(object: TaskExecutionListener {

    override fun beforeExecute(task: Task) {
        println("---Gradle：Task ${task.name} beforeExecute---")
    }

    override fun afterExecute(task: Task, state: TaskState) {
        println("---Gradle：Task ${task.name} afterExecute---")
    }
})
include(":Plugins")
