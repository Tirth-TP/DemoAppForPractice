package com.example.demoappforpractice.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demoappforpractice.model.data.PostsList
import com.example.demoappforpractice.model.network.PostService
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Tirth Patel.
 */
@Singleton
class PostRepository @Inject constructor(private val postService: PostService) {

    private val postList = MutableLiveData<PostsList>()

    val post: LiveData<PostsList>
        get() = postList

    suspend fun getPost() {

        try {
            val result = postService.getAllPost()

            if (result.body() != null) {
                postList.postValue(result.body())
            }
        } catch (e: Exception) {
            //Handle Exception here
        }

    }
}