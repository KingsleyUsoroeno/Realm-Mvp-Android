package com.kingtech.tasky.views.todo


import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kingtech.tasky.R
import com.kingtech.tasky.data.model.Todo
import com.kingtech.tasky.databinding.FragmentViewTodoBinding
import com.kingtech.tasky.views.todo.presenter.ViewTodo
import com.kingtech.tasky.views.todo.presenter.ViewTodoFragmentImpl
import com.kingtech.tasky.views.ui.fragment.TodoFragment

/**
 * A simple [Fragment] subclass.
 */
class ViewTodoFragment : Fragment(), ViewTodo {
	
	private lateinit var viewBinding: FragmentViewTodoBinding
	private lateinit var todoPresenter: ViewTodoFragmentImpl
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		viewBinding = DataBindingUtil.inflate(
			inflater,
			R.layout.fragment_view_todo,
			container,
			false
		)
		
		todoPresenter = ViewTodoFragmentImpl(this)
		
		val todo = arguments?.getParcelable<Todo>(TodoFragment.TODO)
		todo?.let {
			Log.i("ViewTodoFrag", "Bundled Todo is $todo")
			if (it.reminder) {
				viewBinding.alarmState.text = getString(R.string.reminder_alarm_is_on)
				val wrappedDrawable = DrawableCompat.wrap(viewBinding.imgReminder.drawable)
				DrawableCompat.setTint(wrappedDrawable, Color.BLUE)
			} else {
				viewBinding.alarmState.text = getString(R.string.reminder_alarm_is_off)
				val wrappedDrawable = DrawableCompat.wrap(viewBinding.imgReminder.drawable)
				DrawableCompat.setTint(wrappedDrawable, Color.BLACK)
			}
			viewBinding.todo = it
			viewBinding.executePendingBindings()
		}
		
		viewBinding.imgDelete.setOnClickListener {
			todoPresenter.deleteTodo(todo!!.id)
		}
		
		return viewBinding.root
	}
	
	override fun navigate(destination: Int) {
		viewBinding.root.findNavController().navigate(destination)
	}
	
	override fun showMessage(msg: String) {
		Toast.makeText(context!!, msg, Toast.LENGTH_LONG).show()
	}
}
