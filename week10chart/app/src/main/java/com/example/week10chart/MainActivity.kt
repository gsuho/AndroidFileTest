package com.example.week10chart

import android.R
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.week10chart.databinding.ActivityMainBinding
import org.eazegraph.lib.charts.StackedBarChart
import org.eazegraph.lib.models.BarModel
import org.eazegraph.lib.models.StackedBarModel


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mStackedBarChart = binding.stackedbarchart as StackedBarChart

        val s1 = StackedBarModel("12.4")

        s1.addBar(BarModel(2.3f, -0x9c3450))
        s1.addBar(BarModel(2.3f, -0xa9480f))
        s1.addBar(BarModel(2.3f, -0x325981))

        val s2 = StackedBarModel("13.4")
        s2.addBar(BarModel(1.1f, -0x9c3450))
        s2.addBar(BarModel(2.7f, -0xa9480f))
        s2.addBar(BarModel(0.7f, -0x325981))

        val s3 = StackedBarModel("14.4")

        s3.addBar(BarModel(2.3f, -0x9c3450))
        s3.addBar(BarModel(2f, -0xa9480f))
        s3.addBar(BarModel(3.3f, -0x325981))

        val s4 = StackedBarModel("15.4")
        s4.addBar(BarModel(1f, -0x9c3450))
        s4.addBar(BarModel(4.2f, -0xa9480f))
        s4.addBar(BarModel(2.1f, -0x325981))

        mStackedBarChart.addBar(s1)
        mStackedBarChart.addBar(s2)
        mStackedBarChart.addBar(s3)
        mStackedBarChart.addBar(s4)

        mStackedBarChart.startAnimation()
    }
}