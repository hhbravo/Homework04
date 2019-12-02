package com.hans.homerwok04.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hans.homerwok04.R
import com.hans.homerwok04.listener.ProductListener
import com.hans.homerwok04.model.Product
import java.io.IOException
import java.io.InputStream


class ProductAdapter(val context: Context, val listener: ProductListener) :
    RecyclerView.Adapter<ProductAdapter.Companion.ViewHolder>() {

    private var productList: List<Product> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Product = productList[position]

        val name = item.name
        val price = item.price
        val stock = item.stock
        val image = item.photo


        holder.tvName.text = name
        holder.tvPrice.text = "S/ ".plus("$price")
        holder.tvStock.text = "Stock ".plus("$stock")
 //       holder.tvImage.setImageBitmap(getBitmapFromAssets(image))

        holder.itemView.setOnClickListener{
            listener.onClickProduct(item)
        }

    }


    fun getBitmapFromAssets(fileName: String): Bitmap {
        val assetManager = context.assets

        var istr: InputStream? = null
        try {
            istr = assetManager.open(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return BitmapFactory.decodeStream(istr)//istr will be null
    }

    fun addData(values: List<Product>) {
        productList = values
    }

    companion object {
        class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
            val tvName: TextView = v.findViewById(R.id.tvName)
            val tvPrice: TextView = v.findViewById(R.id.tvPrice)
            val tvStock: TextView = v.findViewById(R.id.tvStock)
            val tvImage: ImageView = v.findViewById(R.id.tvImage)
        }
    }
}