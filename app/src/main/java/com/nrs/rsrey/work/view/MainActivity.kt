/*
 *     Credit Card Security V1  Copyright (C) 2018  sid-sun
 *     This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
 *     This is free software, and you are welcome to redistribute it
 *     under certain conditions; type `show c' for details.
 *
 * The hypothetical commands `show w' and `show c' should show the appropriate
 * parts of the General Public License.  Of course, your program's commands
 * might be different; for a GUI interface, you would use an "about box".
 *
 *   You should also get your employer (if you work as a programmer) or school,
 * if any, to sign a "copyright disclaimer" for the program, if necessary.
 * For more information on this, and how to apply and follow the GNU GPL, see
 * <http://www.gnu.org/licenses/>.
 *
 *   The GNU General Public License does not permit incorporating your program
 * into proprietary programs.  If your program is a subroutine library, you
 * may consider it more useful to permit linking proprietary applications with
 * the library.  If this is what you want to do, use the GNU Lesser General
 * Public License instead of this License.  But first, please read
 * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
 */

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

    private fun initialize() {
        setSupportActionBar(mainToolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24px)
        }
        mainNavView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navDrawerHome -> {
                    mainDrawer.closeDrawer(Gravity.START)
                    return@setNavigationItemSelectedListener true
                }
                R.id.navDrawerPeople -> {
                    mainDrawer.closeDrawer(Gravity.START)
                    return@setNavigationItemSelectedListener true
                }
                R.id.navDrawerPhone -> {
                    mainDrawer.closeDrawer(Gravity.START)
                    return@setNavigationItemSelectedListener true
                }
                R.id.navDrawerActivatePro -> {
                    mainDrawer.closeDrawer(Gravity.START)
                    return@setNavigationItemSelectedListener true
                }
                R.id.navDrawerLanguages -> {
                    mainDrawer.closeDrawer(Gravity.START)
                    return@setNavigationItemSelectedListener true
                }
                R.id.navDrawerSettings -> {
                    mainDrawer.closeDrawer(Gravity.START)
                    return@setNavigationItemSelectedListener true
                }
                else -> return@setNavigationItemSelectedListener true
            }
        }
    }

    override fun onSupportNavigateUp() = findNavController(R.id.mainNavHost).navigateUp()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                mainDrawer.openDrawer(Gravity.START)
                return true
            }
            R.id.menuMainSearch -> {
                this.toast("Search")
                return true
            }
            R.id.menuMainNotification -> {
                this.toast("Notification")
                return true
            }
            R.id.menuMainSettings -> {
                this.toast("Settings")
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
