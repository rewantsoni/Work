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

package com.nrs.rsrey.work.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.transaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nrs.rsrey.work.R
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuFragment : Fragment() {

    private val TAGS: Array<String> = arrayOf("HOME", "RADIO", "BROWSE", "MY_MUSIC")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        swapFragment(HomeFragment(), TAGS[0])
    }

    private fun initialize() {
        menuBottomNav.disableShiftMode()
        menuBottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuBottomHome -> {
                    swapFragment(HomeFragment(), TAGS[0])
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuBottomRadio -> {
                    swapFragment(RadioFragment(), TAGS[1])
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuBottomBrowse -> {
                    swapFragment(BrowseFragment(), TAGS[2])
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuBottomMyMusic -> {
                    swapFragment(MyMusicFragment(), TAGS[3])
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }


    private fun swapFragment(fragment: Fragment, tag: String) {
        if (fragmentManager?.findFragmentByTag(tag) == null)
            fragmentManager?.transaction(allowStateLoss = true) {
                setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out)
                replace(R.id.menuContainer, fragment, tag)
            }

    }

    //TODO
    private fun BottomNavigationView.disableShiftMode() {
    }

}
