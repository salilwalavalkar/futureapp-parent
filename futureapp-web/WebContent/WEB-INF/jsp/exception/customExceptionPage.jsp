<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Custom Error Page #EXCEPTIONHANDLER</title>
</head>
<body>
	<b style="color: red;">A error has occurred.</b>
	<br>
	<%
		try {
			// The Servlet spec guarantees this attribute will be available
			//Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");			
			if (exception != null) {
				if (exception instanceof ServletException) {
					// It's a ServletException: we should extract the root cause
					ServletException servletException = (ServletException) exception;
					Throwable rootCause = servletException.getRootCause();
					if (rootCause == null)
						rootCause = servletException;
					out.println("** Root cause is: "
							+ rootCause.getMessage());
					rootCause.printStackTrace(new java.io.PrintWriter(out));
				} else {
					// It's not a ServletException, so we'll just show it
					exception.printStackTrace(new java.io.PrintWriter(out));
				}
			} else {
				out.println("No error information available");
			}

		} catch (Exception ex) {
			ex.printStackTrace(new java.io.PrintWriter(out));
		}
	%>
</body>
</html>
