package com.example.androidstudy.demos

import androidx.compose.runtime.remember
import java.util.Objects

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/3/25.
 */

interface ResInterface {
    fun invokeWithRes(objects: Any?)
}

class CoroutineRunBody : ResInterface {
    /**
     * 使用label作为状态机，进行控制程序流程，首先进来一次，默认走0，如果碰到执行的程序需要挂起，说明当前流程无法继续
     * 执行下去，程序需要暂停然后等待被挂起的程序执行完成，然后再继续执行，此时lebel变为1。等到被挂起的程序执行完成后，
     * 程序会继续执行，此时因为label变为1，执行case 1中的代码，然后继续向下执行代码，如果不遇到新的阻塞的协程，
     * 则直接执行完所有程序。
     */
    var label = 0
    override fun invokeWithRes(objects: Any?) {
        when (label) {
            0 -> {
                label = 1
                println("resumeWith:${objects}")
                return
            }
            1 -> {
                println("resumeWithException:${objects}")
            }
        }
        var a = "res"
        println("res:${a}")
    }

}