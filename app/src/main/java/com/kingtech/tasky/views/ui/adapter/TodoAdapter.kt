package com.kingtech.tasky.views.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.kingtech.tasky.R
import com.kingtech.tasky.views.todo.Todo
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults

class TodoAdapter(private val todo: RealmResults<Todo>) :
	RealmRecyclerViewAdapter<Todo, TodoAdapter.ViewHolder>(todo, true) {
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_todos,parent,false)
		return ViewHolder(view)
	}
	
	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val todo = todo[position]
		todo?.let { holder.bindViews(it) }
	}
	
	class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		private val tvTodoName = itemView.findViewById<AppCompatTextView>(R.id.tv_todoName)
		private val tvTodoDate = itemView.findViewById<AppCompatTextView>(R.id.tv_todo_description)
		private val tvPriority = itemView.findViewById<AppCompatTextView>(R.id.tv_priority)
		
		fun bindViews(todo : Todo){
			tvTodoName.text = todo.name
			tvPriority.text = todo.priority.toString()
			tvTodoDate.text = todo.desciption
		}
	}
}