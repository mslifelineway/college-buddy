<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Discussion Room</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="discussion_room_css" value="/static/css/discussion_room_css.css" />
<link href="${discussion_room_css}" rel="stylesheet">
</head>
<body>
	<!--============ HEADER FILE ============-->
	<c:set var="title" value="Discussion Room" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<!--============ CONTENT FILE ============-->
	<%@include file="includes/discussion-room-modules/discussion-room-content-section.jsp"%>
</body>
</html>