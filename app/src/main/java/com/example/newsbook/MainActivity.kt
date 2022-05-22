package com.example.newsbook


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchData()
        // create adapter class instance
        val adapter = NewsListAdapter(items,this)
        //attach adapter to the recyclerview
        recyclerView.adapter = adapter
    }

    private fun fetchData(): ArrayList<String>{
        val list = ArrayList<String>()
        for(i in 0..100){
            list.add("item $i")
            print("hello my commit")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,"clicked item $item",Toast.LENGTH_LONG).show()
    }

}

