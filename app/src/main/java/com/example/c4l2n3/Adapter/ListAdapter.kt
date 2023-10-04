package com.example.c4l2n3.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.c4l2n3.R
import com.example.c4l2n3.models.ItemModel

class ListAdapter (context: Context, private val arrayList: ArrayList<ItemModel>) :
    ArrayAdapter<ItemModel>(context, R.layout.list_view_item, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.list_view_item, parent, false)

        val imageView : ImageView = view.findViewById(R.id.iconImageView)
        val dishName : TextView = view.findViewById(R.id.nameTextView)

        imageView.setImageResource(arrayList[position].image)
        dishName.text = arrayList[position].name

        return view
    }
}