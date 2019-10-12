<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit personal information</title>
<%@include file="includes/spring-tag-libs.jsp"%>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="edit_personal_info_css"
	value="/static/user-css/edit-personal-info.css" />
<link href="${edit_personal_info_css}" rel="stylesheet">
<s:url var="user_profile_sidebar_css"
	value="/static/user-css/user-profile-sidebar-css.css" />
<link href="${user_profile_sidebar_css}" rel="stylesheet">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (session.getAttribute("USER") == null) {
			response.sendRedirect("/index?act=Access Denied!");
		}
	%>
	<%@include file="../includes/home-modules/home-header.jsp"%>

	<div class="col-lg-12 col-md-12 col-sm-12 main-container">
		<div class="row">
			<%@include file="includes/user-profile-sidebar.jsp"%>

			<div class="col-lg-9 col-md-9 col-sm-9 edit-container">
				<div class="row">
					<s:url var="update_user" value="/user-account/update-personal-info" />
					<f:form action="${update_user }" method="post"
						modelAttribute="USER_COMMAND" class="edit-personal-info ">
						<h2 class="title">Update your personal information.</h2>
						<div class="col-lg-12 input-container full-name">
							<f:input type="text" path="name" placeholder="full name"
								required="required" />
						</div>
						<div class="col-lg-12 input-container college-name">
							<f:input type="text" path="college" placeholder="college name"
								required="required" />
						</div>
						<div class="col-lg-12 input-container college-link">
							<f:input type="text" path="collegeLink"
								placeholder="college link" />
						</div>
						<c:if test="${USER_COLLEGES ne null }">
							<div class="col-lg-12 input-container college-link">
								<f:select path="defaultCollege">
									<c:forEach items="${USER_COLLEGES }" var="userCollege">
										<f:option value="${userCollege }">${userCollege.collegeName }</f:option>
									</c:forEach>
								</f:select>
							</div>
						</c:if>
						<div class="col-lg-12 textarea-container user-status">
							<f:textarea path="about" placeholder="about you"
								required="required"></f:textarea>
						</div>
						<div class="col-lg-12 submit-button">
							<input class="pull-right" type="submit" value="Update" />
						</div>
					</f:form>
				</div>

				<div class="row">
					<s:url var="update_account_info"
						value="/user-account/update-account-login-details" />
					<f:form action="${update_account_info }" method="post"
						modelAttribute="USER_COMMAND" class="edit-personal-info ">
						<h2 class="title">Update account login details.</h2>
						<div class="d-flex justify-content-between align-item-center">
							<span>Email Id</span>
							<div class="input-container" style="width: 85%;">
								<f:input type="email" path="email" placeholder="email ID"
									required="required" />
							</div>
						</div>
						<div class="d-flex justify-content-between align-item-center">
							<span>username</span>
							<div class="input-container" style="width: 85%;">
								<f:input type="text" path="username"
									placeholder="username, ex: Ilovejava4ever" required="required" />
							</div>
						</div>


						<div class="col-lg-12 submit-button">
							<input class="pull-right" type="submit" value="Update" />
						</div>
					</f:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>