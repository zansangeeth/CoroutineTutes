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

        GlobalScope.launch(Dispatchers.IO){
            Log.i(TAG, "starting coroutine thread as ${Thread.currentThread().name}")
            val netCall = doNetworkCall()
            withContext(Dispatchers.Main){
                Log.i(TAG, "finishing coroutine thread as ${Thread.currentThread().name}")
                tvText.text = netCall
            }
        }

    }

    suspend fun doNetworkCall() : String{
        delay(3000)
        return "network call 01"
    }

}