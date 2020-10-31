package com.sriyank.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSimpleSpinner()

        setupCustomSpinner()
    }

    private fun setupCustomSpinner() {

        val adapter = CountryArrayAdapter(this, Countries.list!!)
        customSpinner.adapter = adapter
        // TODO Assignment: add listener to the customSpinner
    }

    private fun setupSimpleSpinner() {

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.countries,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        simpleSpinner.adapter = adapter

        simpleSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val selectedItem = parent!!.getItemAtPosition(position)
                Toast.makeText(this@MainActivity, "$selectedItem Selected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Use as per your wish
            }
        }
    }
}