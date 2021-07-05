package pmf.unsa.imunizacija

import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_main.*
import androidx.databinding.DataBindingUtil
import pmf.unsa.imunizacija.databinding.ActivityMainBinding

const val KEY_TIMER_SECONDS = "timer_seconds_key"

class MainActivity : AppCompatActivity() {

    private lateinit var registeredUsers : RegisteredUsers
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(toolbar)

        drawerLayout = binding.drawerLayout
        val navView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_question, R.id.nav_about_apk
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.title = ""


        // Setup registeredUsers, passing in the lifecycle
        registeredUsers = RegisteredUsers(this.lifecycle)


        if (savedInstanceState != null) {
            registeredUsers.counter = savedInstanceState.getInt(KEY_TIMER_SECONDS, 0)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_TIMER_SECONDS, registeredUsers.counter)
    }
}