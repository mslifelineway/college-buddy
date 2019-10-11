<%@include file="spring-tag-libs.jsp"%>

<!-- USER POSTS (QUESTIONS AND ANSWER) -->
<!--post item 1 -->
<c:if test="${mq eq null}">
	<div class="card col-lg-12 col-md-12 col-sm-12">
		<h4>Nothing to preview.</h4>
	</div>
</c:if>
<c:if test="${mq ne null}">
	<c:set var="carousel_no" value="1" />
	<c:forEach items="${mq}" var="mq_obj" varStatus="st">
		<div class="col-lg-12 col-md-12 col-sm-12 middle_content">
			<!-- user details -->
			<!--
					BEFORE INCLUDING 'profile-container-with-date.jsp' PAGE MUST SET 
					REQUIRED DATA ONTO THIS FILE 
				-->
			<s:url var="url_profile_image"
				value="/static/user_profile_images/${mq_obj.user.image}" />
			<s:url var="url_user_profile" value="user/user_profile">
				<s:param name="userId" value="${mq_obj.user.id}" />
			</s:url>
			<c:set var="user_name" value="${mq_obj.user.name}" />
			<s:url var="url_user_default_college"
				value="user/user-college-profile">
				<s:param name="collegeId" value="${lq_obj.user.defaultCollege.id}" />
			</s:url>
			<c:set var="user_default_college_name"
				value="${lq_obj.user.defaultCollege.collegeName}" />

			<%@include file="profile-container.jsp"%>
			<!-- user post details -->
			<div class="user_post col-lg-12 col-md-12 col-sm-12">
				<!-- QUESTION -->
				<!--question item 1 -->
				<div class="question">
					<span>Q.</span>
					<div class="question_container">
						<p class="question-data">${mq_obj.question }</p>

						<!-- QUESTION FILES -->
						<c:if test="${mq_obj.questionFiles ne null}">
							<c:set var="active" value="1" />
							<c:set var="active_fullscreen" value="1" />
							<div id="collegeBuddyCarousel${carousel_no}"
								class="carousel slide" data-ride="carousel">
								<div class="carousel-inner gallery">
									<c:forEach items="${mq_obj.questionFiles}" var="carousel_item">
										<s:url var="carousel_image"
											value="/static/question_files/${carousel_item.fileName }" />
										<c:choose>
											<c:when test="${active eq '1'}">
												<div class="carousel-item active">
													<a href="${carousel_image }" class="gallery-popup"><img
														src="${carousel_image }"
														style="background: #f3f3f3; object-fit: none; object-position: center; width: 100%"
														class="d-block w-100" alt="The file could not be loaded."></a>
												</div>
												<c:set var="active" value="0" />
											</c:when>
											<c:otherwise>
												<div class="carousel-item">
													<a href="${carousel_image }" class="gallery-popup"><img
														src="${carousel_image }"
														style="background: #f3f3f3; object-fit: none; object-position: center; width: 100%"
														class="d-block w-100" alt="The file could not be loaded."></a>
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
								<a class="carousel-control-prev"
									href="#collegeBuddyCarousel${carousel_no}" role="button"
									data-slide="prev"> <i
									class="carousel-control-prev-icon fa fa-angle-left"
									aria-hidden="true"></i> <span class="sr-only">Previous</span>
								</a> <a class="carousel-control-next"
									href="#collegeBuddyCarousel${carousel_no}" role="button"
									data-slide="next"> <i
									class="carousel-control-next-icon fa fa-angle-right"
									aria-hidden="true"></i> <span class="sr-only">Next</span>
								</a>
								<c:set var="carousel_no" value="${carousel_no + 1 }" />
							</div>
						</c:if>

						<div class="user_post_action col-lg-12 col-md-12 col-sm-12">
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

							<%@include file="action-icons-list.jsp"%>
						</div>

					</div>
				</div>

				<!-- ANSWER -->
				<c:if test="${mq_obj.answers ne null}">
					<c:forEach items="${mq_obj.answers }" var="ans_obj" varStatus="st">
						<div class="answer">
							<span>A.</span>
							<div class="answer_container">
								<p class="answer-data">${ans_obj.answer}</p>
								<img
									src="https://images.unsplash.com/photo-1501159771943-cc9027db4d8b?ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80"
									class="img-resonsive" />
								<!-- user post actions area like share, comments, like etc -->
								<div class="user_post_action col-lg-12 col-md-12 col-sm-12">
									<!--  
									BEFORE INCLUDING BELOW FILE MUST SET DATA REQUIRED FOR THAT FILE
								-->
									<c:set var="total_shared" value="${ans_obj.shared}" />
									<c:set var="total_disliked"
										value="${ans_obj.answerEmbedded.totalDislikedAnswer}" />
									<c:set var="total_liked"
										value="${ans_obj.answerEmbedded.totalLikedAnswer}" />
									<c:set var="answer_user_id" value="${ans_obj.user.id}" />
									<c:set var="answer_status"
										value="${ans_obj.answerEmbedded.answerStatus}" />
									<c:set var="answer_id" value="${ans_obj.id}" />

									<!-- This item will be updated dynamically without page refreshing, whenever an answer will be liked or disliked -->
									<div class="action_icon_list_with_like_dislike${answer_id }">
										<%@include file="action-icons-list-with-like-dislike.jsp"%>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</c:forEach>
</c:if>
