package adrian.doordash.interview.restaurants.model


import com.google.gson.annotations.SerializedName

data class MinimumSubtotalMonetaryFields(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("decimal_places")
    val decimalPlaces: Int,
    @SerializedName("display_string")
    val displayString: String,
    @SerializedName("unit_amount")
    val unitAmount: Any?
)