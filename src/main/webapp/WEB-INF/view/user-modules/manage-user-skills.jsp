<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Your Skills</title>
<%@include file="includes/spring-tag-libs.jsp"%>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<style>
.selected-li-item {
	margin: 2px;
	padding: 4px 6px;
	border-radius: 10px;
	border: 1px solid #174A61;
	float: left;
	min-width: 10%;
	text-align: center;
	display: flex;
}

.selected-li-item input[type=text] {
	outline-style: none;
	box-shadow: none;
	border-color: transparent;
	text-align: center;
	width: 100%;
	margin: 0px;
}
</style>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (session.getAttribute("USER") == null) {
			response.sendRedirect("/index?act=Access Denied! please login back");
		}
	%>
	<%@include file="../includes/home-modules/home-header.jsp"%>
	<%@include file="manage-user-skills-content-section.jsp"%>

	<s:url var="url_search_skills" value="/skills/search_skills" />
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var liIndex = 1;
							$("#search-skill")
									.keyup(
											function(e) {
												var code = (e.keyCode ? e.keyCode
														: e.which);
												var searchTxt = $(this).val();
												if (searchTxt != '') {

													$
															.ajax({
																url : "${url_search_skills}",
																method : "POST",
																data : {
																	skillKey : searchTxt
																},
																success : function(
																		skillsData) {
																	$(
																			".skills-list-container")
																			.fadeIn();
																	$(
																			".skills-list-container")
																			.html(
																					skillsData);
																}
															});
												}

												if (code == 13) {
													$(".skills-list-container")
															.fadeOut();
													var liItem = "<li class='selected-li-item justify-content-between skillLiItem"+liIndex+"'><input readonly type='text' name='skills' id='skills' value='"
															+ $("#search-skill")
																	.val()
															+ "' /><span style='font-size: 25px; font-weight: bold;' class='close' onclick='removeLiItem("
															+ liIndex
															+ ")'>&times;</span></li>";
													liIndex++;
													$("#skill-box").append(
															liItem);
													e.preventDefault();
												}

											});

							$(document)
									.on(
											"click",
											"td",
											function() {
												$(".skills-list-container")
														.fadeOut();
												$("#search-skill").val(
														$(this).text());
												var liItem = "<li class='selected-li-item justify-content-between skillLiItem"+liIndex+"'><input readonly type='text' name='skills' id='skills' value='"
														+ $(this).text()
														+ "' /><span style='font-size: 25px; font-weight: bold;' class='close' onclick='removeLiItem("
														+ liIndex
														+ ")'>&times;</span></li>";
												liIndex++;
												$("#skill-box").append(liItem);
											});

						});

		function removeLiItem(index) {
			$(".skillLiItem" + index).remove(); /// delete the selected li item from the selected ul li list
		}

		function saveAllSkills() {
			/// check if ul's child exists then save the skills
			if ($("#skill-box").children().length > 0) {
				$("#saveSkills").removeAttr("disabled");
				$("#saveSkills").click();
			}
		}
	</script>
</body>
</html>