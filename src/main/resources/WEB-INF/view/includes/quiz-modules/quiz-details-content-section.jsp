<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../spring-tag-libs.jsp" %>
</head>
<body>
	<section class="content_section">
		<div
			class="content_section_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
			<!-- left content -->
			<div class="row">
				<div class="left_content col-lg-3 col-md-3 col-sm-3 col-xs-3">
					<%@include file="../tree_form_contents.jsp"%>
				</div>
				<!-- Middle content -->
				<div class="middle_content col-lg-6 col-md-6 col-sm-6 col-xs-6">
					<c:set var="x" value="1" />
					<c:set var="array"
						value="{1,2,1,2,1,2,1,2,3,1,2,1,2,1,2,23,1,2,3,1}" />
					<c:forEach items="${array}">
						<!-- item 1 start here -->
						<div
							class="middle_content_container col-lg-12 col-md-12 col-sm-12 col-xs-12">
							<p>
								Problem ${x}.<span class="pull-right " style="color: #174A61"><small>Asked
										by:&nbsp; </small><a href="#"
									style="color: #174A61; text-decoration: underline">Surya
										Bhai</a></span>
							</p>

							<c:set var="x" value="${x+1}" />
							<section id="question">
								<span> Pied Piper currently have A users and gains X user
									every day, Other company Hooli has B users and gains Y users
									every day, given a parameter Z you have to tell which company
									reaches Z users first. In case if both the company reach Z
									users on the same day then you have to print RIP Piper has N
									supporters C1, C2,Cn. When an i-th supporter supports Piper,
									company instantly gains Ci subscriber and the value of Ci is
									halved A supporter can support any number of times. Print the
									minimum number of time supporters must support so that Pied
									piper gains control of Pipernet else print RIP. </span>
							</section>
							<section id="action">
								<ul class="d-flex justify-content-between">
									<li><s:url var="url_view_problem"
											value="/quiz/view-problem" /> <a
										href="${url_view_problem}">View&nbsp;Answer</a></li>
									<li><a href="#">Write&nbsp;Answer</a></li>
									<li><a href="#">Discuss</a></li>
									<li><a href="#">Follow</a></li>
								</ul>
							</section>
						</div>
						<!-- item 1 end here -->
					</c:forEach>
				</div>
				<!-- RIGHT CONTENT.. -->
				<div
					class="group_members_section col-lg-3 col-md-3 col-sm-3 col-xs-3 p-0">
					Right content goes here...</div>
			</div>
		</div>
	</section>
</body>
</html>