<%@include file="spring-tag-libs.jsp"%>
<%-- plugins for cropping image --%>
<s:url var="url_cropper_css" value="/static/cropper/croppie.css" />
<link href="${url_cropper_css}" rel="stylesheet">

<div class="col-lg-3 col-md-3 col-sm-3 profile-container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 cover-image-box">
			<s:url var="url_user_cover_image"
				value="/static/user_profile_images/default_cover_image.png" />
			<c:if test="${NEW_USER.coverImage ne null}">
				<s:url var="url_user_cover_image"
					value="/static/user_profile_images/${NEW_USER.coverImage }" />
			</c:if>
			<img src="${url_user_cover_image }" alt="image"
				class="cover-image img-responsive" />
			<c:if test="${USER.id eq NEW_USER.id }">
				<span class="fa fa-camera coverImageCamera"
					onclick="changeCoverImage()"></span>
			</c:if>
		</div>
	</div>
	<div class="row">
		<div
			class="col-lg-12 col-md-12 col-sm-12 btn-container d-flex justify-content-between align-item-center">
			<c:if test="${USER.id eq NEW_USER.id }">
				<div class="logout-button">
					<a href="#">Logout</a>
				</div>
			</c:if>
			<div class="profile-image-box">
				<s:url var="url_user_profile_image"
					value="/static/user_profile_images/default_profile_image.png" />
				<c:if test="${NEW_USER.image ne null}">
					<s:url var="url_user_profile_image"
						value="/static/user_profile_images/${NEW_USER.image }" />
				</c:if>
				<img src="${url_user_profile_image }" alt="img"
					class="profile-image img-responsive" />
				<c:if test="${USER.id eq NEW_USER.id }">
					<span class="fa fa-camera profileImageCamera"
						onclick="changeProfileImage()"></span>
				</c:if>
			</div>
			<c:if test="${USER.id eq NEW_USER.id }">
				<div class="edit-button">
					<s:url var="url_edit_personal_info"
						value="/account/edit-personal-info" />
					<a href="${url_edit_personal_info }">Edit</a>
				</div>
			</c:if>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12 col-md-12 col-sm-12 name-section">
			<div class="user-name">
				<p>${NEW_USER.name }</p>
			</div>
			<c:if test="${NEW_USER.college ne null}">
				<div class="college-name">
					<p>${NEW_USER.college }</p>
				</div>
			</c:if>
			<c:if test="${NEW_USER.collegeLink ne null}">
				<div class="college-url">
					<a href="#">${NEW_USER.collegeLink }</a>
				</div>
			</c:if>

			<div class="user-status">
				<p>${NEW_USER.about }</p>
			</div>
			<div class="user-status">
				<p>
					<i>${NEW_USER.profession }</i>
				</p>
			</div>
			<div class="user-skills">
				<div
					class="skill-header d-flex justify-content-center align-item-center">
					<h5>Interested In</h5>
					<c:if test="${USER.id eq NEW_USER.id }">
						<s:url value="/user-skills/manage" var="url_manage_user_skills"></s:url>
						<a href="${url_manage_user_skills }" class="pull-right">Manage</a>
					</c:if>
				</div>
				<c:choose>
					<c:when test="${mySkills ne null }">
						<ul class="min-width">
							<c:forEach items="${mySkills}" var="uSkill">
								<li>${uSkill.skillName}</li>
							</c:forEach>
						</ul>
					</c:when>
					<c:otherwise>
						<div class="user-skills">
							<ul class="min-width">
								<li><h6>No skills found.</h6></li>
							</ul>
						</div>
					</c:otherwise>
				</c:choose>

			</div>
			<!--  other accounts -->
			<div class="other-accounts">
				<s:url value="/user-account/link-other-accounts"
					var="url_link_other_accounts"></s:url>
				<f:form action="${url_link_other_accounts}"
					modelAttribute="OTHER_ACCOUNTS" method="post">
					<div
						class="skill-header d-flex justify-content-between align-item-center">
						<h5 class="pull-left">Other Accounts</h5>
						<c:if test="${USER.id eq NEW_USER.id }">
							<span class="fa fa-edit pull-right linkOtherAccountsButton"
								onclick="linkOrUpdateOtherAccounts()"></span>
							<input class="apply_button" type="submit" value="Apply Changes">
						</c:if>
					</div>
					<!-- this will show by default-->
					<ul class="min-width show-other-accounts">
						<s:url value="${OTHER_ACCOUNTS.facebookUrl}" var="url_f_account"></s:url>
						<c:choose>
							<c:when test="${OTHER_ACCOUNTS.facebookUrl ne null}">
								<li class="d-flex justify-content-between"><i
									class="fa fa-facebook pull-left"></i> <span
									class="show-other-accounts">${OTHER_ACCOUNTS.facebookUrl}</span>
									<a href="${url_f_account }" target="_blank"><span
										class="icon ion-share show-other-accounts"></span></a></li>

							</c:when>
							<c:otherwise>
								<li class="d-flex justify-content-between"><i
									class="fa fa-facebook pull-left"></i><span>facebook</span></li>
							</c:otherwise>
						</c:choose>

						<s:url value="${OTHER_ACCOUNTS.googleUrl}" var="url_g_account"></s:url>
						<c:choose>
							<c:when test="${OTHER_ACCOUNTS.googleUrl ne null}">
								<li class="d-flex justify-content-between"><i
									class="fa fa-google-plus pull-left"></i><span
									class="show-other-accounts">${OTHER_ACCOUNTS.googleUrl}</span><a
									href="${url_g_account }" target="_blank"><span
										class="icon ion-share show-other-accounts"></span></a></li>
							</c:when>
							<c:otherwise>
								<li class="d-flex justify-content-between"><i
									class="fa fa-google-plus pull-left"></i><span>google</span></li>
							</c:otherwise>
						</c:choose>

						<s:url value="${OTHER_ACCOUNTS.twitterUrl}" var="url_t_account"></s:url>
						<c:choose>
							<c:when test="${OTHER_ACCOUNTS.twitterUrl ne null}">
								<li class="d-flex justify-content-between"><i
									class="fa fa-twitter pull-left"></i><span
									class="show-other-accounts">${OTHER_ACCOUNTS.twitterUrl}</span><a
									href="${url_t_account }" target="_blank"><span
										class="icon ion-share show-other-accounts"></span></a></li>
							</c:when>
							<c:otherwise>
								<li class="d-flex justify-content-between"><i
									class="fa fa-twitter pull-left"></i><span>twitter</span></li>
							</c:otherwise>
						</c:choose>

						<s:url value="${OTHER_ACCOUNTS.linkedinUrl}" var="url_l_account"></s:url>
						<c:choose>
							<c:when test="${OTHER_ACCOUNTS.linkedinUrl ne null}">
								<li class="d-flex justify-content-between"><i
									class="fa fa-linkedin pull-left"></i><span
									class="show-other-accounts">${OTHER_ACCOUNTS.linkedinUrl}</span><a
									href="${url_l_account }" target="_blank"><span
										class="icon ion-share show-other-accounts"></span></a></li>
							</c:when>
							<c:otherwise>
								<li class="d-flex justify-content-between"><i
									class="fa fa-linkedin pull-left"></i><span>linkedin</span></li>
							</c:otherwise>
						</c:choose>

						<s:url value="${OTHER_ACCOUNTS.quoraUrl}" var="url_q_account"></s:url>
						<c:choose>
							<c:when test="${OTHER_ACCOUNTS.quoraUrl ne null}">
								<li class="d-flex justify-content-between"><i
									class="fa fa-quora pull-left"></i><span
									class="show-other-accounts">${OTHER_ACCOUNTS.quoraUrl}</span><a
									href="${url_q_account }" target="_blank"><span
										class="icon ion-share show-other-accounts"></span></a></li>
							</c:when>
							<c:otherwise>
								<li class="d-flex justify-content-between"><i
									class="fa fa-quora pull-left"></i><span>quora</span></li>
							</c:otherwise>
						</c:choose>

						<s:url value="${OTHER_ACCOUNTS.youtubeUrl}" var="url_y_account"></s:url>
						<c:choose>
							<c:when test="${OTHER_ACCOUNTS.youtubeUrl ne null}">
								<li class="d-flex justify-content-between"><i
									class="fa fa-youtube pull-left"></i> <span
									class="show-other-accounts">${OTHER_ACCOUNTS.youtubeUrl}<a
										href="${url_y_account }" target="_blank"><span
											class="icon ion-share show-other-accounts"></span></a></span></li>
							</c:when>
							<c:otherwise>
								<li class="d-flex justify-content-between"><i
									class="fa fa-youtube pull-left"></i><span>youtube</span></li>
							</c:otherwise>
						</c:choose>
					</ul>

					<ul class="min-width link-other-accounts link-other-accounts">
						<li class="d-flex justify-content-between"><i
							class="fa fa-facebook pull-left"></i> <f:input path="facebookUrl"
								class="facebook_url" type="text"
								placeholder="copy & paste facebook profile url..." /></li>

						<li class="d-flex justify-content-between"><i
							class="fa fa-google-plus pull-left"></i> <f:input
								path="googleUrl" class="google_url" type="text"
								placeholder="copy & paste google profile url..." /></li>

						<li class="d-flex justify-content-between"><i
							class="fa fa-twitter pull-left"></i> <f:input path="twitterUrl"
								class="twitter_url" type="text"
								placeholder="copy & paste twitter profile url..." /></li>

						<li class="d-flex justify-content-between"><i
							class="fa fa-linkedin pull-left"></i> <f:input path="linkedinUrl"
								class="linkedin_url" type="text"
								placeholder="copy & paste linkedin profile url..." /></li>

						<li class="d-flex justify-content-between"><i
							class="fa fa-quora pull-left"></i> <f:input path="quoraUrl"
								class="quora_url" type="text"
								placeholder="copy & paste quora profile url..." /></li>

						<li class="d-flex justify-content-between"><i
							class="fa fa-youtube pull-left"></i> <f:input path="youtubeUrl"
								class="youtube_url" type="text"
								placeholder="copy & paste youtube channel url..." /></li>
					</ul>

				</f:form>
			</div>
		</div>
	</div>
