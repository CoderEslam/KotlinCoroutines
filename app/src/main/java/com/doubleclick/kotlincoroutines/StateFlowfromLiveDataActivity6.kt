package com.doubleclick.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.activity_state_flowfrom_live_data6.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StateFlowfromLiveDataActivity6 : AppCompatActivity() {

    lateinit var timerViewModel: TimerViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state_flowfrom_live_data6)
        timerViewModel = ViewModelProvider(this)[TimerViewModel::class.java]
        lifecycleScope.launch {
            timerViewModel.startTimer()
            timerViewModel.timerStateFlow.collect {
                text.text = it.toString();
                Log.e("DATA", it.toString());
            }
        }

        /*
        * run when on Start only
        * */
        lifecycleScope.launchWhenStarted {
            timerViewModel.startTimer()
            timerViewModel.timerStateFlow.collect {
                text.text = it.toString();
                Log.e("DATA", it.toString());
            }
        }

    }
}