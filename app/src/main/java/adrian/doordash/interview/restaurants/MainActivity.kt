package adrian.doordash.interview.restaurants

import adrian.doordash.interview.restaurants.view.RestaurantListFragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showRestaurantListFragment()
        }
    }

    private fun showRestaurantListFragment() {
        val fragment = RestaurantListFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, fragment, RestaurantListFragment.TAG).commit()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refresh_button -> {
                refreshRestaurantList()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun refreshRestaurantList() {
        val fragment = supportFragmentManager.findFragmentByTag(RestaurantListFragment.TAG)
        (fragment as RestaurantListFragment).refreshRestaurantList()
    }

}
