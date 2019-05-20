package adrian.doordash.interview.restaurants.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by Adrian on 2019-05-18.
 */
object ImageLoader {

    fun loadImage(url: String?, imageView: ImageView?) {
        imageView?.let {
            Glide.with(imageView)
                .load(url)
                .centerCrop()
                .into(imageView)
        }
    }

}