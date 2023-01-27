package com.ynov.upwork.listUtils

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ynov.upwork.R

import com.ynov.upwork.model.ListEmployee

class ListEmployeesAdapter(private val dataSet: ArrayList<ListEmployee>) :
    RecyclerView.Adapter<ListEmployeesAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.employeeName)
            imageView = view.findViewById(R.id.greenCircle)

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
        viewHolder.textView.text = dataSet[position].name

        if (dataSet[position].isWorking == true) {
            viewHolder.imageView.setImageResource(R.drawable.ic_baseline_green_circle_24)
        } else if (dataSet[position].isWorking == false) {
            viewHolder.imageView.setImageResource(R.drawable.ic_baseline_red_circle_24)
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

