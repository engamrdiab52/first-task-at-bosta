package com.amrabdelhamiddiab.firsttaskatbosta.presentation.albumsScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amrabdelhamiddiab.core.data.Album
import com.amrabdelhamiddiab.core.data.PhotoThum
import com.amrabdelhamiddiab.core.usecases.DownloadAlbums
import com.amrabdelhamiddiab.core.usecases.DownloadImages
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity
import com.amrabdelhamiddiab.firsttaskatbosta.MainActivity.Companion.TAG
import com.amrabdelhamiddiab.firsttaskatbosta.utilis.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val downloadAlbums: DownloadAlbums,
                                          private val downloadImages: DownloadImages) :
    ViewModel() {
    private val _listOfAlbums = SingleLiveEvent<List<Album>?>()
    val listOfAlbums: LiveData<List<Album>?> get() = _listOfAlbums

    private val _listOfPhots = SingleLiveEvent<List<PhotoThum>?>()
    val listOfPhots: LiveData<List<PhotoThum>?> get() = _listOfPhots

    private val _cardClicked = SingleLiveEvent<Boolean>()
    val cardClicked: LiveData<Boolean> get() = _cardClicked

    private val _downloading = SingleLiveEvent<Boolean>()
    val downloading: LiveData<Boolean> get() = _downloading

    private val _idOfAlbum = SingleLiveEvent<Long>()
    val idOfAlbum: LiveData<Long> get() = _idOfAlbum

    fun buttonClicked(albumId: Long) {
        _cardClicked.value = true
        _idOfAlbum.value = albumId
    }

    fun downloadAlbumsViewModel() {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            _listOfAlbums.postValue(downloadAlbums())
            _downloading.postValue(false)
        }
    }
    fun downloadPhotosViewModel(albumId: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _downloading.postValue(true)
            _listOfPhots.postValue(downloadImages(albumId))
            _downloading.postValue(false)
        }
    }
    fun search(query :String?, tempList: List<PhotoThum>){
        viewModelScope.launch(Dispatchers.IO){
            //  val listOfTempBags = listOfCategoryWomen.value
            val filteredList = tempList.filter {
                query?.let { it1 ->
                    it.title?.contains(
                        it1, true
                    )
                }!!
            }
            _listOfPhots.postValue(filteredList)
            Log.d(TAG, filteredList.toString())
        }
    }
}