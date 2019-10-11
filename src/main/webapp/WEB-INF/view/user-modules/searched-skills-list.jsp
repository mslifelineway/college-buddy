<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="includes/spring-tag-libs.jsp"%>
<style type="text/css">

.skill-list-section {
	background: #f8f8f8;
	padding: 10px;
	margin: 0px;
	width: 100%;
	font-size: 20px;
	z-index = 1;
}

.skill-list-section th {
	display: block;
	padding: 4px 6px;
}

.skill-list-section td {
	display: block;
	padding: 4px 6px;
	width: 100%;
	cursor: pointer;
}
.skill-list-section td:hover{
	background: #eee;
	width: 100%;
}
</style>
</head>
<body>
	<c:set var="skillList" value="${SKILL_LIST}" />
	<c:set var="cnt" value="1" />
	<c:set var="skillType" value="" />
	<c:choose>
		<c:when test="${skillList ne null }">
			<table class="skill-list-section">
				<c:forEach items="${skillList}" var="skillObj">


					<c:if test="${cnt eq '1'}">
						<c:set var="cnt" value="2" />
						<c:set var="skillType" value="${skillObj.type}" />
						<tr>
							<th>${skillObj.type}</th>
						</tr>
					</c:if>

					<c:if test="${skillType eq skillObj.type}">
						<tr>
							<td>${skillObj.name}</td>
						</tr>
					</c:if>

					<c:if test="${skillType ne skillObj.type}">
						<c:set var="cnt" value="1" />
					</c:if>


				</c:forEach>
			</table>
		</c:when>
	</c:choose>

</body>
</html>