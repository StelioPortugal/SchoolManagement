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
		<h1>Assign Class</h1>
		<form action="${student.id}" method="post">
					  <div class="row">
            				<div class="col">
            					<div class="form-group">
            					<label for="name">Class</label>
                                  <select name="classesId">
                                    <c:forEach items="${classesList}" var="classes">
                                       <option value="${classes.id}">${classes.name}</option>
                                    </c:forEach>
                                   </select>
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