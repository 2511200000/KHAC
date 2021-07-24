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
	<a href="/admin/manageUser">Back to list user</a>
	<form action="/admin/searchUser">
		Search value: <input type="text" name="searchValue" value="${param.searchValue}"/> <input
			type="submit" value="Search" />
	</form>


	<c:set var="listSearch" value="${requestScope.SEARCH}" />

	<c:if test="${not empty listSearch}">
		<h2>List Search User</h2>
		<table border="1">
			<thead>
				<tr>
					<th>Email</th>
					<th>Role</th>
					<th>Status</th>
					<th>Delete</th>
					<th>Detail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listSearch}" var="user">
					<tr>
						<td>${user.email}</td>
						<td><c:if test="${user.role eq 'HS'}">
								<span>Student</span>
							</c:if> <c:if test="${user.role eq 'GV'}">
								<span>Teacher</span>
							</c:if> <c:if test="${user.role eq 'AD'}">
								<span>Admin</span>
							</c:if></td>
						<td><c:if test="${user.status eq true}">
								<span>Active</span>
							</c:if> <c:if test="${user.status eq false}">
								<span>InActive</span>
							</c:if></td>
						<td><a href="/admin/searchToDelete/${user.email}">Delete</a></td>
						<td><a href="/admin/user-details/${user.email}&${user.role}">details</a></td>
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