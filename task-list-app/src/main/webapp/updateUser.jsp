<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
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
</head>
<body style="background-color: #e6ffec"> 

<nav class="navbar navbar-dark bg-primary">

		<div>
			<h1 class="navbar-brand">Update User Page</h1>
		</div>



	</nav>
<s:form action="updateUser">
<s:textfield value="%{user.firstname}" name="firstname" label="Enter first name"></s:textfield>
<s:textfield value="%{user.lastname}" name="lastname" label="Enter last name"></s:textfield>
<s:textfield value="%{user.email}" name="email" label="Enter email"></s:textfield>
<s:textfield value="%{user.username}" name="username" label="Enter username"></s:textfield>
<s:textfield value="%{user.password}" name="password" label="Enter password"></s:textfield>
<s:hidden value="%{updateUser}" name="updateUser"></s:hidden>
<s:submit value="update"  class="btn btn-warning"></s:submit>
</s:form>
<a style="color:red">
<s:property value="validationMessage"/>
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