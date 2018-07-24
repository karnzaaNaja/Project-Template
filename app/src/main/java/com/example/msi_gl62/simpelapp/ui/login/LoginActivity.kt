package com.example.msi_gl62.simpelapp.ui.login

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.extension.navigate
import com.example.msi_gl62.simpelapp.fragment.MainTabActivity
import com.example.msi_gl62.simpelapp.ui.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setBootnSumit()
    }

    private fun setBootnSumit() {
        btnSubmit.setOnClickListener {
            onSingUp()
        }
        btnRegister.setOnClickListener {
            navigate<RegisterActivity> { }
        }
    }

    private fun onSingUp() {
        mAuth = FirebaseAuth.getInstance()
        val progressDialog = ProgressDialog.show(this@LoginActivity, "Please wait...", "Proccessing...", true)
        mAuth?.signInWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString())
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    progressDialog.dismiss()
                    //** ส่วนของการเช็ค การยืนยันใน gmail
                    val user = FirebaseAuth.getInstance().currentUser
                    val satus = user!!.isEmailVerified.toString()
                    if (satus == "true") {
                        navigate<MainTabActivity> { }
                    } else {
                        Toast.makeText(this@LoginActivity, satus, Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "กรุณาตรวจสอบ", Toast.LENGTH_LONG).show()
                    progressDialog.dismiss()
                }
            }
    }
}
