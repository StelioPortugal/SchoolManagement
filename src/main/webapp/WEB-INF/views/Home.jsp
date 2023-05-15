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
  h2, th , td{
          color: white;
      }
</style>
   <body>
      <h2>${message}</h2>
      <div class="container mt-3">
          <div class="mask" style="background-color: #147357;">
            <div class="d-flex justify-content-center align-items-center h-100">
              <div class="text-white">
                <h1 class="mb-3">Welcome To School Management Application</h1>
              </div>
            </div>
          </div>
                <br>
      <a href="addSubject" class="btn btn-primary">  Add Subject </a>
      <a href="addClasses" class="btn btn-primary">  Add Classes </a>
      <a href="addTeacher" class="btn btn-primary">  Add Teacher </a>
      <a href="addStudent" class="btn btn-primary">  Add Student </a>
      <a  style="margin-left:345px" href="manageStudent" class="btn btn-warning">  Manage Student </a>
      <a  href="manageSubject" class="btn btn-warning">  Manage Subject </a>

      <br>
      <br>
      <br>
 <h2>Class Details</h2>
      		<div class="row">
      			<table class="table table-hover">
      				<thead>
      					<tr>
      						<th scope="col">S.No</th>
      						<th scope="col">Class</th>
      						<th scope="col" colspan="3" class="text-center">Action</th>
      					</tr>
      				</thead>
      				<tbody>
      					<c:forEach var="classes" items="${classesList}">
      						<tr>
      							<td>${classes.id}</td>
      							<td>${classes.name}</td>
      							<td class="text-center"><a href="${pageContext.request.contextPath }/viewClasses/${classes.id}" class="btn btn-success">View</a></td>
      						</tr>
      					</c:forEach>
      				</tbody>
      			</table>
      		</div>
 <h2>Teacher Details</h2>

                              		      		<div class="row">
                                          			<table class="table table-hover">
                                          				<thead>
                                          					<tr>
                                          						<th scope="col">S.No</th>
                                          						<th scope="col">Name</th>
                                          						<th scope="col">Email</th>
                                          						<th scope="col">Address</th>
                                          						<th scope="col" class="text-center" colspan="3">Action</th>
                                          					</tr>
                                          				</thead>
                                          				<tbody>
                                          					<c:forEach var="teacher" items="${teachers}">
                                          						<tr>
                                          							<td>${teacher.id}</td>
                                          							<td>${teacher.name}</td>
                                          							<td>${teacher.email}</td>
                                          							<td>${teacher.address}</td>
                                          							<td class="text-center"><a href="${pageContext.request.contextPath }/viewTeacher/${teacher.id}"
                                                                    class="btn btn-success">View </a><a style="margin-left:5px" href="${pageContext.request.contextPath }/deleteTeacher/${teacher.id}"
                                                                    class="btn btn-danger">Delete</a></td>
                                          						</tr>
                                          					</c:forEach>
                                          				</tbody>
                                          			</table>
                                          		</div>
      	</div>
   </body>
</html>