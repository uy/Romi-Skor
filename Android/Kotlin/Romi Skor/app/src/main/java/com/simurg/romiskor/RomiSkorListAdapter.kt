package com.simurg.romiskor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.simurg.romiskor.customObjects.HKEditText
import com.simurg.romiskor.skorApi.OyuncuIndex
import com.simurg.romiskor.skorApi.SkorHolderMain

/**
* Created by uyegen on 11.01.2018.
*/

class RomiSkorListAdapter(context: Context, private var listData: SkorHolderMain): BaseAdapter() {
    private var layoutInflater = LayoutInflater.from(context)

    private class ListRowHolder(row: View) {
        val oyunAdi: TextView = row.findViewById<TextView>(R.id.oyunAdi)
        val oyuncuPuan1: HKEditText = row.findViewById<HKEditText>(R.id.oyuncuPuan1)
        val oyuncuPuan2: HKEditText = row.findViewById<HKEditText>(R.id.oyuncuPuan2)
        val oyuncuPuan3: HKEditText = row.findViewById<HKEditText>(R.id.oyuncuPuan3)
        val oyuncuPuan4: HKEditText = row.findViewById<HKEditText>(R.id.oyuncuPuan4)

        init {
            oyuncuPuan1.tag = OyuncuIndex.O1
            oyuncuPuan2.tag = OyuncuIndex.O2
            oyuncuPuan3.tag = OyuncuIndex.O3
            oyuncuPuan4.tag = OyuncuIndex.O4
        }
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

        viewHolder.oyunAdi.text = this.listData.getRowData(position).getOyunAdi()

        // 1. oyuncu işlemleri
        viewHolder.oyuncuPuan1.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O1).toString())
        viewHolder.oyuncuPuan1.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O1, viewHolder.oyuncuPuan1)
            }
        }

        // 2. oyuncu işlemleri
        viewHolder.oyuncuPuan2.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O2).toString())
        viewHolder.oyuncuPuan2.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O2, viewHolder.oyuncuPuan2)
            }
        }

        // 3. oyuncu işlemleri
        viewHolder.oyuncuPuan3.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O3).toString())
        viewHolder.oyuncuPuan3.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O3, viewHolder.oyuncuPuan3)
            }
        }

        // 4. oyuncu işlemleri
        viewHolder.oyuncuPuan4.setText(this.listData.getRowData(position)
                .getPuan(OyuncuIndex.O4).toString())
        viewHolder.oyuncuPuan4.setOnFocusChangeListener { _, focus ->
            if (!focus) {
                ifPossibleSetText(position, OyuncuIndex.O4, viewHolder.oyuncuPuan4)
            }
        }

        // klavye kapanirken girilmis olan degerlerin tutulmasini saglayacak lambda tanimlamasi
        viewHolder.oyuncuPuan1.setRouteParameter(position, this::ifPossibleSetText)
        viewHolder.oyuncuPuan2.setRouteParameter(position, this::ifPossibleSetText)
        viewHolder.oyuncuPuan3.setRouteParameter(position, this::ifPossibleSetText)
        viewHolder.oyuncuPuan4.setRouteParameter(position, this::ifPossibleSetText)

        return  view
    }

    override fun getItem(p0: Int): String {
        return this.listData.getRowData(p0).getOyunAdi()
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return this.listData.getRowCount()
    }

    private fun ifPossibleSetText(position: Int, oyuncuIndex: OyuncuIndex, obj: HKEditText) {
        if (obj.text.toString() == "") {
            this.listData.getRowData(position).setPuan(oyuncuIndex, 0)
        } else {
            this.listData.getRowData(position).setPuan(oyuncuIndex, obj.text.toString().toInt())
        }
    }
}