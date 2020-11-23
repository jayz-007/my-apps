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
<style >
tr:hover{
background-color:#ffd500;
}
</style>
</head>
<body style="background-color: #e6ffec">
	<nav class="navbar navbar-dark bg-primary">
	

	<s:form action="getSubTaskAddPage" class="form-inline my-2 my-lg-0" method="get">
		<div>
	<a href="/task-list-app/userDisplay.action" class="navbar-brand">Go Home</a>
	</div>

		<s:submit value="Add" class="btn btn-warning"></s:submit>
		
			
	</s:form>
	<a href="/task-list-app/userDisplay.action">Home</a>
	<a class="navbar-brand">Subtasks</a>
	
	</nav>
	<table class="table" >
		<thead class="thead-dark">
			<tr>
			
			<th scope="col">Done</th>
				<th scope="col">Id</th>
				<th scope="col">title</th>
				<th scope="col">Date</th>
				<th scope="col">Update</th>
				<th scope="col"> Delete</th>
				
			</tr>
		</thead>
		<tbody>
			<s:iterator value="subtasks">
				<tr>
					<td><s:form action="checkSubTask">
							<s:hidden name="id" value="%{id}"></s:hidden>
							<s:checkbox name="done" value="%{done}"
								onchange="this,form.submit()"></s:checkbox>
						</s:form></td>
					<td><s:property value="id" /></td>
					<td><s:property value="title" /></td>
					<td><s:property value="date" /></td>


					<td><s:form action="getSubTaskUpdatePage" method="get">
							<s:hidden value="%{id}" name="updateSubTask"></s:hidden>
							<s:submit value="update" class="btn btn-outline-primary"></s:submit>
						</s:form></td>
					<td><s:form action="deleteSubTask">
							<s:hidden value="%{id}" name="deleteSubTask"></s:hidden>
							<s:submit value="Delete" class="btn btn-outline-danger"></s:submit>
						</s:form></td>
						

				</tr>

			</s:iterator>
		</tbody>

	</table>

</body>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
</html>