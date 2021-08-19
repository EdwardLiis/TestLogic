package com.example.myapplication.menu

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.UiThread
import com.example.myapplication.*
import com.google.gson.Gson
import java.net.URL
import java.util.zip.Inflater
import kotlin.concurrent.thread


class Other : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_other, container, false)

        val donate = view.findViewById<Button>(R.id.donate)
        val share = view.findViewById<Button>(R.id.share)
        val about = view.findViewById<Button>(R.id.about)
        val logout = view.findViewById<Button>(R.id.login)

        donate.setOnClickListener { Toast.makeText(this.context,"Not Implemented",Toast.LENGTH_SHORT).show() }
        share.setOnClickListener { Toast.makeText(this.context,"Not Implemented",Toast.LENGTH_SHORT).show() }

        about.setOnClickListener {

            val intent = Intent(this.context, AboutProgram::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener {
            val auth_key = "IsAuthorized"
            val pref_key = "com.example.myapp.PREFERENCE_FILE_KEY"
            val sharedPref = this.activity?.getSharedPreferences(pref_key,Context.MODE_PRIVATE)
            with (sharedPref!!.edit()){
                putBoolean(auth_key,false)
                apply()
            }
                val intent = Intent(this.context,MainActivity::class.java)
                startActivity(intent)
                this.requireActivity().finish()
        }

        return view
    }


    companion object {

        @JvmStatic
        fun newInstance() {}

    }
}