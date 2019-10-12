<%@include file="includes/spring-tag-libs.jsp"%>
<s:url var="user_profile_sidebar_css"
	value="/static/user-css/user-profile-sidebar-css.css" />
<link href="${user_profile_sidebar_css}" rel="stylesheet">

<s:url var="manage_user_skills_content_section_css"
	value="/static/user-css/manage-user-skills-content-section-css.css" />
<link href="${manage_user_skills_content_section_css}" rel="stylesheet">

<div class="col-lg-12 col-md-12 col-sm-12">
	<div class="row">
		<!-- Side bar -->
		<!-- skill list -->
		<c:set var="mySkills" value="${USER_SKILL_LIST}" />
		<c:set var="otherAccounts" value="${OTHER_ACCOUNTS}" />
		<%@include file="includes/user-profile-sidebar.jsp"%>

		<div class="col-lg-9 col-md-9 col-sm-9 middle-section">
			<h4 class="skill-header text-center">Manage Your Skills.</h4>
			<c:choose>
				<c:when test="${mySkills ne null }">
					<div class="user-skills user-skills-list inputs">
						<span>Your Skills</span>
						<s:url var="url_handle_skills" value="/skills/remove-skills" />
						<form action="${url_handle_skills }" method="post">
							<ul class="li-min-width">
								<c:forEach items="${mySkills}" var="mSkill">
									<li class="d-flex justify-content-between align-item-center">${mSkill.skillName}
										<input type="checkbox" name="userSkillIds" value="${mSkill.id}" id="checkbox${mSkill.id}" />
										<label for="checkbox${mSkill.id}" ></label>
									</li>
								</c:forEach>
							</ul>
							<div class="submit-button">
								<input type="submit" value="Remove skills" class="pull-right" />
							</div>
						</form>
					</div>
				</c:when>
				<c:otherwise>
					<div class="user-skills user-skills-list inputs">
						<ul class="li-min-width">
							<li><h5>You have not describe your skills yet.</h5></li>
						</ul>
					</div>
				</c:otherwise>
			</c:choose>

			<s:url var="url_add_more_skill" value="/skills/add_more_skills" />
			<f:form modelAttribute="ADD_USER_SKILL"
				action="${url_add_more_skill}" method="post" autocomplete="off">

				<div class="user-skills add-more-skills user-skills-list">
					<span>Add More Skills</span>
					<div class="search-skill-box">
						<div class="search-box form-group">
							<input type="text" class="" id="search-skill" name="search-skill"
								placeholder="type to search your skills" />

						</div>
						<div class="skills-list-container"></div>
					</div>

					<ul id="skill-box" class="li-min-width"></ul>
				</div>
				<div class="saveAllButton save-button">
					<span class="pull-right save-skills-button"
						onclick="saveAllSkills()">Save All</span> <span
						class="pull-right save-skills-button" style="visibility: hidden;"><input
						type="submit" id="saveSkills" value="Save All" disabled="disabled"></span>
				</div>

			</f:form>
		</div>
	</div>
</div>
