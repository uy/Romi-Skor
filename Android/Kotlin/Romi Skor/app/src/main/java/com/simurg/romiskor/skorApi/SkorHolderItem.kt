package com.simurg.romiskor.skorApi

/**
* Created by uyegen on 18.01.2018.
*/

class SkorHolderItem(i: Int) {
    var index = 0
    var oyuncuPuan1 = 0
    var oyuncuPuan2 = 0
    var oyuncuPuan3 = 0
    var oyuncuPuan4 = 0

    init {
        this.index = i
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