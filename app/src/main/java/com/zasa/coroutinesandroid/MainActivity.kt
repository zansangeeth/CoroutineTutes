package com.zasa.coroutinesandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnButton.setOnClickListener {
            CoroutineScope(IO).launch{
                fakeApiRequest()
            }
        }

    }

    fun setNewText(input : String){
        val newText = input
        tvText.text = newText
    }

    suspend fun setTextToMainThread(input : String){
        withContext(Main){
            setNewText(input)
        }
    }
    suspend fun fakeApiRequest(){
        var results1 = getApiCall1()
        setTextToMainThread(results1)

        var results2 = getApiCall2()
        setTextToMainThread(results2)
    }

    suspend fun getApiCall1() : String{
        logThread("getApiCall1")
        delay(2000)
        return "results from api-1"
    }

    suspend fun getApiCall2() : String{
        logThread("getApiCall2")
        delay(2000)
        return "results from api-2"
    }

    fun logThread(methodName : String){
        println(" $TAG $methodName : ${Thread.currentThread().name}")
    }

}