package com.example.habiteditor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doamin.Habit

class SharedViewModel: ViewModel() {
    val createNewHabit: MutableLiveData<Habit> by lazy {
        MutableLiveData<Habit>()
    }
}