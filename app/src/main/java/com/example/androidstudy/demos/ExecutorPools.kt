package com.example.androidstudy.demos

import java.util.concurrent.Executors

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/3/25.
 */
class ExecutorPools {

    fun mainTest() {
        // 创建一个线程池
        val executor = Executors.newFixedThreadPool(5)

        // 创建一个任务并提交到线程池
        executor.execute {
            println("Executing task in thread ${Thread.currentThread().name}")
        }

        executor.submit {
            println("submit Executing task in thread ${Thread.currentThread().name}")
        }

        // 关闭线程池
        executor.shutdown()
    }

}