<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<style>
html {
  height: 100%;
}
body{
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(#141e30, #243b55);
  height: 100%;
  background-repeat: no-repeat;
  background-attachment: fixed;
}
  h1,h2, th , td{
          color: white;
      }
</style>
   <body>
      <h2>${message}</h2>
      <div class="container mt-3">
      <a href="/school-management" class="btn btn-secondary"> Go To Home </a>
      <br>
      <br>
		<h1>Student List</h1>

            		      	<div class="row">
                              			<table class="table table-hover">
                              				<thead>
                              					<tr>
                              						<th scope="col">S.No</th>
                              						<th scope="col">Name</th>
                              						<th scope="col">Email</th>
                              						<th scope="col">Address</th>
                              						<th scope="col">Class</th>
                              						<th scope="col" colspan="3" class="text-center">Action</th>
                              					</tr>
                              				</thead>
                              				<tbody>
                              					<c:forEach var="student" items="${students}">
                              						<tr>
                              							<td>${student.id}</td>
                              							<td>${student.name}</td>
                              							<td>${student.email}</td>
                              							<td>${student.address}</td>
                              							<td>${student.classes.name}</td>
                              							<td class="text-center"><a href="${pageContext.request.contextPath }/assignClasses/${student.id}"
                                                          class="btn btn-success"> Update Class </a><a style="margin-left:5px" href="${pageContext.request.contextPath }/deleteStudent/${student.id}"
                                                                                class="btn btn-danger">Delete</a></td>
                              						</tr>
                              					</c:forEach>
                              				</tbody>
                              			</table>
                              		</div>
      	</div>
   </body>
</html>