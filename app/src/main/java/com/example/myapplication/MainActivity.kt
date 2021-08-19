package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val auth_key = "IsAuthorized"
    val pref_key = "com.example.myapp.PREFERENCE_FILE_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {

        val sharedPref = getSharedPreferences(pref_key,Context.MODE_PRIVATE)

        if (sharedPref.getBoolean(auth_key,false)){
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
            finish()
        }

        Toast.makeText(this,"Auth key set to ${sharedPref.getBoolean(auth_key,false)}",Toast.LENGTH_LONG).show()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val googleAuth:ImageButton = findViewById(R.id.googleAuth)
        val facebookAuth:ImageButton = findViewById(R.id.facebookAuth)
        val noAuth:Button = findViewById(R.id.noAuth)



        googleAuth.setOnClickListener{
            Toast.makeText(this,"Only noAuth implemented(set auth to false)",Toast.LENGTH_SHORT).show()
            with(sharedPref.edit()){
                putBoolean(auth_key,false)
                apply()
            }
        }
        facebookAuth.setOnClickListener{
            Toast.makeText(this,"Only noAuth implemented(set auth to true)",Toast.LENGTH_SHORT).show()
            with(sharedPref.edit()){
                putBoolean(auth_key,true)
                apply()
            }
        }

        noAuth.setOnClickListener{
            val intent = Intent(this,AcceptTerms::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        val sharedPref = getSharedPreferences(pref_key,Context.MODE_PRIVATE)
        if (sharedPref.getBoolean(auth_key,false)){
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
        super.onResume()
    }
}