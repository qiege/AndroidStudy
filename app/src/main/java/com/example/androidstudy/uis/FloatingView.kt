package com.example.androidstudy.uis

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager

/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 3/1/25.
 */
class FloatingView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var initialX = 0f
    var initialY = 0f

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                initialX = event.rawX
                initialY = event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                val dx = event.rawX - initialX
                val dy = event.rawY - initialY
                val l = left + dx
                val t = top + dy
                val r = right + dx
                val b = bottom + dy
                Log.d("FloatingView","dx:$dx,dy:$dy,l:$l,t:$t,r:$r,b:$b lastX:$initialX lastY:$initialY")
                layout(l.toInt(),t.toInt(),r.toInt(),b.toInt())
                initialX = event.rawX
                initialY = event.rawY
            }
        }
        return super.onTouchEvent(event)
    }

    override fun setLayoutParams(params: ViewGroup.LayoutParams?) {
        super.setLayoutParams(params)
    }
}