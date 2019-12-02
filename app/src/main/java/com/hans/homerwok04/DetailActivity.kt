package com.hans.homerwok04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hans.homerwok04.model.Product

const val EXTRA_PRODUCT = "extra.product"

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailFragment = DetailFragment()

        val item = intent.getSerializableExtra(EXTRA_PRODUCT) as? Product

        supportFragmentManager.beginTransaction().apply {
            add(R.id.detailProduct, detailFragment)
        }.commit()

    }
}
