package com.example.triviaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class SelectionPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.selection_page, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mathsBtn: Button= view.findViewById(R.id.maths)
        val geoBtn: Button= view.findViewById(R.id.geo)
        val hisBtn: Button= view.findViewById(R.id.history)

        mathsBtn.setOnClickListener{
            findNavController().navigate(R.id.MathsFragment)
        }
        geoBtn.setOnClickListener{
            findNavController().navigate(R.id.GeoFragment)
        }
        hisBtn.setOnClickListener {
            findNavController().navigate(R.id.HisFragment)
        }
    }
}