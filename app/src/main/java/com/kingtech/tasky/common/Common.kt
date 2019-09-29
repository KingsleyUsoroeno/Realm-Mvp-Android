package com.kingtech.tasky.common

import java.text.SimpleDateFormat
import java.util.*

object Common {
	
	fun formateDialogDate(year: Int, month: Int, day: Int): String {
		val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
		val calendar = Calendar.getInstance()
		calendar.set(year, month, day)
		return dateFormat.format(calendar.time)
	}
}