package com.sentenz.controlz

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.sentenz.controlz.fragment.DrawerFragment
import com.sentenz.controlz.fragment.SecondDrawerFragment
import kotlinx.android.synthetic.main.activity_sample_fragment.*

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_fragment)

        // Handle Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.drawer_item_fragment_drawer)

        //ignore the DemoFragment and it's layout it's just to showcase the handle with an keyboard
        if (savedInstanceState == null) {
            val f = DrawerFragment.newInstance("Demo")
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, f).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.fragment_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //handle the click on the back arrow click
        when (item.itemId) {
            R.id.menu_1 -> {
                val f = DrawerFragment.newInstance("Demo")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, f).commit()
                return true
            }
            R.id.menu_2 -> {
                val f2 = SecondDrawerFragment.newInstance("Demo 2")
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, f2).commit()
                return true
            }
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
