package com.example.saiwaterdriver

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saiwaterdriver.databinding.FragmentHomeBinding
import com.example.saiwaterdriver.databinding.FragmentProfileBinding


class ProfilFragment : Fragment() {
    var toggleState:Boolean= true

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.btnToggle.setOnClickListener {
            if (toggleState){
                binding.idOrdersLayout.visibility = View.GONE
                toggleState = false
            }else{
                binding.idOrdersLayout.visibility = View.VISIBLE
                toggleState = true
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}