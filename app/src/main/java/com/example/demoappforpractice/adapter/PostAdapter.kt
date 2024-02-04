package com.example.demoappforpractice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demoappforpractice.databinding.ItemPostBinding
import com.example.demoappforpractice.model.data.PostsItem
import com.example.demoappforpractice.model.data.PostsList

/**
 * Created by Tirth Patel.
 */

class PostAdapter(val postsList: PostsList, private val kFunction1: (PostsItem) -> Unit) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

    inner class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(post: PostsItem) {
            binding.txtTitle.text = post.title
            binding.txtBody.text = post.body
            binding.root.setOnClickListener {
                kFunction1(post)
            }
        }
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postsList[position]
        holder.bind(post)
    }
}