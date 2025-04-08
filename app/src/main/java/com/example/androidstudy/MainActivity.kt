package com.example.androidstudy

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.androidstudy.demos.Coroutine
import com.example.androidstudy.demos.ExecutorPools
import com.example.androidstudy.demos.Queue
import com.example.androidstudy.recyclerview.MyAdapter
import com.example.androidstudy.ui.theme.AndroidStudyTheme
import com.example.androidstudy.uis.FloatingView

class MainActivity : ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            AndroidStudyTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
        setContentView(R.layout.main)
        val rootView = findViewById<FrameLayout>(R.id.ssRelativeLayout)
        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.adapter = MyAdapter()
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top = 2
                }
            }

            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDraw(c, parent, state)


            }
        })

        val btn = findViewById<TextView>(R.id.btn)
        btn.setOnClickListener {
            rv?.adapter?.notifyItemRemoved(22)
        }

        val floatingView = findViewById<FloatingView>(R.id.floatingView)
        floatingView.setOnClickListener {
            //rootView?.scrollBy(0, 500)
            Toast.makeText(this, " 点击滑动组件", Toast.LENGTH_LONG).show()
            //Coroutine().cortinue()
            //ExecutorPools().mainTest()
            Queue().testMain()
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidStudyTheme {
        Greeting("Android")
    }
}