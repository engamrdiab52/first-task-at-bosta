package com.amrabdelhamiddiab.firsttaskatbosta.presentation.imagesScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.amrabdelhamiddiab.firsttaskatbosta.R
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.FragmentImagesBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class ImagesFragment : Fragment() {
    private lateinit var binding: FragmentImagesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}