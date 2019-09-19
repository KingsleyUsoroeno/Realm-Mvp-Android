package com.kingtech.tasky.views.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.kingtech.tasky.R
import com.kingtech.tasky.databinding.FragmentTodoBinding
import com.kingtech.tasky.views.ui.adapter.TodoAdapter
import com.kingtech.tasky.views.todo.presenter.RealmControllerImpl

/**
 * A simple [Fragment] subclass.
 */
class TodoFragment : Fragment(){
	
	private lateinit var realmControllerImpl: RealmControllerImpl
	private lateinit var dataBinding: FragmentTodoBinding
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setHasOptionsMenu(true)
		realmControllerImpl = RealmControllerImpl()
	}
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment using DataBinding
		dataBinding = DataBindingUtil.inflate(
			inflater, R.layout.fragment_todo, container,
			false
		)
		
		dataBinding.fab.setOnClickListener {
			addTask()
		}
		
		setUpRecyclerView()
		return dataBinding.root
	}
	
	private fun addTask() {
		dataBinding.root.findNavController().navigate(R.id.action_todoFragment_to_addTodoFragment)
	}
	
	private fun setUpRecyclerView() {
		val todo = realmControllerImpl.getAllTodo()
		if (todo.size > 0) {
			dataBinding.taskList.setHasFixedSize(true)
			dataBinding.taskList.adapter = TodoAdapter(todo)
			dataBinding.taskList.addItemDecoration(DividerItemDecoration(this.context,1))
			dataBinding.tvNoTodo.visibility = View.GONE
		} else {
			dataBinding.tvNoTodo.visibility = View.VISIBLE
			dataBinding.taskList.visibility = View.GONE
		}
	}
	
	override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
		super.onCreateOptionsMenu(menu, inflater)
	}
	
	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		return super.onOptionsItemSelected(item)
	}
}
