package com.example.kursproject.ui.LoginRegister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.kursproject.R
import com.example.kursproject.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
//                    var intent=Intent(requireContext(),MainActivity::class.java)
//                    startActivity(intent)
                } else {

                }
            }
        }
        return binding.root
    }
}