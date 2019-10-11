<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Announcements</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_announcement_css"
	value="/static/css/college_announcement.css" />
<link href="${college_announcement_css}" rel="stylesheet">
</head>
<body>
	<!--============ HEADER FILE ============-->
	<c:set var="title" value="Announcement" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<!--============ CONTENT FILE ============-->
	<%@include file="includes/announcement-modules/announcement-content-section.jsp"%>
</body>
</html>