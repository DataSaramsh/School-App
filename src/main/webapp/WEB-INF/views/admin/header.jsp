<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
#toplinks {
	color:green;
	padding-left:20px;
	font-size:20px;
}
</style>
<meta charset="UTF-8">
<title>Schoolapp platform admin page</title>
</head>
<body>

<h2>Welcome to Schoolapp admin panel  <a href="<c:url value='/logout' />" >Log Out</a></h2>

<a href="<c:url value='/admin/feestructures' />" id="toplinks">Feestructures</a>
<a href="<c:url value='/admin/activities' />" id="toplinks">Activities</a>
<a href="<c:url value='/admin/enrolledstudents' />" id="toplinks">Enrolledstudent</a>