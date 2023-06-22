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
import java.util.Scanner;

public class FitForDutyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Create a Scanner object to read user input from the request
    Scanner scanner = new Scanner(request.getInputStream());

    // Read the selected options from the user input
    String physicalSymptoms = scanner.nextLine();
    String cognitiveFunction = scanner.nextLine();
    String emotionalState = scanner.nextLine();
    String workloadResponsibilities = scanner.nextLine();
    String environmentalFactors = scanner.nextLine();
    String personalFactors = scanner.nextLine();

    // Perform the fitness calculation using FitForDutyApp
    FitForDutyApp fitForDutyApp = new FitForDutyApp();
    scanner result = fitForDutyApp.selectOption(
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
