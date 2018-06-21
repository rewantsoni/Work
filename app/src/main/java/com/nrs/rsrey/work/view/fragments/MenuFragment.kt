package com.nrs.rsrey.work.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nrs.rsrey.work.R
import kotlinx.android.synthetic.main.fragment_menu.*


class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val navHostFragment: NavHostFragment? = fragmentManager?.findFragmentById(R.id.menuNavHost) as NavHostFragment
//        menuBottomNav.let {
//            NavigationUI.setupWithNavController(it, navHostFragment!!.navController)
//        }
        initialize()
    }

    private fun initialize() {
        disableBottomNavShifting()
        menuBottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menuBottomHome -> {
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuBottomRadio -> {
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuBottomBrowse -> {
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menuBottomMyMusic -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }


    private fun disableBottomNavShifting() {
        //TODO
    }

}
