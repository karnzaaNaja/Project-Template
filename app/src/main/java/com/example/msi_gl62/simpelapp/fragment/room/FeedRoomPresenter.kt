package com.example.msi_gl62.simpelapp.fragment.room

import com.example.msi_gl62.simpelapp.callapi.Request
import com.example.msi_gl62.simpelapp.mainactor.InterActor
import com.example.msi_gl62.simpelapp.model.ListRoomEven
import com.example.msi_gl62.simpelapp.model.ListTestModel
import java.net.HttpURLConnection

class FeedRoomPresenter(val view: FeedRoomContact.View): FeedRoomContact.Presenter, Request.ResponseListFood,
    Request.ResponseTest {

    private val actData: InterActor.ActData = Request()

    override fun callListFoodApi(key: String?) {
        actData.callListFoodApi(this)
    }

    override fun callListFoodApiTest(key: String?) {
       actData.callTest(this)
    }

    override fun <T> onSuccess(t: T) {
        view.onCallSuccess(dataList = (t as ListRoomEven).results)
        HttpURLConnection.HTTP_OK
    }

    override fun <T> onSuccess2(t: T) {
        view.onCallSuccessTest(data = (t as ListTestModel).results2)
        HttpURLConnection.HTTP_OK

    }

}