<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Add/Edit Student Details</title>

<link
	href="${pageContext.request.contextPath}/custom/styles/custom_styles.css"
	rel="stylesheet" type="text/css" media="all" />

<script src="${pageContext.request.contextPath}/custom/jquery/jquery-1.7.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/custom/jquery/jquery.numeric.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/student.js" type="text/javascript"></script>

<script type="text/javascript">
	jQuery(function() {
		$(".integer").numeric(false, function() { alert("Integers only"); this.value = ""; this.focus(); });
	});
</script>

</head>
<body>
	<form:form id="studFormId" modelAttribute="studentAddEditForm">
	<form:hidden path="sid" id="sidId"/>
		<table class="fullBorder">
			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" id="fnameId" type="text" maxlength="20"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" id="lnameId" type="text" maxlength="20" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input path="age" id="ageId" type="text" maxlength="5" class="integer"/></td>
			</tr>

			<tr>
				<td colspan="2" class="centerAlign">
					<c:if test="${mode eq 'ADD'}">
						<input type="button" id="btnAdd" value="Add Student" onclick="javascript:addStudent();">
					</c:if>
					<c:if test="${mode eq 'EDIT'}">
						<input type="button" id="btnEdit" value="Save Student" onclick="javascript:saveStudent();">
					</c:if>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>