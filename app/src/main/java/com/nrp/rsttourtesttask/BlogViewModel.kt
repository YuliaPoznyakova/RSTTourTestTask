package com.nrp.rsttourtesttask

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nrp.rsttourtesttask.Api.retrofitService
import com.nrp.rsttourtesttask.model.BlogCard
import com.nrp.rsttourtesttask.model.ContentItem
import kotlinx.coroutines.*

class BlogViewModel : ViewModel() {

    private val _blogObjects = MutableLiveData<List<BlogCard>>()
    val blogObjects: LiveData<List<BlogCard>> = _blogObjects

    init {
        loadMain()
    }

    private fun loadMain() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = retrofitService.getMain()
            withContext(Dispatchers.IO) {
                if (response.isSuccessful) {
                    val blogItem =
                        response.body()?.data!!.content.firstOrNull { it.template.type == "blog" }
                    blogItem.let {
                        val blogResponse = retrofitService.getBlogCards(it!!.url)
                        withContext(Dispatchers.Main) {
                            _blogObjects.value = blogResponse.body()?.data!!
                        }
                    }
                }
            }
        }
    }
}
