<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>College Profile</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_profile_css"
	value="/static/css/college_profile_css.css" />
<link href="${college_profile_css}" rel="stylesheet">
<s:url var="college_profile_css"
	value="/static/css/college_profile_css.css" />
<link href="${college_profile_css}" rel="stylesheet">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	%>
	<%-- ========================> HEADER PART <========================= --%>
	<%@include file="includes/college-modules/college-header.jsp"%>
	<%-- ========================> CONTENT PART <========================= --%>
	<%@include file="includes/college-modules/college-content-section.jsp"%>
</body>
</html>