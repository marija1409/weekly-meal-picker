<%--
  Created by IntelliJ IDEA.
  User: marija
  Date: 4.4.25.
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.web_domaci4.Meal" %>
<%@ page import="java.util.*" %>
<html>
<head>
  <title>Potvrda porudzbine</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div class="confirmation-box">
  <h1>✅ Vasa porudzbina je zabelezena</h1>
  <p>Hvala! Ovo ste porucili:</p>

  <ul>
    <%
      List<Meal> chosenMeals = (List<Meal>) request.getAttribute("chosenMeals");
      if (chosenMeals != null) {
        for (Meal meal : chosenMeals) {
    %>
    <li><strong><%= meal.getDay() %>:</strong> <%= meal.getFood() %></li>
    <%
      }
    }
    %>
  </ul>
</div>
</body>
</html>
