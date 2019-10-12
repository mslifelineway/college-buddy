
<%@include file="../spring-tag-libs.jsp"%>
<!--=============== PROGRAM CONTENTS ================= -->
<section class="program_content_section">
	<div
		class="program_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<!-- left content -->
		<div class="row">
			<div class="left_content col-lg-3 col-md-3 col-sm-12 col-xs-12">
				<section id="blog_title">
					<p>Top Blogs</p>
				</section>
				<c:set var="cnt" value="1" />
				<c:forEach items="${BLOGS}" var="blog">
					<!-- item 1 -->
					<s:url var="url_show_blog" value="/blog/show-blog">
						<s:param name="blogId" value="${blog.id}" />
					</s:url>
					<c:choose>
						<c:when test="${blog.id eq BLOG.id }">
							<section id="blog_link" class="d-flex"
								onclick="location.href='${url_show_blog}'"
								style="border: 1px solid #fb4502d9;">
								<div class="left-items" style="width: 50px; float: left;">
									<ul>
										<li><span
											style="border: 1px solid #174A61; border-radius: 4px; padding: 4px; font-size: 26px;">${cnt }</span></li>
										<li><i class="fa fa-caret-up" aria-hidden="true"
											title="likes (${blog.blogEmbedded.totalLikedBlog})"></i></li>
										<li>${blog.blogEmbedded.totalLikedBlog}</li>
										<li><i class="fa fa-caret-down" aria-hidden="true"
											title="dislikes (${blog.blogEmbedded.totalDislikedBlog})"></i></li>
									</ul>
									<c:set var="cnt" value="${cnt + 1 }" />
								</div>
								<div class="right-items" style="width: 100%; float: left;">
									<p>${blog.title }</p>
								</div>
								<!-- <span class="icon ion-android-arrow-dropright"></span>&nbsp;<a
								href="#">Why TO Use HYperloop In Rather Than Train Or Busses</a> -->
							</section>
						</c:when>
						<c:otherwise>
							<section id="blog_link" class="d-flex"
								onclick="location.href='${url_show_blog}'">
								<div class="left-items" style="width: 50px; float: left;">
									<ul>
										<li><span
											style="border: 1px solid #174A61; border-radius: 4px; padding: 4px; font-size: 26px;">${cnt }</span></li>
										<li><i class="fa fa-caret-up" aria-hidden="true"
											title="likes (${blog.blogEmbedded.totalLikedBlog})"></i></li>
										<li>${blog.blogEmbedded.totalLikedBlog}</li>
										<li><i class="fa fa-caret-down" aria-hidden="true"
											title="dislikes (${blog.blogEmbedded.totalDislikedBlog})"></i></li>
									</ul>
									<c:set var="cnt" value="${cnt + 1 }" />
								</div>
								<div class="right-items" style="width: 100%; float: left;">
									<p>${blog.title }</p>
								</div>
								<!-- <span class="icon ion-android-arrow-dropright"></span>&nbsp;<a
								href="#">Why TO Use HYperloop In Rather Than Train Or Busses</a> -->
							</section>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<!-- Middle content -->
			<div
				class="middle_content_container col-lg-6 col-md-9 col-sm-12 col-xs-12 mx-uto">
				<!-- middle content are -->
				<c:choose>
					<c:when test="${BLOG ne null }">
						<c:set var="blog" value="${BLOG}" />
						<div class="row">
							<section id="blog_container">
								<div id="blog_heading" class="blog_heading d-flex">
									<div class="user-image">
										<s:url var="url_user_profile_image"
											value="/static/user_profile_images/default_profile_image.png" />
										<c:if test="${blog.user.image ne null }">
											<s:url var="url_user_profile_image"
												value="/static/user_profile_images/${blog.user.image}" />
										</c:if>
										<img src="${url_user_profile_image}" alt="" />
									</div>
									<div class="blog-title">
										<p>${blog.title }</p>
										<span>Written By - ${blog.user.name } on
											${blog.writtenOn }</span>
									</div>
									<c:if test="${blog.user.id eq USER.id}">
										<div class="options">
											<span class="fa fa-ellipsis-h btn-menu"></span>
										</div>
										<div class="menu-options" id="menu-options"
											style="background: transparent">
											<div class="inner"></div>
											<!-- this div works to hide the opened menu options such as edit, delete -->
											<ul>
												<li><s:url var="url_edit_blog" value="/blog/edit-blog">
														<s:param name="blogId" value="${blog.id }" />
													</s:url> <a href="${url_edit_blog }">Edit</a></li>
												<li class="hr"></li>
												<li><a href="#">Delete</a></li>
											</ul>
										</div>
									</c:if>
								</div>
								<div id="blog" class="article_container">
									<article>${blog.desc }</article>
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
											file="../action-icons-list-with-like-dislike-for-blog.jsp"%>
									</div>
								</div>
							</section>
						</div>

					</c:when>
					<c:otherwise>
						<section id="blog_container" class="">The blog does not
							exists or found!</section>
					</c:otherwise>
				</c:choose>
			</div>
			<!-- RIGHT CONTENT.. -->
			<div class="left_content col-lg-3 col-md-3 col-sm-12 col-xs-12">
				<section id="blog_title">
					<p>Related Blogs</p>
				</section>
				<c:set var="cnt" value="1" />
				<c:forEach items="${BLOGS}" var="blog">
					<!-- item 1 -->
					<s:url var="url_show_blog" value="/blog/show-blog">
						<s:param name="blogId" value="${blog.id}" />
					</s:url>
					<c:choose>
						<c:when test="${blog.id eq BLOG.id }">
							<section id="blog_link" class="d-flex"
								onclick="location.href='${url_show_blog}'"
								style="border: 1px solid #fb4502d9;">
								<div class="left-items" style="width: 50px; float: left;">
									<ul>
										<li><span
											style="border: 1px solid #174A61; border-radius: 4px; padding: 4px; font-size: 26px;">${cnt }</span></li>
										<li><i class="fa fa-caret-up" aria-hidden="true"
											title="likes (${blog.blogEmbedded.totalLikedBlog})"></i></li>
										<li>${blog.blogEmbedded.totalLikedBlog}</li>
										<li><i class="fa fa-caret-down" aria-hidden="true"
											title="dislikes (${blog.blogEmbedded.totalDislikedBlog})"></i></li>
									</ul>
									<c:set var="cnt" value="${cnt + 1 }" />
								</div>
								<div class="right-items" style="width: 100%; float: left;">
									<p>${blog.title }</p>
								</div>
								<!-- <span class="icon ion-android-arrow-dropright"></span>&nbsp;<a
								href="#">Why TO Use HYperloop In Rather Than Train Or Busses</a> -->
							</section>
						</c:when>
						<c:otherwise>
							<section id="blog_link" class="d-flex"
								onclick="location.href='${url_show_blog}'">
								<div class="left-items" style="width: 50px; float: left;">
									<ul>
										<li><span
											style="border: 1px solid #174A61; border-radius: 4px; padding: 4px; font-size: 26px;">${cnt }</span></li>
										<li><i class="fa fa-caret-up" aria-hidden="true"
											title="likes (${blog.blogEmbedded.totalLikedBlog})"></i></li>
										<li>${blog.blogEmbedded.totalLikedBlog}</li>
										<li><i class="fa fa-caret-down" aria-hidden="true"
											title="dislikes (${blog.blogEmbedded.totalDislikedBlog})"></i></li>
									</ul>
									<c:set var="cnt" value="${cnt + 1 }" />

								</div>
								<div class="right-items" style="width: 100%; float: left;">
									<p>${blog.title }</p>
								</div>
								<!-- <span class="icon ion-android-arrow-dropright"></span>&nbsp;<a
								href="#">Why TO Use HYperloop In Rather Than Train Or Busses</a> -->
							</section>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript">
	$(document).ready(function() {
		$(".btn-menu").on('click', function() {
			$(".menu-options").css("display", "block");
		});
	});
	$(document).ready(function() {
		$(".inner").on('click', function() {
			$(".menu-options").css("display", "none");
		});
	});

	
</script>
