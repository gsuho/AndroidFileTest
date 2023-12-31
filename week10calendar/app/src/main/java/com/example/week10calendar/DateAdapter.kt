package com.example.week10calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week10calendar.databinding.ItemCalendarBinding

class DateAdapter(val day : ArrayList<String>) : RecyclerView.Adapter<DateAdapter.ViewHolder>() {

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
        return day.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(day[position])
    }
}