package task2.project1task2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "MainServlet", urlPatterns = {"/submit", "/getResults"})
public class MainServlet extends HttpServlet {
    // ConcurrentHashMap for thread safety
    private static Map<String, Integer> votes = new ConcurrentHashMap<>();
    boolean mobile;

    // Method to set the appropriate DOCTYPE based on user-agent
    private void setDoctype(HttpServletRequest request) {
        String ua = request.getHeader("User-Agent");
        if (ua != null && (ua.contains("Android") || ua.contains("iPhone"))) {
            mobile = true;
            request.setAttribute("pageType", "<!DOCTYPE html PUBLIC \"-//WAPFORUM//DTD XHTML Mobile 1.2//EN\" \"http://www.openmobilealliance.org/tech/DTD/xhtml-mobile12.dtd\">");
        } else {
            mobile = false;
            request.setAttribute("pageType", "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setDoctype(request);  // Set DOCTYPE based on user-agent

        String path = request.getServletPath();
        if ("/submit".equals(path)) {
            String answer = request.getParameter("response");
            if (answer != null) {
                votes.put(answer, votes.getOrDefault(answer, 0) + 1);
                request.setAttribute("notification", "Your '" + answer + "' vote has been registered");
            }

            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        setDoctype(request);  // Set DOCTYPE based on user-agent

        String path = request.getServletPath();
        if ("/getResults".equals(path)) {
            // Forward the votes map to the JSP
            request.setAttribute("v", new HashMap<>(votes));
            votes.clear(); // Optionally clear votes after displaying results
            request.getRequestDispatcher("/results.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}