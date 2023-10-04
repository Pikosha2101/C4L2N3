package com.example.c4l2n3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.c4l2n3.R
import com.example.c4l2n3.databinding.DishFragmentBinding

class DishFragment : Fragment(R.layout.dish_fragment) {
    private var _binding: DishFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DishFragmentBinding.inflate(inflater, container, false)

            binding.titleImageView.setImageResource(arguments?.getInt("TitleImage")!!)
            binding.titleTextView.text = getString(arguments?.getInt("TitleName")!!)
            binding.mainImageView.setImageResource(arguments?.getInt("Image")!!)
            binding.descriptTextView.text = getString(arguments?.getInt("Descr")!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)
        backBut.setOnClickListener {
            findNavController().navigate(R.id.action_dishFragment_to_listFragment2)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}