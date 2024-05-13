package com.example.kursproject.loginRegister.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.kursproject.R
import com.example.kursproject.databinding.FragmentLoginBinding
import com.example.kursproject.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        auth = Firebase.auth
        binding= FragmentLoginBinding.inflate(layoutInflater, container, false)
        binding.register.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_registerFragment)
        }
        binding.login.setOnClickListener {
            auth.signInWithEmailAndPassword(binding.email.text.toString(),
                binding.password.text.toString()).addOnCompleteListener(requireActivity()){
                    task->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(requireContext(), "User$user",Toast.LENGTH_LONG).show()
                    val intent=Intent(requireActivity(),MainActivity::class.java)
                    startActivity(intent)
                } else {

                }
            }
        }
        return binding.root
    }
}