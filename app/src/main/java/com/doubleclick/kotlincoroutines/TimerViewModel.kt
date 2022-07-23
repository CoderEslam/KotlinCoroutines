package com.doubleclick.kotlincoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

/**
 * Created By Eslam Ghazy on 7/23/2022
 */
class TimerViewModel : ViewModel() {
    @OptIn(ExperimentalCoroutinesApi::class)
    val timerStateFlow = MutableStateFlow<Int>(0)

    fun startTimer() {

        viewModelScope.launch {
            val list = listOf<Int>(1, 1, 1, 5, 8, 9, 6, 3, 7, 2, 3, 6, 6, 6, 4, 7, 8, 5);
            for (i in list) {
                timerStateFlow.emit(i)
                delay(1000);
            }
        }
    }

}