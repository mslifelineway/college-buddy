
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ISO-8859-1">
<%@ include file="spring-tag-libs.jsp"%>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<!-- TREE FORM CONTENT OR LEFT CONTENT OF TREE FORM -->
<s:url var="tree_form_content_css"
	value="/static/css/tree_form_content_css.css" />
<link href="${tree_form_content_css}" rel="stylesheet">
</head>
<body>
	<section id="leftItem">
		<section id="subject_title">
			<p>A</p>
			<span>lgorithm</span>
		</section>
		<c:set var="t" value="{1,2,2,1,1,2,3,1,3}" />
		<c:forEach items="${t}">
			<section id="subject_topic">
				<i class="fa fa-circle-o"></i>
				<p>Searching Algorithm in Data Structure</p>
			</section>
		</c:forEach>
	</section>
</body>
</html>
