package com.doubleclick.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

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

            flow<Int> {
                for (i in 1..10) {
                    emit(i);
                    delay(1000)
                    Log.e("data producer", i.toString());
                }
            }.filter { i: Int -> i < 5 } // intermediate
                .buffer() // by butting buffer -> make collector in another thread
                .collect {
                    Log.e("data collect", it.toString());
                } // collector

            GlobalScope.launch(Dispatchers.Main) {
                TwoFlow();
            }
        }
    }

    private suspend fun TwoFlow() {
        val f1 = flow<Int> {
            for (i in 1..4) {
                emit(i)
                delay(1000);
            }
        }
        val f2 = flow<String> {
            val list = listOf("A", "D", "F", "S");
            for (i in list) {
                emit(i)
                delay(2000);
            }
        }
        f1.zip(f2) { a: Int, b: String ->
            "$a:$b"
        }.collect() {
            Log.e("DATA", it);
        }
    }
}