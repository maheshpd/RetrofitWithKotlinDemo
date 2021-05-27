package com.createsapp.retrofitwithkotlin.retrofit


import com.createsapp.retrofitwithkotlin.response.DataResponse
import com.createsapp.retrofitwithkotlin.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("photos")
    fun getPhotos(): Call<List<DataResponse>>

    @FormUrlEncoded
    @POST("teacher_login.php")
    fun login(@Field("emailid") email: String, @Field("password") password: String): Call<LoginResponse>
}