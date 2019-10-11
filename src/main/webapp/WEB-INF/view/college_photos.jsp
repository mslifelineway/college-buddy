<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CITS : Photos</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_photots_css" value="/static/css/college_photos_css.css" />
<link href="${college_photots_css}" rel="stylesheet">
</head>
<body>
<!--============ HEADER FILE ============-->
	<c:set var="title" value="Photos" />
	<%@include file="includes/home-modules/home-header.jsp" %>
	<%@include file="includes/college-photos-modules/college-photos-content-section.jsp"%>
</body>
</html>