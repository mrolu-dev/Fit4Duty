package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.RequestDispatcher;
import com.example.FitForDutyApp;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FitForDutyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 // Retrieve the selected options from the request parameters
        String physicalSymptoms = request.getParameter("physicalSymptoms");
        String cognitiveFunction = request.getParameter("cognitiveFunction");
        String emotionalState = request.getParameter("emotionalState");
        String workloadResponsibilities = request.getParameter("workloadResponsibilities");
        String environmentalFactors = request.getParameter("environmentalFactors");
        String personalFactors = request.getParameter("personalFactors");
            
                // Perform the fitness calculation using FitForDutyApp
        FitForDutyApp fitForDutyApp = new FitForDutyApp();
        String result = fitForDutyApp.selectOption(
            physicalSymptoms, cognitiveFunction, emotionalState,
            workloadResponsibilities, environmentalFactors, personalFactors
    );
    
    // Set the result as a request attribute
    request.setAttribute("fitForDutyResult", result);
    
    // Forward the request to the JSP for rendering
    RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
    dispatcher.forward(request, response);
        
        response.setContentType("text/html");
                 // Get the path to the fit-for-duty.html file
        String filePath = getServletContext().getRealPath("/fit-for-duty.html");
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line);
        }
        PrintWriter out = response.getWriter();
        out.println(content.toString());
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
        catch (FileNotFoundException e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
        
        
    }
}
