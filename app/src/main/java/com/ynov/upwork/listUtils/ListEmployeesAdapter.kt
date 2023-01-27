package com.ynov.upwork.listUtils

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.ynov.upwork.databinding.EmployeeItemBinding
import com.ynov.upwork.model.Employee

class ListEmployeesAdapter (
    private val values: List<Employee>
) : RecyclerView.Adapter<ListEmployeesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            EmployeeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employee = values[position]
        holder.nameView.text = employee.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: EmployeeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val nameView: TextView = binding.employeeName

        override fun toString(): String {
            return super.toString() + " '" + nameView.text + "'"
        }
    }

}