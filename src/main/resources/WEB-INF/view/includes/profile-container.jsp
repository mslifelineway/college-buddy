
<%@ include file="spring-tag-libs.jsp"%>
<s:url var="profile_container_css"
	value="/static/css/profile-container-css.css" />
<link href="${profile_container_css}" rel="stylesheet">
<div
	class="user_details col-lg-12 col-md-12 col-sm-12 d-flex justify-content-center"
	style="border: 2px;">
	<div class="user_image_container">
		<img src="${url_profile_image}" class="responsive" alt="" />
	</div>
	<div class="user_detail_container">
		<p>
			<a href="${url_user_profile}">${user_name}</a>&nbsp;<span
				class="ion ion-checkmark-circled"></span>&nbsp; <i
				class="fa fa-graduation-cap pull-right"></i> <br> <span>
				<a href="${url_user_college}">${user_college_name}</a>
			</span>
			<c:choose>
				<c:when test="${user_default_College_id ne '0'}">
					<s:url var="url_user_college" value="/user/user-college-profile">
						<s:param name="collegeId" value="${user_default_College_id }" />
					</s:url>
					<span><a href="${url_user_college }"
						class="user-college-link">${user_default_college_name}</a></span>
				</c:when>
				<c:otherwise>
					<span><a class="user-college-link">${user_college_name}</a></span>
				</c:otherwise>
			</c:choose>
		</p>
	</div>
</div>
