<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask your doubts</title>
<%@include file="includes/css_plugins.jsp"%>
<%@include file="includes/js_plugins.jsp"%>
<s:url var="ask_your_doubts_css" value="/static/css/ask-your-doubts.css" />
<link href="${ask_your_doubts_css}" rel="stylesheet">
</head>
<body>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (session.getAttribute("USER") == null) {
			response.sendRedirect("/index?act=Access Denied!");
		}
	%>
	<!--============ HEADER FILE ============-->
	<c:set var="title" value="Write an answer" />
	<%@include file="includes/home-modules/home-header.jsp"%>

	<div class="content-part col-lg-12 col-md-12 col-sm-12">

		<div class="row">

			<div class="left-part col-lg-3 col-md-3 col-sm-3"></div>

			<div class="middle-part col-lg-6 col-md-6 col-sm-6 mx-auto">

				<s:url var="url_add_answer" value="/question/add-answer">
					<s:param name="questionId" value="${WRITE_AN_ANSWER.question.id }" />
				</s:url>
				<f:form action="${url_add_answer }" method="post"
					modelAttribute="WRITE_AN_ANSWER" enctype="multipart/form-data"
					class="post-form ">

					<div class="post-section">
						<h2>Question</h2>
						<f:textarea path="question.question"
							placeholder="type your queries..." readonly="readonly"></f:textarea>
					</div>

					<div class="post-section">
						<h2>Write Your Answer</h2>
						<f:textarea path="answer.answer"
							placeholder="type your queries..." required="required"></f:textarea>
					</div>

					<div class="attachment-section">
						<small>(optional)</small><br>
						<f:input path="fileUploadCommand.files" type="file"
							multiple="multiple" placeholder="choose file" />
					</div>
					<c:set var="index" value="0" />
					<div class="code-block">
						<%-- 						<c:forEach items="${ASK_DOUBT_COMMAND.codes}" varStatus="code"> --%>
						<div class="code-section" style="padding-bottom: 40px">
							<div class="code-title">
								<small>(optional)</small>
								<f:input path="codeList[${index }].codeTitle" class="title"
									type="text" placeholder="describe what you have done yet..." />
							</div>
							<div class="code-desc">
								<f:textarea path="codeList[${index }].codeDesc"
									placeholder="write your code here..."></f:textarea>
							</div>
							<div class="more-button">
								<input type="button" class="pull-right" value="Add More"
									onclick="addMoreCodeSection()" />
							</div>
						</div>
						<%-- 						</c:forEach> --%>
					</div>
					<div class="submit-button">
						<input type="submit" class="pull-right" value="Submit" />
					</div>
				</f:form>

			</div>

			<div class="right-part col-lg-3 col-md-3 col-sm-3"></div>
		</div>

	</div>
	<script type="text/javascript">
		var codeIndex = 1;
		var codeBlock = 1;
		function addMoreCodeSection() {

			var block = '<div class="code-section code-section'+codeBlock+'" style="padding-bottom: 40px">'
					+ '<div class="code-title"><small>(optional)</small>'
					+ '<input name="codeList['+codeIndex+'].codeTitle" id="codeTitles" class="title" type="text" placeholder="want to describe more about your work..."/>'
					+ '</div>'
					+ '<div class="code-desc">'
					+ '<textarea name="codeList['+codeIndex+'].codeDesc" id="codeDescs" placeholder="write your code here..."></textarea>'
					+ '</div>'
					+ '<div class="more-button">'
					+ '<input type="button" class="pull-right" value="Remove" onclick="removeCodeSection('
					+ codeBlock + ')" />' + '</div>' + '</div>';

			codeIndex++;
			codeBlock++;
			$(".code-block").append(block);
		}
		function removeCodeSection(blockIndex) {

			$(".code-section" + blockIndex).remove(); /// delete a particular code block by index
		}
	</script>
</body>
</html>