package com.ch.ni.an.ordervapeliquid.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val DELIVERY_COST = 5
private const val DELIVERY_TODAY_COST = 10
private const val DELIVERY_PICKUP = -10

class OrderViewModel: ViewModel() {

    private val _item = MutableLiveData<String>()
    val item: LiveData<String>
        get() = _item

    private val _subItem = MutableLiveData<String>()
    val subItem: LiveData<String>
        get() = _subItem

    private val _price = MutableLiveData<Int>()
    val price: LiveData<Int>
        get() = _price

    private val _delivery = MutableLiveData<Int>()
    val delivery: LiveData<Int>
        get() = _delivery

    private val _totalCost = MutableLiveData<Double>()
    val totalCost: LiveData<Double>
        get() = _totalCost

    init {
        resetOrder()
    }



    fun setItem(item: String){
        _item.value = item
        when(item){
            "vape" -> setPrice(30)
            "liquid" -> setPrice(10)
            "accessory" -> setPrice(5)
        }
    }

    fun setSubItem(subItem: String){
        _subItem.value = subItem
        val price = _price.value?: 0
        val currentPrice = when(subItem){
            "High cost" -> price + 25
            "Middle cost" -> price + 15
            else -> price + 5
        }
        setPrice(currentPrice)
    }

    fun setDelivery(delivery: Int){
        val price = _price.value?: 0
        val currentPrice =  when(delivery){
            1 -> price + DELIVERY_PICKUP
            2 -> price + DELIVERY_TODAY_COST
            else -> price + DELIVERY_PICKUP
        }
        _delivery.value = delivery
    }

    fun resetOrder(){
        _item.value = ""
        _subItem.value = ""
        _delivery.value = 0
        _price.value = 0
        _totalCost.value = 0.0
    }

   private fun setPrice(price: Int){
        _price.value = price
    }







}