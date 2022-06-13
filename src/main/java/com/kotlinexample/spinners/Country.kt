package com.kotlinexample.spinners

data class Country(var id : Int, var name: String, var stateList : MutableList<State>){
    override fun toString(): String {
        return name
    }
}
