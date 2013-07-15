package com.salil.futureapp.dao.intf;

import java.util.List;

import com.salil.futureapp.base.exception.BaseException;
import com.salil.futureapp.dao.base.IDao;
import com.salil.futureapp.dao.entity.StudentEVO;

/**
 * Student Dao Interface
 * 
 * @author salil
 * @version 1.0
 */
public interface IStudentDao extends IDao {

	List<StudentEVO> getStudentList(final String sid) throws BaseException;
	
	void addStudent(final StudentEVO evo) throws BaseException;
	
	void deleteStudent(final String sid) throws BaseException;
	
	void saveStudent(final StudentEVO evo) throws BaseException;
	
	StudentEVO loadStudent(final String sid) throws BaseException;
}
