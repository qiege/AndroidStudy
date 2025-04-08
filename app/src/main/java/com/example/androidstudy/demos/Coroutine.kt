package com.example.androidstudy.demos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/2/25.
 */
class Coroutine {


    fun <T> launchFish(block: suspend () -> T) {
        //创建协程，返回值为SafeContinuation(实现了Continuation 接口)
        //入参为Continuation 类型，参数名为completion，顾名思义就是
        //协程结束后(正常返回&抛出异常）将会调用它。
        var coroutine = block.createCoroutine(object : Continuation<T> {
            override val context: CoroutineContext
                get() = EmptyCoroutineContext

            //协程结束后调用该函数
            override fun resumeWith(result: Result<T>) {
                println("result:$result")
            }
        })
        //开启协程
        coroutine.resume(Unit)
    }


    suspend fun getStuInfo3(): StudentInfo {
        return suspendCoroutine<StudentInfo> {
            thread {
                //开启线程执行耗时任务
                Thread.sleep(3000)
                var studentInfo = StudentInfo()
                println("resume coroutine")
                //恢复协程,it指代 Continuation
                it.resumeWith(Result.success(studentInfo))
            }
            println("suspendCoroutine end")
        }
    }

    fun testSelf() {
        launchFish {
            println("before suspend")
            val studentInfo = getStuInfo3()
            //挂起函数执行返回
            println("after suspend student name:${studentInfo?.name}")
        }
       println("test self")
    }






    private suspend fun a() {
        runBlocking {
            println("a in coroutine")
            val result = b()
            println("a resume coroutine result: $result")
        }
        //xxxx
    }

    private suspend fun b() {
        GlobalScope.launch(Dispatchers.IO) {
            "net data:student info"
        }
    }

    fun foo() {
        GlobalScope.launch {
            a()
        }
        println("bb")
    }



    fun cortinue() {
        GlobalScope.launch(Dispatchers.Main) { //使用launch函数
            val detail = getDetail(0L) //在IO线程获取Detail，此时未阻塞主线程，执行完再执行getComment
            val comment = getComment(detail.commentId) //在IO线程获取Comment，再执行showComment
            showComment(comment) //在Main线程执行绘制
        }
    }

    private suspend fun getDetail(id: Long): Detail = withContext(Dispatchers.IO) {
        //耗时
        delay(3000)
        print("get comment thread: ${Thread.currentThread().name} thread id: ${Thread.currentThread().id}")
        return@withContext Detail(1L, 2L)
    }

    private suspend fun getComment(id: Long): String {
        return withContext(Dispatchers.Default) {
            //耗时
            delay(2000)
            print("get comment thread: ${Thread.currentThread().name} thread id: ${Thread.currentThread().id}")
            return@withContext "comment"
        }
    }

    private fun showComment(comment: String) {
        print(comment)
    }
}

data class Detail(val id: Long, val commentId: Long)