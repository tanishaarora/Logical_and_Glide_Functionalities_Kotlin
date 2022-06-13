package com.kotlinexample.listsorting

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import java.util.*


class Details : AppCompatActivity(), DetailsAdapter.DetailsAdapterListener,
    AdapterView.OnItemSelectedListener{
    lateinit var adapter : DetailsAdapter
    var mutableList = mutableListOf<DetailsView>()
    lateinit var chk_selectall : CheckBox
    lateinit var btn_delete : Button


    var sort_by = arrayOf("Sort By",
        "Ascend by name",
        "Descend by name", "Ascend by dob",
        "Descend by dob")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        chk_selectall = findViewById<CheckBox>(R.id.chk_selectall)
        btn_delete = findViewById<Button>(R.id.btn_delete)
        val spn_spinner = findViewById<Spinner>(R.id.spinner)

        spn_spinner.onItemSelectedListener = this

        val ad: ArrayAdapter<*> = ArrayAdapter<Any?>(this, android.R.layout.simple_spinner_item, sort_by)

        ad.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spn_spinner.adapter = ad

        /*chk_selectall.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                for(detailView in mutableList){
                    detailView.isDetailChecked = isChecked
                }
                adapter.notifyDataSetChanged()
            }
        })*/

        chk_selectall.setOnClickListener(View.OnClickListener {
            for(detailView in mutableList){
                detailView.isDetailChecked = chk_selectall.isChecked
            }
            adapter.notifyDataSetChanged()
        })

        btn_delete.setOnClickListener(View.OnClickListener {
                if (chk_selectall.isChecked){
                    mutableList.clear()
                }
                else if(!chk_selectall.isChecked) {
                    val sublist = mutableListOf<DetailsView>()
                    for (detailView in mutableList) {
                        if(detailView.isDetailChecked){
                            sublist.add(detailView)
                        }
                    }
                    if (!sublist.isEmpty()){
                        mutableList.removeAll(sublist)
                    }else{
                        Toast.makeText(applicationContext, "Select any box", Toast.LENGTH_SHORT).show()
                    }
                }
            adapter.notifyDataSetChanged()
        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        mutableList.add(DetailsView("Tanisha", "22", "New York", "1999"))
        mutableList.add(DetailsView("Lovely", "23", "Manhattan", "1998"))
        mutableList.add(DetailsView("Shagun", "24", "Ambedkar Nagar", "1997"))
        mutableList.add(DetailsView("Vanshika", "25", "Ayodhya", "1996"))
        mutableList.add(DetailsView("Simran", "26", "Dalhousie", "1995"))
        mutableList.add(DetailsView("Kishi", "27", "Srinagar", "1994"))
        mutableList.add(DetailsView("Ruba", "28", "Noida", "1993"))
        mutableList.add(DetailsView("Amrita", "29", "Shimla", "1992"))
        mutableList.add(DetailsView("Pragati", "30", "Manali", "1991"))
        mutableList.add(DetailsView("Tanvi", "31", "Auli", "1990"))

        adapter = DetailsAdapter(mutableList, this)
        recyclerView.adapter  = adapter
    }
    override fun onChecked(isChecked: Boolean, position : Int) {
        val detailView : DetailsView = mutableList.get(position)
        detailView.isDetailChecked = isChecked

        if(!detailView.isDetailChecked){
            chk_selectall.isChecked = false
        }
        adapter.notifyDataSetChanged()
    }

    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {
        sort_by = arrayOf(parent?.getItemAtPosition(position).toString())
        if(position == 1)
        {
            Collections.sort(mutableList, object : Comparator<DetailsView> {
                override fun compare(o1: DetailsView, o2: DetailsView): Int {
                    return o1.Name.compareTo(o2.Name)
                }
            })
        }
        else if (position == 2){
            Collections.sort(mutableList, object : Comparator<DetailsView> {
                override fun compare(o1: DetailsView, o2: DetailsView): Int {
                    return o2.Name.compareTo(o1.Name)
                }
            })
        }
        else if (position == 3){
            Collections.sort(mutableList, object : Comparator<DetailsView> {
                override fun compare(o1: DetailsView, o2: DetailsView): Int {
                    return o1.DOB.compareTo(o2.DOB)
                }
            })
        }
        else{
            Collections.sort(mutableList, object : Comparator<DetailsView> {
                override fun compare(o1: DetailsView, o2: DetailsView): Int {
                    return o2.DOB.compareTo(o1.DOB)
                }
            })
        }

        adapter.notifyDataSetChanged()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

/*        Toast.makeText(applicationContext,
            sort_by[position],
            Toast.LENGTH_LONG)
            .show()*/
    }