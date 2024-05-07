package com.example.kursproject.ui.LoginRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kursproject.R
import com.example.kursproject.databinding.FragmentRegisterBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRegisterBinding.inflate(layoutInflater, container, false)
        binding.login.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.register.setOnClickListener {

            if(binding.registerPassword.text.toString().equals(binding.registerPasswordRepeat.text.toString())) {

            }

        }
        return binding.root
    }
}