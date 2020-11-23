<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body style="background-color: #e6ffec">

<nav class="navbar navbar-dark bg-primary">

		<div>
			<h1 class="navbar-brand">Login Page</h1>
		</div>



	</nav>

<s:form action="LoginAuthentication">

		<s:textfield name="username" placeholder="Enter Username" label="Enter Username">
		</s:textfield>
		<s:password placeholder="Enter Password" name="password" label="Enter password">
		</s:password>
		<s:checkbox name="isAdmin" label="Login as admin"></s:checkbox>
		<s:submit value="login"  class="btn btn-warning" ></s:submit>
		
	</s:form>
	<a style="color: red"> <s:property value="message" />
		</a>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
</html>