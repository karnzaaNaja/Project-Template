package com.example.msi_gl62.simpelapp.ui.register

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.msi_gl62.simpelapp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setButtonClick()
    }

    private fun setButtonClick() {
        btn_register_sing_up.setOnClickListener {
            btnRegisterClick()
        }
    }

    private fun btnRegisterClick() {
        mAuth = FirebaseAuth.getInstance()
        mAuth?.createUserWithEmailAndPassword(edt_register_email.text.toString(), edt_register_password.text.toString())
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    senEmailVerification()
                } else {
                    Toast.makeText(this@RegisterActivity, "ไม่สำเร็จ", Toast.LENGTH_LONG).show()
                }
            } }

    private fun senEmailVerification() {
        val user = FirebaseAuth.getInstance().currentUser
        user?.sendEmailVerification()?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this@RegisterActivity, "เช็คที่ Email เพื่อยืนยัน", Toast.LENGTH_LONG).show()
                FirebaseAuth.getInstance().signOut()
            }
        }
    }

}
