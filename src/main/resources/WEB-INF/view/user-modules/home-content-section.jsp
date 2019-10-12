<%@include file="includes/spring-tag-libs.jsp"%>
<s:url var="home_content_css"
	value="/static/user-css/home-content-css.css" />
<link href="${home_content_css}" rel="stylesheet">
<s:url var="user_profile_sidebar_css"
	value="/static/user-css/user-profile-sidebar-css.css" />
<link href="${user_profile_sidebar_css}" rel="stylesheet">
<s:url var="action_icon_list"
	value="/static/css/action-icon-list-css.css" />
<link href="${action_icon_list}" rel="stylesheet">

<div class="col-lg-12 col-md-12 col-sm-12 main-container">
	<div class="row">
		<%@include file="includes/user-profile-sidebar.jsp"%>
		<div class="col-lg-9 col-md-9 col-sm-9">

			<!-- Blog list Section-->
			<div class="row question-section">
				<div
					class="q-title d-flex justify-content-between align-item-center">

					<h4>Blogs</h4>
					<c:if test="${USER_BLOGS.size() > 3 }">
						<a href="#" class="pull-right">View All</a>
					</c:if>
				</div>
				<div class="question-container">
					<!-- Only Three Data will show -->
					<c:choose>
						<c:when test="${USER_BLOGS ne null}">

							<c:forEach items="${USER_BLOGS }" var="blog">

								<!-- item 1 -->
								<div class="question-item">
									<div class="details">
										<div id="blog_heading" class="blog_heading d-flex">
											<div class="blog-title">
												<h5>${blog.title}</h5>
											</div>
											<c:if test="${blog.user.id eq USER.id}">
												<div class="options">
													<span class="fa fa-ellipsis-h btn-menu"
														onclick="showMenuOptions('Blog${blog.id}')"></span>
												</div>
												<div class="menu-options menu-optionsBlog${blog.id}"
													id="menu-options" style="background: transparent">
													<div class="inner"></div>
													<!-- this div works to hide the opened menu options such as edit, delete -->
													<ul>
														<li><s:url var="url_edit_blog"
																value="/blog/edit-blog">
																<s:param name="blogId" value="${blog.id }" />
															</s:url> <a href="${url_edit_blog }">Edit</a></li>
														<li class="hr"></li>
														<li><s:url var="url_delete_blog"
																value="/blog/delete-blog">
																<s:param name="blogId" value="${blog.id }" />
															</s:url> <a href="${url_delete_blog }">Delete</a></li>
													</ul>
												</div>
											</c:if>
										</div>
										<div class="question">
											<article>${blog.desc }</article>
											<div class="transparent-background"></div>
										</div>
									</div>
									<div class="q_date">
										<small class="pull-right">${blog.writtenOn }</small>
									</div>
									<div class="user_post_action col-lg-12 col-md-12 col-sm-12">
										<!--  
									BEFORE INCLUDING BELOW FILE MUST SET DATA REQUIRED FOR THAT FILE
								-->
										<c:set var="total_shared" value="${blog.shared}" />
										<c:set var="total_disliked"
											value="${blog.blogEmbedded.totalDislikedBlog}" />
										<c:set var="total_liked"
											value="${blog.blogEmbedded.totalLikedBlog}" />
										<c:set var="blogger_id" value="${blog.user.id}" />
										<c:set var="blog_status"
											value="${blog.blogEmbedded.blogStatus}" />
										<c:set var="blog_id" value="${blog.id}" />
										<!-- This item will be updated dynamically without page refreshing, whenever an blog will be liked or disliked -->
										<div
											class="action_icon_list_with_like_dislike_for_blog${blog.id }">
											<%@include
												file="../includes/action-icons-list-with-like-dislike-for-blog.jsp"%>
										</div>
									</div>

								</div>

							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="question-item">
								<div class="">
									<div class="blog">
										<h5>No blogs found...</h5>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

			</div>

			<!-- Section-2 -->
			<!-- Asked Question Section -->
			<div class="row question-section">
				<div
					class="q-title d-flex justify-content-between align-item-center">
					<h4>Asked Question</h4>
					<c:if test="${ASKED_QUESTIONS.size() > 3 }">
						<s:url var="view_all_questions"
							value="/questions/view-all-asked-questions" />
						<a href="${view_all_questions }" class="pull-right">View All</a>
					</c:if>
				</div>
				<div class="question-container">
					<!-- Only Three Data will show -->
					<c:choose>
						<c:when test="${ASKED_QUESTIONS ne null}">
							<c:forEach items="${ASKED_QUESTIONS }" var="qs">

								<!-- item 1 -->
								<div class="question-item">
									<div class="details d-flex">
										<div class="question">
											<article>${qs.question}</article>
											<div class="transparent-background"></div>
										</div>
										<c:if test="${qs.user.id eq USER.id}">
											<div class="options">
												<span class="fa fa-ellipsis-h btn-menu"
													onclick="showMenuOptions('Ques${qs.id}')"></span>
											</div>
											<div class="menu-options menu-optionsQues${qs.id}"
												id="menu-options" style="background: transparent">
												<div class="inner"></div>
												<!-- this div works to hide the opened menu options such as edit, delete -->
												<ul>
													<li><s:url var="url_edit_asked_question"
															value="/question/edit-asked-question">
															<s:param name="questionId" value="${qs.id }" />
														</s:url><a href="${url_edit_asked_question }">Edit</a></li>
													<li class="hr"></li>
													<li><s:url var="url_delete_asked_question"
															value="/question/delete-asked-question">
															<s:param name="questionId" value="${qs.id }" />
														</s:url> <a href="${url_delete_asked_question }">Delete</a></li>
												</ul>
											</div>
										</c:if>
									</div>
									<div class="q_date">
										<small class="pull-right">${qs.date }</small>
									</div>
									<div class="user_post_action col-lg-12 col-md-12 col-sm-12">
										<!--  
									BEFORE INCLUDING BELOW FILE MUST SET DATA REQUIRED FOR THAT FILE
								-->
										<c:set var="total_shared" value="${qs.shared}" />
										<c:set var="total_answered"
											value="${qs.questionEmbedded.countAQuestionAnswered}" />
										<c:set var="total_followed"
											value="${qs.questionEmbedded.countAQuestionFollowed }" />
										<c:set var="question_user_id" value="${qs.user.id}" />
										<c:set var="user_follow_this_question"
											value="${qs.questionEmbedded.userFollowThisQuestion}" />
										<c:set var="question_id" value="${qs.id}" />
										<%@include file="../includes/action-icons-list.jsp"%>
									</div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="question-item">
								<div class="">
									<div class="blog">
										<h5>This user hasn't asked any question yet.</h5>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>



				</div>

			</div>
			<!-- Section-3 -->
			<!-- Answered to a question Section-->
			<div class="row question-section">
				<div
					class="q-title d-flex justify-content-between align-item-center">
					<h4>Answered</h4>
					<c:if test="${ANSWERED.size() > 3 }">
						<s:url var="view_all_answers"
							value="/answers/view-all-answered-questions" />
						<a href="${view_all_answers }" class="pull-right">View All</a>
					</c:if>
				</div>
				<div class="question-container">
					<!-- Only Three Data will show -->
					<c:choose>
						<c:when test="${ANSWERED ne null}">
							<c:forEach items="${ANSWERED}" var="ans">

								<!-- item 1 -->
								<div class="question-item">
									<!-- Question goes here -->
									<div class="d-flex">
										<div class="answer_to_question">
											<article>${ans.question.question }</article>
										</div>
										<c:if test="${ans.user.id eq USER.id}">
											<div class="options">
												<span class="fa fa-ellipsis-h btn-menu"
													onclick="showMenuOptions('Ans${ans.id}')"></span>
											</div>
											<div class="menu-options menu-optionsAns${ans.id}"
												id="menu-options" style="background: transparent">
												<div class="inner"></div>
												<!-- this div works to hide the opened menu options such as edit, delete -->
												<ul>
													<li><a href="#">Edit</a></li>
													<li class="hr"></li>
													<li><a href="#">Delete</a></li>
												</ul>
											</div>
										</c:if>
									</div>
									<div class="answer">
										<article>${ans.answer }</article>
										<div class="transparent-background"></div>
									</div>

									<div class="q_date">
										<small class="pull-right">${ans.date }</small>
									</div>
									<!-- TODO: BLOG SECTION ICON -->
									<div class="user_post_action col-lg-12 col-md-12 col-sm-12">
										<!--  
									BEFORE INCLUDING BELOW FILE MUST SET DATA REQUIRED FOR THAT FILE
								-->
										<c:set var="total_shared" value="${ans.shared }" />
										<c:set var="total_disliked"
											value="${ans.answerEmbedded.totalDislikedAnswer }" />
										<c:set var="total_liked"
											value="${ans.answerEmbedded.totalLikedAnswer }" />
										<c:set var="answer_user_id" value="${ans.user.id}" />
										<c:set var="answer_status"
											value="${ans.answerEmbedded.answerStatus }" />
										<c:set var="answer_id" value="${ans.id}" />
										<%@include
											file="../includes/action-icons-list-with-like-dislike.jsp"%>
									</div>

								</div>

							</c:forEach>
						</c:when>
						<c:otherwise>
							<div class="question-item">
								<div class="">
									<div class="blog">
										<h5>This user hasn't answered any question yet.</h5>
									</div>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

			</div>
			<!-- Section-4 -->

		</div>
	</div>
</div>
