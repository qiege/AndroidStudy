package com.example.testdemolib.demos;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 2/25/25.
 */
class LockJava {

    //synchronized修饰方法或者代码块
    public synchronized void test() {
        int a =8;
        String s = "sajk";

    }


    public void test2() {
        //只有执行代码块结束或者
        synchronized (this) {
            int a =8;
            String s = "sajk";
        }
    }

    Lock lock = new ReentrantLock();
    public void test3() {
        lock.lock();
        lock.tryLock();
        int c =10;
        String ss = "leeee";
        lock.unlock();
    }


    public void test4() {

        AtomicInteger a = new AtomicInteger();
    }


}
