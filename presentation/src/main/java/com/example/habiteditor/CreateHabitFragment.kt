package com.example.habiteditor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.doamin.Habit
import kotlinx.android.synthetic.main.fragment_create_habit.view.*
import kotlinx.android.synthetic.main.item_habit.view.*

class CreateHabitFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_habit, container, false)

        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.btn_create_habit.setOnClickListener {
            val isCreateHabit = createHabit(view)
            // стоит ли так делать?
            if (isCreateHabit)
                (requireActivity() as MainActivity).navController.navigate(R.id.listHabits)
        }
        // стоит ли так использовать SharedViewModel?
    }

    private fun createHabit(view: View): Boolean {
        // стоит ли куда-то передавать view
        if (view.create_habit_title.text.toString() == ""
            || view.create_habit_frequency.text.toString() == ""
            || view.create_habit_count.text.toString() == "") {
            Toast.makeText(context, R.string.toast_empty_field_create_habit, Toast.LENGTH_SHORT)
                .show()
            return false
        } else {
            val habit = Habit(
                view.create_habit_title.text.toString(),
                view.create_description_habit.text.toString(),
                10,
                10,
                view.create_habit_frequency.text.toString().toInt(),
                view.create_habit_count.text.toString().toInt(),
                10
            )

            sharedViewModel.createNewHabit.value = habit

            return true
        }
    }
}

// добавить цвет по умолчанию
// сделать enum для приоритета и типа привычки
// добавить ограничение на ввод символов