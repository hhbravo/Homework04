package com.hans.homerwok04.listener

import com.hans.homerwok04.model.Product

interface ProductListener {
    fun onClickProduct(item: Product)
}