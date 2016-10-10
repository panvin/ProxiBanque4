<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>


	<div align="center">
		<h1>Veuillez vous identifier</h1>
	</div>

	<form method="post" action="j_security_check">
		<table align="center">
			<tr>
				<td>Identifiant</td>
				<td><input type="text" name="j_username" value=""></td>
			</tr>
			<tr>
				<td>Mot de passe</td>
				<td><input type="password" name="j_password" value=""></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Valider"></td>

			</tr>
		</table>
	</form>



</body>
</html>