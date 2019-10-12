<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<!--=============== PROGRAM CONTENTS ================= -->
	<section class="program_content_section">
		<div
			class="program_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<!-- left content -->
			<div class="row">
				<div class="left_content col-lg-3 col-md-3 col-sm-3 col-xs-3">
					<%@include file="../tree_form_contents.jsp"%>
				</div>
				<!-- Middle content -->
				<div
					class="middle_content_container col-lg-6 col-md-6 col-sm-6 col-xs-6">
					<!-- middle content are -->
					<%@include file="../question_with_answers_section.jsp"%>
				</div>
				<!-- RIGHT CONTENT.. -->
				<div
					class="group_members_section col-lg-3 col-md-3 col-sm-3 col-xs-3 p-0">
					Right content goes here...</div>
			</div>
		</div>
	</section>
</body>
</html>