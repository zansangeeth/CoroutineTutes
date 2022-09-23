package com.zasa.coroutinesandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.*

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i(TAG, "before runBlocking ${Thread.currentThread().name}")
        runBlocking {
            Log.i(TAG, "start runBlocking ${Thread.currentThread().name}")
            delay(5000)
            Log.i(TAG, "end runBlocking ${Thread.currentThread().name}")
        }
        Log.i(TAG, "after runBlocking ${Thread.currentThread().name}")

    }


}