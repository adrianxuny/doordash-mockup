package adrian.doordash.interview.restaurants.model


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("printable_address")
    val printableAddress: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street")
    val street: String
)