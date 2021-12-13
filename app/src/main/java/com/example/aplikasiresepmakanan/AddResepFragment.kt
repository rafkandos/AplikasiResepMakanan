package com.example.aplikasiresepmakanan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_add_resep.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [AddResepFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddResepFragment : Fragment() {

    private var namaResep : String = ""
    private var alatBahan : String = ""
    private var caraMemasak : String = ""

    private var db: AppDatabase? = null
    private var resepDao: ResepDao? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_add_resep, container, false)
        val saveResep = rootView.findViewById<Button>(R.id.btnSimpan) // Use the current view
        saveResep.setOnClickListener() { validasiInput() }

        initLocalDB()

        return rootView
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        resepDao = db?.resepDao()
    }

    private fun validasiInput() {
        namaResep = inputNamaResep.text.toString()
        alatBahan = inputAlatBahan.text.toString()
        caraMemasak = inputCaraMemasak.text.toString()

        when{
            namaResep.isEmpty() -> inputNamaResep.error = "Nama Resep tidak boleh kosong"
            alatBahan.isEmpty() -> inputAlatBahan.error = "Alat dan Bahan tidak boleh kosong"
            caraMemasak.isEmpty() -> inputCaraMemasak.error = "Cara Memasak tidak boleh kosong"

            else -> {

                val res = Resep(nama = namaResep, alatBahan = alatBahan, caraMemasak = caraMemasak)
                addDataResep(res)

            }
        }

    }

    private fun addDataResep(resep: Resep) : Job {

        return GlobalScope.launch {
            resepDao?.addResep(resep)
            (activity as MainActivity).showResepFragment()
        }

    }

    companion object {
        fun newInstance(): AddResepFragment {
            return AddResepFragment()
        }
    }
}