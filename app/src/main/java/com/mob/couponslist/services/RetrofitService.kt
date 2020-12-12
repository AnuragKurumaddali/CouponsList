package com.kotlin.mvvmdemo.services

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mob.couponslist.interfaces.APiInterface
import com.mob.couponslist.models.CouponDO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

//    https://run.mocky.io/v3/4c663239-03af-49b5-bcb3-0b0c41565bd2
    companion object Factory {
        var gson = GsonBuilder().setLenient().create()
        fun create(): APiInterface {
            Log.e("retrofit","create")

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(APiInterface::class.java)
        }

        private const val BASE_URL = "https://run.mocky.io/"
    }

    fun loadCouponData() : MutableLiveData<List<CouponDO>>?{
        val  liveUserResponse : MutableLiveData<List<CouponDO>> = MutableLiveData()

        val retrofitCall = create().getCouponsList()

        retrofitCall.enqueue(object : Callback<List<CouponDO>> {
            override fun onFailure(call: Call<List<CouponDO>>, t: Throwable?) {
                Log.e("on Failure :", "retrofit error")
            }
            override fun onResponse(call: Call<List<CouponDO>>, response: retrofit2.Response<List<CouponDO>>) {
                liveUserResponse.value = response.body()
            }
        })

        return liveUserResponse
    }


}