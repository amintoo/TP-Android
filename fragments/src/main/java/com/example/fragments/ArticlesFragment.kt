package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ArticlesFragment : Fragment() {
    /**
     * Ici, on associe le layout à afficher dans le fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
      ): View? {
        return inflater.inflate(R.layout.activity_main, container, false)
    }
}