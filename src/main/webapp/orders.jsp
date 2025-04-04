<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.web_domaci4.Meal" %>
<%@ page import="java.util.*" %>
<html>
<head>
  <title>Porudzbine</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>

<form method="POST" action="orders?password=<%= request.getParameter("password") %>">
  <h1>Odabrana jela</h1>

  <%
    List<String> days = (List<String>) request.getAttribute("days");
    List<Meal> listOfMeals = (List<Meal>) request.getAttribute("listOfMeals");
    for (String day : days) {
  %>
  <h1><%= day %></h1>
  <table>
    <tr>
      <th class="left-align">Jelo</th>
      <th class="right-align">Kolicina</th>
    </tr>

    <%
      int mealIndex = 0;
      for (Meal meal : listOfMeals) {
        if (meal.getDay().equals(day)) {
          String backgroundColor = mealIndex % 2 == 0 ? "#ffffff" : "#f2f2f2";
    %>
    <tr style="background-color: <%= backgroundColor %>;">
      <td class="left-align"><%= meal.getFood() %></td>
      <td class="right-align"><%= meal.getOrderNumber() %></td>
    </tr>
    <%
          mealIndex++;
        }
      }
    %>
  </table>
  <hr>
  <%
    }
  %>

  <br>
  <input type="submit" name="submit" value="Obrisi"/>
</form>

</body>
</html>
