package com.ynov.upwork.listUtils

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ynov.upwork.R
import com.ynov.upwork.model.WorkedDays

class EmployeeAdapter(private val dataSet: ArrayList<WorkedDays>) :
    RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView
        val hour: TextView

        init {
            // Define click listener for the ViewHolder's View
            date = view.findViewById(R.id.date)
            hour = view.findViewById(R.id.hour)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.employee_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.date.text = dataSet[position].date
        viewHolder.hour.text = dataSet[position].workedHours

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

