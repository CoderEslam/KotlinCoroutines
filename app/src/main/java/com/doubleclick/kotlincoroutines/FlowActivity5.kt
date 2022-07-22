package com.doubleclick.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class FlowActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow5)

        runBlocking {


            // producer
            flow<Int> {
                for (i in 1..10) {
                    emit(i);
                    delay(1000)
                    Log.e("data producer", i.toString());
                }
            }.filter { i: Int -> i < 5 } // intermediate
                .collect {
                    Log.e("data collect", it.toString());
                } // collector
        }
    }
}