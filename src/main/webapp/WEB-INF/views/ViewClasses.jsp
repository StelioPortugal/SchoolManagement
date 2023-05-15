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
 h1, h2, th , td{
          color: white;
      }
</style>
   <body>
      <h2>${message}</h2>
      <div class="container mt-3">
      <a href="/school-management" class="btn btn-secondary"> Go To Home </a>

      <a style="margin-left:5px" href="assignTeacher/${id}" class="btn btn-primary">  Assign Teacher </a>
      <br>
      <br>
 <h2>Subjects</h2>
      		<div class="row">
      			<table class="table table-hover">
      				<thead>
      					<tr>
      						<th scope="col">S.No</th>
      						<th scope="col">Subject</th>
      						<th scope="col">Teacher</th>
      						<th scope="col">Action</th>
      					</tr>
      				</thead>
      				<tbody>
      					<c:forEach var="subject" items="${subjects}">
      						<tr>
      							<td>${subject.id}</td>
      							<td>${subject.name}</td>
      							<td>${subject.teachers[0].name}</td>
                                <td><a href="${pageContext.request.contextPath }/deleteSubjectTeacher/${subject.id}/${id}/${subject.teachers[0].id}"
                                class="btn btn-danger">Delete </a></td>
      						</tr>
      					</c:forEach>
      				</tbody>
      			</table>
      		</div>
 <h2>Students List</h2>
                <div class="row">
                              			<table class="table table-hover">
                              				<thead>
                              					<tr>
                              						<th scope="col">S.No</th>
                              						<th scope="col">Name</th>
                              						<th scope="col">Email</th>
                              						<th scope="col">Address</th>
                              					</tr>
                              				</thead>
                              				<tbody>
                              					<c:forEach var="student" items="${students}">
                              						<tr>
                              							<td>${student.id}</td>
                              							<td>${student.name}</td>
                              							<td>${student.email}</td>
                              							<td>${student.address}</td>
                              						</tr>
                              					</c:forEach>
                              				</tbody>
                              			</table>
                              		</div>
      	</div>
   </body>
</html>