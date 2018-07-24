package com.example.msi_gl62.simpelapp.edr.loginedr

import com.example.msi_gl62.simpelapp.callapi.Request
import com.example.msi_gl62.simpelapp.mainactor.InterActor
import com.example.msi_gl62.simpelapp.edr.modellogin.LoginEdr

class LoginPresenterEdr (val view: LoginContactEdr.View) : LoginContactEdr.Presenter, InterActor.OnFinishRequest, Request.LoginListerEdr {


    private val actData: InterActor.ActData = Request()

    override fun checkEdiTextLogin(model: LoginEdr) {
        view.onSuccessValidated(model)
    }

    override fun requestValidateApiLogin(model: LoginEdr) {
        actData.callLoginEdr(model,this)
    }



    override fun onResponseSuccessLogin(status_id: String?, error_msg: String?, name: String?,
        teacher_id: String?,surname: String?,
        term_id: String?)

    { view.onResponseFromApiLogin(status_id,error_msg,name, teacher_id,surname, term_id) }
}