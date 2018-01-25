package com.simurg.romiskor.customObjects

import android.content.Context
import android.util.AttributeSet
import android.view.KeyEvent
import android.widget.EditText
import com.simurg.romiskor.skorApi.OyuncuIndex

/**
* Created by uyegen on 25.01.2018.
*/

class HKEditText: EditText {
    constructor(context: Context?): super(context)
    constructor(context: Context?, attrs: AttributeSet?): super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr)

    private var position = 0
    private lateinit var oyuncuIndex: OyuncuIndex
    private lateinit var callback: (position: Int, oyuncuIndex: OyuncuIndex, obj: HKEditText) -> Unit

    override fun onKeyPreIme(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_0 || keyCode == KeyEvent.KEYCODE_1
                || keyCode == KeyEvent.KEYCODE_2 || keyCode == KeyEvent.KEYCODE_3
                || keyCode == KeyEvent.KEYCODE_4 || keyCode == KeyEvent.KEYCODE_5
                || keyCode == KeyEvent.KEYCODE_6 || keyCode == KeyEvent.KEYCODE_7
                || keyCode == KeyEvent.KEYCODE_8 || keyCode == KeyEvent.KEYCODE_9
                || keyCode == KeyEvent.KEYCODE_DEL) {
            // ok
        } else {
            callback(this.position, this.oyuncuIndex, this)
        }
        return super.onKeyPreIme(keyCode, event)
    }

    fun setRouteParameter(position: Int, oyuncuIndex: OyuncuIndex, l: (position: Int, oyuncuIndex: OyuncuIndex, obj: HKEditText) -> Unit) {
        this.position = position
        this.oyuncuIndex = oyuncuIndex
        this.callback = l
    }
}