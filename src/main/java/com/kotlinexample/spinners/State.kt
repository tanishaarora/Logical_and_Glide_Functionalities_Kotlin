package com.kotlinexample.spinners

data class State(var id : Int, var name : String, var cityList : MutableList<City>){
    override fun toString(): String {
        return name
    }
}
