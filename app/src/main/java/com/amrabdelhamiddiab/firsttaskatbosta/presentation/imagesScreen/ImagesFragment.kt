package com.amrabdelhamiddiab.firsttaskatbosta.presentation.imagesScreen

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.amrabdelhamiddiab.core.data.PhotoThum
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
    private lateinit var tempList: List<PhotoThum>
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
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        viewModel.idOfAlbum.observe(viewLifecycleOwner) {
            viewModel.downloadPhotosViewModel(it)
             binding.textViewNameOfAlbum.text = it.toString()
        }

        viewModel.listOfPhots.observe(viewLifecycleOwner) {
            recyclerView.layoutManager = GridLayoutManager(context, 3)
            Log.d(TAG, it.toString())
            photosEpoxyController.setData(it)
            //  binding.textViewAlbumsFragment.text = it.toString()
            Log.d(TAG, it.toString())
        }
        viewModel.album.observe(viewLifecycleOwner){
            binding.textViewNameOfAlbum.text = it?.title
        }
        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.search(newText, tempList)
                return false
            }

        })
        binding.searchView.setOnQueryTextFocusChangeListener { _, p1 ->
            if (p1) {
                tempList = viewModel.listOfPhots.value!!
            }
        }
        return binding.root
    }

}