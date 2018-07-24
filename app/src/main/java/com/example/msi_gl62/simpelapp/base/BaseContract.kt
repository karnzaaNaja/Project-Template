package com.example.msi_gl62.simpelapp.base

open class BaseContract {

    interface View {
        fun showProgressDialog()
    }

    interface Presenter<V : View> {
        fun onViewCreate()
        fun onViewDestroy()
        fun onViewStart()
        fun onViewStop()
    }
}