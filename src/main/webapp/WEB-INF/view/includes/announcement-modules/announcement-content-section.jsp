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
			class="program_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<!-- left content -->
			<div class="row">
				<div class="left_content col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<!-- item 1 -->
					<div class="left_content_container">
						<p>Related Workshop</p>
						<ul>
							<li><a href="#">Today</a></li>
							<li><a href="#">Yesterday</a></li>
							<li><a href="#">Last Week</a></li>
							<li><a href="#">Last 30days</a></li>
							<li><a href="#">All</a></li>
							<li><a href="#">Read</a></li>
							<li><a href="#">Unread</a></li>
							<li><a href="#">Mark all as read</a></li>
							<li><a href="#">Mark all as unread</a></li>
							<!-- this section will display only for college admin not for students -->
							<li><a href="#">Post an announcement</a></li>
						</ul>
					</div>
				</div>
				<!-- Middle content -->
				<div class="middle_content col-lg-8 col-md-8 col-sm-8 col-xs-8">
					<div
						class="middle_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<!-- item goes here.. -->
						<c:set var="x"
							value="{1,2,3,12,13,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,1,2,3,4,5,
                                   1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,1,2,3,4,5,8,9,10,11,12,13,1,2,3,4,5}" />
						<c:forEach items="${x}" varStatus="st">
							<div class="content_item col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="announcement_title">
									<p>Announcement Title</p>
								</div>
								<div class="announcement_details">
									<p>Years ago, mails were written on paper and it took
										longer for one person to send a message to another. For
										businesses, letters are important documents. Today, important
										documents can be sent in minutes through emails, establishing
										an effective business to business relationship. Applying for
										jobs have become much easier because of emails.For example, a
										email cover letter from an applicant can be sent through
										email.</p>
									<img class="img-resonsive"
										src="https://images.pexels.com/photos/4154/clinic-doctor-health-hospital.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500 1x, https://images.pexels.com/photos/4154/clinic-doctor-health-hospital.jpg?auto=compress&cs=tinysrgb&dpr=2&w=500 2x" />

									<span>cloud computing to work with google and microsoft
										database to manage and modify</span> <br>
									<a href="#">Registration Open</a>
									<p>Tags :</p>
									<p>Link :</p>
									<p>Website :</p>
								</div>

								<div class="announcement_source">
									<p>soucrce : chaitanya institute of technology and science</p>
								</div>
							</div>
						</c:forEach>
						<!-- item end here.. -->
					</div>
				</div>
				<div class="tag_content col-lg-2 col-md-2 col-sm-2 col-xs-2 p-0">
					<!-- item 1 -->
					<div class="tags_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<!-- tag items -->
						<div class="row" style="margin: 0">
							<c:set var="x"
								value="{1,1,1,1,2,2,2,2,2,2,1,1,1,1,2,2,2,2,2,2,1,1,1,1,1}" />
							<c:forEach items="${x}" varStatus="st">
								<div class="tag_item col-lg-6 col-md-6 col-sm-6">
									<p>Result</p>
								</div>
								<div class="tag_item col-lg-6 col-md-6 col-sm-6">
									<p>Reopen</p>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
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