package com.example.myapplication

import android.content.ComponentCallbacks
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityAboutSoftBinding
import com.google.gson.Gson
import java.net.URL
import kotlin.concurrent.thread

class AboutSoft : AppCompatActivity() {
    private lateinit var binding:ActivityAboutSoftBinding
    private val policyUrl = URL("http://65.21.190.65/api/about")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutSoftBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.getPolicy.setOnClickListener {
            thread {
                val response = Gson().fromJson(policyUrl.readText(), Policy::class.java)
                val download = Intent(Intent.ACTION_VIEW, Uri.parse(response.data.privacy_file))
                startActivity(download)
            }
        }
    }

}

data class Policy(
    val success: Boolean,
    val errors_message:String,
    val data:Data
)

data class Data(
    val privacy_file:String,
    val about:String
)