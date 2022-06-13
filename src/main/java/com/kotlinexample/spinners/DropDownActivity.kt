package com.kotlinexample.spinners

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.kotlinexample.listsorting.R
import java.util.*

class DropDownActivity : AppCompatActivity() {

    lateinit var actvCountry : AutoCompleteTextView
    lateinit var actvState : AutoCompleteTextView
    lateinit var actvCity : AutoCompleteTextView

    var countryMutableList = mutableListOf<Country?>()
    var stateMutableList = mutableListOf<State>()
    var cityMutableList = mutableListOf<City>()

    lateinit var countryAdapter : ArrayAdapter<Country>
    lateinit var stateAdapter : ArrayAdapter<State>
    lateinit var cityAdapter : ArrayAdapter<City>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinners)

        actvCountry = findViewById(R.id.country_dropdown)
        actvState = findViewById(R.id.state_dropdown)
        actvCity = findViewById(R.id.city_dropdown)

        createList()

        countryAdapter = ArrayAdapter<Country>(this, android.R.layout.simple_spinner_item, countryMutableList)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        actvCountry.setAdapter(countryAdapter)

        stateAdapter = ArrayAdapter<State>(this, android.R.layout.simple_spinner_item, stateMutableList)
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        actvState.setAdapter(stateAdapter)

        cityAdapter = ArrayAdapter<City>(this, android.R.layout.simple_spinner_item, cityMutableList)
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        actvCity.setAdapter(cityAdapter)

        actvCountry.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position != 0) {
                    stateMutableList.clear()

                    countryMutableList[position]?.stateList?.let {
                        if(it.isNotEmpty()) {
                            stateMutableList.addAll(it)
                        }
                        else{
                            stateMutableList.add(State(0, "Choose a State", mutableListOf()))
                            Toast.makeText(this@DropDownActivity, "No state is available", Toast.LENGTH_SHORT).show()
                        }
                    }
                    cityMutableList.clear()
                    cityMutableList.add(City(0, "Choose a city"))
                    stateAdapter.notifyDataSetChanged()
                    cityAdapter.notifyDataSetChanged()

                    actvState.setText("Choose a State", false)
                    actvCity.setText("Choose a City", false)
                }
            }
        }
        actvState.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position != 0) {
                    cityMutableList.clear()
                    stateMutableList[position].cityList.let {
                        if(it.isNotEmpty()) {
                            cityMutableList.addAll(it)
                        }
                        else {
                            cityMutableList.add( City(0, "Choose a city"))
                            Toast.makeText(this@DropDownActivity, "No city is available", Toast.LENGTH_SHORT).show()

                        }
                    }
                    cityAdapter.notifyDataSetChanged()
                    actvCity.setSelection(0)
                }
            }
        }
        actvCity.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            }
        }
    }
    private fun createList() {
        val upCityList = mutableListOf<City>()
        Collections.addAll(upCityList, City(0, "Choose a city"), City(1,"Lucknow"), City(2, "Gorakhpur"))
        val maharashtraCityList = mutableListOf<City>()
        Collections.addAll(maharashtraCityList, City(0, "Choose a city"), City(3,"Mumbai"), City(4, "Pune"))


        val indiaStateList = mutableListOf<State>()
        Collections.addAll(indiaStateList, State(0, "Choose a State", mutableListOf()),  State(1, "U.P.", upCityList),
            State(2, "Delhi", mutableListOf()),State(3, "Goa", mutableListOf()), State(4, "Maharashtra", maharashtraCityList) )

        val americaStateList = mutableListOf<State>()
        Collections.addAll(americaStateList, State(0, "Choose a State", mutableListOf()), State(5, "California", mutableListOf()),
            State(6, "Washington", mutableListOf()))

        val allCountryList = mutableListOf<Country>()
        Collections.addAll(allCountryList, Country(0, "Choose a country", mutableListOf()), Country (1, "America", americaStateList)
        ,Country(2, "India", indiaStateList),  Country(3, "Australia", mutableListOf()))

        countryMutableList.addAll(allCountryList)
        stateMutableList.add(State(0, "Choose a State", mutableListOf()))
        cityMutableList.add(City(0, "Choose a city"))
    }
}