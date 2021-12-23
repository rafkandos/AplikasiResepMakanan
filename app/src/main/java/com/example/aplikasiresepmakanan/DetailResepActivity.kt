package com.example.aplikasiresepmakanan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_resep.*

class DetailResepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_resep)

        val item = intent.getParcelableExtra<Resep>("extra_resep")
        tv_nama.text = item?.nama
        tv_bahan.text = item?.alatBahan
        tv_cara.text = item?.caraMemasak
    }
}