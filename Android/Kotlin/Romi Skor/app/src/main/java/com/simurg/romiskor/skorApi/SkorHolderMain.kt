package com.simurg.romiskor.skorApi

/**
* Created by uyegen on 18.01.2018.
*/

class SkorHolderMain(gameList: Array<String>) {
    private var arrGame = arrayListOf<SkorHolderItem>()

    init {
        var i = 0
        for (gameItem in gameList) {
            i += 1
            arrGame.add(SkorHolderItem(1, gameItem))
        }
    }

    fun getRowData(i: Int): SkorHolderItem {
        return this.arrGame[i]
    }

    fun getRowCount(): Int {
        return this.arrGame.size
    }
}