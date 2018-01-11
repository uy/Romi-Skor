package com.simurg.romiskor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
* Created by uyegen on 11.01.2018.
*/

class RomiSkorListAdapter(context: Context, list: Array<String>): BaseAdapter() {
    private var layoutInflater = LayoutInflater.from(context)
    private var list = list

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val v = layoutInflater.inflate(R.layout.game_row_cell, null)

        val oyunAdi = v.findViewById<TextView>(R.id.oyunAdi)
        oyunAdi.text = this.list[p0]

        return v
    }

    override fun getItem(p0: Int): String {
        return this.list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return this.list.size
    }

}