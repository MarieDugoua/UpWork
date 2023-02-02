package com.ynov.upwork.model

import org.json.JSONObject

data class EmployeeResponseAPI(
    var employee   : EmployeeAPI?             = EmployeeAPI(),
    var today      : Today?                = Today(),
    var workedDays : ArrayList<WorkedDays> = arrayListOf()
) {
    companion object {
        @JvmStatic
        fun fromJson(jsonObject: JSONObject) : EmployeeResponseAPI {
            val employee= EmployeeResponseAPI()

            employee.employee = EmployeeAPI(
               id = jsonObject.getString("id"),
               name = jsonObject.getString("name")
            )

            employee.today = Today(
               workedHours = jsonObject.getString("workedHours"),
               credit = jsonObject.getString("credit"),
               startHour = jsonObject.getString("startHour"),
               endHour = jsonObject.getString("endHour")
            )

            val workedDays = arrayListOf<WorkedDays>()
            val jsonArray = jsonObject.getJSONArray("workedDays")

            for(i in 0 until jsonArray.length()) {
                val workedDaysObject = jsonArray.getJSONObject(i)
                workedDays.add(WorkedDays(
                   date = workedDaysObject.getString("date"),
                   workedHours = workedDaysObject.getString("workedHours")
                ))
            }
            return employee
        }
    }
}

data class EmployeeAPI(
    var id   : String? = null,
    var name : String? = null
)

data class Today(
    var workedHours : String? = null,
    var credit      : String? = null,
    var startHour   : String? = null,
    var endHour     : String? = null
)

data class WorkedDays (
    var date        : String? = null,
    var workedHours : String? = null
)