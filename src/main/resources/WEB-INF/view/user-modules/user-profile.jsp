<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<%@include file="includes/spring-tag-libs.jsp"%>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	%>
	<%@include file="../includes/home-modules/home-header.jsp"%>
	<%@include file="home-content-section.jsp"%>


	<script type="text/javascript">
		function likeThisBlog(blogId, totalShared) {
			//// ajax to do the like operation
			if (blogId != 0) {
				<s:url var="url_like_blog" value="/blog/like-blog"/>
				$
						.ajax({
							url : "${url_like_blog}",
							method : "post",
							data : {
								blogId : blogId,
								total_shared_blog : totalSharedBlog
							},
							success : function(likeResponse) {
								var updatingDiv = ".action_icon_list_with_like_dislike_for_blog"
										+ blogId;
								$(updatingDiv).html(likeResponse);
							},
							error : function(jqXHR, textStatus, errorThrown) {
								alert(jqXHR + textStatus + errorThrown);
							}
						});
			}
		}

		function disLikeThisBlog(blogId, totalShared) {
			if (blogId != 0) {
				//// ajax to do the dislike operation
				<s:url var="url_dislike_blog" value="/blog/dislike-blog"/>
				$
						.ajax({
							url : "${url_dislike_blog}",
							method : "post",
							data : {
								blogId : blogId,
								total_shared_blog : totalSharedBlog
							},
							success : function(dislikeResponse) {
								var updatingDiv = ".action_icon_list_with_like_dislike_for_blog"
										+ blogId;
								$(updatingDiv).html(dislikeResponse);
							},
							error : function(jqXHR, textStatus, errorThrown) {
								alert(jqXHR + textStatus + errorThrown);
							}
						});
			}
		}

		///when click on option button in blog then show options
		function showMenuOptions(class_name) {
			$(".menu-options" + class_name).css("display", "block");
		}
		///hide opened menu options when click on any where in the window
	$(document).ready(function() {
		$(".inner").on('click', function() {
			$(".menu-options").css("display", "none");
		});
	});	

	</script>
</body>
</html>