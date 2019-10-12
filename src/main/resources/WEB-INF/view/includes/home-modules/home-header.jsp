
<%@include file="../spring-tag-libs.jsp"%>
<%-- ========================> HEADER PART <========================= --%>
<section id="header">
	<div class="header col-lg-12 col-md-12 col-sm-12 fixed-top ">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
				<div class="row">
					<c:set var="user" value="${USER}" />
					<!-- check whether the 'user' object is found or not that is 'user object is null or not
                            if not then sign In or sign Up option will show otherwise user profile will show -->
					<!-- THIS LAYOUT WILL HIDE AFTER USER LOGIN -->
					<c:choose>
						<c:when test="${user eq null}">
							<div class="account_container">
								<s:url var="url_create_account" value="/new_user/create_account" />
								<label data-target="#sign_up_modal" data-toggle="modal"
									class="btn sign_up"
									style="font-family: 'Rubik Mono One', sans-serif;"
									title="New User? create account">Sign Up</label> |
								<s:url var="url_login_account" value="/login_account" />
								<label data-target="#sign_in_modal" data-toggle="modal"
									class="btn sign_in " title="Already have an account? login">Sign
									In</label>
							</div>
						</c:when>
						<c:otherwise>
							<!-- THIS LAYOUT WILL SHOW AFTER USER LOGIN -->
							<div class="profile_container col-lg-12 col-md-12 col-sm-12">
								<div
									class="profile_image_container col-lg-2 col-md-2 col-sm-2 col-md-2 col-sm-2 text-center">
									<s:url var="url_profile_image"
										value="/static/user_profile_images/${user.image }" />
									<img src="${url_profile_image}" class="responsive" alt="" />
								</div>
								<div
									class="profile_data col-lg-9 col-md-9 col-sm-9 col-md-9 col-sm-9">
									<s:url var="url_my_profile" value="/user/user_profile">
										<s:param name="userId" value="${user.id }" />
									</s:url>
									<p>
										<a href="${url_my_profile}">${user.name}</a>&nbsp;<span
											class="ion ion-checkmark-circled"></span>&nbsp; <i
											class="fa fa-graduation-cap"></i> <br>
										<s:url var="url_user_college_profile"
											value="/user/user-college-profile">
											<s:param name="collegeId" value="${user.defaultCollege.id }" />
										</s:url>
										<c:choose>
											<c:when
												test="${user.defaultCollege.id ne '0' or user.defaultCollege.collegeName ne null}">
												<span><a href="${url_user_college_profile }"
													class="user-college-link">${user.defaultCollege.collegeName}</a></span>
											</c:when>
											<c:otherwise>
												<span><a class="user-college-link">${user.college}</a></span>
											</c:otherwise>
										</c:choose>
									</p>
								</div>
							</div>
						</c:otherwise>
					</c:choose>


				</div>
			</div>
			<!-- SEARCH HEADER AREA -->
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 search_container">
				<div class="row search_box">
					<input type="text" name="searchText"
						placeholder="Hit Here For Your Career Kick..." />
					<button class="btn btn-sm pull-right">Q</button>
				</div>
			</div>
			<!-- RIGHT HEADER MENU OPTIONS -->
			<div
				class="col-lg-3 col-md-3 col-sm-3 col-xs-3 right_option_container">
				<div class="row right_option_box">
					<ul>
						<s:url var="url_home" value="/index" />
						<li><a href="${url_home}" title="jump to home page"><span
								class="fa fa-home"></span></a></li>
						<s:url var="url_chat_room" value="/chat/chat-room" />
						<li><a href="${url_chat_room}" title="Talk to your friends"><span
								class="ion ion-chatbubble"></span></a></li>
						<s:url var="url_create_post" value="/post/ask-your-doubts" />
						<li><a href="${url_create_post}" title="Ask your doubts"><i
								class="fa fa-edit"></i></a></li>
						<!--<li><a href="${url_create_post}" title="Create a post"><span
									class="ion ion-edit"></span></a></li> -->
						<li><a href="#" title="Notifications"><span
								class="ion ion-ios-bell"></span></a></li>
						<s:url var="url_discussion_room"
							value="/discussion/discussion-room" />
						<li><a href="${url_discussion_room}" title="Discussion Room"><span
								class="ion"
								style="border: 1px solid #174A61; border-radius: 4px; padding: 1px 2px; font-weight: bold">C</span></a></li>
					</ul>
					<div class="right_option_box_title">
						<!-- TODO: check whether the user is logged in or not and if logged in then is he member of 
						this current college, if yes then only show write blog option -->
						<c:set var="UserIsACollegeMember" value="1"></c:set>
						<c:choose>
							<c:when test="${USER ne null and UserIsACollegeMember eq '1'}">
								<s:url var="url_write_a_blog" value="/blog/write-a-blog">
									<s:param name="collegeId" value="2"/>
								</s:url>
								<p><a href="${url_write_a_blog }">Write Blog</a></p>
							</c:when>
							<c:otherwise>
								<p>${title}</p>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<br>
<br>
