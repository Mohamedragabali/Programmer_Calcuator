package com.mohamedragab.developercalculater

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var resetBt: Button
    lateinit var hexShow: TextView
    lateinit var octShow: TextView
    lateinit var binShow: TextView
    lateinit var decShow: TextView
    lateinit var charA: Button
    lateinit var charB: Button
    lateinit var charC: Button
    lateinit var charD: Button
    lateinit var charE: Button
    lateinit var charF: Button
    lateinit var zero: Button
    lateinit var one: Button
    lateinit var tow: Button
    lateinit var three: Button
    lateinit var four: Button
    lateinit var five: Button
    lateinit var six: Button
    lateinit var siven: Button
    lateinit var eight: Button
    lateinit var nine: Button
    var whereWrite: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resetBt = findViewById(R.id.Reset)
        hexShow = findViewById(R.id.hexShow)
        octShow = findViewById(R.id.octShow)
        binShow = findViewById(R.id.binShow)
        decShow = findViewById(R.id.decShow)
        charA = findViewById(R.id.charA)
        charB = findViewById(R.id.charB)
        charC = findViewById(R.id.charC)
        charD = findViewById(R.id.charD)
        charE = findViewById(R.id.charE)
        charF = findViewById(R.id.charF)
        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        tow = findViewById(R.id.tow)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        siven = findViewById(R.id.siven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)

        resetBt.setOnClickListener {
            reset()
        }

        //hexShow.setTextColor(R.color.white);
        hexShow.setOnClickListener {
            reset()
            whereWrite = hexShow
            hexShow.setText("")
            hexShow.setBackgroundResource(R.drawable.circle_textview_selected)
            octShow.setBackgroundResource(R.drawable.circle_textview)
            binShow.setBackgroundResource(R.drawable.circle_textview)
            decShow.setBackgroundResource(R.drawable.circle_textview)
        }
        octShow.setOnClickListener {
            reset()
            whereWrite = octShow
            octShow.setText("")
            hexShow.setBackgroundResource(R.drawable.circle_textview)
            octShow.setBackgroundResource(R.drawable.circle_textview_selected)
            binShow.setBackgroundResource(R.drawable.circle_textview)
            decShow.setBackgroundResource(R.drawable.circle_textview)
        }
        binShow.setOnClickListener {
            reset()
            whereWrite = binShow
            binShow.setText("")
            hexShow.setBackgroundResource(R.drawable.circle_textview)
            octShow.setBackgroundResource(R.drawable.circle_textview)
            binShow.setBackgroundResource(R.drawable.circle_textview_selected)
            decShow.setBackgroundResource(R.drawable.circle_textview)
        }
        decShow.setOnClickListener {
            reset()
            whereWrite = decShow
            decShow.setText("")
            hexShow.setBackgroundResource(R.drawable.circle_textview)
            octShow.setBackgroundResource(R.drawable.circle_textview)
            binShow.setBackgroundResource(R.drawable.circle_textview)
            decShow.setBackgroundResource(R.drawable.circle_textview_selected)
        }

        zero.setOnClickListener {
            writeInTextView("0")
        }
        one.setOnClickListener {
            writeInTextView("1")
        }
        tow.setOnClickListener {
            writeInTextView("2")
        }
        three.setOnClickListener {
            writeInTextView("3")
        }
        four.setOnClickListener {
            writeInTextView("4")
        }
        five.setOnClickListener {
            writeInTextView("5")
        }
        six.setOnClickListener {
            writeInTextView("6")
        }
        siven.setOnClickListener {
            writeInTextView("7")
        }
        eight.setOnClickListener {
            writeInTextView("8")
        }
        nine.setOnClickListener {
            writeInTextView("9")
        }
        charA.setOnClickListener {
            writeInTextView("A")
        }
        charB.setOnClickListener {
            writeInTextView("B")
        }
        charC.setOnClickListener {
            writeInTextView("C")
        }
        charD.setOnClickListener {
            writeInTextView("D")
        }
        charE.setOnClickListener {
            writeInTextView("E")
        }
        charF.setOnClickListener {
            writeInTextView("F")
        }

    }

    fun writeInTextView(num: String) {
        val hex = "HEX: "
        val oct = "OCT: "
        val bin = "BIN: "
        val dec = "Dec: "

        val stringInTextView = whereWrite?.text.toString()
        if( ( whereWrite == decShow && stringInTextView.length == 18 )
            || (whereWrite == binShow && stringInTextView.length == 63)
            ||(whereWrite == octShow && stringInTextView.length == 21 )
            ||(whereWrite == hexShow && stringInTextView.length == 15))
        {
            Toast.makeText(
                applicationContext,
                "I am so sad my app can't do it with this length :( ",
                Toast.LENGTH_SHORT
            ).show()
        }
        else if (whereWrite == null) {
            Toast.makeText(
                applicationContext,
                "please first select system number :) ",
                Toast.LENGTH_SHORT
            ).show()
        } else if (stringInTextView.length < 1 && num == "0") {
            Toast.makeText(
                applicationContext,
                "are you joking you can't add 0 at first",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            if (whereWrite == hexShow) {
                whereWrite!!.setText("$stringInTextView$num")
                binShow.setText("$bin${hexTobinary(whereWrite!!.text.toString())}")
                octShow.setText("$oct${hexToOctal(whereWrite!!.text.toString())}")
                decShow.setText("$dec${hexToDecimal(whereWrite!!.text.toString())}")
            } else if (num != "A" && num != "B" && num != "C" && num != "D" && num != "E" && num != "F") {
                if (whereWrite == binShow && (num == "0" || num == "1")) {

                    whereWrite!!.setText("$stringInTextView$num")
                    hexShow.setText("$hex${binaryToHex(whereWrite!!.text.toString())}")
                    octShow.setText("$oct${binaryToOctal(whereWrite!!.text.toString())}")
                    decShow.setText("$dec${binaryToDecimal(whereWrite!!.text.toString())}")

                } else if (whereWrite == decShow) {

                    whereWrite!!.setText("$stringInTextView$num")
                    hexShow.setText("$hex${decimalToHex(whereWrite!!.text.toString().toLong())}")
                    binShow.setText("$bin${decimalTobinary(whereWrite!!.text.toString().toLong())}")
                    octShow.setText("$oct${decimalToOctal(whereWrite!!.text.toString().toLong())}")
                } else if (whereWrite == octShow) {

                    whereWrite!!.setText("$stringInTextView$num")
                    hexShow.setText("$hex${octalToHex(whereWrite!!.text.toString())}")
                    binShow.setText("$bin${octalTobinary(whereWrite!!.text.toString())}")
                    decShow.setText("$dec${octalToDecimal(whereWrite!!.text.toString())}")
                } else {
                    Toast.makeText(
                        applicationContext,
                        "this number $num  Not all in this System Number",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    applicationContext,
                    "this number $num  Not all in this System Number",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun reset() {
        whereWrite = null
        hexShow.setText("HEX: ")
        octShow.setText("OCT: ")
        binShow.setText("BIN: ")
        decShow.setText("Dec: ")
        hexShow.setBackgroundResource(R.drawable.circle_textview)
        octShow.setBackgroundResource(R.drawable.circle_textview)
        binShow.setBackgroundResource(R.drawable.circle_textview)
        decShow.setBackgroundResource(R.drawable.circle_textview)
    }




    fun binaryToHex(binaryNumber: String): String {
        var st = binaryNumber.length
        var ans = ""
        while (st > 3) {
            val decimalFourNumber =
                simpleDecimalToHex(binaryToDecimal(binaryNumber.substring(st - 4, st)))
            ans = decimalFourNumber + ans
            st -= 4
        }
        if (st > 0) ans = simpleDecimalToHex(binaryToDecimal(binaryNumber.substring(0, st))) + ans
        return ans
    }

    fun simpleDecimalToHex(decimalNumber: String): String {
        return if (decimalNumber == "10") "A"
        else if (decimalNumber == "11") "B"
        else if (decimalNumber == "12") "C"
        else if (decimalNumber == "13") "D"
        else if (decimalNumber == "14") "E"
        else if (decimalNumber == "15") "F"
        else decimalNumber
    }

    fun binaryToOctal(binaryNumber: String): String {
        var st = binaryNumber.length
        var ans = ""
        while (st > 2) {
            val decimalFourNumber = binaryToDecimal(binaryNumber.substring(st - 3, st))
            ans = decimalFourNumber + ans
            st -= 3
        }
        if (st > 0) ans = binaryToDecimal(binaryNumber.substring(0, st)) + ans
        return ans
    }

    fun binaryToDecimal(binaNumber: String): String {
        var ans = 0L
        var multOfTow = 1L
        for (i in binaNumber.length - 1 downTo 0) {
            if (binaNumber[i] == '1') {
                ans += multOfTow
            }
            multOfTow *= 2
        }
        return "$ans"
    }


    fun decimalTobinary(decimalNumber: Long): String {
        if (decimalNumber == 0L) return ""
        return "${decimalTobinary(decimalNumber / 2)}${decimalNumber % 2}"
    }

    fun decimalTobinary(decimalNumber: Int): String {
        if (decimalNumber == 0) return ""
        return "${decimalTobinary(decimalNumber / 2)}${decimalNumber % 2}"
    }

    fun decimalToOctal(decimalNumber: Int): String {
        return binaryToOctal(decimalTobinary(decimalNumber))
    }

    fun decimalToOctal(decimalNumber: Long): String {
        return binaryToOctal(decimalTobinary(decimalNumber))
    }

    fun decimalToOcHex(decimalNumber: Int): String {
        return binaryToHex(decimalTobinary(decimalNumber))
    }

    fun decimalToHex(decimalNumber: Long): String {
        return binaryToHex(decimalTobinary(decimalNumber))
    }

    fun simpleHexTOBinary(hexNumber: Char): String {
        return if (hexNumber == '0') "0000"
        else if (hexNumber == '1') "0001"
        else if (hexNumber == '2') "0010"
        else if (hexNumber == '3') "0011"
        else if (hexNumber == '4') "0100"
        else if (hexNumber == '5') "0101"
        else if (hexNumber == '6') "0110"
        else if (hexNumber == '7') "0111"
        else if (hexNumber == '8') "1000"
        else if (hexNumber == '9') "1001"
        else if (hexNumber == 'A') "1010"
        else if (hexNumber == 'B') "1011"
        else if (hexNumber == 'C') "1100"
        else if (hexNumber == 'D') "1101"
        else if (hexNumber == 'E') "1110"
        else "1111"
    }

    fun hexTobinary(hexNumber: String): String {
        var ans = ""
        for (i in hexNumber.length - 1 downTo 0) {
            ans = simpleHexTOBinary(hexNumber[i]) + ans
        }
        return ans
    }

    fun hexToDecimal(hexNumber: String): String {
        return binaryToDecimal(hexTobinary(hexNumber))
    }

    fun hexToOctal(hexNumber: String): String {
        return binaryToOctal(hexTobinary(hexNumber))
    }


    fun simpleOctalTOBinary(octalNumber: Char): String {
        return if (octalNumber == '0') "000"
        else if (octalNumber == '1') "001"
        else if (octalNumber == '2') "010"
        else if (octalNumber == '3') "011"
        else if (octalNumber == '4') "100"
        else if (octalNumber == '5') "101"
        else if (octalNumber == '6') "110"
        else "111"
    }

    fun octalTobinary(octalNumber: String): String {
        var ans = ""
        for (i in octalNumber.length - 1 downTo 0) {
            ans = simpleOctalTOBinary(octalNumber[i]) + ans
        }
        return ans
    }

    fun octalToDecimal(octalNumber: String): String {
        return binaryToDecimal(octalTobinary(octalNumber))
    }

    fun octalToHex(octalNumber: String): String {
        return binaryToHex(octalTobinary(octalNumber))
    }


}