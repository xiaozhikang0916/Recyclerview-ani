package site.xiaozk.demo.rv_ani

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import site.xiaozk.demo.rv_ani.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        binding.toolBar.setupWithNavController(navController, appBarConfiguration)

        binding.navView.setNavigationItemSelectedListener {
            it.onNavDestinationSelected(navController)
        }

        binding.drawerLayout.showContextMenu()
    }

    override fun onBackPressed() {
        if (binding.navView.isShown) {
            binding.drawerLayout.close()
        } else {
            super.onBackPressed()
        }
    }
}