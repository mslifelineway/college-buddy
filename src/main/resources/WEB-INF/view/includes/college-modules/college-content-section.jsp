
<%@include file="../spring-tag-libs.jsp"%>
<s:url var="action_icon_list_css"
	value="/static/css/action-icon-list-css.css" />
<link href="${action_icon_list_css}" rel="stylesheet">
<s:url var="profile_container_with_date_css"
	value="/static/css/profile-container-with-date-css.css" />
<link href="${profile_container_with_date_css}" rel="stylesheet">

<%-- ========================> CONTENT PART <========================= --%>
<section id="content_area">
	<div class="col-lg-12 col-md-12 col-sm-12">
		<div class="row">
			<!-- left content area (IN THIS AREA REGISTERED STUDENT AND FACULTIES OF THE SELECTED COLLEGE WILL BE SHOWN) -->
			<div
				class="col-lg-3 col-md-3 col-sm-3 col-xs-3 left_content_container">
				<c:set var="x" value="{1,2,3,4,5,6,7}" />
				<!-- item 1 -->
				<c:set var="approved_users" value="${APPROVED_USERS }" />
				<c:choose>
					<c:when test="${approved_users ne null }">
						<c:forEach items="${approved_users}" var="ap_user">
							<div class="col-lg-12 col-md-12 col-sm-12 left_content">
								<!-- user details -->
								<!--
								 BEFORE INCLUDING 'profile-container.jsp' PAGE MUST SET 
								REQUIRED DATA ONTO THIS FILE 
								-->
								<s:url var="url_profile_image"
									value="/static/user_profile_images/${ap_user.image }" />
								<s:url var="url_user_profile" value="/user/user_profile">
									<s:param name="userId" value="${ap_user.id}" />
								</s:url>
								<c:set var="user_name" value="${ap_user.username }" />

								<c:set var="user_default_College_id"
									value="${ap_user.defaultCollege.id }" />
								<c:set var="user_default_college_name"
									value="${ap_user.defaultCollege.collegeName }" />

								<%@include file="../profile-container.jsp"%>

								<!-- user post details -->
								<div class="user_post col-lg-12 col-md-12 col-sm-12">
									<p>
										Technical Languages:<br>
										C/C++/Java/Html/Css/JavaScript/BootStrap /Jquery/Ajax/Angular
										JS/React/Php/MySql/PDO/
										JSP/Servlet/Jdbc/Hibernate/RestApi/Maven/Spring MVC/Spring
										Boot <br>FrameWork/Platform: <br>
										Eclipse/NetBeans/Android Studio
									</p>
								</div>
								<!-- user post actions area like share, comments, like etc -->
								<%@include file="../chat-follow-icons-list.jsp"%>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="col-lg-12 col-md-12 col-sm-12 left_content">
							<div class="user_post col-lg-12 col-md-12 col-sm-12">
								<p>No approved members are found.</p>
							</div>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- middle content are -->
			<div
				class="col-lg-6 col-md-6 col-sm-6 col-xs-6 middle_content_container">
				<%@include file="../question_with_answers_section.jsp"%>
			</div>

			<!-- right content are (IN THIS AREA NOTIFICATIONS DATA LIKE WHO FOLLOWED, WHO REPLIED ETC WILL BE SHOWN) -->
			<!-- AND ALSO EVENTS INFORMATIONS WILL BE SHOWN -->
			<div
				class="col-lg-3 col-md-3 col-sm-3 col-xs-3 right_content_container">
				<div class="right_content">
					<div
						class="col-lg-12 col-md-12 col-sm-12 col-xs-12 left_content_container">

						<c:set var="x" value="{1,2,3}" />
						<!-- item 1 -->
						<c:forEach items="${x}" varStatus="st">
							<div class="col-lg-12 col-md-12 col-sm-12 left_content">
								<!-- user details -->
								<!--
								 BEFORE INCLUDING 'profile-container-with-date.jsp' PAGE MUST SET 
								REQUIRED DATA ONTO THIS FILE 
								-->
								<s:url var="url_profile_image"
									value="/static/user_profile_images/default.png" />
								<s:url var="url_user_profile" value="/user/profile">
									<s:param name="userId" value="${lq_obj.user.id}" />
								</s:url>
								<c:set var="user_name" value="Java World" />
								<c:set var="reg_date" value="20/08/2019" />
								<s:url var="url_user_college" value="/user/user-college">
									<s:param name="collegeId" value="1" />
								</s:url>
								<c:set var="user_college_name" value="Cits warangal" />
								<%@include file="../profile-container-with-date.jsp"%>


								<!-- user post details -->
								<div class="user_post col-lg-12 col-md-12 col-sm-12">
									<p>I am using RecyclerView inside ViewPager, which is
										already inside another RecyclerView, but the ViewPager
										RecyclerView is not scrolling vertically. What should I do?</p>
								</div>
								<!-- user post actions area like share, comments, like etc -->
								<!--  
									BEFORE INCLUDING BELOW FILE MUST SET DATA REQUIRED FOR THAT FILE
								-->
								<c:set var="total_shared" value="${mq_obj.shared}" />
								<c:set var="total_answered"
									value="${mq_obj.questionEmbedded.countAQuestionAnswered}" />
								<c:set var="total_followed"
									value="${mq_obj.questionEmbedded.countAQuestionFollowed}" />
								<c:set var="question_user_id" value="${mq_obj.user.id}" />
								<c:set var="user_follow_this_question"
									value="${mq_obj.questionEmbedded.userFollowThisQuestion}" />
								<c:set var="question_id" value="${mq_obj.id}" />

								<%@include file="../notification-action-icon-list.jsp"%>

							</div>
						</c:forEach>
						<!-- =============== notifications related to the students who logged In ============= -->
						<c:forEach items="${x}" varStatus="st">
							<div class="col-lg-12 col-md-12 col-sm-12 left_content">
								<!-- user details -->
								<!--
								 BEFORE INCLUDING 'profile-container-with-date.jsp' PAGE MUST SET 
								REQUIRED DATA ONTO THIS FILE 
								-->
								<s:url var="url_profile_image"
									value="/static/user_profile_images/default.png" />
								<s:url var="url_user_profile" value="/user/profile">
									<s:param name="userId" value="${lq_obj.user.id}" />
								</s:url>
								<c:set var="user_name" value="Java World" />
								<c:set var="reg_date" value="20/08/2019" />
								<s:url var="url_user_college" value="/user/user-college">
									<s:param name="collegeId" value="1" />
								</s:url>
								<c:set var="user_college_name" value="Cits warangal" />
								<%@include file="../profile-container-with-date.jsp"%>

								<!-- user post details -->
								<div class="user_post col-lg-12 col-md-12 col-sm-12">
									<p>Started following You..............................!</p>
								</div>
							</div>
						</c:forEach>
						<!--====================== EVENTS INFORMATIONS ==================-->
						<!-- event item 1 -->
						<div
							class="col-lg-12 col-md-12 col-sm-12 left_content event_container">
							<p class="text-center">Event</p>
							<h6 class="text-center college_name">Chaitanya Institute Of
								Technology</h6>
							<label class="text-center"> Hello students we are glad to
								inform you that we are going to organize an event where all
								interested Student can participate and they can get benefit from
								this event </label> <span class="event_name">Dance Programe : </span><span
								class="event_detail">On 22th Dec Degree Block</span> <br> <span
								class="event_name">Tech Event : </span><span
								class="event_detail">On 18th Aug At College campus</span> <br>
							<span class="event_name">Job Interview : </span><span
								class="event_detail">On 21th April At Kakatiya University</span>
							<br> <span class="event_name">Fun Day : </span><span
								class="event_detail">on 25Aug At College Campus and also
								at kakatiya university</span>
						</div>
						<!-- event item 2 -->
						<div
							class="col-lg-12 col-md-12 col-sm-12 left_content event_container">
							<p class="text-center">Notice</p>
							<h6 class="text-center college_name">Chaitanya Institute Of
								Technology</h6>
							<label class="text-center"> Hello students we are glad to
								inform you that we are going to organize an event where all
								interested Student can participate and they can get benefit from
								this event </label> <span class="event_name">Dance Programe : </span><span
								class="event_detail">On 22th Dec Degree Block</span> <br> <span
								class="event_name">Tech Event : </span><span
								class="event_detail">On 18th Aug At College campus</span> <br>
							<span class="event_name">Job Interview : </span><span
								class="event_detail">On 21th April At Kakatiya University</span>
							<br> <span class="event_name">Fun Day : </span><span
								class="event_detail">on 25Aug At College Campus and also
								at kakatiya university</span>
						</div>
						<!-- event item 2 -->
						<div
							class="col-lg-12 col-md-12 col-sm-12 left_content event_container">
							<p class="text-center">Announcement</p>
							<h6 class="text-center college_name">Chaitanya Institute Of
								Technology</h6>
							<label class="text-center"> Hello students we are glad to
								inform you that we are going to organize an event where all
								interested Student can participate and they can get benefit from
								this event </label> <span class="event_name">Dance Programe : </span><span
								class="event_detail">On 22th Dec Degree Block</span> <br> <span
								class="event_name">Tech Event : </span><span
								class="event_detail">On 18th Aug At College campus</span> <br>
							<span class="event_name">Job Interview : </span><span
								class="event_detail">On 21th April At Kakatiya University</span>
							<br> <span class="event_name">Fun Day : </span><span
								class="event_detail">on 25Aug At College Campus and also
								at kakatiya university</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</section>
