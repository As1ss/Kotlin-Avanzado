package com.example.kotlin_avanzado

class Person(var name: String? = null, var passport: String? = null, var height: Float? = null) {
    var alive: Boolean = true


    fun die() {
        this.alive = false
    }

    fun checkPolice(fn: (Float?) -> Boolean): Boolean {
        return fn(height)
    }


}