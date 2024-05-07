package com.example.kursproject.ui.LoginRegister

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser


class LoggedInViewModel(app:Application):ViewModel()
{
    private var authAppRepository: AuthAppRepository? = null
    private var userLiveData: MutableLiveData<FirebaseUser?>? = null
    private var loggedOutLiveData: MutableLiveData<Boolean>? = null

    init
    {
        authAppRepository = AuthAppRepository(app)
        userLiveData = authAppRepository!!.getUserLiveData()
        loggedOutLiveData = authAppRepository!!.getLoggedOutLiveData()
    }

    fun logOut() {
        authAppRepository!!.logOut()
    }

    fun getUserLiveData(): MutableLiveData<FirebaseUser?>? {
        return userLiveData
    }

    fun getLoggedOutLiveData(): MutableLiveData<Boolean>? {
        return loggedOutLiveData
    }
}