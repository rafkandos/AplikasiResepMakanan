package com.example.aplikasiresepmakanan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplikasiresepmakanan.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_card_resep.*
import kotlinx.android.synthetic.main.fragment_card_resep.view.*
import kotlinx.android.synthetic.main.fragment_resep.*

/**
 * A simple [Fragment] subclass.
 * Use the [ResepFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResepFragment : Fragment() {

    companion object {
        fun newInstance(): ResepFragment {
            return ResepFragment()
        }
    }

    private var listResep : List<Resep>? = null

    private var db: AppDatabase? = null
    private var resepDao: ResepDao? = null


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

        initLocalDB()
        getDataResep()

        return  rootView;
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        resepDao = db?.resepDao()
    }

    private fun getDataResep() {

        listResep = ArrayList()
        resepDao?.getAllResep()?.observe(viewLifecycleOwner, Observer { r ->

            listResep = r

            when {
                listResep?.size == 0 -> tampilToast("Belum ada data teman")

                else -> {
                    showResep()
                }
            }
        })
    }

    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

    private fun showResep() {
        listReseps.layoutManager = LinearLayoutManager(activity)
        listReseps.adapter = ResepAdapter(requireActivity(),
            listResep!! as ArrayList<Resep>
        )
    }
}