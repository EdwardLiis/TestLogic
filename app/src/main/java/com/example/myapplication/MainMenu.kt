package com.example.myapplication

import com.example.myapplication.menu.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainMenu : AppCompatActivity() {

    private val predictionsFrag = Predictions()
    private val forecastsFrag = Forecasts()
    private val otherFrag = Other()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        val navPanel = findViewById<BottomNavigationView>(R.id.navPanel)
        changeFrag(predictionsFrag)

        navPanel.setOnItemSelectedListener {
            when (it.itemId){
                R.id.nav_home -> changeFrag(predictionsFrag)
                R.id.nav_carriage -> changeFrag(forecastsFrag)
                R.id.nav_other -> changeFrag(otherFrag)
            }
            true
        }

    }

    private fun changeFrag(fragment: Fragment){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainer, fragment)
            transaction.commit()
    }
}