<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/course/manageCourse">Back to list course</a>
	<c:set var="course" value="${requestScope.COURSE_DETAIL}"/>
	 <form action="/course/updateCourse">
		<span>Course ID: </span><input type="text" name="courseID" value="${course.courseID}" disabled="disabled"/><br>
		<span>Title: </span><input type="text" name="title" value="${course.title}" placeholder="Enter to update"/><br>
		<span>Category: </span>  
							<c:forEach items="${sessionScope.LIST_CATEGORY}" var="category">
															 
							 <c:if test="${course.category eq category.categoryID}">
								 <input type="radio" value="${category.categoryID}" checked="checked"/><span>${category.categoryName}</span>						 
							 </c:if>
							 
							  <c:if test="${course.category ne category.categoryID}">
								 <input type="radio" value="${category.categoryID}" /><span>${category.categoryName}</span>	 
							 </c:if>
										  							
							</c:forEach><br>
 		<span>Description: </span><input type="text" name="description" value="${course.description}"  placeholder="Enter to update"/><br>
 		<input Onclick="return ConfirmUpdate();" type="submit" value="Update" /><br>
		<div id="error" style="color: red"></div>
 	</form>
 	
 	 <script>
 
	  
            function ConfirmUpdate() {
             
            	 var x = confirm("Are you sure you want to update?");
            	if(x){
           				return true;
                }else{
                           
                       	
                        return false;
                 }
              
                
            
            }
        </script>
</body>
</html>