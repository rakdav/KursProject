package com.example.kursproject.loginRegister.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kursproject.model.AuthAppRepository
import com.google.firebase.auth.FirebaseUser


class LoggedInViewModel(app:Application):ViewModel()
{
    private var authAppRepository: AuthAppRepository = AuthAppRepository(app)
    private var userLiveData: MutableLiveData<FirebaseUser> = authAppRepository.getUserLiveData()
    private var loggedOutLiveData: MutableLiveData<Boolean> = authAppRepository.getLoggedOutLiveData()

    fun logOut() {
        authAppRepository.logOut()
    }

    fun getUserLiveData(): MutableLiveData<FirebaseUser> {
        return userLiveData
    }

    fun getLoggedOutLiveData(): MutableLiveData<Boolean> {
        return loggedOutLiveData
    }
}