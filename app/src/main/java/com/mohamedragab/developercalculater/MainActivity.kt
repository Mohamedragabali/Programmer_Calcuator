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

    lateinit var resetBt : Button
    lateinit var convertBt : Button
    lateinit var radioGroup :RadioGroup
    lateinit var hexShow  :TextView
    lateinit var octShow  :TextView
    lateinit var binShow  :TextView
    lateinit var decShow  :TextView
    lateinit var editText  :EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resetBt = findViewById(R.id.Reset)
        convertBt = findViewById(R.id.Convert)
        radioGroup = findViewById(R.id.radio_group)
        hexShow = findViewById(R.id.hexShow)
        octShow = findViewById(R.id.octShow)
        binShow = findViewById(R.id.binShow)
        decShow = findViewById(R.id.decShow)
        editText = findViewById(R.id.editText)

        // hexShow.setText("hallo")
        // editText.text.toString()
        // Get radio group selected status and text using button click event
        convertBt.setOnClickListener{
            var id: Int = radioGroup.checkedRadioButtonId
            if (id!=-1){
                val radio:RadioButton = findViewById(id)
                //  radio.text
                if(radio.text == "HEX") {
                    hexShow.setText("${editText.text.toString()}")
                    binShow.setText("${hexTobinary(editText.text.toString())}")
                    octShow.setText("${hexToOctal(editText.text.toString())}")
                    decShow.setText("${hexToDecimal(editText.text.toString())}")
                }
                else if(radio.text == "OCT") {

                    hexShow.setText("${octalToHex(editText.text.toString())}")
                    binShow.setText("${octalTobinary(editText.text.toString())}")
                    octShow.setText("${editText.text.toString()}")
                    decShow.setText("${octalToDecimal(editText.text.toString())}")
                }
               else if(radio.text == "BIN"){

                    hexShow.setText("${binaryToHex(editText.text.toString())}")
                    binShow.setText("${(editText.text.toString())}")
                    octShow.setText("${ binaryToOctal(editText.text.toString())  }")
                    decShow.setText("${ binaryToDecimal(editText.text.toString()) }")
                }
                else {

                    hexShow.setText("${decimalToHex(editText.text.toString().toLong())}")
                    binShow.setText("${decimalTobinary(editText.text.toString().toLong())}")
                    octShow.setText("${decimalToOctal(editText.text.toString().toLong())   }")
                    decShow.setText("${ editText.text.toString() }")
                }
            }
            else
            {
                Toast.makeText(applicationContext,
                        " nothing selected please selcted number system ",
                    Toast.LENGTH_SHORT).show()
            }

        }
        resetBt.setOnClickListener {
            hexShow.setText("")
            octShow.setText("")
            binShow.setText("")
            decShow.setText("")
        }
    }


    fun binaryToHex(binaryNumber: String): String {
        var st = binaryNumber.length
        var ans = ""
        while (st > 3) {
            val decimalFourNumber = simpleDecimalToHex( binaryToDecimal(binaryNumber.substring(st - 4, st)) )
            ans = decimalFourNumber + ans
            st -= 4
        }
        if(st > 0 ) ans = simpleDecimalToHex( binaryToDecimal(binaryNumber.substring(0, st)) ) + ans
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
        if(st > 0 ) ans = binaryToDecimal(binaryNumber.substring(0, st)) + ans
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
    fun decimalToOctal(decimalNumber: Int ) : String {
        return binaryToOctal(decimalTobinary(decimalNumber))
    }
    fun decimalToOctal(decimalNumber: Long ) : String {
        return binaryToOctal(decimalTobinary(decimalNumber))
    }
    fun decimalToOcHex(decimalNumber: Int ) : String {
        return binaryToHex(decimalTobinary(decimalNumber))
    }
    fun decimalToHex(decimalNumber: Long ) : String {
        return binaryToHex( decimalTobinary(decimalNumber))
    }

    fun simpleHexTOBinary(hexNumber : Char ) :String {
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
    fun hexTobinary (hexNumber: String ): String {
        var ans = ""
        for(i in hexNumber.length-1 downTo  0  ) {
            ans = simpleHexTOBinary( hexNumber[i] ) + ans
        }
        return ans
    }

    fun hexToDecimal(hexNumber: String):String{
        return binaryToDecimal(hexTobinary(hexNumber))
    }
    fun hexToOctal (hexNumber: String):String{
        return binaryToOctal(hexTobinary(hexNumber))
    }


    fun simpleOctalTOBinary(octalNumber: Char ) :String {
        return if (octalNumber == '0')"000"
        else if (octalNumber == '1') "001"
        else if (octalNumber == '2') "010"
        else if (octalNumber == '3') "011"
        else if (octalNumber == '4') "100"
        else if (octalNumber == '5') "101"
        else if (octalNumber == '6') "110"
        else "111"
    }
    fun octalTobinary (octalNumber: String ): String {
        var ans = ""
        for(i in octalNumber.length-1 downTo  0  ) {
            ans = simpleOctalTOBinary( octalNumber[i] ) + ans
        }
        return ans
    }

    fun octalToDecimal(octalNumber: String ) : String {
        return binaryToDecimal(octalTobinary(octalNumber))
    }
    fun octalToHex (octalNumber: String ): String{
        return binaryToHex(octalTobinary(octalNumber))
    }




}