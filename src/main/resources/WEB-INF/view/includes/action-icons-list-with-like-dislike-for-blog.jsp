
<%@include file="spring-tag-libs.jsp"%>

<div class="icon-list-container" style="width: 100%; margin: 0px;">
	<c:if test="${USER eq null}">
		<ul class="d-flex justify-content-between align-item-center"
			style="width: 100%; margin: 0px;">
			<li><p title="Share Now">
					<i class="ion ion-share" aria-hidden="true"></i><small>&nbsp;${total_shared}</small>
				</p></li>
			<li><p title="You must login to dislike this">
					<i class="fa fa-thumbs-o-down" aria-hidden="true"></i><small>&nbsp;${total_disliked}</small>
				</p></li>
			<li><p title="Your must login to like this">
					<i class="fa fa-thumbs-o-up" aria-hidden="true"></i><small>&nbsp;${total_liked}</small>
				</p></li>
			<li><p title="View">
					<s:url var="url_view_blog" value="/blog/show-blog">
						<s:param name="blogId" value="${blog_id }"></s:param>
					</s:url>
					<a href="${url_view_blog}"><i class="fa fa-eye"
						aria-hidden="true"></i></a>
				</p></li>
		</ul>
	</c:if>
	<c:if test="${USER ne null}">
		<ul class="d-flex justify-content-between align-item-center">
			<li><p title="Share Now">
					<i class="ion ion-share"></i><small>&nbsp;${total_shared}</small>
				</p></li>
			<c:choose>
				<c:when test="${blogger_id eq USER.id}">
					<li><p title="You are unable to dislike this"
							style="cursor: not-allowed;">
							<i class="fa fa-thumbs-o-down" aria-hidden="true"></i><small>&nbsp;${total_disliked}</small>
						</p></li>
					<li><p title="You are unable to like this"
							style="cursor: not-allowed;">
							<i class="fa fa-thumbs-o-up" aria-hidden="true"></i><small>&nbsp;${total_liked}</small>
						</p></li>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${blog_status eq '2'}">
							<li><p title="You disliked this"
									style="color: #009BD9; cursor: not-allowed;">
									<i class="fa fa-thumbs-o-down" aria-hidden="true"></i><small>&nbsp;${total_disliked}</small>
								</p></li>
							<li><p title="No, I like this"
									onclick="likeThisBlog('${blog_id }' , '${total_shared}')">
									<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp;<small>${total_liked}</small>
								</p></li>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when test="${blog_status eq '1'}">
									<li><p title="No, I don't like this"
											onclick="disLikeThisBlog('${blog_id }' , '${total_shared}')">
											<i class="fa fa-thumbs-o-down" aria-hidden="true"></i>&nbsp;<small>${total_disliked}</small>
										</p></li>
									<li><p title="You liked this"
											style="color: #009BD9; cursor: not-allowed;">
											<i class="fa fa-thumbs-o-up" aria-hidden="true"></i><small>&nbsp;${total_liked}</small>
										</p></li>
								</c:when>
								<c:otherwise>
									<li><p title="I don't like this"
											onclick="disLikeThisBlog('${blog_id }' , '${total_shared}')">
											<i class="fa fa-thumbs-o-down" aria-hidden="true"></i>&nbsp;<small>${total_disliked}</small>
										</p></li>
									<li><p title="I like this"
											onclick="likeThisBlog('${blog_id }' , '${total_shared}')">
											<i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp;<small>${total_liked}</small>
										</p></li>
								</c:otherwise>
							</c:choose>
						</c:otherwise>

					</c:choose>
				</c:otherwise>
			</c:choose>
			<li><p title="View">
					<s:url var="url_view_blog" value="/blog/show-blog">
						<s:param name="blogId" value="${blog_id }"></s:param>
					</s:url>
					<a href="${url_view_blog}"><i class="fa fa-eye"
						aria-hidden="true"></i></a>
				</p></li>
		</ul>
	</c:if>
</div>
