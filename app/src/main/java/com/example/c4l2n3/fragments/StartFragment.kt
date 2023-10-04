package com.example.c4l2n3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.c4l2n3.R
import com.example.c4l2n3.databinding.StartFragmentBinding

class StartFragment : Fragment(R.layout.start_fragment) {
    private var _binding: StartFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = StartFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding){
        super.onViewCreated(view, savedInstanceState)
        nextBut.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_listFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}