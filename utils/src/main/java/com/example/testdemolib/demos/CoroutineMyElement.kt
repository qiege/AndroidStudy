package com.example.testdemolib.demos

import kotlinx.coroutines.CoroutineName
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/15/25.
 */
class CoroutineMyElement(val name: String) : AbstractCoroutineContextElement(CoroutineMyElement) {
        /**
         * Key for [CoroutineName] instance in the coroutine context.
         */
        public companion object Key : CoroutineContext.Key<CoroutineMyElement>

        /**
         * Returns a string representation of the object.
         */
        override fun toString(): String = "CoroutineName($name)"
}