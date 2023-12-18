package com.example.week10calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week10calendar.databinding.ActivityCalendarBinding
import java.util.Calendar

class CalendarActivity : AppCompatActivity() {
    lateinit var binding: ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvWeek.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvDate.layoutManager = GridLayoutManager(this, 7)

        binding.rvWeek.adapter = WeekAdapter(arrayListOf("S", "M", "T", "W", "T", "F", "S"))

        var dayList = setDayList()
        binding.rvDate.adapter = DateAdapter(dayList)

    }

    private fun setDayList() : ArrayList<String>{
        var cal = Calendar.getInstance()
        cal.set(Calendar.DATE, 1)
        var startWeekday = cal.get(Calendar.DAY_OF_WEEK) //
        var lastDay = cal.getActualMaximum(Calendar.DATE) //현재달의 가장 마지막날을 알려줌.

        if (cal.get(Calendar.MONTH) == 0) { //1월일 경우 예외 처리
            cal.set(Calendar.YEAR - 1, 11, 1)
        } else {
            cal.set(Calendar.YEAR, Calendar.MONTH - 1, 1) //
        }

        var previousMonthLastDay = cal.getActualMaximum(Calendar.DATE) //이전달의 마지막날 구하기
        Log.d("qwerty", previousMonthLastDay.toString())
        var dayList = ArrayList<String>()


        for (i in startWeekday - 2 downTo 0) {
            dayList.add((previousMonthLastDay - i).toString())
        }
        for (i in 1..lastDay)
            dayList.add(i.toString())
        //앞뒤로 이전달 다음달 넣기
        var dayCount = 1
        while (dayList.size < 42) {
            dayList.add(dayCount.toString())
            dayCount++
        }
        return dayList
    }
}