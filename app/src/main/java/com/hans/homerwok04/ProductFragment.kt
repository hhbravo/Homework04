package com.hans.homerwok04


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hans.homerwok04.adapter.ProductAdapter
import com.hans.homerwok04.data.ProductData
import com.hans.homerwok04.listener.ProductListener
import com.hans.homerwok04.model.Product

/**
 * A simple [Fragment] subclass.
 */
class ProductFragment : Fragment(), ProductListener {
    private var mRecyclerView: RecyclerView? = null
    private lateinit var productAdapter: ProductAdapter
    var listener : ProductListener? = null


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as? ProductListener
    }

    override
    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        mRecyclerView = view.findViewById(R.id.mRecyclerView)

        mRecyclerView?.layoutManager = LinearLayoutManager(activity)
        productAdapter = ProductAdapter(this.requireContext(), this)
        mRecyclerView?.adapter = productAdapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        productAdapter.addData(ProductData.getProductList())
    }

    override fun onClickProduct(item: Product) {
        listener?.onClickProduct(item)
    }

}
