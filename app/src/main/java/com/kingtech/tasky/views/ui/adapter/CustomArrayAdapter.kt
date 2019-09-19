package com.kingtech.tasky.views.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.kingtech.tasky.R


class CustomArrayAdapter(private val ctx: Context, private val items: List<String>) :
	ArrayAdapter<String>(ctx, 0, items) {
	
	override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
		var layoutView = convertView
		if (layoutView == null) {
			val inflater =
				context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
			layoutView = inflater.inflate(R.layout.layout_spinner, null)
		}
		val adapterContent = getItem(position)
		if (adapterContent != null) {
			//val spinnerTxt = layoutView!!.findViewById<TextView>(R.id.spinner_text_view)
			//spinnerTxt.text = adapterContent
		}
		
		return layoutView!!
	}
	
}
