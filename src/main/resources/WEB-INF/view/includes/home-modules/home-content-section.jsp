
<%@include file="../spring-tag-libs.jsp"%>
<s:url var="action_icon_list_css"
	value="/static/css/action-icon-list-css.css" />
<link href="${action_icon_list_css}" rel="stylesheet">
<s:url var="profile_container_with_date_css"
	value="/static/css/profile-container-with-date-css.css" />
<link href="${profile_container_with_date_css}" rel="stylesheet">
<s:url var="question_with_answers_css"
	value="/static/css/question_with_answers_css.css" />
<link href="${question_with_answers_css}" rel="stylesheet">
<section id="content_area">
	<div class="col-lg-12 col-md-12 col-sm-12">
		<div class="row">
			<c:set var="lq" value="${LQuestions}" />
			<!-- left content area -->
			<div
				class="col-lg-3 col-md-3 col-sm-3 col-xs-3 left_content_container">
				<c:if test="${lq eq null}">
					<div class="card col-lg-12 col-md-12 col-sm-12">
						<h4>Nothing to preview.</h4>
					</div>
				</c:if>
				<c:if test="${lq ne null}">
					<c:forEach items="${lq}" var="lq_obj" varStatus="st">
						<div class="col-lg-12 col-md-12 col-sm-12 left_content">
							<!-- user details -->
							<!--
								 BEFORE INCLUDING 'profile-container-with-date.jsp' PAGE MUST SET 
								REQUIRED DATA ONTO THIS FILE 
								-->
							<s:url var="url_profile_image"
								value="/static/user_profile_images/${lq_obj.user.image}" />
							<s:url var="url_user_profile" value="user/user_profile">
								<s:param name="userId" value="${lq_obj.user.id}" />
							</s:url>
							<c:set var="user_name" value="${lq_obj.user.name}" />
							<c:set var="reg_date" value="${lq_obj.user.regDate}" />
							<s:url var="url_user_default_college" value="user/user-college-profile">
								<s:param name="collegeId" value="${lq_obj.user.defaultCollege.id}" />
							</s:url>
							<c:set var="user_default_college_name" value="${lq_obj.user.defaultCollege.collegeName}" />

							<%@include file="../profile-container-with-date.jsp"%>
							<!-- user post details -->
							<div class="user_post col-lg-12 col-md-12 col-sm-12">
								<p>${lq_obj.question}</p>
							</div>
							<!-- user post actions area like share, comments, like etc -->
							<div class="user_post_action col-lg-12 col-md-12 col-sm-12">

								<!--  
									BEFORE INCLUDING BELOW FILE MUST SET DATA REQUIRED FOR THAT FILE
								-->
								<c:set var="total_shared" value="${lq_obj.shared}" />
								<c:set var="total_answered"
									value="${lq_obj.questionEmbedded.countAQuestionAnswered}" />
								<c:set var="total_followed"
									value="${lq_obj.questionEmbedded.countAQuestionFollowed}" />
								<c:set var="question_user_id" value="${lq_obj.user.id}" />
								<c:set var="user_follow_this_question"
									value="${lq_obj.questionEmbedded.userFollowThisQuestion}" />
								<c:set var="question_id" value="${lq_obj.id}" />

								<%@include file="../action-icons-list.jsp"%>

							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<!-- middle content are -->
			<div
				class="col-lg-6 col-md-6 col-sm-6 col-xs-6 middle_content_container">
				<c:set var="mq" value="${MQuestions}" />
				<%@include file="../question_with_answers_section.jsp"%>
			</div>
			<!-- right content are -->
			<div
				class="col-lg-3 col-md-3 col-sm-3 col-xs-3 right_content_container">
				<div class="right_content">
					<div class="col-lg-12 col-md-12 col-sm-12 events">
						<p>Upcoming Events</p>
					</div>
					<c:set var="y"
						value="{1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,6,7,8,9,10,11
                                   ,12,13,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,6,7,8}" />
					<!-- item 1 -->
					<c:forEach items="${y}" varStatus="st">
						<!-- items 1 -->
						<div class="col-lg-12 col-md-12 col-sm-12 events_container">
							<div class="col-lg-12 col-md-12 col-sm-12 events_title">
								<p>
									Cloud Computing <br> <span>18th Dec 1998</span>
								</p>
							</div>
							<!-- article -->
							<div class="col-lg-12 col-md-12 col-sm-12 event_article">
								<article>
									<div class="image-wrapper">
										<img
											src="https://images.unsplash.com/photo-1501159771943-cc9027db4d8b?ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80">
									</div>
									<div class="text-wrapper">
										<p>cloud computing to work with google and Microsoft
											database to manage and modify working with lots of project.
											cloud computing to work with google and Microsoft database to
											manage and modify working with lots of project.</p>
										<p>This paragraph will include the photo of a random cat
											that the author of this tutorial has found online. You can
											replace this text with any random text. The sole purpose of
											this copy is to fill the space and make sure that the image
											to the left has enough text of low around it.</p>
									</div>
								</article>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 apply">
								<a href="#" class="btn btn-md">Apply For Registration</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>

