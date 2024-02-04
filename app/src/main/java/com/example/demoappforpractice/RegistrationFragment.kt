package com.example.demoappforpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.demoappforpractice.databinding.FragmentRegistrationBinding
import com.example.demoappforpractice.viewModel.PostViewModel

class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)

        binding.btnRegistration.setOnClickListener {
            findNavController().navigate(R.id.action_registrationFragment_to_mainFragment)
        }
        return binding.root
    }
}