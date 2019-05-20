package adrian.doordash.interview.restaurants.model


import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_catering")
    val isCatering: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("popular_items")
    val popularItems: List<Any>,
    @SerializedName("subtitle")
    val subtitle: String
)