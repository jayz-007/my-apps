<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task List App</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style >
.col-xl{
padding:150px;
background-color: 	 #a6a6a6;
top: 100px;
 border: 30px solid #e6ffec;


}
</style>
</head>
<body style="background-color: #e6ffec">
	<nav class="navbar navbar-dark bg-primary">
	

		<div>
			<h1 class="navbar-brand">Home</h1>
		</div>
		
			<h1 class="header" style="color:white">Task List App</h1>
		
		<div class="form-inline my-2 my-lg-0">
			<s:form action="getLoginPage" >
				<s:submit value="Login" class="btn btn-secondary"></s:submit>



			</s:form>

			<s:form action="getRegisterPage">
				<s:submit value="Register" class="btn btn-secondary"
					onclick="this.form.submit()"></s:submit>
			</s:form>
		</div>


	</nav>


</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
</html>