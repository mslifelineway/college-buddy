<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Workshops</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_workshops_css"
	value="/static/css/college_workshops.css" />
<link href="${college_workshops_css}" rel="stylesheet">
</head>
<body>
	<%-- ========================> HEADER PART <========================= --%>
	<%@include file="includes/workshop-modules/workshop-header.jsp"%>
	<%-- ========================> CONTENT PART <========================= --%>
	<%@include
		file="includes/workshop-modules/workshop-content-section.jsp"%>
</body>
</html>