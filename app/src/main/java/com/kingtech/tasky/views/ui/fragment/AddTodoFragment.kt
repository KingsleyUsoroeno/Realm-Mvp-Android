package com.kingtech.tasky.views.ui.fragment


import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.kingtech.tasky.R
import com.kingtech.tasky.common.Common
import com.kingtech.tasky.data.model.Todo
import com.kingtech.tasky.databinding.FragmentAddTodoBinding
import com.kingtech.tasky.views.todo.presenter.TodoFragmentImpl
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class AddTodoFragment : Fragment(), UserView, AdapterView.OnItemSelectedListener,
	DatePickerDialog.OnDateSetListener {
	
	private lateinit var todoFragmentBinding: FragmentAddTodoBinding
	private lateinit var addTodoImpl: TodoFragmentImpl
	private var selectedCategory = ""
	private var dueDate = ""
	private val TAG = "AddTodoFragment"
	private var isReminderEnabled = false
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		todoFragmentBinding =
			DataBindingUtil.inflate(inflater, R.layout.fragment_add_todo, container, false)
		addTodoImpl = TodoFragmentImpl(this, false)
		
		todoFragmentBinding.btnSave.setOnClickListener {
			addTodoImpl.onSaveClicked()
		}
		
		todoFragmentBinding.imgCalendar.setOnClickListener {
			showDatePicker()
		}
		
		todoFragmentBinding.imgNotification.setOnClickListener {
			addTodoImpl.setToggle()
		}
		
		setUpSpinnerCategoryAdapter()
		return todoFragmentBinding.root
	}
	
	private fun setUpSpinnerCategoryAdapter() {
		val categories = getStringResourceArray()
		val adapter = ArrayAdapter<String>(this.context!!, R.layout.layout_spinner, categories)
		todoFragmentBinding.catSpinner.onItemSelectedListener = this
		todoFragmentBinding.catSpinner.adapter = adapter
	}
	
	override fun getTodo(): Todo {
		var priority = 0
		val id = System.currentTimeMillis().toInt()
		val name = todoFragmentBinding.edtName.text.toString()
		val desc = todoFragmentBinding.edtDescription.text.toString()
		val priorityText = todoFragmentBinding.edtPriority.text.toString()
		if (priorityText.isNotEmpty()) {
			priority = priorityText.toInt()
		}
		Log.i(TAG, "Reminder is $isReminderEnabled")
		return Todo(id, name, desc, priority, selectedCategory, dueDate, isReminderEnabled)
	}
	
	private fun showDatePicker() {
		val calendar = Calendar.getInstance()
		val year = calendar.get(Calendar.YEAR)
		val month = calendar.get(Calendar.MONTH)
		val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
		val datePicker = DatePickerDialog(this.context!!, this, year, month, dayOfMonth)
		datePicker.datePicker.minDate = System.currentTimeMillis()
		datePicker.show()
	}
	
	
	override fun showInputIsRequired() {
		showMsg("Somethings Missing")
	}
	
	override fun getStringResourceArray(): List<String> {
		return context!!.resources.getStringArray(R.array.all_task).asList()
	}
	
	override fun showMsg(msg: String) {
		Toast.makeText(context!!, msg, Toast.LENGTH_LONG).show()
	}
	
	override fun navigateTo(destination: Int) {
		todoFragmentBinding.root.findNavController().navigate(destination)
	}
	
	override fun showEnabledReminder(isEnabled: Boolean, color: Int) {
		val wrappedDrawable = DrawableCompat.wrap(todoFragmentBinding.imgNotification.drawable)
		DrawableCompat.setTint(wrappedDrawable, ContextCompat.getColor(context!!, color))
		isReminderEnabled = isEnabled
	}
	
	override fun showDisabledReminder(isEnabled: Boolean, color: Int) {
		val wrappedDrawable = DrawableCompat.wrap(todoFragmentBinding.imgNotification.drawable)
		DrawableCompat.setTint(wrappedDrawable, ContextCompat.getColor(context!!, color))
		isReminderEnabled = isEnabled
	}
	
	override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
		selectedCategory = getStringResourceArray()[position]
		
	}
	
	override fun onNothingSelected(parent: AdapterView<*>) {
		// Another interface callback
	}
	
	override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
		dueDate = Common.formatDialogDate(year, month, day)
	}
}
