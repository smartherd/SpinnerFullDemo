package com.sriyank.spinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.spinner_item.view.*

class CountryArrayAdapter(context: Context, countryList: List<Country>) : ArrayAdapter<Country>(context, 0, countryList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    private fun initView(position: Int, convertView: View?, parent: ViewGroup): View {

        val country = getItem(position)

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false)
        view.countryImage.setImageResource(country!!.image)
        view.countryName.text = country.name

        return view
    }
}