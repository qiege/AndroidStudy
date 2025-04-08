package com.example.androidstudy.recyclerview

import  com.example.androidstudy.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * Copyright (c) ByteDance Inc. All rights reserved.
 * Created by litan on 2/25/25.
 */
class MyAdapter : RecyclerView.Adapter<MyHolder?>() {
    private val str = mutableListOf<String>().apply {
        for (i in 0..100) {
            add("item $i")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.holder, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textView.text = str[position]
    }

    override fun getItemCount(): Int {
        return str.size
    }
}