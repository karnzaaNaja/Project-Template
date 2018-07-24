package com.example.msi_gl62.simpelapp.edr.loginedr

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.WindowManager
import com.example.msi_gl62.simpelapp.R
import com.example.msi_gl62.simpelapp.edr.modellogin.LoginEdr
import com.example.msi_gl62.simpelapp.edr.setuniversity.MainActivity
import com.example.msi_gl62.simpelapp.extension.navigate
import com.example.msi_gl62.simpelapp.fragment.MainTabActivity
import kotlinx.android.synthetic.main.activity_login_test.*
import kotlinx.android.synthetic.main.item_dialog_error.*

class LoginActivityEdr : AppCompatActivity(), LoginContactEdr.View {

    private lateinit var presenter: LoginContactEdr.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_test)
        presenter = LoginPresenterEdr(this)
        setUniversity()
        setClick()
    }

    private fun setUniversity(){
        edt_co.setOnClickListener { navigate<MainActivity> { } }
    }

    private fun setClick() {
        click.setOnClickListener {
            val model = LoginEdr(edt_username.text.trim().toString(), "81dc9bdb52d04dc20036dbd8313ed055")
            presenter.checkEdiTextLogin(model)
        }
    }

    override fun onStart() {
        super.onStart()
        val sp = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE)
        val user_id = sp.getString("customer", "")
        edt_co.text = user_id
    }

    override fun onSuccessValidated(model: LoginEdr) {
        presenter.requestValidateApiLogin(model)
    }

    override fun onErrorMessage(err: Int) {}

    @SuppressLint("SetTextI18n")
    override fun onResponseFromApiLogin(status_id: String?, error_msg: String?, name: String?, teacher_id: String?, surname: String?, term_id: String?) {
        if(error_msg.equals("")){
            Dialog(this, R.style.DialogTheme).apply {
                setContentView(R.layout.item_dialog_error)
                tvDialogMessage.text = error_msg
                window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                btnDialogAccept.setOnClickListener { hide() }
                show()
            }
        }else{
            navigate<MainTabActivity> {  }
        }
    }
}
