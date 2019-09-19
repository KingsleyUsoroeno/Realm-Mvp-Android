package com.kingtech.tasky.splash_screen


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kingtech.tasky.R
import com.kingtech.tasky.databinding.FragmentSplashScreenBinding

/**
 * A simple [Fragment] subclass.
 */
class SplashScreenFragment : Fragment() {
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		val dataBinding = DataBindingUtil.inflate<FragmentSplashScreenBinding>(
			inflater,
			R.layout.fragment_splash_screen,
			container,
			false
		)
		Handler().postDelayed({
			dataBinding.root.findNavController().navigate(R.id.action_splashScreenFragment_to_todoFragment)
		},3000)
		return dataBinding.root
	}
}
