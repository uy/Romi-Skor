package com.simurg.romiskor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val oyunListesi = arrayOf("3'lü Küt",
            "3'lü Seri",
            "3'lü Küt 3'lü Seri",
            "4'lü Küt",
            "4'lü Seri",
            "4'lü Küt 3'lü Seri",
            "3'lü Küt 4'lü Seri",
            "4'lü Küt 4'lü Seri",
            "4'lü Küt 4'lü Küt",
            "4'lü Seri 4'lü Seri",
            "5'lü Seri",
            "5'lü Seri 3'lü Küt",
            "5'lü Seri 4'lü Küt",
            "5 Çift",
            "Elden Bitme")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            gameList.adapter = RomiSkorListAdapter(applicationContext, this.oyunListesi)
        }
    }
}
