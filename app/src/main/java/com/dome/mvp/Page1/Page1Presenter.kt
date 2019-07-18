package com.dome.mvp.Page1

import android.util.Log
import com.example.promptnow.testkotlin.ApiService
import com.example.promptnow.testkotlin.DataModel
import retrofit2.Call
import retrofit2.Callback

class Page1Presenter(private var view: Page1Interface.View) :
    Page1Interface.Presenter {


    override fun callWebService() {
        val apiService = ApiService.create()
        val call = apiService.getCategoryDetails()
        Log.d("REQUEST", call.toString() + "")
        call.enqueue(object : Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>, response: retrofit2.Response<DataModel>?) {
                view.initRecycleview(response!!.body()!!)
            }

            override fun onFailure(call: Call<DataModel>, t: Throwable) {
                Log.d("dome","Fails")
                view.serviceError()
            }
        })
    }
}