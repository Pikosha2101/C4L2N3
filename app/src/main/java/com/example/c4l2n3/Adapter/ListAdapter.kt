package com.example.c4l2n3.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.c4l2n3.R
import com.example.c4l2n3.databinding.ListViewItemBinding
import com.example.c4l2n3.models.ItemModel

class ListAdapter (context: Context, private val arrayList: ArrayList<ItemModel>) :
    ArrayAdapter<ItemModel>(context, R.layout.list_view_item, arrayList) {

    private lateinit var binding : ListViewItemBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)
        binding = ListViewItemBinding.inflate(inflater, parent, false)
        //Picasso.get().load(arrayList[position].image).into(binding.iconImageView)
        binding.iconImageView.setImageResource(arrayList[position].image)
        binding.nameTextView.text = arrayList[position].name

        return binding.root
    }
}