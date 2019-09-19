package com.kingtech.tasky.views.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kingtech.tasky.R
import com.kingtech.tasky.databinding.FragmentAddTodoBinding
import com.kingtech.tasky.views.todo.Todo
import com.kingtech.tasky.views.todo.presenter.RealmControllerImpl

/**
 * A simple [Fragment] subclass.
 */
class AddTodoFragment : Fragment(), UserView {
	
	private lateinit var todoFragmentBinding: FragmentAddTodoBinding
	private lateinit var addTodoImpl: TodoFragmentImpl
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		todoFragmentBinding =
			DataBindingUtil.inflate(inflater, R.layout.fragment_add_todo, container, false)
		addTodoImpl = TodoFragmentImpl(this, RealmControllerImpl())
		
		todoFragmentBinding.btnSave.setOnClickListener {
			addTodoImpl.onSaveClicked()
		}
		
		val categories = getStringResourceArray()
		val adapter = ArrayAdapter<String>(this.context!!, R.layout.layout_spinner, categories)
		todoFragmentBinding.catSpinner.adapter = adapter
		
		return todoFragmentBinding.root
	}
	
	override fun getTodo(): Todo {
		var priority = 0
		val id = System.currentTimeMillis().toInt()
		val name = todoFragmentBinding.edtName.text.toString()
		val desc = todoFragmentBinding.edtDescription.text.toString()
		val priorityText = todoFragmentBinding.edtPriority.text.toString()
		val dueDate = "23 Feb 2019"
		if (priorityText.isNotEmpty()) {
			priority = priorityText.toInt()
		}
		return Todo(id, name, desc, priority, dueDate)
	}
	
	override fun showUserNotSavedMessage() {
		showMsg("Error saving your Todo please try again")
	}
	
	override fun showInputIsRequired() {
		showMsg("Somethings Missing")
	}
	
	override fun getStringResourceArray(): List<String> {
		return context!!.resources.getStringArray(R.array.all_task).asList()
	}
	
	private fun showMsg(msg: String) {
		Toast.makeText(context!!, msg, Toast.LENGTH_LONG).show()
	}
	
	override fun showUserSavedMsg() {
		showMsg("Todo Saved Successfully")
	}
	
	override fun navigateTo(destination: Int) {
		todoFragmentBinding.root.findNavController().navigate(destination)
	}
}
