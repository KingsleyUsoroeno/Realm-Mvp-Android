package com.kingtech.tasky.views.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.kingtech.tasky.R
import com.kingtech.tasky.databinding.FragmentTodoBinding
import com.kingtech.tasky.views.todo.Todo
import com.kingtech.tasky.views.ui.adapter.TodoAdapter
import io.realm.RealmResults

/**
 * A simple [Fragment] subclass.
 */
class TodoFragment : Fragment(), TodoView, TodoAdapter.OnTodoClickListener {
	
	companion object {
		const val TODO = "todo"
	}
	
	private lateinit var dataBinding: FragmentTodoBinding
	private lateinit var todoPresenter: TodoPresenter
	private var allTodo: RealmResults<Todo>? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setHasOptionsMenu(true)
		todoPresenter = TodoPresenter(this)
		todoPresenter.getAllSavedTodo()
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
		allTodo?.let {
			setUpRecyclerView(it)
			
		}
		return dataBinding.root
	}
	
	private fun addTask() {
		todoPresenter.navigate(R.id.action_todoFragment_to_addTodoFragment, null)
	}
	
	private fun setUpRecyclerView(todo: RealmResults<Todo>) {
		if (todo.isNotEmpty()) {
			val todoAdapter = TodoAdapter(todo)
			dataBinding.taskList.setHasFixedSize(true)
			dataBinding.taskList.adapter = todoAdapter
			todoAdapter.setOnItemClickListener(this)
			dataBinding.taskList.addItemDecoration(DividerItemDecoration(this.context, 1))
			dataBinding.tvNoTodo.visibility = View.GONE
		} else {
			dataBinding.tvNoTodo.visibility = View.VISIBLE
			dataBinding.taskList.visibility = View.GONE
		}
	}
	
	override fun navigate(destination: Int, arg: Bundle?) {
		dataBinding.root.findNavController().navigate(destination, arg)
	}
	
	override fun setTodo(todo: RealmResults<Todo>) {
		allTodo = todo
	}
	
	override fun onTodoClicked(todo: Todo) {
		val bundle = Bundle()
		bundle.putParcelable(TODO, todo)
		todoPresenter.navigate(R.id.action_todoFragment_to_viewTodoFragment, bundle)
	}
}
