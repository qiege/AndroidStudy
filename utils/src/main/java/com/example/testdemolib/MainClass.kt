package com.example.testdemolib

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

suspend fun main(args: Array<String>) {
    println("Hello, World!")

//    val c: String = add(3,4)
//    println("c = $c")
    inlinefun(4,5, ::addA)
    val scope = CoroutineScope(Job() + Dispatchers.IO + CoroutineName("leee"))
    val job = scope.launch {
        val result = 3+8
        println("result = $result")  // output: result = 7
        println("Thread: ${Thread.currentThread().name}")  // output: Thread: DefaultDispatcher-worker-1
    }
    job.join()
    Thread.sleep(100000)
}

inline fun <reified T> add(a: Int, b: Int): T {
    println(a + b)
    if (a is T) {
        println("a is instance T:${T::class.java}")
    }
    return a as T
}

fun addA(a: Int, b: Int): Int {
    println(a + b)
    return a +b
}

fun inlinefun(a: Int, b: Int, operation: (Int, Int)->Int):Int {
    println("operation type:"+ operation::class.java)
    return operation(a, b)
}