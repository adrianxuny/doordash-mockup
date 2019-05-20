package adrian.doordash.interview.restaurants.api

import adrian.doordash.interview.restaurants.Constants
import adrian.doordash.interview.restaurants.model.Restaurant
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by Adrian on 2019-05-18.
 */

interface RestaurantListService {

    companion object {

        fun create(): RestaurantListService {
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RestaurantListService::class.java)
        }

    }

    @GET("restaurant/")
    fun getRestaurantList(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<List<Restaurant>>

}