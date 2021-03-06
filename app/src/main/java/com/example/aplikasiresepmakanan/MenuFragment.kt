package com.example.aplikasiresepmakanan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton


/**
 * A simple [Fragment] subclass.
 * Use the [MenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_menu, container, false)
        val btnResep = rootView.findViewById<ImageButton>(R.id.btnAnekaMenu) // Use the current view
        btnResep.setOnClickListener() {
            (activity as MainActivity).showResepFragment()
        }

        val btnAboutMe = rootView.findViewById<ImageButton>(R.id.btnAboutMe) // Use the current view
        btnAboutMe.setOnClickListener() {
            (activity as MainActivity).showAboutMeFragment()
        }

        val btnAboutApp = rootView.findViewById<ImageButton>(R.id.btnAboutApp) // Use the current view
        btnAboutApp.setOnClickListener() {
            (activity as MainActivity).showAboutAppFragment()
        }
        return rootView
    }

    companion object {
        fun newInstance(): MenuFragment {
            return MenuFragment()
        }
    }
}