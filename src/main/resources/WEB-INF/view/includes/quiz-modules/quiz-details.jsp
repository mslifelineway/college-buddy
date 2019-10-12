<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TODO: selected-quiz-name: ${quiz_name}</title>
<%@include file="../css_plugins.jsp"%>
<%@include file="../js_plugins.jsp"%>
<s:url var="quiz_details_css" value="/static/css/quiz_details_css.css"/>
        <link href="${quiz_details_css}" rel="stylesheet">
</head>
<body>
<!--============ HEADER FILE ============-->
	<c:set var="title" value="N-Queen Problems" />
	<%@include file="../home-modules/home-header.jsp"%>
	<!-- -- Content section -->
	<%@include file="../quiz-modules/quiz-details-content-section.jsp"%>
</body>
</html>