</section>
<!-- MODAL FOR SIGN UP ACCOUNT -->
<div class="modal" id="sign_up_modal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<p>Sign Up</p>
				<button class="close" type="button" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="col-lg-12 sign_up_form">
						<!-- first and last name input -->
						<div class="col-lg-12 p-0">
							<div class="row">
								<div class="col-lg-6 first_name">
									<input type="text" class="text-center first-name" id="f_name"
										onfocusout="validateFirstName(this.value)" name="first_name"
										placeholder="first name" />
								</div>
								<div class="col-lg-6 last_name">
									<input type="text" class="text-center last-name" id="l_name"
										onfocusout="validateLastName(this.value)" name="last_name"
										placeholder="last name" />
								</div>
							</div>
						</div>
						<br>
						<!-- university or college -->
						<div class="col-lg-12 university_name p-0">
							<input type="text" class="text-center select user-college"
								id="college" onfocusout="validateCollege(this.value)"
								placeholder="school/college/university/company" />
						</div>
						<br>
						<!-- email -->
						<div class="col-lg-12 form-group email_address">
							<i class="fa fa-envelope icon"></i><input type="email"
								onfocusout="validateEmail(this.value)"
								class="text-center user-email" id="email" name="email"
								placeholder="email address" />
						</div>
						<!-- password and profession input -->
						<div class="col-lg-12">
							<div class="row">
								<div class="col-lg-6 password">
									<i class="fa fa-lock icon" style=""></i><input type="password"
										onfocusout="validatePassword(this.value)" id="password"
										class="text-center user-password" name="password"
										placeholder="xxxxxxxx" />
								</div>
								<div class="col-lg-6 profession">

									<input type="text" onfocusout="validateProfession(this.value)"
										class="form-control text-center user-profession"
										id="profession" name="profession" placeholder="profession" />
								</div>
							</div>
						</div>
						<br>
						<div class="error"></div>
						<!-- create button or register button -->
						<div class="col-lg-12 p-0 create_account">
							<span onclick="createAccount(1)">Create Account</span>
						</div>
						<div class="col-lg-12 p-0 divider d-flex">
							<hr style="width: 45%">
							<p>OR</p>
							<hr style="width: 45%">
						</div>
						<div class="col-lg-12 p-0 facebook_login">
							<p onclick="checkLoginState();"
								class="d-flex justify-content-center">
								<span class="icon ion-social-facebook"
									style="background: white; width: 20px; height: 20px; color: #174A61; padding: 2px; font-size: 20px; line-height: 15px;"></span>
								&nbsp;Sign up With Facebook
							</p>
						</div>
						<div class="col-lg-12 p-0">
							<br>
							<p class="g-signin2" data-onsuccess="onSignIn"
								onclick="accessFor(1)"></p>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</div>
<!-- MODAL FOR SIGN IN ACCOUNT -->
<div class="modal" id="sign_in_modal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<p>Sign In</p>
				<button class="close" type="button" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="col-lg-12 sign_in_form">
						<!-- username -->
						<div class="col-lg-12 form-group username">
							<i class="fa fa-envelope icon"></i><input type="text"
								class="text-center login-name" name="username"
								placeholder="username/email address" />
						</div>
						<!-- password and profession input -->
						<div class="col-lg-12 p-0">
							<div class="col-lg-12 password">
								<i class="fa fa-lock icon" style=""></i><input type="password"
									class="text-center login-password" name="password"
									placeholder="xxxxxxxx" />
							</div>
						</div>
						<div class="col-lg-12 p-0 divider d-flex">
							<p>
								<input type="checkbox" checked="checked" />
							</p>
							&nbsp;
							<p>Remind me later</p>
						</div>
						<!-- create button or register button -->
						<div class="col-lg-12 p-0 login_account">
							<span onclick="loginAccount(1)">Login Account</span>
						</div>
						<div class="col-lg-12 p-0 divider d-flex">
							<hr style="width: 45%">
							<p>OR</p>
							<hr style="width: 45%">
						</div>
						<div class="col-lg-12 p-0 facebook_login">
							<p>
								<span class="icon ion-social-facebook"></span> Facebook Login
							</p>
						</div>
						<div class="col-lg-12 p-0 google_login">
							<p class="g-signin2" data-onsuccess="onSignIn"
								onclick="accessFor(2)"></p>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer reset_password">
				<a href="#" class="pull-right">Reset Password</a>
			</div>
		</div>
	</div>
