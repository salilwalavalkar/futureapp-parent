package com.salil.futureapp.service.intf;

import java.util.Date;

import com.salil.futureapp.service.base.IService;

/**
 * This is a non-auto wired service interface example.
 * 
 * @author salil
 * @version 1.0
 */
public interface INonAutoWRService extends IService {

	Date getDateTomorrow();

}
