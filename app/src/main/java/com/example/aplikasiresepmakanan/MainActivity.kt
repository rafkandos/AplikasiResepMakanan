package com.example.aplikasiresepmakanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMenuFragment()
    }

    private fun gantiFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)

        transaction.commit()
    }

    fun showMenuFragment() {
        gantiFragment(supportFragmentManager, MenuFragment.newInstance(), R.id.contentFrame)
    }

    fun showResepFragment() {
        gantiFragment(supportFragmentManager, ResepFragment.newInstance(), R.id.contentFrame)
    }

    fun showAboutMeFragment() {
        gantiFragment(supportFragmentManager, AboutMeFragment.newInstance(), R.id.contentFrame)
    }

    fun showAddResepFragment() {
        gantiFragment(supportFragmentManager, AddResepFragment.newInstance(), R.id.contentFrame)
    }

    fun tampilToast(message: String) {
        Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()
    }

}