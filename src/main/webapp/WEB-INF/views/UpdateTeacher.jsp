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

	<div class="container mt-3">
      <a href="/school-management" class="btn btn-secondary"> Go To Home </a>
<br>
<br>
		<h1>Update Teacher/Subject</h1>
		<form action="${classId}" method="post">

						<div class="row">
            				<div class="col">
            					<div class="form-group">
            					<label for="name">Teacher</label>
                                  <select name="teacherId">
                                    <c:forEach items="${teachers}" var="teacher">
                                       <option value="${teacher.id}">${teacher.name}</option>
                                    </c:forEach>
                                   </select>
            					</div>
            				</div>
            			</div>
						<div class="row">
            				<div class="col">
            					<div class="form-group">
            					<label for="name">Subject</label>
                                  <select name="subjectId">
                                    <c:forEach items="${subjects}" var="subject">
                                       <option value="${subject.id}">${subject.name}</option>
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