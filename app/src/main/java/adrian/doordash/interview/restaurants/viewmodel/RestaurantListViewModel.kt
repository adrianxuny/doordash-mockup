package adrian.doordash.interview.restaurants.viewmodel

import adrian.doordash.interview.restaurants.Constants
import adrian.doordash.interview.restaurants.api.RestaurantListService
import adrian.doordash.interview.restaurants.model.Restaurant
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Adrian on 2019-05-18.
 */
class RestaurantListViewModel : ViewModel() {

    private val restaurants = MutableLiveData<List<Restaurant>>()

    private val showProgressBar = MutableLiveData<Boolean>()

    init {
        loadRestaurants()
    }

    fun getRestaurants(): LiveData<List<Restaurant>> {
        return restaurants
    }

    fun getShowProgressBar(): LiveData<Boolean> {
        return showProgressBar
    }

    fun refreshRestaurantList() {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        showProgressBar.postValue(true)
        val call = RestaurantListService.create()
            .getRestaurantList(
                Constants.DOORDASH_HQ_LOCATION_LAT,
                Constants.DOORDASH_HQ_LOCATION_LNG,
                Constants.RESTAURANT_LIST_REQUEST_OFFSET_DEFAULT,
                Constants.RESTAURANT_LIST_REQUEST_LIMIT_DEFAULT
            )
        call.enqueue(object : Callback<List<Restaurant>> {
            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                // TODO - UI to inform user load has failed, retry
                showProgressBar.postValue(false)
            }

            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                val body = response.body()
                showProgressBar.postValue(false)
                if (body != null) {
                    restaurants.postValue(body)
                }
            }
        })
    }

}