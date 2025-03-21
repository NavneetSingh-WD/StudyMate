package com.example.studymate

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.work.InputChanges

open class MyCustomTask : DefaultTask() {

    @TaskAction
    fun execute(inputs: InputChanges) {
        // Your task logic here
    }
}
