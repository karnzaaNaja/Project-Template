package com.example.msi_gl62.simpelapp.mainactor

import com.example.msi_gl62.simpelapp.callapi.Request
import com.example.msi_gl62.simpelapp.edr.modellogin.LoginEdr

class InterActor {

    interface OnFinishRequest {
        fun <T> onSuccess(t: T) {}
    }

    interface ActData {
        fun callListFoodApi(callback: Request.ResponseListFood)
        fun callTest(call: Request.ResponseTest)
        fun callLoginEdr(login: LoginEdr, callback: Request.LoginListerEdr)
    }
}