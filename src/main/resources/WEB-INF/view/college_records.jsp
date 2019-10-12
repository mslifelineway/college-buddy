<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CITS : Records</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_records_css" value="/static/css/college_records_css.css" />
<link href="${college_records_css}" rel="stylesheet">
</head>
<body>
<!--============ HEADER FILE ============-->
	<c:set var="title" value="Records" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<%@include file="includes/record-modules/record-content-section.jsp"%>
</body>
</html>