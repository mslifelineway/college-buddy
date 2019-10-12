<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../spring-tag-libs.jsp"%>
</head>
<body>
	<%-- ========================> CONTENT PART <========================= --%>
	<!--=============== PROGRAM CONTENTS ================= -->
	<section class="program_content_section">
		<div
			class="program_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12 ">
			<!-- left content -->
			<div class="row">
				<div class="left_content col-lg-2 col-md-2 col-sm-2 col-xs-2">
					<!-- item 1 -->
					<div class="left_content_container">
						<p>Related Workshop</p>
						<ul>
							<li><a href="#">Announcement</a></li>
							<li><a href="#">Competition</a></li>
							<li><a href="#">Startups</a></li>
							<li><a href="#">Quiz</a></li>
							<li><a href="#">News</a></li>
							<li><a href="#">Blogs</a></li>
							<li><a href="#">Events</a></li>
							<li><a href="#">Webinar</a></li>
							<li><a href="#">Magzine</a></li>
							<li><a href="#">Notice Software Testing</a></li>
							<li><a href="#">Announcement</a></li>
						</ul>
					</div>
					<!-- item 2 -->
					<div class="left_content_container">
						<p>Related Topic</p>
						<ul>
							<li><a href="#">Android Studio</a></li>
							<li><a href="#">Machine Learning</a></li>
							<li><a href="#">Artificial Intelligence</a></li>
							<li><a href="#">Cloud Computing</a></li>
							<li><a href="#">Web Development</a></li>
							<li><a href="#">Android App Development</a></li>
							<li><a href="#">Database Design</a></li>
							<li><a href="#">Java Code camp</a></li>
							<li><a href="#">os development</a></li>
							<li><a href="#">Antivirus software</a></li>
							<li><a href="#">software testing</a></li>
						</ul>
					</div>
					<!-- item 1 and 2 up to here -->
					<!-- new Item type -->
					<p>Students and Faculty</p>
					<!-- new item 1 -->
					<c:set var="y" value="{1,2,3,12,13,1,2,3,4,5,1,2,3,4,5,1,2,1}" />
					<c:forEach items="${y}" varStatus="st">
						<div class="left_content_container" style="padding: 0px;">
							<div class="col-lg-12 col-md-12 col-sm-12" style="padding: 0px;">
								<!-- user details -->
								<div class="user_details col-lg-12 col-md-12 col-sm-12"
									style="padding: 5px;">
									<div
										class="user_image_container col-lg-2 col-md-2 col-sm-2 col-md-2 col-sm-2">
										<s:url var="url_profile_image"
											value="/static/user_profile_images/account.png" />
										<img src="${url_profile_image}" class="responsive" alt="" />
									</div>
									<div
										class="user_detail_container col-lg-10 col-md-9 col-sm-9 col-md-9 col-sm-9">
										<p>
											Mr. Avatar &nbsp;<span class="ion ion-checkmark-circled"></span>&nbsp;
											<!-- for Student this icon will show -->
											<c:set var="temp" value="${temp+1}" />
											<c:if test="${temp != 4}">
												<i class="fa fa-graduation-cap pull-right"></i>
											</c:if>

											<c:if test="${temp == 4}">
												<!-- for Faculty this icon will show -->
												<i class="fa fa-user-secret pull-right"
													style="color: #009BD9"></i>
												<c:set var="temp" value="1" />
											</c:if>

											<br>
											<span>Chaitanya Institute Of dfasd sd & Science</span>
										</p>
									</div>
								</div>
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
								<div class="user_post_action col-lg-12 col-md-12 col-sm-12">
									<ul>
										<li><a href="#"><i class="fa fa-user-plus"></i><small>&nbsp;50</small></a></li>
										<li><a href="#"><i class="fa fa-commenting"></i><small>&nbsp;80</small></a></li>
										<!-- chat -->
										<li><a href="#"><i class="fa fa-comment-o"></i><small>&nbsp;30</small></a></li>
										<!-- ask or comment-->
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- Right content -->
				<div class="right_content col-lg-10 col-md-10 col-sm-10 col-xs-10">
					<div
						class="right_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
						<div class="row">
							<!-- item goes here.. -->
							<c:set var="x"
								value="{1,2,3,12,13,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,1,2,3,4,5,
                                       1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,1,2,3,4,5,8,9,10,11,12,13,1,2,3,4,5}" />
							<c:forEach items="${x}" varStatus="st">
								<div class="content_item col-lg-3 col-md-3 col-sm-3 col-xs-3">

									<div class="item">
										<img class="img-resonsive"
											src="https://images.pexels.com/photos/4154/clinic-doctor-health-hospital.jpg?auto=compress&cs=tinysrgb&dpr=1&w=500 1x, https://images.pexels.com/photos/4154/clinic-doctor-health-hospital.jpg?auto=compress&cs=tinysrgb&dpr=2&w=500 2x" />
										<p>Cloud Computing</p>
										<span>cloud computing to work with google and microsoft
											database to manage and modify</span> <br>
										<a href="#">Registration Open</a>
									</div>

								</div>
							</c:forEach>
							<!-- item end here.. -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>