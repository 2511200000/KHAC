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
	<br>

	<c:set var="teacher" value="${requestScope.TEACHER_DETAIL}" />
	<c:set var="user" value="${requestScope.USER_DETAIL}" />
	<c:if test="${not empty teacher}">
	<form action="/admin/updateProfileTeacher">
		<span>Email: </span><input type="text" name="teacherEmail" value="${teacher.teacherEmail}" disabled="disabled"/><br>
		<span>Full Name: </span><input type="text" name="fullName" value="${teacher.fullName}" placeholder="Enter to update"/><br>
		<span>Phone: </span><input type="text" name="phone" value="${teacher.phone}"  placeholder="Enter to update"/><br>
		<span>Description: </span><input type="text" name="description" value="${teacher.description}"  placeholder="Enter to update"/><br>
		<span>Password(5 chars more): </span><input type="password" id="pass" name="password" value="${user.password}" title="length password than 5"/><br>
		<span>Confirm Password: </span><input type="password" id="check" name="confirmPass" value="${user.password}"  title="length password than 5"/><br>
		<input type="radio" name="role" value="${user.role}" checked="checked"/>Teacher
		<input type="radio" name="role" value="HS"/>Student<br>
		<input Onclick="return ConfirmUpdate();" type="submit" value="Update" /><br>
		<div id="error" style="color: red"></div>
 	</form>
	</c:if>

	<c:set var="student" value="${requestScope.STUDENT_DETAIL}" />
	<c:if test="${not empty student}">
	<form action="/admin/updateProfileStudent" method="POST" enctype="multipart/form-data">
 							
    <p><input type="file" accept="image/*" name="imgFile" id="imageFile" onchange="loadImage(event)" style="display: none;"></p>
    <span>Avatar: </span>
    <p><label for="imageFile" style="cursor: pointer; font-weight: bold; font-size: xx-large; color: red;">
    <img src="/load_image/${student.img}" id="outputImage" style="width: 100px; height: 100px;">
    </label></p>
    <input type="hidden" name="image" value="${student.img}"/>
 	<br>
 	
		<span>Email: </span><input type="text" name="teacherEmail" value="${student.studentEmail}" disabled="disabled"/><br>
		<span>Full Name: </span><input type="text" name="fullName" value="${student.fullName}"  placeholder="Enter to update"/><br>
		<span>Phone: </span><input type="text" name="phone" value="${student.phone}"  placeholder="Enter to update"/><br>
		<span>Description: </span><input type="text" name="description" value="${student.description}"  placeholder="Enter to update"/><br>
		<span>Interests: </span><input type="text" name="interests" value="${student.interests}"  placeholder="Enter to update"/><br>
		<span>Password(5 chars more): </span><input type="password" id="pass" name="password" value="${user.password}" title="length password than 5"/><br>
		<span>Confirm Password: </span><input type="password" id="check" name="confirmPass" value="${user.password}" title="length password than 5"/><br>
		<input type="radio" name="role" value="${user.role}" checked="checked"/>Student
		<input type="radio" name="role" value="GV"/>Teacher<br>
		<input Onclick="return ConfirmUpdate();" type="submit" value="Update" /><br>
		<div id="error" style="color: red"></div>
		</form>
	</c:if>
	
	<c:set var="admin" value="${requestScope.ADMIN_DETAIL}" />
	<c:if test="${not empty admin}">
	<form action="/admin/updateProfileAdmin" method="POST" enctype="multipart/form-data">
 							
    <p><input type="file" accept="image/*" name="imgFile" id="imageFile" onchange="loadImage(event)" style="display: none;"></p>
    <span>Avatar: </span>
    <p><label for="imageFile" style="cursor: pointer; font-weight: bold; font-size: xx-large; color: red;">
    <img src="/load_image/${admin.img}" id="outputImage" style="width: 100px; height: 100px;">
    </label></p>
    <input type="hidden" name="image" value="${admin.img}"/>
 	<br>
		<span>Email: </span><input type="text" name="adminEmail" value="${admin.adminEmail}" disabled="disabled"/><br>
		<span>Full Name: </span><input type="text" name="fullName" value="${admin.fullName}"  placeholder="Enter to update"/><br>
 		<span>Password(5 chars more): </span><input type="password" id="pass" name="password" value="${user.password}" title="length password than 5"/><br>
		<span>Confirm Password: </span><input type="password" id="check" name="confirmPass" value="${user.password}" title="length password than 5"/><br>
		 
		<input Onclick="return ConfirmUpdate();" type="submit" value="Update" /><br>
		<div id="error" style="color: red"></div>
		</form>
	</c:if>
	
	  <script>
	  var loadImage = function (event) {
           let imageMain =  document.getElementById("outputImage")
         	  imageMain.src = URL.createObjectURL(event.target.files[0]);
      };
	  
            function ConfirmUpdate() {
            	var password = document.getElementById('pass').value;
            	console.log(password);
            	var checkPass = document.getElementById('check').value;
            	console.log(checkPass);
            	 var x = confirm("Are you sure you want to update?");
            	if(x){
           
            	    if (password === checkPass  && password.length > 5)
                	{
            
                		alert("Update Successed");
                	
                    return true;
                	}else{
                		document.getElementById('error').innerHTML = "Password not match";
                        document.getElementById('pass').select();
                        return false;
                	}
             
                }else{
                           
                       	
                        return false;
                 }
              
                
            
            }
        </script>
</body>
</html>