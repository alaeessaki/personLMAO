<%@page import="Model.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%  Person person = (Person) request.getAttribute("person");%>
	<fieldset>
		<legend>Ajouter une personne</legend>
		
		<form action="UpdatePersonController" method="POST">
			<input type="hidden" value="<% out.print(person.getId()); %>" name="id">
			<label for="nom">Nom :</label>
			<input type="text" id="nom" name="nom" value="<% out.print(person.getName()); %>"><br>
			
			<label for="prenom">Prenom :</label>
			<input type="text" id="prenom" name="prenom" value="<% out.print(person.getLast_name()); %>"><br>
			
			<label for="age">age :</label>
			<input type="number" id="age" name="age" value="<% out.print(person.getAge()); %>"><br>
			
			<button type="submit">Modifier</button>
		</form>
	</fieldset>
</body>
</html>