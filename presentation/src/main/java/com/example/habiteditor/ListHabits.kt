package com.example.habiteditor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doamin.Habit
import kotlinx.android.synthetic.main.fragment_list_habits.view.*

class ListHabits : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_habits, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.rv_habits.adapter = HabitsRecyclerAdapter().apply {
            val testListHabits = mutableListOf(
                Habit(
                    "тестовая привычка",
                    "описание тестовой привычки описание тестовой привычки описание тестовой привычки описание тестовой привычки описание тестовой привычки описание тестовой привычки описание тестовой привычкиописание тестовой привычки описание тестовой привычки описание тестовой привычки описание тестовой привычки описание тестовой привычки описание тестовой привычки",
                    3,
                    1,
                    30,
                    60,
                    10
                )
            )

            setData(testListHabits)
        }

        view.btn_create_habit.setOnClickListener {

        }
    }
}