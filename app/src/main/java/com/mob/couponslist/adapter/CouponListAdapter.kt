package com.tchnte.codingtask.adapter

import android.R.id.text1
import android.R.id.text2
import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE
import android.text.TextUtils
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.mob.couponslist.R
import com.mob.couponslist.models.CouponDO


class CouponListAdapter(context: Context, lsCoupons: MutableList<CouponDO>?) :
    RecyclerView.Adapter<CouponListAdapter.CouponsHolder>() {
    private var isLoaderVisible = false
    private val lsCouponsData: MutableList<CouponDO>? = lsCoupons
    private val mcontext:Context? = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponsHolder {
        return CouponsHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_coupon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CouponsHolder, position: Int) {
        val couponDO: CouponDO? = lsCouponsData?.get(position)
        holder.tv_CouponCode.text = couponDO?.code
        holder.tv_RibbonMessage.text = couponDO?.ribbonMsg
        if(couponDO?.slabs?.isNotEmpty()!!) {
                holder.tv_GetUpto.text = mcontext?.getString(R.string.get) + " " +(couponDO.slabs.maxOf { it?.wageredPercent!! } + couponDO.slabs.maxOf { it?.otcPercent!! })+"% "+mcontext?.getString(
                    R.string.upto
                )+" "+mcontext?.getString(R.string.Rs)+""+(couponDO.slabs.maxOf { it?.wageredMax!! } + couponDO.slabs.maxOf { it?.otcMax!! })
                holder.tv_MinDeposit.text = mcontext?.getString(R.string.Rs) + "" + couponDO.slabs.minOf { it?.min!! }
        }
        holder.tv_ValidTill.text = mcontext?.getString(R.string.valid_till) + " " +couponDO.validUntil
        holder.tv_BonusVal.text = getBonusValColorText(couponDO)
        holder.tv_BonusExp.text = getBonusExpiryColorText(couponDO)
        if(couponDO.slabs.isNotEmpty() && couponDO.slabs.size == 3) {
            holder.tv_PurchaseAmount1.visibility = View.VISIBLE
            holder.tv_PurchaseAmount2.visibility = View.VISIBLE
            holder.tv_PurchaseAmount3.visibility = View.VISIBLE
            holder.tv_BonusAmount1.visibility = View.VISIBLE
            holder.tv_BonusAmount2.visibility = View.VISIBLE
            holder.tv_BonusAmount3.visibility = View.VISIBLE
            holder.tv_InstantCash1.visibility = View.VISIBLE
            holder.tv_InstantCash2.visibility = View.VISIBLE
            holder.tv_InstantCash3.visibility = View.VISIBLE

            holder.tv_PurchaseAmount1.text = "<"+ couponDO.slabs[0]?.min.toString()
            getTextWithDiffSize(
                couponDO.slabs[0]?.wageredPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[0]?.wageredMax.toString() + ")",holder.tv_BonusAmount1)
            getTextWithDiffSize(
                couponDO.slabs[0]?.otcPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[0]?.otcMax.toString() + ")",holder.tv_InstantCash1)

            holder.tv_PurchaseAmount2.text = ">=" + couponDO.slabs[0]?.min.toString() +
                    " " + mcontext?.getString(R.string.and) +
                    " <" + couponDO.slabs[0]?.max.toString()
            getTextWithDiffSize(
                couponDO.slabs[1]?.wageredPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[1]?.wageredMax.toString() + ")",holder.tv_BonusAmount2)
            getTextWithDiffSize(
                couponDO.slabs[1]?.otcPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[1]?.otcMax.toString() + ")",holder.tv_InstantCash2)

            holder.tv_PurchaseAmount3.text = ">="+ couponDO.slabs[2]?.max.toString()
            getTextWithDiffSize(
                couponDO.slabs[2]?.wageredPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[2]?.wageredMax.toString() + ")",holder.tv_BonusAmount3)
            getTextWithDiffSize(
                couponDO.slabs[2]?.otcPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[2]?.otcMax.toString() + ")",holder.tv_InstantCash3)
        }
        else if(couponDO.slabs.size == 2){
            holder.tv_PurchaseAmount1.visibility = View.VISIBLE
            holder.tv_PurchaseAmount2.visibility = View.VISIBLE
            holder.tv_PurchaseAmount3.visibility = View.GONE
            holder.tv_BonusAmount1.visibility = View.VISIBLE
            holder.tv_BonusAmount2.visibility = View.VISIBLE
            holder.tv_BonusAmount3.visibility = View.GONE
            holder.tv_InstantCash1.visibility = View.VISIBLE
            holder.tv_InstantCash2.visibility = View.VISIBLE
            holder.tv_InstantCash3.visibility = View.GONE

            holder.tv_PurchaseAmount1.text = "<"+ couponDO.slabs[0]?.min.toString()
            getTextWithDiffSize(
                couponDO.slabs[0]?.wageredPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[0]?.wageredMax.toString() + ")",holder.tv_BonusAmount1)
            getTextWithDiffSize(
                couponDO.slabs[0]?.otcPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[0]?.otcMax.toString() + ")",holder.tv_InstantCash1)

            holder.tv_PurchaseAmount2.text = ">="+ couponDO.slabs[1]?.max.toString()
            getTextWithDiffSize(
                couponDO.slabs[1]?.wageredPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[1]?.wageredMax.toString() + ")",holder.tv_BonusAmount2)
            getTextWithDiffSize(
                couponDO.slabs[1]?.otcPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[1]?.otcMax.toString() + ")",holder.tv_InstantCash2)
        }
        else if(couponDO.slabs.size == 1){
            holder.tv_PurchaseAmount1.visibility = View.VISIBLE
            holder.tv_PurchaseAmount2.visibility = View.GONE
            holder.tv_PurchaseAmount3.visibility = View.GONE
            holder.tv_BonusAmount1.visibility = View.VISIBLE
            holder.tv_BonusAmount2.visibility = View.GONE
            holder.tv_BonusAmount3.visibility = View.GONE
            holder.tv_InstantCash1.visibility = View.VISIBLE
            holder.tv_InstantCash2.visibility = View.GONE
            holder.tv_InstantCash3.visibility = View.GONE

            holder.tv_PurchaseAmount1.text = "<"+ couponDO.slabs[0]?.min.toString()
            getTextWithDiffSize(
                couponDO.slabs[0]?.wageredPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[0]?.wageredMax.toString() + ")",holder.tv_BonusAmount1)
            getTextWithDiffSize(
                couponDO.slabs[0]?.otcPercent.toString() + "%",
                "(Max." +mcontext?.getString(R.string.Rs)+ couponDO.slabs[0]?.otcMax.toString() + ")",holder.tv_InstantCash1)
        }

    }

    fun getBonusValColorText(couponDO: CouponDO): SpannableStringBuilder {
        val builder = SpannableStringBuilder()

        val forEvery = mcontext?.getString(R.string.for_every)+" "
        val redSpannable = SpannableString(forEvery)
        redSpannable.setSpan(ForegroundColorSpan(Color.WHITE), 0, forEvery.length, 0)
        builder.append(redSpannable)

        val white = mcontext?.getString(R.string.Rs)+""+ couponDO.wagerToReleaseRatioNumerator +" "
        val whiteSpannable = SpannableString(white)
        whiteSpannable.setSpan(
            ForegroundColorSpan(getColor(mcontext!!, R.color.yellow_color)),
            0,
            white.length,
            0
        )
        builder.append(whiteSpannable)

        val bet = mcontext.getString(R.string.bet) +" "
        val blueSpannable = SpannableString(bet)
        blueSpannable.setSpan(ForegroundColorSpan(Color.WHITE), 0, bet.length, 0)
        builder.append(blueSpannable)


        val data = mcontext.getString(R.string.Rs) +""+ couponDO.wagerToReleaseRatioDenominator +" "
        val dataSpannable = SpannableString(data)
        dataSpannable.setSpan(
            ForegroundColorSpan(getColor(mcontext, R.color.yellow_color)),
            0,
            data.length,
            0
        )
        builder.append(dataSpannable)

        val finalValue = mcontext.getString(R.string.will_be_released) +" "
        val finalValueSpannable = SpannableString(finalValue)
        finalValueSpannable.setSpan(ForegroundColorSpan(Color.WHITE), 0, finalValue.length, 0)
        builder.append(finalValueSpannable)

        return builder
    }

    fun getBonusExpiryColorText(couponDO: CouponDO): SpannableStringBuilder{
        val builder = SpannableStringBuilder()

        val red = mcontext!!.getString(R.string.bonus_expiry) + " "
        val redSpannable = SpannableString(red)
        redSpannable.setSpan(
            ForegroundColorSpan(getColor(mcontext, R.color.light_white)),
            0,
            red.length,
            0
        )
        builder.append(redSpannable)

        val white = couponDO.wagerBonusExpiry.toString() + " " +mcontext.getString(R.string.days) +"\n"
        val whiteSpannable = SpannableString(white)
        whiteSpannable.setSpan(
            ForegroundColorSpan(getColor(mcontext, R.color.yellow_color)),
            0,
            white.length,
            0
        )
        builder.append(whiteSpannable)

        val blue = mcontext.getString(R.string.from_the_issue)
        val blueSpannable = SpannableString(blue)
        blueSpannable.setSpan(
            ForegroundColorSpan(getColor(mcontext, R.color.light_white)),
            0,
            blue.length,
            0
        )
        builder.append(blueSpannable)

        return  builder
    }

    fun getTextWithDiffSize(str1: String,str2: String,tv_View: TextView){
        val textSize1: Int = mcontext?.resources!!.getDimensionPixelSize(R.dimen.text_size_small_medium)
        val textSize2: Int = mcontext.resources!!.getDimensionPixelSize(R.dimen.text_size_small)

        val span1 = SpannableString(str1)
        span1.setSpan(AbsoluteSizeSpan(textSize1), 0, str1.length, SPAN_INCLUSIVE_INCLUSIVE)

        val span2 = SpannableString(str2)
        span2.setSpan(AbsoluteSizeSpan(textSize2), 0, str2.length, SPAN_INCLUSIVE_INCLUSIVE)

        tv_View.text =  TextUtils.concat(span1, " ", span2)
    }

    override fun getItemCount(): Int {
        return lsCouponsData?.size ?: 0
    }

    fun addCoupons(lsCoupon: List<CouponDO>?) {
        this.lsCouponsData?.addAll(lsCoupon!!)
        notifyDataSetChanged()
    }

    class CouponsHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tv_RibbonMessage: TextView = view.findViewById(R.id.textView)
        val tv_CouponCode: TextView = view.findViewById(R.id.textView2)
        val tv_GetUpto: TextView = view.findViewById(R.id.textView3)
        val tv_ValidTill: TextView = view.findViewById(R.id.textView4)
        val tv_MinDeposit: TextView = view.findViewById(R.id.textView7)
        val tv_BonusVal: TextView = view.findViewById(R.id.textView21)
        val tv_BonusExp: TextView = view.findViewById(R.id.textView22)

        val tv_PurchaseAmount1: TextView = view.findViewById(R.id.textView12)
        val tv_BonusAmount1: TextView = view.findViewById(R.id.textView13)
        val tv_InstantCash1: TextView = view.findViewById(R.id.textView14)
        val tv_PurchaseAmount2: TextView = view.findViewById(R.id.textView15)
        val tv_BonusAmount2: TextView = view.findViewById(R.id.textView16)
        val tv_InstantCash2: TextView = view.findViewById(R.id.textView17)
        val tv_PurchaseAmount3: TextView = view.findViewById(R.id.textView18)
        val tv_BonusAmount3: TextView = view.findViewById(R.id.textView19)
        val tv_InstantCash3: TextView = view.findViewById(R.id.textView20)
    }

}