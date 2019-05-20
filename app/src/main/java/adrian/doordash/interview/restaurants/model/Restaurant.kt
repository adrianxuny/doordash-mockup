package adrian.doordash.interview.restaurants.model


import com.google.gson.annotations.SerializedName

data class Restaurant(
    @SerializedName("address")
    val address: Address,
    @SerializedName("asap_time")
    val asapTime: Any?,
    @SerializedName("average_rating")
    val averageRating: Double,
    @SerializedName("business")
    val business: Business,
    @SerializedName("business_id")
    val businessId: Int,
    @SerializedName("composite_score")
    val compositeScore: Int,
    @SerializedName("cover_img_url")
    val coverImgUrl: String,
    @SerializedName("delivery_fee")
    val deliveryFee: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("extra_sos_delivery_fee")
    val extraSosDeliveryFee: Int,
    @SerializedName("featured_category_description")
    val featuredCategoryDescription: Any?,
    @SerializedName("header_img_url")
    val headerImgUrl: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_newly_added")
    val isNewlyAdded: Boolean,
    @SerializedName("is_only_catering")
    val isOnlyCatering: Boolean,
    @SerializedName("is_time_surging")
    val isTimeSurging: Boolean,
    @SerializedName("max_composite_score")
    val maxCompositeScore: Int,
    @SerializedName("max_order_size")
    val maxOrderSize: Int,
    @SerializedName("menus")
    val menus: List<Menu>,
    @SerializedName("merchant_promotions")
    val merchantPromotions: List<MerchantPromotion>,
    @SerializedName("name")
    val name: String,
    @SerializedName("number_of_ratings")
    val numberOfRatings: Int,
    @SerializedName("price_range")
    val priceRange: Int,
    @SerializedName("promotion")
    val promotion: Any?,
    @SerializedName("service_rate")
    val serviceRate: Double,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("status_type")
    val statusType: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("yelp_rating")
    val yelpRating: Double,
    @SerializedName("yelp_review_count")
    val yelpReviewCount: Int
)