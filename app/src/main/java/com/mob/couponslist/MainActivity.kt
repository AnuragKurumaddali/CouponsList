package com.mob.couponslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mob.couponslist.viewmodel.CouponViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCouponData()
    }


    private fun getCouponData(){

        val userViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
        userViewModel.getCouponData()?.observe(this, Observer {
           Log.e("aaa", "Response: $it");
        })
    }
}