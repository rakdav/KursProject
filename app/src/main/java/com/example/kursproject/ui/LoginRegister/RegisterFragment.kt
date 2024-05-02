package com.example.kursproject.ui.LoginRegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.kursproject.R
import com.example.kursproject.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegisterFragment : Fragment(R.layout.fragment_register) {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentRegisterBinding.inflate(layoutInflater, container, false)
        binding.login.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment)
        }
        binding.register.setOnClickListener {
            auth = Firebase.auth

            if(binding.registerPassword.text.toString().equals(binding.registerPasswordRepeat.text.toString())) {
                auth.createUserWithEmailAndPassword(
                    binding.email.text.toString(),
                    binding.registerPassword.text.toString()
                ).addOnCompleteListener(requireActivity()){ task->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(requireContext(),"createUserWithEmail:success",Toast.LENGTH_SHORT).show()
                        view?.findNavController()?.navigate(R.id.action_registerFragment_to_loginFragment)
                    } else {
                        Toast.makeText(requireContext(),"createUserWithEmail:failed",Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }
        return binding.root
    }
}