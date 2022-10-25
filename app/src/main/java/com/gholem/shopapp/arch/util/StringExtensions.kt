package com.gholem.moneylab.util

fun String.removeWhitespaces() = replace(regex = "\\s".toRegex(), replacement = "")