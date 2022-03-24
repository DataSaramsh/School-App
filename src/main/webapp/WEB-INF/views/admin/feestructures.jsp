<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp" />


<sf:form method="POST" modelAttribute="fee" commandName="fee">
		
			<table>
				
				<tr>
				<th>Add new Category Name</th>
				<td><sf:input path="name" size="20"/>
				</br>
				<sf:errors path="name" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th></th>
				<td>
				<input type="submit" /></td>
				</tr>
		</table>
</sf:form>
<h3>Current feestructures list</h3>
<c:forEach var="element" items="${allfees}" >
      
        
	      NAME: <b>${element.name}</b>
	  
          
           
 </c:forEach>          


</body>
</html>