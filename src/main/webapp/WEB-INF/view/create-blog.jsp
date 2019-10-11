<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A Blog</title>

<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<!-- line control editor css and js -->

<s:url var="line_control_editor_js"
	value="/static/line_control_editor/editor.js" />
<script type="text/javascript" src="${line_control_editor_js}"></script>

<s:url var="create_blogs_css" value="/static/css/create_blogs_css.css" />
<link href="${create_blogs_css}" rel="stylesheet">

<s:url var="bootstrap_min_css"
	value="/static/lib/bootstrap/css/bootstrap3.min.css" />
<link href="${bootstrap_min_css}" rel="stylesheet">

<s:url var="line_control_editor_css"
	value="/static/line_control_editor/editor.css" />
<link href="${line_control_editor_css}" rel="stylesheet">

<style type="text/css">
.search_box input[type=text] {
	margin-bottom: 0;
}
</style>
</head>
<body>

	<!--============ HEADER FILE ============-->
	<c:set var="title" value="Blogs" />
	<%@include file="includes/home-modules/home-header.jsp"%>

	<div class="col-lg-12 col-md-12 col-sm-12 blog-main-container">

		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 left-side-container"></div>
			<div class="col-lg-6 col-md-6 col-sm-6 middle-side-container mx-auto">
				<div class="create-blog-container">

					<form class="create-blog-form" method="post">
						<div class="blog-title">
							<textarea class="blogTitle" placeholder="Title"
								required="required"></textarea>
						</div>
						<div class="blog-desc">
							<textarea id="blogDesc" name="desc" class="blogDesc"
								placeholder="start writing your blog..."></textarea>
						</div>

						<div class="post-button">
							<input type="button" class="postButton" value="Post" />
						</div>
					</form>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 right-side-container"></div>
		</div>

	</div>
	<s:url var="url_publish_blog" value="/blog/publish-blog">
		<s:param name="collegeId" value="${CREATE_BLOG.college.id}" />
	</s:url>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#blogDesc").Editor();
		});

		$(document)
				.ready(
						function() {
							$(".postButton")
									.click(
											function() {
												var desc = $("#blogDesc")
														.Editor("getText");
												var title = $(".blogTitle")
														.val();
								
												if (desc != '' || title != '') {

													$
															.ajax({
																url : "${url_publish_blog}",
																method : "POST",
																data : {
																	blogTitle : title,
																	blogDesc : desc
																},

																success : function(
																		response) {
																	if (response == "PUBLISHED") {
																		alert("blog published successfully!");
																		location
																				.reload();
																	} else {
																		alert("blog couldn't published due to some error.");
																	}
																}

															});

												}
											});
						});
	</script>
</body>
</html>