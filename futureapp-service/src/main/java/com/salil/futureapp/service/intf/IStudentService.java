package com.salil.futureapp.service.intf;

import java.util.List;

import com.salil.futureapp.base.exception.BaseException;
import com.salil.futureapp.model.StudentDetails;
import com.salil.futureapp.service.base.IService;

/**
 * This is an Autowired student service interface example.
 * 
 * @author salil
 * @version 1.0
 */
public interface IStudentService extends IService {

	List<StudentDetails> getStudentList(final String sid) throws BaseException;
	
	void addStudentDetails(StudentDetails studentDetails) throws BaseException;
	
	void deleteStudent(final String sid) throws BaseException;
	
	void saveStudentDetails(StudentDetails studentDetails) throws BaseException;
}
