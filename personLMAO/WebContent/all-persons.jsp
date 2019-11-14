<%@page import="Model.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<Person> persons = (ArrayList<Person>) request.getAttribute("persons"); %>
	
	<fieldset>
		<legend>Ajouter une personne</legend>
		
		<form action="PersonController" method="POST">
			<label for="nom">Nom :</label>
			<input type="text" id="nom" name="nom"><br>
			
			<label for="prenom">Prenom :</label>
			<input type="text" id="prenom" name="prenom"><br>
			
			<label for="age">age :</label>
			<input type="number" id="age" name="age"><br>
			
			<button type="submit">Ajouter</button>
		</form>
	</fieldset>
	
	
	<table>
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Age</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<% for(int i=0; i<persons.size(); i++){ %>
			<tr>
				<td><% out.print(persons.get(i).getName()); %></td>
				<td><% out.print(persons.get(i).getLast_name()); %></td>
				<td><% out.print(persons.get(i).getAge()); %></td>
				<td><a href="DeletePersonController?id=<%out.print(persons.get(i).getId());%>">delete</a>
					<a href="UpdatePersonController?id=<%out.print(persons.get(i).getId());%>">update</a>
				</td>
			</tr>
		<% } %>
		</tbody>
	</table>
</body>
</html>