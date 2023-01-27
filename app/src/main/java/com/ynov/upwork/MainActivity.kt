package com.ynov.upwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ynov.upwork.ui.listEmployee.ListEmployeeFragment
import com.ynov.upwork.ui.stats.StatsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listEmployee = ListEmployeeFragment()
        val stats = StatsFragment()
        replaceCurrentFragment(listEmployee)

        val navigation = findViewById<BottomNavigationView>(R.id.nav_view)

        navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_list_employee -> {
                        replaceCurrentFragment(listEmployee)
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_stats -> {
                        replaceCurrentFragment(stats)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
    private fun replaceCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment_activity_main, fragment)
            commit()
        }
}