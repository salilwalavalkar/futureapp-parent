package com.salil.futureapp.web.form.student;

import com.salil.futureapp.web.form.IForm;

public class StudentListForm implements IForm {

	private static final long serialVersionUID = 3586057424936839883L;

	private String selectedSid;
	
	private String actionPerformed;


	public String getActionPerformed() {
		return actionPerformed;
	}

	public void setActionPerformed(String actionPerformed) {
		this.actionPerformed = actionPerformed;
	}

	public String getSelectedSid() {
		return selectedSid;
	}

	public void setSelectedSid(String selectedSid) {
		this.selectedSid = selectedSid;
	}

}
