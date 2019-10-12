<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to College-Buddy</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>

</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	%>
	<%-- ========================> HEADER PART <========================= --%>
	<%@include file="includes/home-modules/home-header.jsp"%>
	<%-- ========================> CONTENT PART <=========================--%>
	<%@include file="includes/home-modules/home-content-section.jsp"%>

	<!-- INFORMATION MODAL (It Will use to display any information -->
	<div class="modal" id="info_modal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<button class="close" type="button" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="info"></div>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		///like an answer
		function likeAnswer(answerId, totalSharedAnswer) {
			//// ajax to do the like operation
			<s:url var="url_like_answer" value="/answer/like-answer"/>
			$.ajax({
				url : "${url_like_answer}",
				method : "post",
				data : {
					answerId : answerId,
					total_shared_answer : totalSharedAnswer
				},
				success : function(likeResponse) {
					var updatingDiv = ".action_icon_list_with_like_dislike"
							+ answerId;
					$(updatingDiv).html(likeResponse);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR + textStatus + errorThrown);
				}
			});

		}

		///disLike an answer
		function disLikeAnswer(answerId, totalSharedAnswer) {
			//// ajax to do the dislike operation
			<s:url var="url_dislike_answer" value="/answer/dislike-answer"/>
			$.ajax({
				url : "${url_dislike_answer}",
				method : "post",
				data : {
					answerId : answerId,
					total_shared_answer : totalSharedAnswer
				},
				success : function(likeResponse) {
					var updatingDiv = ".action_icon_list_with_like_dislike"
							+ answerId;
					$(updatingDiv).html(likeResponse);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR + textStatus + errorThrown);
				}
			});
		}

		/// show all the gallery images of each question, answer etc on full screen
		$('.gallery').each(function() { // the containers for all your galleries
			$(this).magnificPopup({
				delegate : 'a', // the selector for gallery item
				type : 'image',
				gallery : {
					enabled : true
				}
			});
		});
	</script>

</body>
</html>