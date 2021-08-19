package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.gson.Gson
import java.net.URL
import kotlin.concurrent.thread

class AboutProgram : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_program)

        val button:Button = findViewById(R.id.loadPolicy)
        button.setOnClickListener {
            val url = URL("http://65.21.190.65/api/about")
            thread {
                val response = url.readText()
                val parsed = Gson().fromJson(response,DataAbout::class.java)
                val startDownload = Intent(Intent.ACTION_VIEW, Uri.parse(parsed.data.privacy_file))
                startActivity(startDownload)
            }
        }
    }
}