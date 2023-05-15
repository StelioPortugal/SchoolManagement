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
      <br>
      <br>
<h1>Assigned Subjects & Classes </h1>
      		<div class="row">
      			<table class="table table-hover">
      				<thead>
      					<tr>
      						<th scope="col">S.No</th>
      						<th scope="col">Subject</th>
      						<th scope="col">Class</th>
      					</tr>
      				</thead>
      				<tbody>
      					<c:forEach var="subject" items="${subjects}">
      						<tr>
      							<td>${subject.id}</td>
      							<td>${subject.name}</td>
      							<c:forEach var="classes" items="${subject.classes}">
      							<td>${classes.name}</td>
      							</c:forEach>
      						</tr>
      					</c:forEach>
      				</tbody>
      			</table>
      		</div>
      	</div>
   </body>
</html>