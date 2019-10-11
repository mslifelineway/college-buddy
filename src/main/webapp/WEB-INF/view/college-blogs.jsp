<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blogs</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_blogs_css" value="/static/css/college_blogs_css.css" />
<link href="${college_blogs_css}" rel="stylesheet">
<s:url var="action_icon_list"
	value="/static/css/action-icon-list-css.css" />
<link href="${action_icon_list}" rel="stylesheet">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	%>
	<!--============ HEADER FILE ============-->
	<c:set var="title" value="Blogs" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<%-- ========================> CONTENT PART <========================= --%>
	<%@include file="includes/blog-modules/blog-content-section.jsp"%>
</body>
</html>