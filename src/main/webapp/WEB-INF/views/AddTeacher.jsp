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
 h1, h2, th , td, label{
          color: white;
      }
</style>
<body>


	<div class="container mt-3">
      <a href="/school-management" class="btn btn-secondary"> Go To Home </a>
<br>
<br>
		<h1>Add Teacher</h1>
		<form action="insertTeacher" method="post">

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="name">Name</label> <input type="text"
							class="form-control" id="name" name="name"
							placeholder="Enter Name" required="required">
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="email">Email</label> <input type="email"
							class="form-control" id="email" name="email"
							placeholder="Enter Email" required="required">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="address">Address</label>
						<textarea type="text"
							class="form-control" id="address" name="address"
							placeholder="Enter Address" required="required"></textarea>
					</div>
				</div>
			</div>

			<a href="${pageContext.request.contextPath }/"
				class="btn btn-warning"> Back </a>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>

</body>
</html>