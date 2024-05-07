package com.example.kursproject.ui.profile

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.kursproject.R
import com.example.kursproject.databinding.FragmentHomeBinding
import com.example.kursproject.databinding.FragmentProfileBinding
import com.example.kursproject.ui.home.HomeViewModel
import de.hdodenhof.circleimageview.CircleImageView

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var fio:EditText=binding.fio
        var email:EditText=binding.email
        var phone:EditText=binding.phone
        var profileFoto:CircleImageView=binding.profile
//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}