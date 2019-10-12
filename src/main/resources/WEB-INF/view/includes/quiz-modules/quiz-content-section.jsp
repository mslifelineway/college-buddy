<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../spring-tag-libs.jsp"%>
</head>
<body>
	<!--=============== PROGRAM CONTENTS ================= -->
	<section class="program_content_section">
		<div
			class="program_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12 p-0">
			<table class="table-bordered quiz_table" style="width: 100%;">
				<thead>
					<tr>
						<th>Sl.No.</th>
						<th>Quiz Name</th>
						<th>Subject</th>
						<th>No. Of Question</th>
						<th>Answer Status</th>
					</tr>
				</thead>
				<tbody>
					<c:set value="1" var="x" />
					<c:set value="1" var="y" />
					<c:set
						value="{1,1,2,1,1,2,1,2,2,1,2,1,2,1,2,1,1,1,2,1,2,1,2,1,2,1,2,12,1,2,1,1,2,1,2,1,2,1,2,1,2,1}"
						var="items" />
					<c:forEach items="${items}" varStatus="st">
						<tr>
							<td>${x}.</td>
							<td><s:url var="url_quiz_details"
									value="/quiz/quiz-details" /> <a
								href="${url_quiz_details}">N-Queen Problem</a></td>
							<td>Algorithm</td>
							<td>16</td>
							<td>${y}/16</td>
							<c:if test="${x == 16}">
								<c:set var="y" value="0" />
							</c:if>
						</tr>
						<c:set var="y" value="${y+1}" />
						<c:set var="x" value="${x+1}" />
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>
	<script type="text/javascript">
		//--- popover option for account options --//
		$(document).ready(function() {
			$("#user_profile_option").popover({
				title : userProfileOptions,
				html : true,
				placement : 'bottom'
			});
		});
		function userProfileOptions() {
			return "<div class='account_options'>\n\
                    <ul>\n\
                        <li><a href='#'>My Profile</a></li>\n\
                        <li><a href='#'>About</a></li>\n\
                        <li><a href='#'>My Blogs</a></li>\n\
                        <li><a href='#'>Following</a></li>\n\
                        <li><a href='#'>Followers</a></li>\n\
                        <li><a href='#'>New Update</a></li>\n\
                        <li><a href='#'>Help & Support</a></li>\n\
                        <li><a href='#'>Feedback</a></li>\n\
                        <li><a href='#'>My College</a></li>\n\
                    </ul>\n\
                    </div";
		}
		//---- HIDE POPOVER BY OUTSITE CLICKING ---//
		$('html')
				.on(
						'click',
						function(e) {
							if (typeof $(e.target).data('original-title') === 'undefined'
									&& !$(e.target).parents().is('.popover.in')) {
								$('[data-original-title]').popover('hide');
							}
						});
	</script>
</body>
</html>