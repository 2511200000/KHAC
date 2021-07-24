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
	
	<form action="/course/searchCourse">
		Search value: <input type="text" name="searchValue" value="${param.searchValue}"/> <input
			type="submit" value="Search" />
	</form>

	<c:set var="listSearch" value="${requestScope.SEARCH}" />
	
	<c:if test="${not empty listSearch}">
		<h2>List search course</h2>

	<table border="1">
	<thead>
		<tr>
			<th>Course ID</th>
			<th>Title</th>
			<th>Category</th>
			<th>Description</th>
			<th>Status</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listSearch}" var="course">
			<tr>
				<td>${course.courseID}</td>
				<td>${course.title}</td>
				<td> 
					<c:set var="category" value="${sessionScope.LIST_CATEGORY}"/>
					<c:forEach items="${category}" var="cate">
						<c:if test="${course.category eq cate.categoryID}">
						${cate.categoryName}
					</c:if>					
					</c:forEach>
				</td>
				<td>${course.description}</td>
				<td> 
					<c:if test="${course.status eq true}">
					<span>Active</span>
					</c:if> <c:if test="${course.status eq false}">
					<span>InActive</span>
					</c:if>
				</td>
				<td><a href="/course/searchToDelete/${course.courseID}">Delete</a></td>
				<td><a href="">Update</a></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</c:if>
	<c:if test="${empty listSearch}">
		<h1>${ERRORS}</h1>
	</c:if>
</body>
</html>