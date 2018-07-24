package com.example.msi_gl62.simpelapp.fragment.room

import com.example.msi_gl62.simpelapp.model.RoomEven
import com.example.msi_gl62.simpelapp.model.TestModel

interface FeedRoomContact {
    interface Presenter {
        fun callListFoodApi(key: String? = null)
        fun callListFoodApiTest(key: String? = null)
    }
    interface View {
        fun onCallSuccess(dataList: List<RoomEven>?)
        fun onCallSuccessTest(data: List<TestModel>?)
    }
}