</div>

<!-- SOCIAL SIGN UP/ MODAL -->
<div class="modal" id="social_signup_modal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<p>Socail Login</p>
				<button class="close" type="button" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="col-lg-12 sign_up_form">
						<!-- first and last name input -->
						<div class="col-lg-12 p-0">
							<div class="row">
								<div class="col-lg-6 first_name">
									<input type="text" onfocusout="validateFirstName(this.value)"
										class="text-center user-first-name social-first-name first-name"
										id="first_name" name="first_name" placeholder="first name" />
								</div>
								<div class="col-lg-6 last_name">
									<input type="text" onfocusout="validateLastName(this.value)"
										class="text-center user-last-name social-last-name last-name"
										id="last_name" name="last_name" placeholder="last name" />
								</div>
							</div>
						</div>
						<br>
						<!--                                 university or college 
                                <div class="col-lg-12 university_name p-0">
                                    <select >
                                        <option value="0">select college/university/school</option>
                                        <option value="Chaitanya Institute Of Technology warangal">Chaitanya Institute Of Technology warangal</option>
                                        <option value="Kakatiya University Warangal">Kakatiya University Warangal</option>
                                        <option value="Oriental Institute Of Technology Bhopal">Oriental Institute Of Technology Bhopal</option>
                                    </select>
                                </div><br>-->
						<!-- university or college -->
						<div class="col-lg-12 university_name p-0">
							<input type="text"
								class="text-center select social-user-college user-college"
								onfocusout="validateCollege(this.value)" id="user_college"
								placeholder="school/college/university" />
						</div>
						<br>
						<!-- email -->
						<div class="col-lg-12 form-group email_address">
							<i class="fa fa-envelope icon"></i><input type="email"
								class="text-center user-email-id user-email" id="user_email"
								name="user_email" disabled="disabled"
								placeholder="email address" />
						</div>
						<!-- password and profession input -->
						<div class="col-lg-12">
							<div class="row">
								<div class="col-lg-6 password">
									<i class="fa fa-lock icon" style=""></i><input type="password"
										onfocusout="validatePassword(this.value)" id="user_password"
										class="text-center social-user-password user-password"
										name="user_password" placeholder="xxxxxxxx" />
								</div>
								<div class="col-lg-6 profession">

									<input type="text" onfocusout="validateProfession(this.value)"
										class="form-control text-center social-user-profession user-profession"
										id="user_profession" name="user_profession"
										placeholder="profession" />
								</div>
							</div>
						</div>
						<br>
						<div class="info error"></div>
						<!-- create button or register button -->
						<div class="col-lg-12 p-0 create_account">
							<span onclick="createAccount(2)">Confirm Sign Up <c:if
									test="${img ne ''}">
                                            as &nbsp;<img
										id="social_image" src="${img}" width="25" height="25" alt="" />
								</c:if>
							</span>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- SOCIAL SIGN IN MODAL -->
