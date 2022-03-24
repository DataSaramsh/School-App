<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp" />

<h3>Current feestructure</h3>

<table>
<tr><th>Student ID</th><th>Student name</th><th>enroll date</th><th>address</th><th>phone number</th><th>email</th></tr>
<c:forEach var="element" items="${allenrolledstudents}" >
      <tr><td>${element.id}</td><td>${element.username}</td><td>${element.grade}</td><td>${element.date}</td><td>${element.phoneno}</td></tr>
</c:forEach>         

</table>

         


</body>
</html>