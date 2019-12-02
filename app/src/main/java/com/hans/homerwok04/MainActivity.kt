package com.hans.homerwok04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hans.homerwok04.listener.ProductListener
import com.hans.homerwok04.model.Product
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductListener {

    private var isTablet = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (linerLayoutTablet != null) {
            isTablet = true
        }
    }

    override fun onClickProduct(item: Product) {

        if (isTablet) {

        } else {
            Log.d("main", item.toString())
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT, item)
            startActivity(intent)
        }
    }
}

private fun Intent.putExtra(extraProduct: String, item: Product) {

}
