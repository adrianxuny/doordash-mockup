package adrian.doordash.interview.restaurants.view

import adrian.doordash.interview.restaurants.R
import adrian.doordash.interview.restaurants.model.Restaurant
import adrian.doordash.interview.restaurants.utils.ImageLoader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import butterknife.BindView
import butterknife.ButterKnife

/**
 * Created by Adrian on 2019-05-18.
 */
class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.restaurant_image)
        lateinit var image: ImageView
        @BindView(R.id.restaurant_name)
        lateinit var name: TextView
        @BindView(R.id.restaurant_desc)
        lateinit var desc: TextView
        @BindView(R.id.restaurant_status)
        lateinit var status: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(restaurant: Restaurant) {
            name.text = restaurant.name
            desc.text = restaurant.description
            status.text = restaurant.status
            ImageLoader.loadImage(restaurant.coverImgUrl, image)
        }

    }

}

private class DiffCallback : DiffUtil.ItemCallback<Restaurant>() {

    override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
        return oldItem == newItem
    }

}

