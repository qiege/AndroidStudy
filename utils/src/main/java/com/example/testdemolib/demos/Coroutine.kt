package com.example.testdemolib.demos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/2/25.
 */
object Coroutine {








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

    private suspend fun getComment(id: Long): String = withContext(Dispatchers.IO) {
        //耗时
        delay(2000)
        print("get comment thread: ${Thread.currentThread().name}  thread id: ${Thread.currentThread().id}")
        return@withContext "comment"
    }

    private fun showComment(comment: String) {
        print(comment)
    }
}

data class Detail(val id: Long, val commentId: Long)