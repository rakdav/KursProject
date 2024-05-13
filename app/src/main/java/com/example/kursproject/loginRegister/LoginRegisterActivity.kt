package com.example.kursproject.loginRegister

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kursproject.databinding.ActivityLoginRegisterBinding


class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}