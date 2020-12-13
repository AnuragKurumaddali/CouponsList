package com.mob.couponslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mob.couponslist.models.CouponDO
import com.mob.couponslist.viewmodel.CouponViewModel
import com.tchnte.codingtask.adapter.CouponListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var couponListAdapter: CouponListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControls()
        getCouponData()
    }

    private fun initControls() {
        val linearLayoutManager : LinearLayoutManager =  LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rv_Coupon?.layoutManager = linearLayoutManager
    }


    private fun getCouponData(){

        val userViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
        userViewModel.getCouponData()?.observe(this, Observer {
//            couponListAdapter?.addCoupons(it)
            couponListAdapter = CouponListAdapter(this, it as MutableList<CouponDO>?)
            rv_Coupon?.adapter = couponListAdapter
        })
    }
}