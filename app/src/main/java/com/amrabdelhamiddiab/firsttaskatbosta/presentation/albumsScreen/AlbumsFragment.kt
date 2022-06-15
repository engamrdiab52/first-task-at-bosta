package com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity
import com.amrabdelhamiddiab.firsttaskatbosta.R
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.FragmentAlbumsBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding
    private val viewModel: AlbumsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_albums, container, false)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_albumsFragment_to_imagesFragment)
        }
        viewModel.downloadAlbumsViewModel()
        viewModel.listOfAlbums.observe(viewLifecycleOwner){
            Log.d(MainActivity.TAG, it.toString())
            binding.textViewAlbumsFragment.text = it.toString()
        }
            return binding.root
    }

}