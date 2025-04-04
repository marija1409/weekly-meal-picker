package org.example.web_domaci4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private List<String> days = new ArrayList<>();
    private ArrayList<Meal> saveMeal = new ArrayList<>();
    private Map<String, List<Meal>> map = new HashMap<>();

    public void init() {
        days.add("Ponedeljak");
        days.add("Utorak");
        days.add("Sreda");
        days.add("Cetvrtak");
        days.add("Petak");
        getServletContext().setAttribute("days", days);
        for (String day: days) {
            try {
                Scanner scanner = new Scanner(new File("/Users/marija/web_domaci4/src/data/" + day + ".txt"));
                while (scanner.hasNextLine()) {
                    String data = scanner.nextLine();
                    Meal meal = new Meal(day, data);
                    saveMeal.add(meal);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }}
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method");
        super.service(req, resp);
    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (getServletContext().getAttribute(request.getSession().getId()) != null) {
            request.setAttribute("chosenMeals", map.get(request.getSession().getId()));
            request.getRequestDispatcher("/chosenMeals.jsp").forward(request, response);
            return;
        }

        request.setAttribute("days", days);
        request.setAttribute("saveMeal", saveMeal);
        request.getRequestDispatcher("/chooseMeal.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().setAttribute(request.getSession().getId(), true);
        List<Meal> list = new ArrayList<>();
        for (String day : days) {
            String meal = request.getParameter(day);
            Meal m = returnMeal(day, meal);
            if (m != null) {
                m.setOrderNumber(m.getOrderNumber() + 1);
                synchronized (this) {
                    list.add(m);
                }
            }
        }
        map.put(request.getSession().getId(), list);
        getServletContext().setAttribute("map", map);

        request.setAttribute("chosenMeals", list);
        request.getRequestDispatcher("/response.jsp").forward(request, response);
    }

    private Meal returnMeal(String day, String meal){
        for (Meal m : saveMeal) {
            if (m.getDay().equals(day) && m.getFood().equals(meal))
                return m;
        }
        return null;
    }

    public void destroy() {
    }
}
