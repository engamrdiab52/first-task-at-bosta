package com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.amrabdelhamiddiab.core.data.User
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.firsttaskatbosta.R
import com.amrabdelhamiddiab.firsttaskatbosta.databinding.FragmentAlbumsBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@AndroidEntryPoint
class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding

    //  private val viewModel: AlbumsViewModel by viewModels()
    val userId = Random.nextInt(1, 10).toLong()
    private val viewModel: AlbumsViewModel by hiltNavGraphViewModels(R.id.main_nav_graph)
    private lateinit var recyclerView: EpoxyRecyclerView
    private val albumsEpoxyController by lazy {
        AlbumsEpoxyController(viewModel)
    }

    /* override fun onCreate(context: Context) {
         super.onCreate(context)
         viewModel.downloadAlbumsViewModel()
     }*/

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
            //  it?.toString()?.let { it1 -> Log.d(TAG, it1) }
            if (it != null) {
                Log.d(TAG, it.first().username + "................")
            }
            binding.textViewUserName.text = it?.first()?.username
            binding.textViewUserAddress.text =
                "${it?.first()?.address?.street}, ${it?.first()?.address?.suite}, ${it?.first()?.address?.city}, ${it?.first()?.address?.zipcode}"
        }

        viewModel.listOfAlbums.observe(viewLifecycleOwner) {
            Log.d(MainActivity.TAG, it.toString())
            albumsEpoxyController.setData(it)
            //  binding.textViewAlbumsFragment.text = it.toString()
        }
        viewModel.cardClicked.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_albumsFragment_to_imagesFragment)
        }
        viewModel.downloadUserViewModel(userId)
        return binding.root
    }

}


/*viewModel.listOfAlbums.observe(viewLifecycleOwner){
         Log.d(MainActivity.TAG, it.toString())
       //  binding.textViewAlbumsFragment.text = it.toString()
     }*/

/*    binding.button.setOnClickListener {
          findNavController().navigate(R.id.action_albumsFragment_to_imagesFragment)
      }*/