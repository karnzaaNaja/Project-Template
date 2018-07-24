package com.example.msi_gl62.simpelapp.network

import com.example.msi_gl62.simpelapp.model.ListRoomEven
import com.example.msi_gl62.simpelapp.model.ListTestModel
import com.example.msi_gl62.simpelapp.edr.modellogin.ResponseDataLogin
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*

interface BaseService {

    @GET("list_data_detail")
    fun ListFood(): Observable<Response<ListRoomEven>>

    @GET("posts")
    fun List(): Observable<Response<ListTestModel>>

    @FormUrlEncoded
    @POST("jsonTeacherAuthen")
    fun requestLogin(@Field("_u") _u: String?,
        @Field("_p") _p: String?
    ): Observable<Response<ResponseDataLogin>>


}