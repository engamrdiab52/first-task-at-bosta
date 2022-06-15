package com.amrabdelhamiddiab.firsttaskatbosta.presentation.imagesScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.firsttaskatbosta.R
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.FragmentImagesBinding
import com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen.AlbumsEpoxyController
import com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class ImagesFragment : Fragment() {
    private lateinit var binding: FragmentImagesBinding
    private val viewModel: AlbumsViewModel by hiltNavGraphViewModels(R.id.main_nav_graph)
    private lateinit var recyclerView: EpoxyRecyclerView
    private val photosEpoxyController by lazy {
        PhotosEpoxyController(viewModel)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images, container, false)
        recyclerView = binding.recyclerViewImages
        recyclerView.adapter = photosEpoxyController.adapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        viewModel.idOfAlbum.observe(viewLifecycleOwner) {
            viewModel.downloadPhotosViewModel(it)
          // binding.textViewId.text = it.toString()
        }
        viewModel.listOfPhots.observe(viewLifecycleOwner){
            Log.d(TAG, it.toString())
            photosEpoxyController.setData(it)
            //  binding.textViewAlbumsFragment.text = it.toString()
            Log.d(TAG, it.toString())
        }
        return binding.root
    }

}