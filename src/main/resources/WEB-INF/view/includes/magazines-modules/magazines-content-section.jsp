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

			<div class="magazine-contents col-lg-3 col-md-3 col-sm-3">
				<!-- Top Magazines -->
				<div class="content">
					<h5>Top Magazines</h5>
					<section class="content-list">
						<ul>
							<li>Half Girlfriend</li>
						</ul>
					</section>
				</div>
				<!-- Top Novels -->
				<div class="content">
					<h5>Top Novels</h5>
					<section class="content-list">
						<ul>
							<li>Half Girlfriend</li>
						</ul>
					</section>
				</div>
				<!-- Top Books -->
				<div class="content">
					<h5>Top Books</h5>
					<section class="content-list">
						<ul>
							<li>Half Girlfriend</li>
						</ul>
					</section>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 item-section">
				<!-- Magazines Section -->
				<div class="row">
					<div class="heading col-lg-12 col-md-12 col-sm-12">
						<div
							class="heading-section d-flex justify-content-between align-item-center">
							<h5>Magazines</h5>
							<!--  Note : if count of magazines will be greater than three then Only More Options will be display-->
							<a href="#" class="pull-right">More</a>
						</div>
					</div>
					<c:set var="x" value="{1,2,3}" />
					<c:forEach items="${x}">
						<div class="magazine-item col-lg-4 col-md-4 col-sm-4">
							<div class="item">
								<img alt="" src="/static/images/college_dp.jpg"
									class="img-responsive" />
								<ul class="d-flex align-item-center">
									<li><a href="#" class="btn-view">View</a></li>
									<li><a href="#" class="btn-download">Download</a></li>
								</ul>
								<p>Magazine Name</p>
							</div>

						</div>
					</c:forEach>
				</div>
				<!-- Novel Section -->
				<div class="row">
					<div class="heading col-lg-12 col-md-12 col-sm-12">
						<div
							class="heading-section d-flex justify-content-between align-item-center">
							<h5>Novels</h5>
							<a href="#" class="pull-right">More</a>
						</div>
					</div>
					<c:set var="x" value="{1,2,3}" />
					<c:forEach items="${x}">
						<div class="magazine-item col-lg-4 col-md-4 col-sm-4">
							<div class="item">
								<img alt="" src="/static/images/college_dp.jpg"
									class="img-responsive" />
								<ul class="d-flex align-item-center">
									<li><a href="#"
										style="border: 1px solid #2BC105; color: #2BC105;">View</a></li>
									<li><a href="#"
										style="border: 1px solid #EF4723; color: #EF4723;">Download</a></li>
								</ul>
								<p>Novel Name</p>
							</div>

						</div>
					</c:forEach>
				</div>
				<!-- Books Sections -->
				<div class="row">
					<div class="heading col-lg-12 col-md-12 col-sm-12">
						<div
							class="heading-section d-flex justify-content-between align-item-center">
							<h5>Books</h5>
							<a href="#" class="pull-right">More</a>
						</div>
					</div>
					<c:set var="x" value="{1,2,3}" />
					<c:forEach items="${x}">
						<div class="magazine-item col-lg-4 col-md-4 col-sm-4">
							<div class="item">
								<img alt="" src="/static/images/college_dp.jpg"
									class="img-responsive" />
								<ul class="d-flex align-item-center">
									<li><a href="#"
										style="border: 1px solid #2BC105; color: #2BC105;">View</a></li>
									<li><a href="#"
										style="border: 1px solid #EF4723; color: #EF4723;">Download</a></li>
								</ul>
								<p>Book Name</p>
							</div>

						</div>
					</c:forEach>
				</div>
			</div>
			<div
				class="magazine-contents col-lg-3 col-md-3 col-sm-3">
				<div class="right-section">
					<!-- Newest Uploads -->
					<div class="content">
						<h5>Newest Uploads</h5>
						<section class="content-list">
							<ul>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
							</ul>
						</section>
					</div>
					<!-- Top Novels -->
					<div class="content">
						<h5>Latest Uploads</h5>
						<section class="content-list">
							<ul>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
								<li>Half Girlfriend</li>
							</ul>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>