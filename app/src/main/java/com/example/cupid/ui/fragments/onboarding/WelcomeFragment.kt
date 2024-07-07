package com.example.cupid.ui.fragments.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.cupid.R
import com.example.cupid.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

private lateinit var binding: FragmentWelcomeBinding
  override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment3_to_signInFragment)
        }
      binding.btnSignUp.setOnClickListener {
          it.findNavController().navigate(R.id.action_welcomeFragment3_to_signUpFragment2)
      }
      return binding.root
    }


}