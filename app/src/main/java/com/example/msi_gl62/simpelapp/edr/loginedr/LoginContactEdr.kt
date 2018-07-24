package com.example.msi_gl62.simpelapp.edr.loginedr

import com.example.msi_gl62.simpelapp.edr.modellogin.LoginEdr

interface LoginContactEdr{
    interface Presenter {
        fun checkEdiTextLogin(model: LoginEdr)
        fun requestValidateApiLogin(model: LoginEdr)
    }
    interface View {
        fun onSuccessValidated(model: LoginEdr)
        fun onErrorMessage(err: Int)
        fun onResponseFromApiLogin(status_id: String?,
            error_msg:String?,
            name:String?,
            teacher_id:String?,
            surname: String?,
            term_id: String?)
    }
}