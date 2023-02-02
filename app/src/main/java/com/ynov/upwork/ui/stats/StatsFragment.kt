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

    private var stats = ArrayList<Stats>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_stats, container, false)

        ApiUtils.getStats(object : ApiCallBackStats {
            override fun onSuccess(stats : ArrayList<Stats>) {
                requireActivity().runOnUiThread{
                    this@StatsFragment.stats.addAll(stats)
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

        if(stats[0].workHours.toString() == null){
            hour.text = "0"
        } else {
            hour.text = stats[0].workHours.toString()
        }
        if(stats[1].numberOfEmployees.toString() == null){
            vacation.text = "0"
        } else {
            vacation.text = stats[1].numberOfEmployees.toString()
        }
        if(stats[2].averageWorkedHoursByEmployee.toString() == null){
            average.text = "0"
        } else {
            average.text = stats[2].averageWorkedHoursByEmployee.toString()
        }
        if(stats[3].hoursWorkedByDay.toString() == null){
            employee.text = "0"
        } else {
            employee.text = stats[3].hoursWorkedByDay.toString()
        }

    }

}