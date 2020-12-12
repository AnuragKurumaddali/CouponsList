package com.mob.couponslist.interfaces

import com.mob.couponslist.models.CouponDO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APiInterface {

    //    https://run.mocky.io/v3/4c663239-03af-49b5-bcb3-0b0c41565bd2
    @GET("v3/4c663239-03af-49b5-bcb3-0b0c41565bd2")
    fun getCouponsList(): Call<List<CouponDO>>
}