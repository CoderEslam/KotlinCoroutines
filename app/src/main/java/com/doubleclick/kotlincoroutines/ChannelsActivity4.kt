package com.doubleclick.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ChannelsActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channels4)

        val channel = Channel<String>()


        runBlocking {
            val arr = arrayOf("j", "h", "k")
            launch {
                for (char in arr) {
                    channel.send(char)
                    delay(1000)
                }
            }
            launch {
                for (char in channel) {
                    Log.e("channel", char)
                }
            }
        }

        runBlocking {
            val arr = arrayOf("j", "h", "k")
            launch {
                for (char in arr) {
                    channel.trySend(char).isSuccess
                    delay(1000)
                }
            }

            for (char in channel) {
                Log.e("channel", char)
            }

        }

    }
}