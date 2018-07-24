package com.example.msi_gl62.simpelapp.callapi
import com.example.msi_gl62.simpelapp.mainactor.InterActor
import com.example.msi_gl62.simpelapp.model.ListRoomEven
import com.example.msi_gl62.simpelapp.model.ListTestModel
import com.example.msi_gl62.simpelapp.edr.modellogin.LoginEdr
import com.example.msi_gl62.simpelapp.edr.modellogin.ResponseDataLogin
import com.example.msi_gl62.simpelapp.network.BaseRetrofit
import com.example.msi_gl62.simpelapp.network.BaseUrl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class Request : InterActor.ActData {

    interface ResponseTest  {
        fun <T> onSuccess2(t: T)
    }

    interface ResponseListFood  {
        fun <T> onSuccess(t: T)
    }

    interface LoginListerEdr {
        fun onResponseSuccessLogin(status_id: String?,
            error_msg:String?,
            name:String?,
            teacher_id:String?,
            surname: String?,
            term_id: String?
        )
    }

    override fun callListFoodApi(callback: ResponseListFood) {
        val baseService by lazy { BaseRetrofit.createRx(BaseUrl.baseUrl) }
        baseService?.ListFood()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(object : DisposableObserver<Response<ListRoomEven>>() {
                    override fun onComplete() {}
                    override fun onNext(t: Response<ListRoomEven>) {
                        t.body()?.let { callback.onSuccess(it) }
                    }
                    override fun onError(e: Throwable) {}
                })
    }

    //TODO  Test callApiedr
    override fun callTest(call:ResponseTest) {
        val baseService by lazy { BaseRetrofit.createRx(BaseUrl.baseUrl2) }
        baseService?.List()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<Response<ListTestModel>>() {
                override fun onComplete() {}
                override fun onNext(t: Response<ListTestModel>) {
                    t.body()?.let { call.onSuccess2(it) }
                }
                override fun onError(e: Throwable) {}
            })
    }

    //TODO  Test callApiedrLogin
    override fun callLoginEdr(login: LoginEdr, callback: LoginListerEdr) {
        BaseRetrofit.createRx(BaseUrl.baseUrl3)?.requestLogin(login._u, login._p)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : DisposableObserver<Response<ResponseDataLogin>>() {
                override fun onComplete() {}
                override fun onNext(t: Response<ResponseDataLogin>) {
                    t.body()?.let {
                        callback.onResponseSuccessLogin(it.status_id,
                            it.error_msg,it.name,it.teacher_id,it.surname,it.term_id)
                    }
                }
                override fun onError(e: Throwable) {}
            })
    }

}