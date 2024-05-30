package com.example.kursproject.model

import android.app.Application
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AuthAppRepository(private var application: Application) {
    private val mDatabase: FirebaseDatabase? = FirebaseDatabase.getInstance();
    private val mDbRef: DatabaseReference? = mDatabase!!.getReference("users");
    private var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private var userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData()
    private var loggedOutLiveData: MutableLiveData<Boolean> = MutableLiveData()
    init
    {
        if (firebaseAuth.currentUser != null) {
            userLiveData.postValue(firebaseAuth.currentUser)
            loggedOutLiveData.postValue(false)
        }
    }
    @RequiresApi(Build.VERSION_CODES.P)
    fun login(email: String?, password: String?) {
        firebaseAuth.signInWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(
                application.mainExecutor
            ) { task ->
                if (task.isSuccessful) {
                    userLiveData.postValue(firebaseAuth.currentUser)
                } else {
                    Toast.makeText(
                        application.applicationContext,
                        "Login Failure: " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    @RequiresApi(Build.VERSION_CODES.P)
    fun register(email: String?, password: String?)
    {

        firebaseAuth.createUserWithEmailAndPassword(email!!, password!!)
            .addOnCompleteListener(
                application.mainExecutor
            )
            { task ->
                if (task.isSuccessful)
                {
                    userLiveData.postValue(firebaseAuth.currentUser)
                    Toast.makeText(
                        application.applicationContext,
                        "Registration access",
                        Toast.LENGTH_SHORT
                    ).show()
                    val userId = mDbRef!!.push().key
                    val user: User = User(
                        "${firebaseAuth.currentUser!!.email}", "", "",
                        ""
                    )
                    mDbRef.child(userId!!).setValue(user);
                }
                else
                {
                    Toast.makeText(
                        application.applicationContext,
                        "Registration Failure: " + task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    fun logOut() {
        firebaseAuth.signOut()
        loggedOutLiveData.postValue(true)
    }

    fun getUserLiveData(): MutableLiveData<FirebaseUser> {
        return userLiveData
    }

    fun getLoggedOutLiveData(): MutableLiveData<Boolean> {
        return loggedOutLiveData
    }

}