package com.mob.couponslist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.mvvmdemo.services.RetrofitService
import com.mob.couponslist.models.CouponDO

class CouponViewModel : ViewModel() {

    private val userServiceResponse = RetrofitService()

    fun getCouponData() : MutableLiveData<List<CouponDO>>?{

        return userServiceResponse.loadCouponData()
    }
}