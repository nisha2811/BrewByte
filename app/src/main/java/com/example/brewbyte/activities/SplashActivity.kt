package com.example.brewbyte.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.brewbyte.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.splashImg.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}