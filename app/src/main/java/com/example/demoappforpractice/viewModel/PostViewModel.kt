package com.example.demoappforpractice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demoappforpractice.model.data.PostsList
import com.example.demoappforpractice.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Tirth Patel.
 */
@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    val post: LiveData<PostsList>
        get() = postRepository.post

    fun getPost() {
        viewModelScope.launch(Dispatchers.IO) {
            postRepository.getPost()
        }
    }

}