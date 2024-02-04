package com.example.demoappforpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demoappforpractice.databinding.FragmentDetailsBinding
import com.example.demoappforpractice.model.data.PostsItem
import com.google.gson.Gson

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    val binding get() = _binding!!

    private var postItem: PostsItem? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val json = arguments?.getString("post")
        postItem = Gson().fromJson(json, PostsItem::class.java)
        postItem?.let {
            binding.textTitle.text = it.title
            binding.textId.text = it.id.toString()
            binding.textUserId.text = it.userId.toString()
            binding.textBody.text = it.body
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}