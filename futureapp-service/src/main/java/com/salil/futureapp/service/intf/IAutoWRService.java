package com.salil.futureapp.service.intf;

import java.util.Date;

import com.salil.futureapp.service.base.IService;

/**
 * This is an Autowired service interface example.
 * 
 * @author salil
 * @version 1.0
 */
public interface IAutoWRService extends IService {

	Date getDateToday();
}
