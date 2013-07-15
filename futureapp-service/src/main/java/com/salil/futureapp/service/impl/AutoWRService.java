package com.salil.futureapp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salil.futureapp.dao.intf.ICommonDao;
import com.salil.futureapp.service.intf.IAutoWRService;

/**
 * This is an Autowired service class implementation example.
 * 
 * @author salil
 * @version 1.0.0
 */
@Service
public class AutoWRService implements IAutoWRService {

	@Autowired
	private ICommonDao commonDao;

	public Date getDateToday() {
		return new Date();
	}
}
