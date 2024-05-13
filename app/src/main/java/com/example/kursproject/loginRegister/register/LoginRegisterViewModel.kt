package com.example.kursproject.loginRegister.register

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kursproject.model.AuthAppRepository
import com.google.firebase.auth.FirebaseUser


class LoginRegisterViewModel(app: Application): AndroidViewModel(app)
{
    private var authAppRepository: AuthAppRepository = AuthAppRepository(app)
    private var userLiveData: MutableLiveData<FirebaseUser> = authAppRepository.getUserLiveData()


    fun login(email: String?, password: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            authAppRepository.login(email, password)
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun register(email: String?, password: String?){
        authAppRepository.register(email, password)
    }

    fun getUserLiveData(): MutableLiveData<FirebaseUser> {
        return userLiveData
    }
}