</div>
<!-- Modal to crop and change or update profile image -->
<div class="modal" id="changeProfileImageModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<h5>Change Profile Image</h5>
				<button class="close" type="button" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="image-box">
					<div class="select-image-box">
						<input type="file" class="profileImage" name="profileImage"
							id="profileImage" /> <span class="fa fa-upload"
							onclick="chooseProfileImageFile()"></span>
						<p class="pull-right crop_and_upload_profile_image">Crop &
							Upload</p>
					</div>

					<div class="cropProfileImageInit">
						<img class="proflie_image_init" alt=""
							src="${url_user_profile_image }" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal to crop and change or update cover image -->
<div class="modal" id="changeCoverImageModal">
	<div class="modal-dialog modal-dialog-centered" style="max-width: 60%">
		<div class="modal-content">
			<div class="modal-header">
				<h5>Change Cover Image</h5>
				<button class="close" type="button" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<div class="image-box">
					<div class="select-image-box">
						<input type="file" class="coverImage" name="coverImage"
							id="coverImage" /> <span class="fa fa-upload"
							onclick="chooseCoverImageFile()"></span>
						<p class="pull-right crop_and_upload_cover_image">Crop &
							Upload</p>
					</div>
					<div class="cropCoverImageInit">
						<img class="cover_image_init" alt=""
							src="${url_user_cover_image }" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<s:url var="url_crop_and_upload_profile_image"
	value="/user-profile/update-profile-image" />
