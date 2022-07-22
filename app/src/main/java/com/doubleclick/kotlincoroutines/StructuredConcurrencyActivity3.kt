package com.doubleclick.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class StructuredConcurrencyActivity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_structured_concurrency3)

        val parentJop = Job();
        val jop: Job = GlobalScope.launch(parentJop) {
            val j1 = launch { Log.e("Jop", "Jop1") }
            val j3 = launch { Log.e("Jop", "Jop3") }
            joinAll(j1, j3)
            val j2 = launch { Log.e("Jop", "Jop2") }

        }

        /* can be cancel
        * and can cancel all process when call in onStop
        * */

//        jop.cancel()
    }
}