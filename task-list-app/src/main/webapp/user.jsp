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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
tr:hover {

	background-color: #ffd500;
}

.header{
color: white;
 align-content: center;
}
</style>
</head>
<body style="background-color: #e6ffec">

	<!-- Sidebar -->

	<div class="w3-sidebar w3-bar-block w3-border-right"
		style="display: none; width: 9%" id="mySidebar">
		<button onclick="w3_close()" class="w3-bar-item w3-large">Close
			&times;</button>


		<s:form action="getUserAddPage" method="get" >
			<s:submit value="Add" class="btn btn-warning" style="padding: 10px 70px 10px 20px;"></s:submit>
		</s:form>


	</div>

	<nav class="navbar navbar-dark bg-primary">
	
	<div>
			<span  class="btn btn-dark" onclick="w3_open()">Sidebar</span>
			<h1 class="navbar-brand">User Info </h1>
		</div>
		
		<h1 class="header">Task List App</h1>

		<s:form action="Logout">
			<s:submit value="Logout" class="btn btn-secondary"></s:submit>
		</s:form>



	</nav>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">FirstName</th>
				<th scope="col">Lastname</th>
				<th scope="col">Email</th>
				<th scope="col">UserName</th>
				<th scope="col">Password</th>
				<th scope="col">Tasks</th>
				<th scope="col">Update</th>
				<th scope="col">Delete</th>
				<th scope="col">Blocked</th>
				<th scope="col">Count</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="users">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="firstname" /></td>
					<td><s:property value="lastname" /></td>
					<td><s:property value="email" /></td>
					<td><s:property value="username" /></td>
					<td><s:property value="password" /></td>
					<td><s:form action="tasksDisplay" method="get">
							<s:hidden value="%{id}" name="userId"></s:hidden>
							<s:submit value="Tasks" class="btn btn-outline-dark"></s:submit>
						</s:form></td>
					<td><s:form action="getUserUpdatePage" method="get">
							<s:hidden value="%{id}" name="updateUser"></s:hidden>
							<s:submit value="update" class="btn btn-outline-primary"></s:submit>
						</s:form></td>
					<td><s:form action="deleteUser">
							<s:hidden value="%{id}" name="deleteUser"></s:hidden>
							<s:submit value="Delete" class="btn btn-outline-danger"></s:submit>
						</s:form></td>
						
							<td><s:form action="blockUser">
							<s:hidden value="%{id}" name="blockUserId"></s:hidden>
							
							<s:submit value="%{blocked}" class="btn btn-outline-danger"></s:submit>
						</s:form></td>

					<td><s:property value="%{task.size()}" /></td>



				</tr>

			</s:iterator>
		</tbody>

	</table>

</body>

<script>
	function w3_open() {
		document.getElementById("mySidebar").style.display = "block";
	}

	function w3_close() {
		document.getElementById("mySidebar").style.display = "none";
	}
</script>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
</html>