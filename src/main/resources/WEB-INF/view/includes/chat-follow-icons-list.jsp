
<%@include file="spring-tag-libs.jsp"%>

<div class="icon-list-container" style="width: 100%; margin: 0px;">
	<ul class="d-flex justify-content-between align-item-center"
		style="width: 100%; margin: 0px;">
		<li title="Follow"><a href="#"><i class="fa fa-user-plus"></i><small>&nbsp;50</small></a></li>
		<s:url var="url_chat_room" value="/chat/chat_room" />
		<li title="Chat"><a href="${url_chat_room}"><i
				class="fa fa-commenting"></i><small>&nbsp;80</small></a></li>
		<!-- chat -->
		<li title="Ask your query"><a href="#"><i
				class="fa fa-comment-o"></i><small>&nbsp;30</small></a></li>
		<!-- ask or comment-->
	</ul>
</div>
