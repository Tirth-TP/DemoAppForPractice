package com.example.demoappforpractice.model.network

import com.example.demoappforpractice.model.data.PostsList
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Tirth Patel.
 */
interface PostService {

    @GET("/posts")
    suspend fun getAllPost(): Response<PostsList>
}