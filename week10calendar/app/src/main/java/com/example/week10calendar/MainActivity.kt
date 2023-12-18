package com.example.week10calendar

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.core.content.ContextCompat
import com.example.week10calendar.databinding.ActivityMainBinding
import com.google.android.material.datepicker.DayViewDecorator
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewFacade

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
//            Log.d("qwerty", view.toString()+" "+year.toString()+" "+month.toString()+" "+ dayOfMonth.toString())
//        }

        binding.materialCalendar.addDecorator(DayDecorator(applicationContext))
        binding.materialCalendar.addDecorator(TodayDecorator(applicationContext))
    }
}

class DayDecorator(context : Context) : com.prolificinteractive.materialcalendarview.DayViewDecorator{
    val drawable = ContextCompat.getDrawable(context,R.drawable.calendar_selector)
    override fun shouldDecorate(day: CalendarDay?): Boolean {
        //return day?.day ==1 //1일일때만 꾸미기
        return true
    }

    override fun decorate(view: DayViewFacade?) {
        view?.setSelectionDrawable(drawable!!)
    }

}

class TodayDecorator(context : Context) : com.prolificinteractive.materialcalendarview.DayViewDecorator {
    val calendar = CalendarDay.today()
    override fun shouldDecorate(day: CalendarDay?): Boolean {
        //return day?.day ==1 //1일일때만 꾸미기
        return calendar == day
    }

    override fun decorate(view: DayViewFacade?) {
        view?.addSpan(object : ForegroundColorSpan(Color.BLUE) {})
    }
}