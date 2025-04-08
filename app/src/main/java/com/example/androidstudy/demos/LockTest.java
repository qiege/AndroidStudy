package com.example.androidstudy.demos;

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/4/25.
 */
class LockTest {

    Object lock = new Object();
    int num = 0;
    Thread thread2;
    Thread thread3;

    public void testMain() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        while (num > 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        num++;
                        System.out.println("生产一个Thread 1 num = " + num + " thread2:" + thread2.isInterrupted() + " thread3:" + thread3.isInterrupted());
                        lock.notifyAll();
                    }
                }
            }
        });

        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                      while (true) {
                          while (num <= 0) {
                              try {
                                  lock.wait();
                              } catch (InterruptedException e) {
                                  throw new RuntimeException(e);
                              }
                          }
                          num--;
                          System.out.println("消费一个 Thread 2 num = " + num);
                          lock.notify();
                      }

                }
            }
        });

        thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        while (num <= 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        num--;
                        System.out.println("消费一个 Thread 3 num = " + num);
                        lock.notify();
                    }

                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

}
