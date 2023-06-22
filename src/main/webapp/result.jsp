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
