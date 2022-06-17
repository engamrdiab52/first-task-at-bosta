package com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity
import com.amrabdelhamiddiab.firsttaskatbosta.R
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.FragmentAlbumsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random

@AndroidEntryPoint
class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding

    val userId = Random.nextInt(1, 10).toLong()
    private val viewModel: AlbumsViewModel by hiltNavGraphViewModels(R.id.main_nav_graph)
    private lateinit var recyclerView: EpoxyRecyclerView
    private val albumsEpoxyController by lazy {
        AlbumsEpoxyController(viewModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        viewModel.downloadAlbumsViewModel(userId)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_albums, container, false)
        recyclerView = binding.recyclerViewAlbumName
        recyclerView.adapter = albumsEpoxyController.adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.users.observe(viewLifecycleOwner) {
            binding.textViewUserName.text = it?.first()?.username
            binding.textViewUserAddress.text =
                "${it?.first()?.address?.street}, ${it?.first()?.address?.suite}, ${it?.first()?.address?.city}, ${it?.first()?.address?.zipcode}"
        }

        viewModel.listOfAlbums.observe(viewLifecycleOwner) {
            Log.d(MainActivity.TAG, it.toString())
            albumsEpoxyController.setData(it)
        }
        viewModel.cardClicked.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_albumsFragment_to_imagesFragment)
        }
        viewModel.downloadUserViewModel(userId)
        return binding.root
    }

}
