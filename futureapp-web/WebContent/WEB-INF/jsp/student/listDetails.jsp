<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Custom Tag Library - #CUSTOMTAGLIBRARY - Start -->
<%@taglib prefix="customDt" uri="/WEB-INF/tld/CustomDateTagLib.tld"%>
<!-- Custom Tag Library - #CUSTOMTAGLIBRARY - End -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Student List Details</title>

<link
	href="${pageContext.request.contextPath}/custom/styles/custom_styles.css"
	rel="stylesheet" type="text/css" media="all" />

<script src="${pageContext.request.contextPath}/js/student.js" type="text/javascript"></script>

</head>
<body>
	<form:form id="studentListFormId" modelAttribute="studentListForm">
	<form:hidden path="actionPerformed" id="actionPerformedId"/>
	<form:hidden path="selectedSid" id="selectedSidId"/>
		<table class="fullBorder">
			<tr>
				<th>SID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Date Created</th>
				<th>Date Modified</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<tr>
				<c:choose>
						<c:when
							test="${(studentList ne null) && (fn:length(studentList) gt 0)}">
							<c:forEach items="${studentList}" var="studItem"
								varStatus="studItemStatus">
								<tr id="stud_row_${studItemStatus.index}">
									<td>${studItem.studId}</td>
									<td>${studItem.firstName}</td>
									<td>${studItem.lastName}</td>
									<td>${studItem.age}</td>
									<!-- Custom Tag Library - #CUSTOMTAGLIBRARY - Start  -->
									<td><customDt:fmtDate input="${studItem.dateCreated}" javaTimeZone="Asia/Calcutta" timeZoneDesc="Indian Standard Time"/></td>
									<td><customDt:fmtDate input="${studItem.dateModified}" javaTimeZone="Asia/Calcutta" timeZoneDesc="Indian Standard Time"/></td>
									<!-- Custom Tag Library - #CUSTOMTAGLIBRARY - End  -->
									<td width="10%" class="centerAlign"><a href="javascript:void(0);" onclick="javascript:showEditStudentScreen('${studItem.studId}');">E</a></td>
									<td width="10%" class="centerAlign"><a href="javascript:void(0);" onclick="javascript:deleteStudent('${studItem.studId}');">D</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td align="center" colspan="8"><span style="color: red;">No Records Found</span></td>
						</tr>
					</c:otherwise>
				</c:choose>
		</tr>
			<tr>
				<td colspan="8" class="centerAlign"><input type="button"
					id="btnAdd" value="Add Student" onclick="javascript:showAddStudentScreen();">&nbsp;<input type="button"
					id="btnRefresh" value="Refresh" onclick="javascript:refreshScreen();"></td>
			</tr>
		</table>
	</form:form>	
</body>
</html>