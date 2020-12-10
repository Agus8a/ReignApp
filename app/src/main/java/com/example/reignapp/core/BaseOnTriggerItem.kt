package com.example.reignapp.core

interface BaseOnTriggerItem<T> {
    fun onSelectItem(item: T)
    fun onDeleteItem(listItems: MutableList<T>, itemPosition: Int)
}