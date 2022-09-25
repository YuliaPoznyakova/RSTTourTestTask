package com.nrp.rsttourtesttask

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.nrp.rsttourtesttask.Api.retrofitService
import com.nrp.rsttourtesttask.model.Blog
import com.nrp.rsttourtesttask.model.ContentItem
import com.nrp.rsttourtesttask.model.Main
import com.nrp.rsttourtesttask.model.MainData
import kotlinx.coroutines.*

class BlogViewModel : ViewModel() {

    private val _blogObjects = MutableLiveData<List<ContentItem>>()
    val blogObjects: LiveData<List<ContentItem>> = _blogObjects



    init {
        loadMain()
    }

    private fun loadMain() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofitService.getMain()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    _blogObjects.value = response.body()?.data!!.content
                    retrofitService.getBlogCards(response.body()?.data!!.content.)
                } else {
                    Log.e("RETROFIT_ERROR", response.code().toString())
                }
            }
        }
    }
    }
