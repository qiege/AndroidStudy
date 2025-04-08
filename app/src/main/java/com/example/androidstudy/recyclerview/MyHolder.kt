package com.example.androidstudy.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import  com.example.androidstudy.R


/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 2/25/25.
 */
class MyHolder(itemView: View) : ViewHolder(itemView) {
    var textView: TextView

    init {
        textView = itemView.findViewById<TextView>(R.id.itemTextView)
    }
}