package com.kingtech.tasky.views.todo


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.kingtech.tasky.R
import com.kingtech.tasky.databinding.FragmentViewTodoBinding
import com.kingtech.tasky.views.ui.fragment.TodoFragment

/**
 * A simple [Fragment] subclass.
 */
class ViewTodoFragment : Fragment() {
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		val viewBinding = DataBindingUtil.inflate<FragmentViewTodoBinding>(
			inflater,
			R.layout.fragment_view_todo,
			container,
			false
		)
		
		val todo = arguments?.getParcelable<Todo>(TodoFragment.TODO)
		todo?.let {
			Log.i("ViewTodoFrag", "Bundled Todo is $todo")
			viewBinding.todo = it
			viewBinding.executePendingBindings()
		}
		viewBinding.imgDelete.setOnClickListener {
		
		}
		
		return viewBinding.root
	}
	
	
}
