package com.example.c4l2n3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.c4l2n3.Adapter.ListAdapter
import com.example.c4l2n3.R
import com.example.c4l2n3.databinding.ListFragmentBinding
import com.example.c4l2n3.models.ItemModel

class ListFragment : Fragment(R.layout.list_fragment) {
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var itemArrayList : ArrayList<ItemModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ListFragmentBinding.inflate(inflater, container, false)

        val imageArray = intArrayOf(R.drawable.ic_borsch, R.drawable.ic_cesar, R.drawable.ic_milkshake, R.drawable.ic_blinchik, R.drawable.ic_spagetti)
        val nameArray = arrayOf("borsch", "caesar", "milkshake", "pancakes", "spaghetti")

        itemArrayList = ArrayList()
        for (i in imageArray.indices){
            val item = ItemModel(imageArray[i], nameArray[i])
            itemArrayList.add(item)
        }

        binding.listView1.adapter = ListAdapter(requireContext(), itemArrayList)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)
        listView1.onItemClickListener = AdapterView.OnItemClickListener{ _, _, position, _ ->
            var bundle = Bundle()
            when (itemArrayList[position].image){
                R.drawable.ic_borsch -> {
                    val titleImage : Int = R.drawable.ic_borsch
                    val image : Int = R.drawable.borsch
                    bundle = createBundle(
                        titleImage,
                        R.string.borsch,
                        image,
                        R.string.borschDescr
                    )
                }
                R.drawable.ic_cesar -> {
                    val titleImage : Int = R.drawable.ic_cesar
                    val image : Int = R.drawable.cesar
                    bundle = createBundle(
                        titleImage,
                        R.string.cesar,
                        image,
                        R.string.cesarDescr
                    )
                }
                R.drawable.ic_milkshake -> {
                    val titleImage : Int = R.drawable.ic_milkshake
                    val image : Int = R.drawable.milkshake
                    bundle = createBundle(
                        titleImage,
                        R.string.milkshake,
                        image,
                        R.string.milkshakeDescr
                    )
                }
                R.drawable.ic_blinchik -> {
                    val titleImage : Int = R.drawable.ic_blinchik
                    val image : Int = R.drawable.blinchik
                    bundle = createBundle(
                        titleImage,
                        R.string.cesar,
                        image,
                        R.string.cesarDescr
                    )
                }
                R.drawable.ic_spagetti -> {
                    val titleImage : Int = R.drawable.ic_spagetti
                    val image : Int = R.drawable.spagetti
                    bundle = createBundle(
                        titleImage,
                        R.string.cesar,
                        image,
                        R.string.cesarDescr
                    )
                }
            }
            findNavController().navigate(R.id.action_listFragment_to_dishFragment, bundle)
        }
    }

    private fun createBundle(
        titleImage: Int,
        titleName: Int,
        image: Int,
        descr: Int
    ): Bundle {
        val bundle = Bundle()
        bundle.putInt("TitleImage", titleImage)
        bundle.putInt("TitleName", titleName)
        bundle.putInt("Image", image)
        bundle.putInt("Descr", descr)
        return bundle
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}