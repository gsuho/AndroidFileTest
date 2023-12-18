package com.example.week10calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week10calendar.databinding.ItemCalendarBinding

class WeekAdapter(val week : ArrayList<String>) : RecyclerView.Adapter<WeekAdapter.ViewHolder>() {

    inner class ViewHolder(val binding :ItemCalendarBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : String){
            binding.tv.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCalendarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return week.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(week[position])
    }
}