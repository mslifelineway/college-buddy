<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>blog list details</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="show_single_blog_content_css" value="/static/css/show_single_blog_content_css.css" />
<link href="${show_single_blog_content_css}" rel="stylesheet">
<s:url var="action_icon_list"
	value="/static/css/action-icon-list-css.css" />
<link href="${action_icon_list}" rel="stylesheet">
</head>
<body style="padding: 0px;">

	<%-- ========================> HEADER PART <========================= --%>
	<c:set var="title" value="Blogs" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<%@include file="includes/blog-modules/show-single-blog-content-section.jsp"%>

</body>
</html>