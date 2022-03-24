<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp" />
<h3>Add new activity</h3>
<h3 style="color:green"><c:if test="${param.message != null}">  <%= request.getParameter("message") %></c:if></h3>
<sf:form method="POST" modelAttribute="acti" enctype="multipart/form-data" commandName="acti">
		
			<table>
				
				<tr>
				<th>Activity Name</th>
				<td><sf:input path="name" size="20"/>
				</br>
				<sf:errors path="name" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th>Activity date</th>
				<td><sf:input path="date" size="20"/>
				</br>
				<sf:errors path="date" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th></th>
				<td>
				<input type="submit" /></td>
				</tr>
		</table>
</sf:form>

</body>
</html>