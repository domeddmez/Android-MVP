package com.dome.mvp

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.dome.mvp.Page1.Page1Fragment
import com.dome.mvp.Page2.Page2Fragment
import com.dome.mvp.Utils.Utils
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : BaseActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_1 -> {
                replaceFragment(Page1Fragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_2 -> {
                replaceFragment(Page2Fragment())
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Utils.StringToInt("1")
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(Page1Fragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragment)
        transaction.commit()
    }
}
