<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>School App</title>
<link href="<c:url value='/resources/css/mystyle.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<img src="<c:url value='/resources/images/logo.png' />" />
<div class="color">
<h2>Hello! Welcome to our school App. You need to login or register</h2>
<h3 class="error"><c:if test="${param.message != null}">  <%= request.getParameter("message") %></c:if></h3>

<c:choose>
  <c:when  test="${not empty username}">
   welcome ${username} You can logout by clicking here <a href="<c:url value='/logout' />" >Log Out</a>
  </c:when>
  <c:otherwise>
<h4 style="text-align:center;"><a href="register" style="text-decoration:none">Click here to Register</a></h4>
<h4 style="text-align:center;"><a href="login"style="text-decoration:none">Click here to Login</a></h4>
</c:otherwise>
</c:choose>
<br>
<fieldset>
<h4>ADMISSION POLICIES :</h4>
<ul>
<li>Admission is from the international and local communities for children who are 2 years of age and up.</li>
<li>Enrollment is limited to the number of children that can be accommodated bby the classroom space and the teaching staff without detriment to the quality of education offered to each child in the school.</li>
<li>Under the admission policy the child is required to take an entrance test, after which an interview with the parents take place. If the child qualifies in both, an Orientation Programme with the teachers and peers ensues.</li>
</ul>
</fieldset>
<br>
<fieldset>
<h4>REQUIREMENT FOR ADMISSION :</h4>
<ol>
<li>Presentation of the child’s passport or birth certificate </li>
<li> Submission of the child;s record of inoculations for the following:</li>
<ul>
<li>BCG<br></li>
<li> DPT</li>
<li>Polio</li>
<li>Measles</li>
</ul><br>
<li>  Liability Waiver and Emergency Release forms must be signed by the parents or guardian and returned to the school before admission.</li>
<li> 2 passport and 2 stamp sized photographs.</li>
<li> Transfer Certificate from the previous school.</li>
</ol>
<br>
</fieldset>
<fieldset>
<h4>SCHOOL FEES:</h4>
<ol>
<li>The fee is to be deposited by cheque to the Nepal Investment Bank. </li>
<li>Due date for collection is the first month of each quarter. Rs 25/ per day will be charged as late fine in fee collection after the completion of one month, Rs 50/ per day after two months and Rs 100/ per day after the quarter. </li>
<li>Fees may be revised at the beginning of each new session. </li>
<li>Admission fee, annual fee and security deposit are due on notification of admission.</li>
<li>There are four three month quarters, set at the beginning of the Academic Year:</li>
<ul>
<li>1st quarter April to June </li>
<li>2nd quarter July to September </li>
<li>3rd quarter October to December </li>
<li>4th quarter January to March </li>
</ul>
</ol>
</fieldset>
</div>
</body>
</html>