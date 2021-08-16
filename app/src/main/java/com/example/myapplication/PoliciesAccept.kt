package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.graphics.drawable.toDrawable
import com.example.myapplication.databinding.AcceptPoliciesBinding


class PoliciesAccept : AppCompatActivity() {
    private lateinit var binding: AcceptPoliciesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = AcceptPoliciesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            if(binding.checkBox.isChecked){
                binding.button2.apply{
                    isEnabled = true
                    setBackgroundColor(Color.GREEN)
                }
            }
            else{
                binding.button2.apply{
                    isEnabled = false
                    setBackgroundColor(Color.RED)
                }
            }
        }

        binding.button2.setOnClickListener {
            finish()
        }
    }
}