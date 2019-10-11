<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Magazines</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_magazines_css" value="/static/css/college_magazines_css.css" />
<link href="${college_magazines_css}" rel="stylesheet">
</head>
<body>
	<!--============ HEADER FILE ============-->
	<c:set var="title" value="Magazines/Novels/Books" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<%@include file="includes/magazines-modules/magazines-content-section.jsp"%>
</body>
</html>