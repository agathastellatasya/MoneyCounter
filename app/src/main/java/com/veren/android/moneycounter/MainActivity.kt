package com.veren.android.moneycounter

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var sum : ArrayList<Long> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val localeID : Locale = Locale("in", "ID")
        val format : NumberFormat = NumberFormat.getCurrencyInstance(localeID)

        for (i in 0..9) {
            sum.add(0)
        }

        addListenerEditText(input100k, count100k,0)
        addListenerEditText(input50k, count50k,1)
        addListenerEditText(input20k, count20k,2)
        addListenerEditText(input10k, count10k,3)
        addListenerEditText(input5k, count5k,4)
        addListenerEditText(input2k, count2k,5)
        addListenerEditText(input1k, count1k,6)
        addListenerEditText(input500, count500,7)
        addListenerEditText(input200, count200,8)
        addListenerEditText(input100, count100,9)

        addListenerTextView(input100k)
        addListenerTextView(input50k)
        addListenerTextView(input20k)
        addListenerTextView(input10k)
        addListenerTextView(input5k)
        addListenerTextView(input2k)
        addListenerTextView(input1k)
        addListenerTextView(input500)
        addListenerTextView(input200)
        addListenerTextView(input100)

        clear.setOnClickListener{
            input100k.setText("0")
            input50k.setText("0")
            input20k.setText("0")
            input10k.setText("0")
            input5k.setText("0")
            input2k.setText("0")
            input1k.setText("0")
            input500.setText("0")
            input200.setText("0")
            input100.setText("0")
        }
    }

    fun addListenerEditText(et: EditText, tv: TextView, idx: Int) {
        val localeID : Locale = Locale("in", "ID")
        val format : NumberFormat = NumberFormat.getCurrencyInstance(localeID)

        et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(et.text.toString().compareTo("") != 0){
                    sum.set(idx,et.text.toString().toLong() * valueIdx(idx))
                } else {
                    sum.set(idx,0)
                }
                tv.text = format.format(sum.get(idx)).toString()
            }
        })
    }

    fun addListenerTextView(tv: TextView) {
        tv.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                total.text = sumTotal(sum).toString()
            }

        })
    }

    fun valueIdx(idx : Int) : Int {
        var value = 0
        when (idx) {
            0 -> value = 100000
            1 -> value = 50000
            2 -> value = 20000
            3 -> value = 10000
            4 -> value = 5000
            5 -> value = 2000
            6 -> value = 1000
            7 -> value = 500
            8 -> value = 200
            9 -> value = 100
        }
        return value
    }

    fun sumTotal(arrMoney : ArrayList<Long>) : Long{
        var sumtotal : Long = 0
        for (i in 0..9) {
            sumtotal += arrMoney.get(i)
        }
        return sumtotal
    }
}
