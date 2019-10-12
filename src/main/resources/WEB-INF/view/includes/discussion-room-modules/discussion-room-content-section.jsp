<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../spring-tag-libs.jsp"%>
</head>
<body>

	<div class="col-lg-12 col-md-12 col-sm-12 main-container">
		<div class="row">
			<div class="col-lg-3 col-md-3 col-sm-3 left-container p-0">
				<div
					class="button-section justify-content-center d-flex align-item-center">
					<div class="button">
						<p class="btn-chat-room tab" onclick="openTab('1')">Chat Room</p>
					</div>
					<div class="button">
						<p class="btn-personal-chat tab" onclick="openTab('2')">Personal
							Chat</p>
					</div>
				</div>

				<div class="chat-room-section chat-section justify-content-center">

					<!--  Chat Item -->
					<c:set var="x" value="{1,2,3,4,5,6,1,2,3,3,2,1}" />
					<c:forEach items="${x}">
						<div class="chat-container">
							<div class="user-details d-flex">
								<s:url var="url_user_image"
									value="/static/images/college_dp.jpg" />
								<img class="user-image" src="${url_user_image}" alt="" /> <span>Android
									Discussion Android Discussion Android Discussion</span>
							</div>
							<div class="chat-box">
								<span>In this group we use to discuss about the android
									development daily. In this group we use to discuss about the
									android development daily</span>
							</div>
							<div class="chat-status">
								<ul class="justify-content-between d-flex align-item-center">
									<li class="members">Members(100)</li>
									<li class="active">Active(20)</li>
								</ul>
							</div>
						</div>
					</c:forEach>
					<!--  chat item end -->
				</div>

				<!-- Personal Chat Area -->
				<div class="personal-chat-section">Personal Chat Section</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 middle_content">
				<div
					class="middle_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<!-- validating student is joined the selected group or not (1 for joined and 0 for not joined)-->
					<c:choose>
						<c:when test="${validStudent ne '1'}">
							<!-- it means student has joined the selected group -->
							<section id="message_container">
								<c:set var="validStudent" value="0" />
								<!-- item goes here.. -->
								<c:set var="x"
									value="{1,2,3,12,13,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,1,2,3,4,5,
                                               1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,1,2,3,4,5,8,9,10,11,12,13,1,2,3,4,5}" />
								<c:forEach items="${x}" varStatus="st">
									<div
										class="chat_item col-lg-10 col-md-10 col-sm-10 col-xs-10 d-flex">
										<section id="sender_image">
											<s:url var="url_user_image"
												value="/static/images/college_dp.jpg" />
											<img src="${url_user_image}" alt="" />
										</section>
										<section id="message">hey dude whats up how the hell
											are you doing these days ...... is everything ok or the is
											messed up seriously. Hey guys i want to join this group to
											discuss with you , show your interest for me
											.......................!!!!!</section>
									</div>
									<div
										class="chat_item col-lg-9 col-md-10 col-sm-10 col-xs-10 d-flex pull-right justify-content-end">
										<section id="message" class="text-right">Hello dude!
											How are your?</section>
										<section id="sender_image">
											<s:url var="url_user_image"
												value="/static/demo-images/mukesh.jpeg" />
											<img src="${url_user_image}" alt="" />
										</section>
									</div>
								</c:forEach>
								<!-- item end here.. -->
							</section>
							<!-- FOOTER AREA OR MESSAGING OPTIONS CONTAINER -->
							<div
								class="chat_box col-lg-12 col-md-12 col-sm-12 col-xs-12 d-flex">
								<section id="chat">
									<i class="fa fa-image"></i><i class="fa fa-smile-o"></i> <input
										type="text" placeholder="type..." /> <span class="pull-right">Send</span>
								</section>
							</div>
						</c:when>
						<c:otherwise>
							<!-- it means student has not joined the selected group -->
							<div
								class="group_details_section col-lg-12 col-md-12 col-sm-12 col-xs-12 p-0 text-center">
								<section id="group_cover_image">
									<s:url var="url_group_cover_image"
										value="/static/images/college_banner.jpg" />
									<img src="${url_group_cover_image}" alt="" />
								</section>
								<section id="group_logo">
									<!-- this 'A' will replace by first letter of first name of the selected group -->
									<p>A</p>
								</section>
								<section id="group_name">
									<p>Android Discussion</p>
								</section>
								<section id="group_desc">
									<p>In this group we use to discuuss about the android
										development daily</p>
								</section>
								<section id="group_status">
									<p>Members - 300</p>
									<p>Active - 99</p>
								</section>
								<section id="group_join">
									<span class="">Join</span>
								</section>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

			</div>
			<div class="group_members_section col-lg-3 col-md-3 col-sm-3">
				<!-- item 1 -->
				<c:set var="x"
					value="{1,1,1,1,2,2,2,2,2,2,1,1,1,1,2,2,2,2,2,2,1,1,1,1,1}" />
				<c:forEach items="${x}" varStatus="st">
					<div
						class="group_members_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<!-- tag items -->
						<div class="row">
							<div
								class="group_members_profile col-lg-9 col-md-9 col-sm-9 d-flex">
								<s:url var="url_user_image" value="/static/images/account.png" />
								<img src="${url_user_image}" alt="" /> <span>Mr. Avtar</span>
							</div>
							<div
								class="group_members_status col-lg-3 col-md-3 col-sm-3 d-flex justify-content-between">
								<span class="ion ion-checkmark-circled"></span>&nbsp;
								<!-- for Student this icon will show -->
								<c:set var="temp" value="${temp+1}" />
								<c:if test="${temp != 4}">
									<i class="fa fa-graduation-cap pull-right"></i>
								</c:if>

								<c:if test="${temp == 4}">
									<!-- for Faculty this icon will show -->
									<i class="fa fa-user-secret pull-right" style="color: #009BD9"></i>
									<c:set var="temp" value="1" />
								</c:if>
								<!-- if student status -->
								<c:choose>
									<c:when test="${temp == 3}">
										<!-- if student is online or active -->
										<i class="fa fa-circle pull-right" style="color: #2BC105"></i>
									</c:when>
									<c:otherwise>
										<!-- if student is offline -->
										<i class="fa fa-circle pull-right" style="color: #fff"></i>
									</c:otherwise>
								</c:choose>
							</div>

						</div>
					</div>
				</c:forEach>

			</div>

		</div>


	</div>

	<script type="text/javascript">
		function openTab(index) {
			/// index = 1 ==> button class="btn-chat-room" , and tab section class ="chat-room-section"
			/// index = 2 ==> button class="btn-personal-chat" , and tab section class ="personal-chat-section"
			if (index == 1) {
				defaultTab();
				$(".btn-chat-room").css("background-color", "#ddd");
				$(".btn-chat-room").css("border-bottom", "2px solid #174A61");
				$(".personal-chat-section").css("display", "none");
				$(".chat-room-section").css("display", "block");
			}

			if (index == 2) {
				defaultTab();
				$(".btn-personal-chat").css("background-color", "#ddd");
				$(".btn-personal-chat").css("border-bottom",
						"2px solid #174A61");
				$(".chat-room-section").css("display", "none");
				$(".personal-chat-section").css("display", "block");
			}

		}

		function defaultTab() {
			$(".btn-chat-room").css("background-color", "#fafafa");
			$(".btn-chat-room").css("border-bottom", "2px solid  #ccc");
			$(".btn-personal-chat").css("background-color", "#fafafa");
			$(".btn-personal-chat").css("border-bottom", "2px solid  #ccc");
		}
	</script>
</body>
</html>