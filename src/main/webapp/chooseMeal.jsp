<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.web_domaci4.Meal" %>
<%@ page import="java.util.*" %>
<html>
<head>
  <title>Rucak</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<form method="POST" action="hello-servlet">
  <h1>Odaberite vas rucak:</h1>
  <%
    List<String> days = (List<String>) request.getAttribute("days");
    List<Meal> saveMeal = (List<Meal>) request.getAttribute("saveMeal");
    for (String day : days) {
  %>
  <h3><%= day %></h3>
  <select name="<%= day %>" id="<%= day %>">
    <%
      for (Meal meal : saveMeal) {
        if (meal.getDay().equals(day)) {
    %>
    <option value="<%= meal.getFood() %>"><%= meal.getFood() %></option>
    <%
        }
      }
    %>
  </select>
  <hr>
  <%
    }
  %>
  <br>
  <input type="submit" value="Sačuvaj">
</form>
</body>
</html>
