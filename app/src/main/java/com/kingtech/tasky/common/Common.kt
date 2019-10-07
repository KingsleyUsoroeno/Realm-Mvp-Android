package com.kingtech.tasky.common

import java.text.SimpleDateFormat
import java.util.*

object Common {
	
	private fun getDateFormat(): SimpleDateFormat {
		return SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH)
	}
	
	fun formatDialogDate(year: Int, month: Int, day: Int): String {
		val calendar = Calendar.getInstance()
		calendar.set(year, month, day)
		return getDateFormat().format(calendar.time)
	}
	
	fun compareDates(dateToCompare: String): Boolean {
		val currentDate = Date(System.currentTimeMillis())
		val futureDate = getDateFormat().parse(dateToCompare)
		
		val parseFDate = getDateFormat().format(futureDate!!)
		val parseTDate = getDateFormat().format(currentDate)
		
		/*Couldn't compare the both Date values as it would return false as the were not both in the
		* Same time */
		return parseTDate == parseFDate
	}
}