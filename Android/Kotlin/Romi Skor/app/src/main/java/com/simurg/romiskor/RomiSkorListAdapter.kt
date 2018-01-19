package com.simurg.romiskor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.TextView
import com.simurg.romiskor.skorApi.OyuncuIndex
import com.simurg.romiskor.skorApi.SkorHolderMain

/**
* Created by uyegen on 11.01.2018.
*/

class RomiSkorListAdapter(context: Context, private var list: Array<String>,
                          private var listData: SkorHolderMain): BaseAdapter() {
    private var layoutInflater = LayoutInflater.from(context)

    private class ListRowHolder(row: View) {
        val oyunAdi = row.findViewById<TextView>(R.id.oyunAdi)!!
        val oyuncuPuan1 = row.findViewById<EditText>(R.id.oyuncuPuan1)!!
        val oyuncuPuan2 = row.findViewById<EditText>(R.id.oyuncuPuan2)!!
        val oyuncuPuan3 = row.findViewById<EditText>(R.id.oyuncuPuan3)!!
        val oyuncuPuan4 = row.findViewById<EditText>(R.id.oyuncuPuan4)!!
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ListRowHolder

        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.game_row_cell, null)
            viewHolder = ListRowHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ListRowHolder
        }

        viewHolder.oyunAdi.text = this.list[position]

        // 1. oyuncu işlemleri
        viewHolder.oyuncuPuan1.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O1).toString())
        viewHolder.oyuncuPuan1.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O1, viewHolder.oyuncuPuan1)
            } else {
                ifPossibleClearText(viewHolder.oyuncuPuan1)
            }
        }

        // 2. oyuncu işlemleri
        viewHolder.oyuncuPuan2.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O2).toString())
        viewHolder.oyuncuPuan2.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O2, viewHolder.oyuncuPuan2)
            } else {
                ifPossibleClearText(viewHolder.oyuncuPuan2)
            }
        }

        // 3. oyuncu işlemleri
        viewHolder.oyuncuPuan3.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O3).toString())
        viewHolder.oyuncuPuan3.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O3, viewHolder.oyuncuPuan3)
            } else {
                ifPossibleClearText(viewHolder.oyuncuPuan3)
            }
        }

        // 4. oyuncu işlemleri
        viewHolder.oyuncuPuan4.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O4).toString())
        viewHolder.oyuncuPuan4.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O4, viewHolder.oyuncuPuan4)
            } else {
                ifPossibleClearText(viewHolder.oyuncuPuan4)
            }
        }

        return  view
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

    private fun ifPossibleClearText(obj: EditText) {
        if (obj.text.toString() == "0") {
            obj.setText("")
        }
    }

    private fun ifPossibleSetText(position: Int, oyuncuIndex: OyuncuIndex, obj: EditText) {
        if (obj.text.toString() == "") {
            this.listData.getRowData(position).setPuan(oyuncuIndex, 0)
        } else {
            this.listData.getRowData(position).setPuan(oyuncuIndex, obj.text.toString().toInt())
        }
    }
}