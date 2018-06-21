package com.nrs.rsrey.work.view

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.toast
import androidx.navigation.findNavController
import com.nrs.rsrey.work.BuildConfig
import com.nrs.rsrey.work.MyApplication
import com.nrs.rsrey.work.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize(){
        setSupportActionBar(mainToolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24px)
        }
    }

    override fun onSupportNavigateUp() = findNavController(R.id.mainNavHost).navigateUp()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> { mainDrawer.openDrawer(Gravity.START)
                return true
            }
            R.id.menuMainSearch -> { this.toast("Search")
                return true
            }
            R.id.menuMainNotification -> { this.toast("Notification")
                return true
            }
            R.id.menuMainSettings -> { this.toast("Settings")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (BuildConfig.DEBUG) {
            val refWatcher = MyApplication.getRefWatcher(this)
            refWatcher?.watch(this)
        }
    }
}