<s:url var="url_crop_and_upload_cover_image"
	value="/user-profile/update-cover-image" />

<%-- plugins for cropping image --%>
<s:url var="url_cropper_js" value="/static/cropper/croppie.js" />
<script src="${url_cropper_js}"></script>
<script type="text/javascript">
	var action = 1;
	function linkOrUpdateOtherAccounts() {
		$(".linkOtherAccountsButton").css("display", "none");
		$(".show-other-accounts").css("display", "none");
		$(".apply_button").css("display", "block");
		$(".link-other-accounts").css("display", "block");
	}

	///// Profile image
	function changeProfileImage() {
		action = 1;
		$(".modal").modal("hide");
		$("#changeProfileImageModal").modal("show");
		// 		initCrop();
	}

	function chooseProfileImageFile() {
		$(".profileImage").click();

	}

	//////previewing selected proflie image onto the div or img tag////
	function readProfileImageURL(profileImageInput) {
		if (profileImageInput.files && profileImageInput.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('.proflie_image_init').attr('src', e.target.result);
			};
			reader.readAsDataURL(profileImageInput.files[0]);
		}
	}

	$(".profileImage").change(function() {
		readProfileImageURL(this);
	});

	///// COVER IMAGE
	function changeCoverImage() {
		action = 2;
		$(".modal").modal("hide");
		$("#changeCoverImageModal").modal("show");
		// 		initCrop();
	}
	function chooseCoverImageFile() {
		$(".coverImage").click();
	}
	///previewing selected cover image onto the div or img tag////
	function readCoverImageURL(coverImageInput) {
		if (coverImageInput.files && coverImageInput.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('.cover_image_init').attr('src', e.target.result);
			};
			reader.readAsDataURL(coverImageInput.files[0]);
		}
	}

	$(".coverImage").change(function() {
		readProfileImageURL(this);
	});

	///// common method for cropping profile image and cover image
	$(document).ready(function() {
		initCrop();
	});

	function initCrop() {
		/// profile image croping
		$profile_image_crop = $(".proflie_image_init").croppie({
			enableExif : true,
			viewport : {
				zoomable : true,
				width : 150,
				height : 150,
				type : 'circle' // can be circle also
			},
			boundary : {
				width : 300,
				height : 300
			}
		});

		$('.profileImage').on('change', function() {
			var reader = new FileReader();
			reader.onload = function(event) {
				$profile_image_crop.croppie('bind', {
					url : event.target.result
				}).then(function() {
					//                    console.log("jquery bind image complete");
				});
			};
			reader.readAsDataURL(this.files[0]);
		});

		$('.crop_and_upload_profile_image').on('click', function(event) {
			$profile_image_crop.croppie('result', {
				type : 'canvas',
				size : 'viewport'
			}).then(function(response) {
				$('.proflie_image_init').attr('src', response);
				$.ajax({
					url : '${url_crop_and_upload_profile_image}',
					method : 'post',
					data : {
						profileImage : response
					},
					success : function(data) {
						if (data == "SUCCESS") {
							location.reload();
						} else if (data == "FAILED") {
							alert("profile image updation failed");
						}
					}
				});
			});
		});

		///// cover image croping 

		$cover_image_crop = $(".cover_image_init").croppie({
			enableExif : true,
			viewport : {
				zoomable : true,
				width : $(".cover-image").width(),
				height : $(".cover-image").height(),
				maxWidth : $(".cover-image").width(),
				maxHeight : $(".cover-image").height(),
				fillColor : '#fff',
				imageSmoothingEnabled : false,
				imageSmoothingQuality : 'high',
				type : 'rectangle'
			},
			boundary : {
				width : $(".cover-image").width() + 50,
				height : $(".cover-image").height() + 50
			}
		});

		$('.coverImage').on('change', function() {
			var reader = new FileReader();
			reader.onload = function(event) {
				$cover_image_crop.croppie('bind', {
					url : event.target.result
				}).then(function() {
					//                    console.log("jquery bind image complete");
				});
			};
			reader.readAsDataURL(this.files[0]);
		});

		$('.crop_and_upload_cover_image').on('click', function(event) {
			$cover_image_crop.croppie('result', {
				type : 'canvas',
				size : 'viewport',
			}).then(function(response) {
				$('.cover_image_init').attr('src', response);
				$.ajax({
					url : '${url_crop_and_upload_cover_image}',
					method : 'post',
					data : {
						coverImage : response
					},
					success : function(data) {
						if (data == "SUCCESS") {
							location.reload();
						} else if (data == "FAILED") {
							alert("Cover image updation failed");
						}
					}
				});
			});
		});
	}
</script>