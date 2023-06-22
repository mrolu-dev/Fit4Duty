package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
                physicalSymptoms,
                cognitiveFunction,
                emotionalState,
                workloadResponsibilities,
                environmentalFactors,
                personalFactors
        );
        
        // Set the result as a request attribute
        request.setAttribute("fitForDutyResult", result);
        
        // Forward the request to the JSP for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
