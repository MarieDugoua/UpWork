package com.ynov.upwork.ui.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ynov.upwork.R
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
                }
            }
            override fun onError() {

            }
        })

        return view
    }

}