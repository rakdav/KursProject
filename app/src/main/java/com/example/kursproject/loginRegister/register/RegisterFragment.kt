package com.example.kursproject.loginRegister.register

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.kursproject.R
import com.example.kursproject.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding?=null
    private val binding get() = _binding!!
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val loginRegisterViewModel = ViewModelProvider(this)[LoginRegisterViewModel::class.java]
        _binding=FragmentRegisterBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root
        binding.login.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.register.setOnClickListener {
            val email=binding.email.text.toString()
            val password=binding.registerPassword.text.toString()
            val passwordRepeat=binding.registerPasswordRepeat.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty() && password == passwordRepeat)
            {
                loginRegisterViewModel.register(email,password)
                if(loginRegisterViewModel.ge) view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment)
            }
            else {
                Toast.makeText(requireContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show();
            }
        }
        return root
    }
}