package com.simurg.romiskor.skorApi

/**
* Created by uyegen on 18.01.2018.
*/

class SkorHolderItem(i: Int, o: String) {
    private var index = 0
    private var oyunAdi = ""
    private var oyuncuPuan1 = 0
    private var oyuncuPuan2 = 0
    private var oyuncuPuan3 = 0
    private var oyuncuPuan4 = 0

    init {
        this.index = i
        this.oyunAdi = o
    }

    fun getOyunAdi(): String {
        return this.oyunAdi
    }

    fun setPuan(oyuncu: OyuncuIndex, puan: Int) {
        when(oyuncu) {
            OyuncuIndex.O1 -> oyuncuPuan1 = puan
            OyuncuIndex.O2 -> oyuncuPuan2 = puan
            OyuncuIndex.O3 -> oyuncuPuan3 = puan
            OyuncuIndex.O4 -> oyuncuPuan4 = puan
        }
    }

    fun getPuan(oyuncu: OyuncuIndex): Int {
        return when(oyuncu) {
            OyuncuIndex.O1 -> oyuncuPuan1
            OyuncuIndex.O2 -> oyuncuPuan2
            OyuncuIndex.O3 -> oyuncuPuan3
            OyuncuIndex.O4 -> oyuncuPuan4
        }
    }
}