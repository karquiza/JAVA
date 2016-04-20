<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>myTime Login</title>
</head>
<body>
	<h1>Welcome to myTime</h1>
	<form method="post" action="/myTime/ValidateServlet">
		<center>
		<table border="1" cellpadding="5" cellspacing="2">
			<thead>
				<tr>
					<th colspan="2">Login Here</th>
				</tr>
			</thead>	
			<tbody>
				<tr>
					<td>Username</td>
					<td><input id="login_name" type="username" name="username" required/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input id="login_password" type="password" name="password" required/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Login" />
						&nbsp;&nbsp;
						<input type="reset" value="Reset" />
					</td>
				</tr>
			</tbody>
		</table>
		</center>
	</form>
</body>
</html>