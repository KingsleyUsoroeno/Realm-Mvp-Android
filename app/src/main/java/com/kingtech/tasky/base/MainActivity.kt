package com.kingtech.tasky.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kingtech.tasky.R
import com.kingtech.tasky.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		val activityMainBinding =
			DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
		
		setSupportActionBar(activityMainBinding.appToolbar)
	}
}
