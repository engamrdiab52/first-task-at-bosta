package com.amrabdelhamiddiab.firsttaskatbosta.presentation.imagesScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.amrabdelhamiddiab.firsttaskatbosta.R
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.FragmentImagesBinding
import com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class ImagesFragment : Fragment() {
    private lateinit var binding: FragmentImagesBinding
    private val viewModel: AlbumsViewModel by hiltNavGraphViewModels(R.id.main_nav_graph)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images, container, false)
        viewModel.idOfAlbum.observe(viewLifecycleOwner) {
           binding.textViewId.text = it.toString()
        }

        return binding.root
    }

}