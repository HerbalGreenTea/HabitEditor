package com.example.habiteditor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.doamin.Habit
import kotlinx.android.synthetic.main.fragment_list_habits.view.*

class ListHabits : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_habits, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        // стоит ли передавай requireActivity в овнеры?

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
                    10)
            )

            setOnOrderClickListener(View.OnClickListener {
                Log.d("HABITCLIC", "CLICK")
            })

            setData(testListHabits)

            sharedViewModel.createNewHabit.observe(viewLifecycleOwner, Observer<Habit> {
                addItem(it)
            })
            // стоит ли так использовать SharedViewModel?
        }

        view.btn_open_create_habit.setOnClickListener {
            (requireActivity() as MainActivity).navController.navigate(R.id.createHabitFragment)
        }
    }

//    private fun openEditHabit() {
//
//        (requireActivity() as MainActivity).navController.navigate(R.id.createHabitFragment)
//    }
}