<div class="modal" id="social_signIn_modal" class="social_signIn_modal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<p>Sign In</p>
				<button class="close" type="button" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="col-lg-12 sign_in_form">
						<!-- username -->
						<div class="col-lg-12 form-group username">
							<i class="fa fa-envelope icon"></i><input type="text"
								class="text-center social-login-name user-email-id"
								name="username" disabled="disabled"
								placeholder="username/email address" />
						</div>
						<!-- password and profession input -->
						<div class="col-lg-12 p-0">
							<div class="col-lg-12 password">
								<i class="fa fa-lock icon" style=""></i><input type="password"
									class="text-center social-login-password" name="password"
									placeholder="xxxxxxxx" />
							</div>
						</div>
						<div class="col-lg-12 p-0 divider d-flex">
							<p>
								<input type="checkbox" checked="checked" />
							</p>
							&nbsp;
							<p>Remind me later</p>
						</div>
						<!-- create button or register button -->
						<div class="col-lg-12 p-0 login_account">
							<span onclick="loginAccount(2)">Continue <c:if
									test="${img ne ''}">
                                            as &nbsp;<img
										id="login_image" src="${img}" width="25" height="25"
										alt="image" />
								</c:if></span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	var state_count = 0;
	/// hide all the modals when page is loaded
	function pageLoading() {
		$('#sign_up_modal').modal('hide');
		$('#social_signup_modal').modal('hide');
		$('#sign_in_modal').modal('hide');
		$('#social_signIn_modal').modal('hide');
		$('.modal').modal('hide');
	}

	var access_for = 0;
	function accessFor(access) {
		access_for = access;
	}
	//========================================== SIGN UP / REGISTERING NEW ACCOUNT ============================================
	//-- global vars
	var fname = '';
	var lname = '';
	var college = '';
	var email = '';
	var password = '';
	var profession = '';
	function createAccount(access_from) {

		if (access_from === 1) {
			//// normal sign up 
			fname = $(".first-name").val().trim();
			lname = $(".last-name").val().trim();
			college = $(".user-college").val().trim();
			email = $(".user-email").val().trim();
			password = $(".user-password").val().trim();
			profession = $(".user-profession").val().trim();
		}
		if (access_from === 2) {
			//// sign up with social media
			fname = $(".social-first-name").val().trim();
			lname = $(".social-last-name").val().trim();
			college = $(".social-user-college").val().trim();
			email = this.user_email_id.trim();
			password = $(".social-user-password").val().trim();
			profession = $(".social-user-profession").val().trim();
		}
		if (fname === '') {
			checkFirstName();
		} else if (lname === '') {
			checkLastName();
		} else if (college === '') {
			checkCollege();
		} else if (email === '') {
			checkEmail();
		} else if (password === '') {
			checkPassword();
		} else if (profession === '') {
			checkProfession();
		} else if (!verifyEmail(email)) {
			//=== invalid email
			$(".user-email").css("border", "2px solid red");
			$(".error").html(
					"<h5 class='text-danger'>Invalid email address.</h5>");
		} else {
			//=== valid email\
			if (access_from === 1) {
				$(".error").html("<h5 class='text-danger'></h5>");
				$(".user-email").css("border", "1px solid #174A61");
			}
			var userData = new Array(6);
			userData[0] = fname;
			userData[1] = lname;
			userData[2] = college;
			userData[3] = email;
			userData[4] = password;
			userData[5] = profession;
			<s:url var="url_register_new_account" value="/new-user/registration"/>
			$
					.ajax({
						url : "${url_register_new_account}",
						method : "post",
						data : {
							userData : userData
						},
						success : function(data) {
							// 						alert(data);
							if (data === 'f') {
								///-- user registeration failed
								$(".error")
										.html(
												"<h5 class='text-danger'>Registeration Failed! please try again...</h5>");
							} else if (data === 't') {
								////-- user registered successfully
								//closing previous modal that is sign up modal
								$('#sign_up_modal').modal('hide');
								$('#social_signup_modal').modal('hide');
								$(".info")
										.html(
												"<h5 class='text-success text-center'>Account Registered Successfully!</h5>");
								$('#info_modal').modal('show');
							} else if (data === 'e') {
								////-- something went wrong  ---
								$(".error")
										.html(
												"<h5 class='text-danger'>Oops! something went wrong. please try later.</h5>");
							} else if (data === 'ae') {
								////-- account exists  ---
								$(".error")
										.html(
												"<h5 class='text-danger'>This email has been already taken. please use another email.</h5>");
							}
						}
					});

		}
	}

	//--user details validations --/

	function validateFirstName(first_name) {
		this.fname = first_name.trim();
		checkFirstName();
	}

	function validateLastName(last_name) {
		this.lname = last_name.trim();
		checkLastName();
	}

	function validateCollege(user_college) {
		this.college = user_college.trim();
		checkCollege();
	}

	function validateEmail(reg_email) {
		this.email = reg_email.trim();
		checkEmail();
	}

	function validatePassword(user_password) {
		this.password = user_password.trim();
		checkPassword();
	}

	function validateProfession(user_profession) {
		this.profession = user_profession.trim();
		checkProfession();
	}

	///// required methods/functions

	function checkFirstName() {
		makeAllFieldActive();
		if (fname === '') {
			$(".first-name").css("border", "2px solid red");
			$(".first-name").attr("placeholder", "enter first name");
			$(".first-name").val('');
		} else {
			$(".first-name").css("border", "1px solid #174A61");
		}
	}

	function checkLastName() {
		makeAllFieldActive();
		if (lname === '') {
			$(".last-name").css("border", "2px solid red");
			$(".last-name").attr("placeholder", "enter last name");
			$(".last-name").val('');
		} else {
			$(".last-name").css("border", "1px solid #174A61");
		}
	}

	function checkCollege() {
		makeAllFieldActive();
		if (college === '') {
			$(".user-college").css("border", "2px solid red");
		} else {
			$(".user-college").css("border", "1px solid #174A61");
		}
	}

	function checkEmail() {
		makeAllFieldActive();
		if (email === '') {
			$(".error").html("");
			$(".user-email").css("border", "2px solid red");
			$(".user-email").val('');
			$(".user-email").attr("placeholder", "enter email address");
		} else if (verifyEmail(email)) {
			$(".error").html("<h5 class='text-danger'></h5>");
			$(".user-email").css("border", "1px solid #174A61");
		} else {
			$(".user-email").css("border", "2px solid red");
			$(".error").html(
					"<h5 class='text-danger'>Invalid email address.</h5>");
		}
	}

	function verifyEmail(email_address) {
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(String(email_address).toLowerCase());
	}

	function checkPassword() {
		makeAllFieldActive();
		if (password === '') {
			$(".user-password").css("border", "2px solid red");
			$(".user-password").attr("placeholder", "xxxxxxxx");
			$(".user-password").val('');
		} else {
			$(".user-password").css("border", "1px solid #174A61");
		}
	}

	function checkProfession() {
		makeAllFieldActive();
		if (profession === '') {
			$(".user-profession").css("border", "2px solid red");
			$(".user-profession").attr("placeholder", "your profession");
			$(".user-profession").val('');
		} else {
			$(".user-profession").css("border", "1px solid #174A61");
		}
	}

	/////-- common method for all the required method/functions
	function makeAllFieldActive() {
		$(".first-name").css("border", "1px solid #174A61");
		$(".last-name").css("border", "1px solid #174A61");
		$(".user-college").css("border", "1px solid #174A61");
		$(".user-email").css("border", "1px solid #174A61");
		$(".user-password").css("border", "1px solid #174A61");
		$(".user-profession").css("border", "1px solid #174A61");
	}
	//========================================== SIGN UP / REGISTERING NEW ACCOUNT (END) ================

	//========================================== SIGN IN / LOGIN TO ACCOUNT ====================================================
	function loginAccount(access_from) {
		if (access_from === 1) {
			//// normal sign in 
			email = $(".login-name").val().trim(); //login name or username
			password = $(".login-password").val().trim();
		}
		if (access_from === 2) {
			//// sign in with social media
			email = this.user_email_id.trim();
			password = $(".social-login-password").val().trim();
		}
		if (email === '') {
			$(".login-name").css("border", "2px solid red");
			$(".login-name").val('');
		} else if (password === '') {
			if (access_from === 1) {
				$(".login-name").css("border", "0px");
				$(".login-password").css("border", "2px solid red");
				$(".login-password").val('');
			} else if (access_from === 2) {
				$(".social-login-name").css("border", "0px");
				$(".social-login-password").css("border", "2px solid red");
				$(".social-login-password").val('');
			}
		} else {
			$(".login-name").css("border", "0px");
			$(".login-password").css("border", "0px");
			login();
		}

	}
	function login() {
		<s:url var="url_login_account" value="/user/login_account"/>
		$
				.ajax({
					url : '${url_login_account}',
					data : {
						username : email,
						password : password
					},
					type : 'post',
					success : function(data) {
						if (data === 'ne') {
						} else if (data === 'user') {
							pageLoading();
							$(".info")
									.html(
											"<h5 class='text-success text-center'>You are logged In...</h5>");
							$('#info_modal').modal('show');
							location.reload();
						}
					}
				});
	}

	//// Follow Question 
	function followQuestion(qid) {
		<s:url var="url_follow_question"
				value="/question/follow-question"/>
		if (qid == 0)
			alert('qid not zero' + qid);
		else {

			$.ajax({
				url : '${url_follow_question}',
				method : 'post',
				data : {
					questionId : qid
				},
				success : function(follow_response) {
					alert(follow_response);
				}
			});

		}
	}
</script>
