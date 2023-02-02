package com.ynov.upwork.ui.employee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynov.upwork.R
import com.ynov.upwork.model.Employee
import com.ynov.upwork.ui.listEmployee.ListEmployeeFragment
import com.ynov.upwork.utils.ApiCallBackEmployeeById
import com.ynov.upwork.utils.ApiUtils

class EmployeeFragment : Fragment() {

    private var columnCount = 1
    private var employee = ArrayList<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ListEmployeeFragment.ARG_COLUMN_COUNT)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_employee, container, false)

        ApiCallBackEmployeeById(this.employee, object : ApiCallBackEmployeeById {
            override fun onSuccess(employee : ArrayList<Employee>) {
                requireActivity().runOnUiThread{
                    this@EmployeeFragment.employee.addAll(employee)
                }
                override fun onError() {
                }
            }
        })

        return view
    }


    companion object {

        const val ARG_COLUMN_COUNT = "column-count"
    }

}