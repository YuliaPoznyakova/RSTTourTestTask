package com.nrp.rsttourtesttask

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.nrp.rsttourtesttask.model.Blog
import com.nrp.rsttourtesttask.model.BlogCard
import com.nrp.rsttourtesttask.model.ContentItem
import com.nrp.rsttourtesttask.network.NetworkImageComponentPicasso

class LiveDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
fun LiveDataComponent(blogListLiveData: LiveData<List<BlogCard>>) {
    val blogList by blogListLiveData.observeAsState(initial = emptyList())
    if (blogList.isEmpty()) {
        LiveDataLoadingComponent()
    } else {
        LiveDataComponentList(blogList)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LiveDataComponentList(blogList: List<BlogCard>) {
    LazyColumn {
        items(
            items = blogList, itemContent = { blogCard ->
                Card(
                    shape = RoundedCornerShape(4.dp),
                    backgroundColor = Color.White,
                    modifier = Modifier.fillParentMaxWidth().padding(8.dp)
                ) {
                    ListItem(text = {
                        Text(
                            text = blogCard.title,
                            style = TextStyle(
                                fontFamily = FontFamily.Serif, fontSize = 25.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }, icon = {
                        blogCard.image.medium.let { imageUrl ->
                            NetworkImageComponentPicasso(
                                url = imageUrl,
                                modifier = Modifier.width(60.dp).height(60.dp)
                            )
                        }
                    })
                }
            })
    }
}

@Composable
fun LiveDataLoadingComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(modifier = Modifier.wrapContentWidth(CenterHorizontally))
    }
}
