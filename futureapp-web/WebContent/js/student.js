/* Trim function - Start */
String.prototype.trim = function() {
	return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
};
/* Trim function - End */

function submitForm(formId, actionURL, method) {
	var formElement = document.getElementById(formId);
	formElement.action = actionURL;
	formElement.method = method;
	formElement.submit();
}

function showAddStudentScreen()
{
	submitForm("studentListFormId", "../student/showAddStudentScreen", "GET");
}

function showEditStudentScreen(id) {
	document.getElementById("selectedSidId").value = id;
	submitForm("studentListFormId", "../student/showEditStudentScreen", "POST");
}

function addStudent()
{
	if(validateStudentDetails())
	{
		submitForm("studFormId", "../student/addStudentDetails", "POST");
	}
}

function saveStudent()
{
	if(validateStudentDetails())
	{
		submitForm("studFormId", "../student/saveStudentDetails", "POST");
	}
}

function deleteStudent(id) {

	var r=confirm("Are you sure you want to delete student: " + id + " ?");
	if (r == true) {
		document.getElementById("selectedSidId").value = id;
		submitForm("studentListFormId", "../student/deleteStudent", "POST");
	} else {
		alert("Student deletion cancelled");
	}	
}

function refreshScreen()
{
	submitForm("studentListFormId", "../student/listDetails", "GET");
}

function chkIfValueIsNull(id) {
	if (document.getElementById(id).value.trim() == '') {
		return true;
	}
	return false;
}

function validateStudentDetails()
{
	if(chkIfValueIsNull("fnameId"))
	{
		alert("First name is mandatory");
		return false;
	}
	if(chkIfValueIsNull("lnameId"))
	{
		alert("Last name is mandatory");
		return false;
	}
	if(chkIfValueIsNull("ageId"))
	{
		alert("Age is mandatory");
		return false;
	}
	return true;
}