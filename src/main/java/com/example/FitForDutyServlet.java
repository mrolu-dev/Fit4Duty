package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Fit4DutyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Fit4Duty</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to Fit4Duty</h1>");
        out.println("<p>This is the Fit4Duty servlet.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}

