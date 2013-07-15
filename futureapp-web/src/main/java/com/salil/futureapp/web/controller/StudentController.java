package com.salil.futureapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salil.futureapp.base.exception.BaseException;
import com.salil.futureapp.base.util.FutureUtil;
import com.salil.futureapp.model.StudentDetails;
import com.salil.futureapp.service.intf.IStudentService;
import com.salil.futureapp.web.form.student.StudentAddEditForm;
import com.salil.futureapp.web.form.student.StudentListForm;

/**
 * #SPRING
 * @author salil
 */
@Controller
@RequestMapping("/student/*")
public class StudentController extends AbstractController {

	@Autowired
	private IStudentService studentService;

	private static final String VIEW_PREFIX = "student";

	private enum modes
	{
	    ADD, EDIT;
	}
	
    private static Logger LOGGER = LoggerFactory
            .getLogger(StudentController.class);

	@RequestMapping(method = RequestMethod.GET, value = "listDetails")
	public ModelAndView getAllStudentListView() throws BaseException {
		LOGGER.debug("Load Student List - Start");
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/listDetails");
		List<StudentDetails> studentList = studentService.getStudentList(null);
		view.addObject("studentListForm", new StudentListForm());
		view.addObject("studentList", studentList);
		LOGGER.debug("Load Student List - End");
		return view;
	}

	@RequestMapping(method = RequestMethod.GET, value = "showAddStudentScreen")
	public ModelAndView showAddStudentScreen() throws BaseException {
		ModelAndView view = new ModelAndView(VIEW_PREFIX + "/addEditStudentDetails");
		StudentAddEditForm student = new StudentAddEditForm();
		view.addObject("mode", modes.ADD.toString());
		view.addObject("studentAddEditForm", student);
		return view;
	}

	@RequestMapping(method = RequestMethod.POST, value = "showEditStudentScreen")
	public ModelAndView showEditStudentScreen(final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("studentListForm") StudentListForm studentListForm)
			throws BaseException {
		ModelAndView view = new ModelAndView(VIEW_PREFIX
				+ "/addEditStudentDetails");
		List<StudentDetails> studentList = studentService.getStudentList(studentListForm.getSelectedSid());
		StudentAddEditForm student = convertToForm(studentList.get(0));
		view.addObject("mode", modes.EDIT.toString());
		view.addObject("studentAddEditForm", student);
		return view;
	}
	
	private StudentAddEditForm convertToForm(StudentDetails studentDetails) {
		StudentAddEditForm form = new StudentAddEditForm();
		form.setSid(studentDetails.getStudId());
		form.setFirstName(studentDetails.getFirstName());
		form.setLastName(studentDetails.getLastName());
		form.setAge(String.valueOf(studentDetails.getAge()));
		return form;
	}

	@RequestMapping(method = RequestMethod.POST, value = "addStudentDetails")
	public ModelAndView addStudentDetails(final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("studentAddEditForm") StudentAddEditForm studentAddEditForm)
			throws BaseException {
		studentService.addStudentDetails(convertToModel(studentAddEditForm));
		return getAllStudentListView();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "saveStudentDetails")
	public ModelAndView saveStudentDetails(final HttpServletRequest request,
			final HttpServletResponse response,
			@ModelAttribute("studentAddEditForm") StudentAddEditForm studentAddEditForm)
			throws BaseException {
		studentService.saveStudentDetails(convertToModel(studentAddEditForm));
		return getAllStudentListView();
	}


	private StudentDetails convertToModel(StudentAddEditForm form) {
		StudentDetails model = new StudentDetails();
		model.setFirstName(form.getFirstName());
		model.setLastName(form.getLastName());
		model.setAge(Integer.valueOf(form.getAge()));
		
		/*
		 * In edit mode, sid will be present. 
		 */
		if(!FutureUtil.isEmptyOrBlank(form.getSid()))
		{
			model.setStudId(form.getSid());
		}
		
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "deleteStudent")
	public ModelAndView deleteStudent(final HttpServletRequest request,
			final HttpServletResponse response, 
			@ModelAttribute("studentListForm") StudentListForm studentListForm)
			throws BaseException {
		studentService.deleteStudent(studentListForm.getSelectedSid());
		return getAllStudentListView();
	}
	
}