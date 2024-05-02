package com.example.kursproject.ui.LoginRegister

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kursproject.databinding.ActivityLoginRegisterBinding
import com.example.kursproject.databinding.ActivityMainBinding


class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}