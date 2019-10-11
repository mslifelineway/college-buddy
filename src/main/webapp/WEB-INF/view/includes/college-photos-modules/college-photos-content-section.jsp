<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<style>
.header {
	background: linear-gradient(to top, #a18cd1 0%, #fbc2eb 100%);
}

body {
	background-image: linear-gradient(45deg, #a18cd1 0%, #fbc2eb 100%);
}
</style>
<body>
	<div class="col-lg-12 col-md-12 col-sm-12 main-container">
		<div class="row">
			<div
				class="photos-section col-lg-6 col-md-6 col-sm-6 main-container mx-auto">
				<c:set value="{1,1,2,2,1,2,1,2,3,1,2,3,1,2,3,2}" var="x" />
				<c:set value="1" var="a" />
				<c:forEach items="${x}">
					<div class="photo-frame col-lg-3 col-md-3 col-sm-3">
						<img alt="" class="photo-frame${a}" src="/static/images/college_dp.jpg"
							onclick="showImage('${a}')"/>
							<c:set var="a" value="${a+1}" />
					</div>
					<div class="photo-frame col-lg-3 col-md-3 col-sm-3">
						<img alt="" src="/static/demo-images/ahmed.jpg" />
						<c:set var="a" value="${a+1}" />
					</div>
					<div class="photo-frame col-lg-3 col-md-3 col-sm-3">
						<img alt="" src="/static/demo-images/ansari.jpeg" />
						<c:set var="a" value="${a+1}" />
					</div>
					<div class="photo-frame col-lg-3 col-md-3 col-sm-3">
						<img alt="" src="/static/demo-images/mukesh.jpeg" />
						<c:set var="a" value="${a+1}" />
					</div>
					<div class="photo-frame col-lg-3 col-md-3 col-sm-3">
						<img alt="" src="/static/demo-images/irfan.jpg" />
						<c:set var="a" value="${a+1}" />
					</div>
					<div class="photo-frame col-lg-3 col-md-3 col-sm-3">
						<img alt="" src="/static/demo-images/group-image.jpeg" />
						<c:set var="a" value="${a+1}" />
					</div>
					<div class="photo-frame col-lg-3 col-md-3 col-sm-3">
						<img alt="" src="/static/demo-images/jahangeer.jpg" />
						<c:set var="a" value="${a+1}" />
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!--  modal  -->
	<div class="modal" id="show-image-modal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">Modal body..</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>


	<script type="text/javascript">
	var x = 2;
		function showImage(cnt) {
			var src = $(".photo-frame"+cnt).attr("src");
			
			alert(src);
			$(".photo-frame"+cnt).popover({
					data-toggle: 'popover',
					data-placement: 'bottom',
					data-content: "Hello World"
				});
			
		}

		
	</script>

</body>
</html>