package com.timzowen.theandroidseries.navigation

sealed class Routes(val routes: String) {

    object Home : Routes("home")
    object Recipient : Routes("recipient")
    object Amount : Routes("amount")
    object Confirmation : Routes("confirmation")
    object Pin : Routes("pin")
    object Success : Routes("success")
}