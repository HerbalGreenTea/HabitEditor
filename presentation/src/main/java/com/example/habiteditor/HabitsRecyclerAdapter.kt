package com.example.habiteditor

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.doamin.Habit
import kotlinx.android.synthetic.main.item_habit.view.*

// понять, что конкретно тут просиходит

class HabitsRecyclerAdapter: RecyclerView.Adapter<HabitsRecyclerAdapter.HabitsViewHolder>() {

    private var habits = mutableListOf<Habit>()

    class HabitsViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.item_habit, parent, false)) {

        fun bind(habit: Habit) {
            itemView.apply {
                habit_title.text = habit.title
                habit_type.text = habit.type.toString()
                habit_priority.text = habit.priority.toString()
                habit_count.text = habit.count.toString()
                habit_frequency.text = habit.frequency.toString()
                habit_description.text = habit.description
            }

            itemView.setOnClickListener {
                Log.d("HABITSADAPTER", "ClickOK")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HabitsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: HabitsViewHolder, position: Int) {
        val habit = habits[position]
        holder.bind(habit)
    }

    override fun getItemCount(): Int = habits.size

    fun setData(habits: List<Habit>) {
        this.habits.addAll(habits)
        notifyDataSetChanged()
    }

    fun addItem(habit: Habit) {
        habits.add(habit)
        notifyDataSetChanged()
    }
}