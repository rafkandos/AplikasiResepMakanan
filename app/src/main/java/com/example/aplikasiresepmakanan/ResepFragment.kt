package com.example.aplikasiresepmakanan

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_resep.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [ResepFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResepFragment : Fragment(), RecyclerViewClickListener {

    companion object {
        fun newInstance(): ResepFragment {
            return ResepFragment()
        }
    }

    private var listResep: List<Resep>? = arrayListOf()
    private lateinit var adapter: ResepAdapter

    private var db: AppDatabase? = null
    private var resepDao: ResepDao? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_resep, container, false)
        val fabAddResep =
            rootView.findViewById<FloatingActionButton>(R.id.fabAddResep) // Use the current view
        fabAddResep.setOnClickListener() {
            (activity as MainActivity).showAddResepFragment()
        }

        initLocalDB()
        getDataResep()

        return rootView;
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        resepDao = db?.resepDao()
    }

    private fun getDataResep() {
        listResep = ArrayList()
        resepDao?.getAllResep()?.observe(viewLifecycleOwner, { r ->
            listResep = r

            when (listResep?.size) {
                0 -> tv_no_data.visibility = View.VISIBLE
                else -> tv_no_data.visibility = View.GONE
            }
            showResep()
        })
    }

    private fun showResep() {
        listReseps.layoutManager = LinearLayoutManager(activity)
        adapter = ResepAdapter(
            requireActivity(),
            listResep!! as ArrayList<Resep>,
            this
        )
        listReseps.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onItemClicked(view: View, resep: Resep) {
        val intent = Intent(context, DetailResepActivity::class.java)
        intent.putExtra("extra_resep", resep)
        startActivity(intent)
    }

    override fun onDeleteItem(view: View, resep: Resep) {
        GlobalScope.launch {
            resepDao?.deleteAddress(resep)
        }
        getDataResep()
    }
}