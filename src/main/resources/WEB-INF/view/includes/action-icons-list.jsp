
<%@include file="spring-tag-libs.jsp"%>

<div class="icon-list-container" style="width: 100%; margin: 0px;">
	<c:if test="${USER eq null}">
		<ul class="d-flex justify-content-between align-item-center"
			style="width: 100%; margin: 0px;">
			<li><p title="Share Now" onclick="showShareButtons()">
					<i class="ion ion-share" aria-hidden="true"></i><small>&nbsp;${total_shared}</small>
				</p></li>
			<li><p title="You must login to Write answer">
					<i class="fa fa-edit"></i><small>&nbsp;${total_answered}</small>
				</p></li>
			<li><p title="You must login to follow this">
					<i class="fa fa-question-circle"></i><small>&nbsp;${total_followed}</small>
				</p></li>
			<li><p title="Show More">
					<i class="fa fa-eye" aria-hidden="true"></i>
				</p></li>
		</ul>
	</c:if>
	<c:if test="${USER ne null}">
		<ul class="d-flex justify-content-between align-item-center">
			<li><p title="Share Now" onclick="showShareButtons()">
					<i class="ion ion-share"></i><small>&nbsp;${total_shared}</small>
				</p></li>
				<s:url var="url_write_answer" value="/question/write-answer">
					<s:param name="questionId" value="${question_id}"/>
				</s:url>
			<li><a href="${url_write_answer}" title="Write an answer">
					<i class="fa fa-edit"></i><small>&nbsp;${total_answered}</small>
				</a></li>

			<c:choose>
				<c:when test="${question_user_id eq USER.id}">
					<li><p title="Your can not follow this">
							<i class="fa fa-question-circle"></i><small>&nbsp;${total_followed}</small>
						</p></li>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${user_follow_this_question eq '1'}">
							<li><p title="You are following this" style="color: #009BD9">
									<i class="fa fa-question-circle"></i><small>&nbsp;${total_followed}</small>
								</p></li>
						</c:when>
						<c:otherwise>
							<li><p onclick="followQuestion('${question_id}')"
									title="Follow this">
									<i class="fa fa-question-circle"></i><small>&nbsp;${total_followed}</small>
								</p></li>
						</c:otherwise>

					</c:choose>
				</c:otherwise>
			</c:choose>
			<li><p title="Show More">
					<i class="fa fa-eye" aria-hidden="true"></i>
				</p></li>
		</ul>
	</c:if>
</div>
