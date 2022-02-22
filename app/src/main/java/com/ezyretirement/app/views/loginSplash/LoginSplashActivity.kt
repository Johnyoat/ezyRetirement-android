package com.ezyretirement.app.views.loginSplash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezyretirement.app.databinding.ActivityLoginSplashBinding

class LoginSplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginSplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}