package adrian.doordash.interview.restaurants.model


import com.google.gson.annotations.SerializedName

data class MerchantPromotion(
    @SerializedName("delivery_fee")
    val deliveryFee: Any?,
    @SerializedName("delivery_fee_monetary_fields")
    val deliveryFeeMonetaryFields: DeliveryFeeMonetaryFields,
    @SerializedName("id")
    val id: Int,
    @SerializedName("minimum_subtotal")
    val minimumSubtotal: Any?,
    @SerializedName("minimum_subtotal_monetary_fields")
    val minimumSubtotalMonetaryFields: MinimumSubtotalMonetaryFields,
    @SerializedName("new_store_customers_only")
    val newStoreCustomersOnly: Boolean
)