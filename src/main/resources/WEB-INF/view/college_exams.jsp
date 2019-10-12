<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CITS : Exams</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_exams_css" value="/static/css/college_exams_css.css" />
<link href="${college_exams_css}" rel="stylesheet">
</head>
<body>
<!--============ HEADER FILE ============-->
	<c:set var="title" value="Exam Papers" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<%@include file="includes/exams-modules/exams-content-section.jsp"%>
</body>
</html>