package com.ynov.upwork.ui.employee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ynov.upwork.R
import com.ynov.upwork.listUtils.EmployeeAdapter
import com.ynov.upwork.model.EmployeeResponseAPI
import com.ynov.upwork.model.WorkedDays
import com.ynov.upwork.utils.ApiCallBackEmployeeById
import com.ynov.upwork.utils.ApiUtils

class EmployeeActivity : AppCompatActivity() {
    private var employee : EmployeeResponseAPI? = null
    private var workedDays : ArrayList<WorkedDays> = arrayListOf()
    private lateinit var adapter: EmployeeAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        val backButton = findViewById<ImageView>(R.id.arrow)

        backButton.setOnClickListener {
            onBackPressed()
        }

        recyclerView = findViewById(R.id.list)
        adapter = EmployeeAdapter(workedDays)

        recyclerView.adapter = this.adapter

        ApiUtils.getEmployeeById(object : ApiCallBackEmployeeById {
            override fun onSuccess(employee : EmployeeResponseAPI) {
                runOnUiThread{
                    this@EmployeeActivity.employee = employee
                    displayData()
                }
            }
            override fun onError() {

            }
        }, intent.getStringExtra("id"))
    }

    fun displayData() {
        val worked = findViewById<TextView>(R.id.worked)
        val credit = findViewById<TextView>(R.id.credit)
        val arrive = findViewById<TextView>(R.id.arrive)
        val leave = findViewById<TextView>(R.id.leave)

        if (employee?.today?.workedHours.toString() == null){
            worked.text = "0"
        } else {
            worked.text = employee?.today?.workedHours.toString()
        }
        if (employee?.today?.credit.toString() == null){
            credit.text = "0"
        } else {
            credit.text = employee?.today?.credit.toString()
        }
        if (employee?.today?.startHour.toString() == null){
            arrive.text = "0"
        } else {
            arrive.text = employee?.today?.startHour.toString()
        }
        if (employee?.today?.endHour.toString() == null){
            leave.text = "0"
        } else {
            leave.text = employee?.today?.endHour.toString()
        }

    }
}