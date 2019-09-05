package com.wzk.aspectj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.wzk.aspectj.annotation.Test
import com.wzk.aspectj.annotation.TestJava
import kotlinx.android.synthetic.main.activity_main.*
import org.aspectj.lang.annotation.Aspect

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_test.setOnClickListener {
            aspectj1()
            aspectj2()
        }
    }


    @TestJava("我知道了")
    private fun aspectj1(): String {
        Log.d("MainActivity", "aspectj1")
        return "aspectj1  返回值"
    }

    @TestJava("test")
    private fun aspectj2() {
        Log.d("MainActivity", "aspectj2")
    }
}
