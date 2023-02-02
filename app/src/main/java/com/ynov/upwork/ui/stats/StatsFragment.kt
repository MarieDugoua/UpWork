package com.ynov.upwork.ui.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.ynov.upwork.R
import com.ynov.upwork.model.ListEmployee
import com.ynov.upwork.model.Stats
import com.ynov.upwork.utils.ApiCallBackStats
import com.ynov.upwork.utils.ApiUtils

class StatsFragment : Fragment() {

    private var stats = Stats()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        ApiUtils.getStats(object : ApiCallBackStats {
            override fun onSuccess(stats : Stats) {
                requireActivity().runOnUiThread{
                    this@StatsFragment.stats = stats
                    displayData()
                }
            }
            override fun onError() {

            }
        })

        return view
    }

    fun displayData(){
        val hour = requireActivity().findViewById<TextView>(R.id.text_hours)
        val employee = requireActivity().findViewById<TextView>(R.id.text_employee)
        val stat = requireActivity().findViewById<TextView>(R.id.text_stats)
        val vacation = requireActivity().findViewById<TextView>(R.id.text_vacation)
        val average = requireActivity().findViewById<TextView>(R.id.text_average)

        if(stats.workHours.toString() == null){
            hour.text = "0"
        } else {
            hour.text = stats.workHours.toString()
        }
        if(stats.numberOfEmployees.toString() == null){
            vacation.text = "0"
        } else {
            vacation.text = stats.numberOfEmployees.toString()
        }
        if(stats.averageWorkedHoursByEmployee.toString() == null){
            average.text = "0"
        } else {
            average.text = stats.averageWorkedHoursByEmployee.toString()
        }
        if(stats.hoursWorkedByDay.toString() == null){
            employee.text = "0"
        } else {
            employee.text = stats.hoursWorkedByDay.toString()
        }

    }

}