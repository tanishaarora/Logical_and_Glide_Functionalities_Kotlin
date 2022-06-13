package com.kotlinexample.spinners

data class City(var id : Int, var name : String){
    override fun toString(): String {
        return name
    }
}
