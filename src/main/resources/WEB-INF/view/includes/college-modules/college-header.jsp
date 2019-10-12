
<%@include file="../spring-tag-libs.jsp"%>

<%-- ========================> HEADER PART <========================= --%>
<c:set var="college" value="${COLLEGE }" />
<c:set var="user" value="${USER }"/>
<!-- TODO: CHECK IF COLLEGE OR USER IS NULL REDIRECT IT TO THE INDEX PAGE BY SECURITY-->
<section id="header">
	<div
		class="container-fluid college_profile_header col-lg-12 col-md-12 col-sm-12">
		<div class="col-lg-12 col-md-12 col-sm-12"
			style="margin: 0; padding: 0">
			<s:url var="url_college_banner"
				value="/static/college-images/default_college_cover_image.jpg" />
			<c:if test="${college.coverImage ne null}">
				<s:url var="url_college_banner"
				value="/static/college-images/${college.coverImage }" />
			</c:if>
			<img src="${url_college_banner}" width="100%" height="200px">
		</div>
	</div>
	<!-- COLLEGE DETAILS LIKE COLLEGE NAME ETC. -->
	<div
		class="container-fluid college_profile_details col-lg-12 col-md-12 col-sm-12">
		<s:url var="url_college_dp"
				value="/static/college-images/default_college_profile_image.jpg" />
			<c:if test="${college.profileImage ne null}">
				<s:url var="url_college_dp"
				value="/static/college-images/${college.profileImage }" />
			</c:if>
		<img src="${url_college_dp}" class="img-resonsive" alt="img">
		<p>${college.collegeName }
			
			<c:if test="${college.user.id ne USER.id}">
				<span class="pull-right"><a href="#">Join</a></span>
			</c:if>
		</p>

	</div>
	<!-- MENUS OR OPTIONS (MENUS WILL BE DYNAMIC) -->
	<div
		class="container-fluid college_profile_menus col-lg-12 col-md-12 col-sm-12">
		<ul class="d-flex justify-content-end" style="width: 100%">

			<s:url var="url_college_home" value="/user/user-college-profile">
				<s:param name="collegeId" value="${college.id }" />
			</s:url>
			<li><a href="${url_college_home}">Home</a></li>

			<s:url var="url_college_about" value="/college/about" />
			<li><a href="${url_college_about}">About</a></li>

			<s:url var="url_college_announcement"
				value="/college/programs/announcement" />
			<li><a href="${url_college_announcement}">Announcement</a></li>

			<s:url var="url_college_blog" value="/college/blogs" >
				<s:param name="collegeId" value="${college.id }"/>
			</s:url>
			<li><a href="${url_college_blog}">Blogs</a></li>

			<s:url var="url_college_exams" value="/college/exams" />
			<li><a href="${url_college_exams}">Exams</a></li>

			<s:url var="url_college_magazines" value="/college/magazines" />
			<li><a href="${url_college_magazines}">Magazines</a></li>

			<s:url var="url_college_members" value="/college/members" />
			<li><a href="${url_college_members}">Members</a></li>

			<s:url var="url_college_photos" value="/college/photos" />
			<li><a href="${url_college_photos}">Photos</a></li>

			<s:url var="url_college_quiz" value="/college/programs/quiz" />
			<li><a href="${url_college_quiz}">Quiz</a></li>

			<s:url var="url_college_records" value="/college/records" />
			<li><a href="${url_college_records}">Records</a></li>

			<s:url var="url_college_workshops"
				value="/college/programs/workshops" />
			<li><a href="${url_college_workshops}">Workshop</a></li>

		</ul>
	</div>
</section>
