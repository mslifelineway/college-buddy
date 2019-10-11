<%@include file="spring-tag-libs.jsp"%>
<%-- ========================> HEADER PART <========================= --%>
<section id="header">
	<div class="header col-lg-12 col-md-12 col-sm-12 fixed-top ">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
				<div class="row">
					<c:set var="user" value="${USER}" />
					<!-- THIS LAYOUT WILL SHOW AFTER USER LOGIN -->
					<div class="profile_container col-lg-12 col-md-12 col-sm-12">
						<div
							class="profile_image_container col-lg-2 col-md-2 col-sm-2 col-md-2 col-sm-2 text-center">
							<s:url var="url_profile_image"
								value="/static/user_profile_images/default_profile_image.png" />
							<c:if test="${USER.image ne null }">
								<s:url var="url_profile_image"
									value="/static/user_profile_images/${USER.image }" />
							</c:if>
						</div>
						<img src="${url_profile_image}" class="responsive" alt="img" />
					</div>
					<div
						class="profile_data col-lg-9 col-md-9 col-sm-9 col-md-9 col-sm-9">
						<s:url var="url_my_profile" value="/user/user_profile">
							<s:param name="userId" value="${USER.id }" />
						</s:url>
						<p>
							<a href="${url_my_profile}">${USER.name }</a>&nbsp;<br> <span>${USER.defaultCollege.collegeName}</span>
						</p>
					</div>
				</div>
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
					<!-- THE SELECTED CHAT ROOM WILL BE SHOWN HERE... -->
					<p>${title}</p>
				</div>
			</div>
		</div>
	</div>
	</div>
</section>
<br>
<br>