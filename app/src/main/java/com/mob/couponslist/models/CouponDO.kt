package com.mob.couponslist.models

import com.google.gson.annotations.SerializedName

data class CouponDO(

	@field:SerializedName("bonus_booster")
	val bonusBooster: Any? = null,

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("_cls")
	val cls: String? = null,

	@field:SerializedName("valid_from")
	val validFrom: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("is_bonus_booster_enabled")
	val isBonusBoosterEnabled: Boolean? = null,

	@field:SerializedName("user_redeem_limit")
	val userRedeemLimit: Int? = null,

	@field:SerializedName("visibility_user_levels")
	val visibilityUserLevels: List<Int?>? = null,

	@field:SerializedName("days_since_last_purchase_min")
	val daysSinceLastPurchaseMin: Int? = null,

	@field:SerializedName("is_deleted")
	val isDeleted: Boolean? = null,

	@field:SerializedName("tab_type")
	val tabType: String? = null,

	@field:SerializedName("user_segmentation_type")
	val userSegmentationType: String? = null,

	@field:SerializedName("eligibility_user_segments")
	val eligibilityUserSegments: List<String?>? = null,

	@field:SerializedName("ribbon_msg")
	val ribbonMsg: String? = null,

	@field:SerializedName("eligibility_user_levels")
	val eligibilityUserLevels: List<Int?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("visibility_user_segments")
	val visibilityUserSegments: List<String?>? = null,

	@field:SerializedName("wager_to_release_ratio_numerator")
	val wagerToReleaseRatioNumerator: Int? = null,

	@field:SerializedName("is_active")
	val isActive: Boolean? = null,

	@field:SerializedName("bonus_image_back")
	val bonusImageBack: String? = null,

	@field:SerializedName("user_limit")
	val userLimit: Int? = null,

	@field:SerializedName("tags")
	val tags: Tags? = null,

	@field:SerializedName("valid_until")
	val validUntil: String? = null,

	@field:SerializedName("bonus_image_front")
	val bonusImageFront: String? = null,

	@field:SerializedName("last_updated_at")
	val lastUpdatedAt: String? = null,

	@field:SerializedName("wager_bonus_expiry")
	val wagerBonusExpiry: Int? = null,

	@field:SerializedName("campaign")
	val campaign: String? = null,

	@field:SerializedName("wager_to_release_ratio_denominator")
	val wagerToReleaseRatioDenominator: Int? = null,

	@field:SerializedName("slabs")
	val slabs: List<SlabsItem?>? = null
)

data class Tags(
	val any: Any? = null
)

data class SlabsItem(

	@field:SerializedName("min")
	val min: Double? = null,

	@field:SerializedName("max")
	val max: Double? = null,

	@field:SerializedName("wagered_percent")
	val wageredPercent: Double? = null,

	@field:SerializedName("otc_max")
	val otcMax: Double? = null,

	@field:SerializedName("num")
	val num: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("otc_percent")
	val otcPercent: Double? = null,

	@field:SerializedName("wagered_max")
	val wageredMax: Double? = null
)
