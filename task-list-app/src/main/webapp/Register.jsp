<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="botDetect" uri="https://captcha.com/java/jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<body style="background-color: #e6ffec">

<nav class="navbar navbar-dark bg-primary">

		<div>
			<h1 class="navbar-brand">Register Page</h1>
		</div>



	</nav>
	
	<s:form action="register" method="post">
		<s:textfield name="firstname" id="firstname" label="Enter first name"></s:textfield>
		<s:textfield name="lastname" id="lastname" label="Enter last name"></s:textfield>
		<s:textfield name="email" id="email" label="Enter email"></s:textfield>
		<s:textfield name="username" id="username" label="Enter username"></s:textfield>
		<s:password name="password" id="password" label="Enter password"></s:password>
		<s:password name="confirmPassword" id="confirmPassword"
			label="Confirm Password"></s:password>
	<botDetect:captcha id="exampleCaptcha" userInputID="captchaCode"></botDetect:captcha>
		<s:textfield name="captchaCode" label="Enter captcha " id="captcha"></s:textfield>
		
		<s:submit value="Register" class="btn btn-warning" ></s:submit>
			
	</s:form>
	
	<a style="color: red"> <s:property value="validationMessage" />
	</a>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							validate();
							$(
									'#firstname, #lastname, #password ,#email,#username,#confirmPassword,#captcha')
									.change(validate);
						});

		function validate() {
			if ($('#firstname').val().length > 0
					&& $('#lastname').val().length > 0
					&& $('#password').val().length > 0
					&& $('#email').val().length > 0
					&& $('#username').val().length > 0
					&& $('#captcha').val().length > 0
					&& $('#confirmPassword').val().length > 0

			) {
				$("input[type=submit]").prop("disabled", false);
			} else {
				$("input[type=submit]").prop("disabled", true);
			}
		}
	</script>

</body>
</html>