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

<body style="background-color: #e6ffec">

<nav class="navbar navbar-dark bg-primary">

		<div>
			<h1 class="navbar-brand">Add User Page</h1>
		</div>



	</nav>
<s:form action="addUser">
<s:textfield name="firstname" label="Enter first name"></s:textfield>
<s:textfield name="lastname" label="Enter last name"></s:textfield>
<s:textfield name="email" label="Enter email"></s:textfield>
<s:textfield name="username" label="Enter username"></s:textfield>
<s:password name="password" label="Enter password"></s:password>
	<s:password name="confirmPassword" id="confirmPassword"
			label="Confirm Password"></s:password>
<s:submit value="Add"  class="btn btn-warning"></s:submit>
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

<script type="text/javascript">
		$(document)
				.ready(
						function() {
							validate();
							$(
									'#firstname, #lastname, #password ,#email,#username,#confirmPassword')
									.change(validate);
						});

		function validate() {
			if ($('#firstname').val().length > 0
					&& $('#lastname').val().length > 0
					&& $('#password').val().length > 0
					&& $('#email').val().length > 0
					&& $('#username').val().length > 0
					&& $('#confirmPassword').val().length > 0

			) {
				$("input[type=submit]").prop("disabled", false);
			} else {
				$("input[type=submit]").prop("disabled", true);
			}
		}
	</script>
</html>