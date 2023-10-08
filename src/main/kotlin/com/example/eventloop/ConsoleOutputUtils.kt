package com.example.eventloop

object ConsoleOutputUtils {
    fun printWithThread(any: Any) {
        println("[${Thread.currentThread().name}] $any")
    }
}