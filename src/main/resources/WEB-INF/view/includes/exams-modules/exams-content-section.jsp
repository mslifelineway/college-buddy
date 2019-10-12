<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../spring-tag-libs.jsp"%>

</head>
<body>

	<section class="filter-data-container">
		<div class="list-data col-lg-6 col-md-6 col-sm-6 mx-auto">
			<ul class="d-flex justify-content-between align-items-center">
				<!-- Select Course -->
				<li><select id="course" name="course">
						<!--  TODO : this as dynamic when admin inserted data to the record list at that time we will 
					put input as well as select like auto complete form.
				-->
						<option value="">Course</option>
						<option value="B.TECH">B.Tech</option>
						<option value="M.TECH">M.Tech</option>
						<option value="BCA">BCA</option>
						<option value="MCA">MCA</option>
				</select></li>
				<!-- Select Branch -->
				<li><select id="branch" name="branch">
						<!--  TODO : this as dynamic when admin inserted data to the record list at that time we will 
					put input as well as select like auto complete form.
				-->
						<option value="">Branch</option>
						<option value="CSE">CSE</option>
						<option value="ECE">ECE</option>
						<option value="EEE">EEE</option>
						<option value="CIV">CIV</option>
						<option value="MEC">MEC</option>
				</select></li>
				<!-- Select Subject -->
				<li><select id="subject" name="subject">
						<!--  TODO : this as dynamic when admin inserted data to the record list at that time we will 
					put input as well as select like auto complete form.
				-->
						<option value="">Subject</option>
						<option value="PHYSICS">PHYSICS</option>
						<option value="PCIT">PCIT</option>
						<option value="CHEMISTRY">CHEMISTRY</option>
						<option value="DATA STRUCTURE">DATA STRUCTURE</option>
						<option value="DE">DE</option>
				</select></li>
				<!-- Select Year -->
				<li><select id="year" name="year">
						<!--  TODO : this as dynamic when admin inserted data to the record list at that time we will 
					put input as well as select like auto complete form.
				-->
						<option value="">Year</option>
						<option value="2019">2019</option>
						<option value="2018">2018</option>
						<option value="2017">2017</option>
						<option value="2016">2016</option>
						<option value="2015">2015</option>
						<option value="2014">2014</option>
						<option value="2013">2013</option>
						<option value="2011">2012</option>
						<option value="2011">2011</option>
						<option value="2010">2010</option>
						<option value="2009">2009</option>
						<option value="2008">2008</option>
						<option value="2007">2007</option>
						<option value="2006">2006</option>
						<option value="2005">2005</option>
						<option value="2004">2004</option>
						<option value="2003">2003</option>
						<option value="2002">2002</option>
						<option value="2001">2001</option>
						<option value="2000">2000</option>
				</select></li>
				<!-- Select Semester -->
				<li><select id="sem" name="sem">
						<!--  TODO : this as dynamic when admin inserted data to the record list at that time we will 
					put input as well as select like auto complete form.
				-->
						<option value="">Semester</option>
						<option value="1">I</option>
						<option value="2">II</option>
				</select></li>

				<li class="btn-apply">Apply Filter</li>
			</ul>
		</div>
	</section>

	<section id="content">
		<div class="record-list col-md-12 col-lg-12 col-sm-12">
			<div class="row">
				<div class="other-choices col-md-3 col-lg-3 col-sm-3"></div>
				<div class="filter-items col-md-6 col-lg-6 col-sm-6 p-0 mx-auto">
					<c:set var="i" value="{1,3,2,3,4,3,2,3,4,2,1,3,1}" />
					<c:forEach items="${i}">
						<div class="item col-md-12 col-lg-12 col-sm-12">
							<div class="item-content">
								<p>Question 1</p><br>
								<span>function getTextWidth(txt) { var $elm = $('<span
									class="tempforSize">'+txt+'</span>').prependTo("body"); var
									elmWidth = $elm.width(); $elm.remove(); return elmWidth; }
									function centerSelect($elm) { var optionWidth =
									getTextWidth($elm.children(":selected").html()) var emptySpace
									= $elm.width()- optionWidth; $elm.css("text-indent",
									(emptySpace/2) - 10);// -10 for some browers to remove the
									right toggle control width }
								</span>
								<img alt="" src="/static/images/college_dp.jpg" />
								<ul class="d-flex justify-content-end">
									<li style="border: 1px solid #2BC105;color: #2BC105;">Like <span>50</span></li>
									<li style="border: 1px solid #EF4723;color: #EF4723;">Dislike <span>10</span></li>
								</ul>
							</div>
						</div>
					</c:forEach>
				</div>

				<div class="other-choices col-md-3 col-lg-3 col-sm-3">
					<ul>
						<li>All Records</li>
						<!--TODO: the all data like 1/1, 1/2 etc will come dynamically... -->
						<li>Common To All</li>
						<li>1/2 Final Exams</li>
						<li>2/1 Mid Exams</li>
						<li>2/2 Second Mid Exams</li>
						<li>3/1 Records</li>
						<li>3/2 Records</li>
						<li>4/1 Records</li>
						<li>4/4 Records</li>
					</ul>
				</div>

			</div>
		</div>
	</section>



</body>
</html>