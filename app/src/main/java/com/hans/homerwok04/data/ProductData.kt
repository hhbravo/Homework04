package com.hans.homerwok04.data

import com.hans.homerwok04.model.Product


object ProductData {
    fun getProductList(): List<Product> {
        val mList: MutableList<Product> = arrayListOf()
        mList.add(Product("Lapicero", 1.0, 10, "images/Abra.png"))
        mList.add(Product("Borrador", 0.5, 10, "images/Arcanine.png"))
        mList.add(Product("Folders", 1.5, 10, "images/Bulbasaur.png"))
        mList.add(Product("Cuadernos", 2.0, 10, "images/Caterpie.png"))
        mList.add(Product("Tajador", 0.5, 10, "images/Drowzee.png"))
        mList.add(Product("Hojas Bond", 1.5, 10, "images/Exeggcute.png"))
        mList.add(Product("Tajador", 0.5, 10, "images/Golem.png"))
        mList.add(Product("Tajador", 0.5, 10, "images/Lickitung.png"))
        return mList.toList()
    }
}