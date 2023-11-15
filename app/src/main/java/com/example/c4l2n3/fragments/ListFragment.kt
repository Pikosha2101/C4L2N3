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
            when (itemArrayList[position].name){
                "borsch" -> {
                    val titleImage : Int = R.drawable.ic_borsch
                    bundle = createBundle(
                        titleImage,
                        R.string.borsch,
                        "https://www.gastronom.ru/binfiles/images/20220907/b7f6fa22.jpg",
                        R.string.borschDescr
                    )
                }
                "caesar" -> {
                    val titleImage : Int = R.drawable.ic_cesar
                    bundle = createBundle(
                        titleImage,
                        R.string.cesar,
                        "https://e1.edimdoma.ru/data/posts/0002/2917/22917-ed4_wide.jpg?1631185869",
                        R.string.cesarDescr
                    )
                }
                "milkshake" -> {
                    val titleImage : Int = R.drawable.ic_milkshake
                    bundle = createBundle(
                        titleImage,
                        R.string.milkshake,
                        "https://e3.edimdoma.ru/data/posts/0002/5904/25904-ed4_wide.jpg?1662982620",
                        R.string.milkshakeDescr
                    )
                }
                "pancakes" -> {
                    val titleImage : Int = R.drawable.ic_blinchik
                    bundle = createBundle(
                        titleImage,
                        R.string.blinchik,
                        "https://e0.edimdoma.ru/data/recipes/0013/5237/135237-ed4_wide.jpg?1628766116",
                        R.string.blinchikDescr
                    )
                }
                "spaghetti" -> {
                    val titleImage : Int = R.drawable.ic_spagetti
                    bundle = createBundle(
                        titleImage,
                        R.string.spagetti,
                        "https://www.gastronom.ru/binfiles/images/20180227/baeeb555.jpg",
                        R.string.spagettiDescr
                    )
                }
            }
            findNavController().navigate(R.id.action_listFragment_to_dishFragment, bundle)
        }
    }

    private fun createBundle(
        titleImage: Int,
        titleName: Int,
        image: String,
        descr: Int
    ): Bundle {
        val bundle = Bundle()
        bundle.putInt("TitleImage", titleImage)
        bundle.putInt("TitleName", titleName)
        bundle.putString("Image", image)
        bundle.putInt("Descr", descr)
        return bundle
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}