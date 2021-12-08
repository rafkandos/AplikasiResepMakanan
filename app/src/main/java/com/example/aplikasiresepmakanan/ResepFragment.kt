package com.example.aplikasiresepmakanan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 * Use the [ResepFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_resep, container, false)
        val fabAddResep = rootView.findViewById<FloatingActionButton>(R.id.fabAddResep) // Use the current view
        fabAddResep.setOnClickListener() {
            (activity as MainActivity).showAddResepFragment()
        }

        return  rootView;
    }

    companion object {
        fun newInstance(): ResepFragment {
            return ResepFragment()
        }
    }
}