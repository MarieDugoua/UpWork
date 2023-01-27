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
import com.ynov.upwork.utils.ApiCallBack
import com.ynov.upwork.utils.ApiUtils

class ListEmployeeFragment : Fragment() {

    private var columnCount = 1
    private var employees = ArrayList<Employee>()
    private lateinit var adapter: ListEmployeesAdapter
    private lateinit var recyclerView: RecyclerView

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
        recyclerView = view.findViewById(R.id.list)
        adapter = ListEmployeesAdapter(employees)

        // Set the adapter
        recyclerView.adapter = this.adapter

        ApiUtils.get(object : ApiCallBack {
            override fun onSuccess(employees : ArrayList<Employee>) {
                requireActivity().runOnUiThread{
                    this@ListEmployeeFragment.employees = employees
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onError() {

            }
        })
        return view
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"
    }

}