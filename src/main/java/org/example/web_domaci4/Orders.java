package org.example.web_domaci4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@WebServlet(name = "Orders", value = "/orders")
public class Orders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String password = request.getParameter("password");
        Scanner scanner = new Scanner(new File("/Users/marija/web_domaci4/src/data/password.txt"));
        if (password.equals(scanner.nextLine())) {
            Map<String, List<Meal>> map = (Map<String, List<Meal>>) getServletContext().getAttribute("map");
            List<Meal> listOfMeals = new ArrayList<>();
            if (map != null) {
                for (List<Meal> meals : map.values()) {
                    listOfMeals.addAll(meals);
                }
            }

            List<String> days = (List<String>) getServletContext().getAttribute("days");

            request.setAttribute("listOfMeals", listOfMeals);
            request.setAttribute("days", days);
            request.setAttribute("password", password);

            RequestDispatcher dispatcher = request.getRequestDispatcher("orders.jsp");
            dispatcher.forward(request, response);
        } else {
            response.getWriter().println("<h3>Wrong password</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, List<Meal>> map = (Map<String, List<Meal>>) getServletContext().getAttribute("map");

        if (map != null) {
            for (List<Meal> meals : map.values()) {
                for (Meal meal : meals) {
                    meal.setOrderNumber(0);
                }
            }
        }

        getServletContext().setAttribute("map", new java.util.HashMap<String, List<Meal>>());

        response.sendRedirect("orders?password=" + request.getParameter("password"));
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
