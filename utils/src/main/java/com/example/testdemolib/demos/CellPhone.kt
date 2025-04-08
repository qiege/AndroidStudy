package com.example.testdemolib.demos

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/16/25.
 */
data class Cellphone(val brand: String, val price: Double)

object Singleton {
    fun singletonTest() {
        println("singletonTest is called.")
    }
}