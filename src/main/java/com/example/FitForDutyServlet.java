package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FitForDutyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Set the content type of the response
    response.setContentType("text/html");

    // Get the path to the fit-for-duty.html file
    String filePath = getServletContext().getRealPath("/fit-for-duty.html");

    // Read the contents of the HTML file
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }

        // Send the HTML content as the response
        PrintWriter writer = response.getWriter();
        writer.println(content.toString());
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
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
}
