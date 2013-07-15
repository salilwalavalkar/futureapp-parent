package com.salil.futureapp.service.impl;

import java.util.Calendar;
import java.util.Date;

import com.salil.futureapp.service.intf.INonAutoWRService;

/**
 * This is non-auto wired service class implementation example.
 * 
 * @author salil
 * @version 1.0.0
 */
public class NonAutoWRService implements INonAutoWRService {

	public Date getDateTomorrow() {
		Date now = new Date();  
		Calendar cal = Calendar.getInstance();  
		cal.setTime(now);  
		cal.add(Calendar.DAY_OF_YEAR, 1);  
		return cal.getTime();  	
	}
}
