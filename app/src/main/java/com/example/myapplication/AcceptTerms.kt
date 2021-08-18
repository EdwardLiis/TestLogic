package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox

class AcceptTerms : AppCompatActivity() {
    val auth_key = "IsAuthorized"
    val pref_key = "com.example.myapp.PREFERENCE_FILE_KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accept_terms)

        val checkBox:CheckBox = findViewById(R.id.checkbox)
        val button:Button = findViewById(R.id.accept)

        checkBox.setOnCheckedChangeListener { compoundButton, b ->
            button.isEnabled = b
        }

        button.setOnClickListener {
            val sharedPref = getSharedPreferences(pref_key,Context.MODE_PRIVATE)
            with(sharedPref.edit()){
                putBoolean(auth_key,true)
                apply()
            }
            finish()
        }
    }
}