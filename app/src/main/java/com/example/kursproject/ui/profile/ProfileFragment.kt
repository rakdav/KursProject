package com.example.kursproject.ui.profile

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kursproject.databinding.FragmentProfileBinding
import com.example.kursproject.loginRegister.register.LoginRegisterViewModel
import de.hdodenhof.circleimageview.CircleImageView
import java.io.File
import java.io.FileOutputStream

import java.io.IOException


class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    var mUri: Uri? = null
    private val PHOTO_INTENT_REQUEST_CODE = 100
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]
        val loginRegisterViewModel = ViewModelProvider(this)[LoginRegisterViewModel::class.java]

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root
        var fio:EditText=binding.fio
        var email:EditText=binding.email
        var phone:EditText=binding.phone
        var profileFoto:CircleImageView=binding.profile

        binding.btupload.setOnClickListener{
            val name=loginRegisterViewModel.getUserLiveData().value!!.email.toString()
            mUri = generateFileUri(loginRegisterViewModel.getUserLiveData().value!!.email.toString());
            if (mUri == null) {
                Toast.makeText(requireContext(), "File not created", Toast.LENGTH_LONG).show();
            }
            else {
                var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, mUri);
                startActivityForResult(intent, PHOTO_INTENT_REQUEST_CODE);
            }
        }


        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun generateFileUri(fotoname:String): Uri? {

        var fos: FileOutputStream? = null
        var newFile:File?=null
        try {
            fos = requireContext().openFileOutput(fotoname+".jpg", Context.MODE_PRIVATE);
            newFile = File(fotoname+".jpg")
        }
        catch (ex:IOException)
        {
            Toast.makeText(requireContext(), ex.message, Toast.LENGTH_SHORT).show();
        }
        finally {
            try {
                fos?.close()
            } catch (ex: IOException) {
                Toast.makeText(requireContext(), ex.message, Toast.LENGTH_SHORT).show()
            }
        }
        return Uri.fromFile(newFile)
    }

}