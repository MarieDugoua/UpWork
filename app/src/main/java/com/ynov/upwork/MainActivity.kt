package com.ynov.upwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    private var mRequestQueue: RequestQueue? = null
    private var mStringRequest: StringRequest? = null
    private val url = "http://10.33.10.193:3000/api/employees"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this)

        // String Request initialized
        mStringRequest = StringRequest(Request.Method.GET, url, object : Listener<String?>() {
            // display the response on screen
            fun onResponse(response: String) {
                Toast.makeText(applicationContext, "Response :$response", Toast.LENGTH_LONG)
                    .show()
            }
        }, object : ErrorListener() {
            fun onErrorResponse(error: VolleyError) {
                Log.i(ContentValues.TAG, "Error :" + error.toString())
            }
        })
        mRequestQueue.add(mStringRequest)
    }
}