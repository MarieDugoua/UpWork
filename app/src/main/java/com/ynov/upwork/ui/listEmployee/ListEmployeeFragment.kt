package com.ynov.upwork.ui.listEmployee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ynov.upwork.R
import com.ynov.upwork.listUtils.ListEmployeesAdapter
import com.ynov.upwork.model.Employee
import com.ynov.upwork.utils.ApiUtils

class ListEmployeeFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_employee, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = ListEmployeesAdapter(employees)
            }
        }
        ApiUtils.get()
        return view
    }

    companion object {
        lateinit var employees: ArrayList<Employee>

        const val ARG_COLUMN_COUNT = "column-count"
    }

}