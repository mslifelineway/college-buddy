<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="college_quiz_css" value="/static/css/college_quiz_css.css" />
<link href="${college_quiz_css}" rel="stylesheet">
</head>
<body>
	<!--============ HEADER FILE ============-->
	<c:set var="title" value="Quiz" />
	<%@include file="includes/home-modules/home-header.jsp"%>
	<!--============ CONTENT FILE ============-->
	<%@include file="includes/quiz-modules/quiz-content-section.jsp"%>
</body>
</html>