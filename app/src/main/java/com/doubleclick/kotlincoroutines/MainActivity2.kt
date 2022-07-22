package com.doubleclick.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        GlobalScope.launch {
            val time = measureTimeMillis {
                val dataUser = async { getUserDataFromNet() }
                val localUser = async { getUserDataFromLocal() }

                if (dataUser.await() == localUser.await()) {
                    Log.e("EQUAL", "EQUAL");

                } else {
                    Log.e("EQUAL", "Not EQUAL");
                }


            }
            Log.e("TIME", time.toString());
        }
    }

    private suspend fun getUserDataFromLocal(): String {
        delay(2000)
        return "Eslam"
    }

    private suspend fun getUserDataFromNet(): String {
        delay(5000)
        return "Ghazy"
    }
}