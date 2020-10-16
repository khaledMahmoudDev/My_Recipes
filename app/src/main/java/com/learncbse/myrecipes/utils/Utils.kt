package com.learncbse.myrecipes.utils


// extract numbers from string
fun getNumericValueFromString(text: String): Int {
    var num = text.replace(Regex("[^0-9]"), "")
    if (num.isEmpty()) {
        num = "0"
    }
    return num.toInt()

}