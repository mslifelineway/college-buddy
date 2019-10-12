
<%@ include file="spring-tag-libs.jsp"%>

<div
	class="user_details col-lg-12 col-md-12 col-sm-12 d-flex justify-content-center"
	style="border: 2px;">
	<div class="user_image_container">
		<img src="${url_profile_image}" class="responsive" alt="image" />
	</div>
	<div class="user_detail_container">
		<p>
			<a href="${url_user_profile}">${user_name}</a>&nbsp;<span
				class="pull-right">${reg_date}</span>&nbsp; <br> <span>
				<a href="${url_user_default_college}">${user_default_college_name}</a>
			</span>
		</p>
	</div>
</div>