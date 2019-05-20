package adrian.doordash.interview.restaurants.view

import adrian.doordash.interview.restaurants.R
import adrian.doordash.interview.restaurants.viewmodel.RestaurantListViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

/**
 * Created by Adrian on 2019-05-18.
 */
class RestaurantListFragment : Fragment() {

    companion object {
        const val TAG = "RestaurantListFragment"
    }

    @BindView(R.id.recycler_view)
    lateinit var recyclerView: RecyclerView
    @BindView(R.id.progress_bar)
    lateinit var progressBar: ProgressBar

    private lateinit var viewModel: RestaurantListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_restaurant_list, container, false)
        ButterKnife.bind(this, view)

        viewModel = ViewModelProviders.of(this).get(RestaurantListViewModel::class.java)

        configureView()
        return view
    }

    private fun configureView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = RestaurantAdapter()
        recyclerView.adapter = adapter
        subscribeUi(adapter)
    }

    private fun subscribeUi(adapter: RestaurantAdapter) {
        viewModel.getRestaurants().observe(this, Observer { restaurants ->
            adapter.submitList(restaurants)
        })
        viewModel.getShowProgressBar().observe(this, Observer { showProgressBar ->
            if (showProgressBar) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        })
    }

    fun refreshRestaurantList() {
        viewModel.refreshRestaurantList()
    }

}
