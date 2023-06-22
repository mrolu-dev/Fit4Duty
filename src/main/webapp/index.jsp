<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Fit for Duty Calculator</title>
</head>
<body>
    <h1>Fit for Duty Calculator</h1>
    <form method="post" action="fit-for-duty">
        <h3>Physical Symptoms:</h3>
        <select name="physicalSymptoms">
            <option value="0">None</option>
            <option value="1">Mild</option>
            <option value="2">Moderate</option>
            <option value="3">Severe</option>
        </select>
        
        <h3>Cognitive Function:</h3>
        <select name="cognitiveFunction">
            <option value="0">Normal</option>
            <option value="1">Slight impairment</option>
            <option value="2">Moderate impairment</option>
            <option value="3">Significant impairment</option>
        </select>
        
        <h3>Emotional State:</h3>
        <select name="emotionalState">
            <option value="0">Positive</option>
            <option value="1">Neutral</option>
            <option value="2">Negative</option>
        </select>
        
        <h3>Workload Responsibilities:</h3>
        <select name="workloadResponsibilities">
            <option value="0">Low</option>
            <option value="1">Moderate</option>
            <option value="2">High</option>
        </select>
        
        <h3>Environmental Factors:</h3>
        <select name="environmentalFactors">
            <option value="0">Favorable</option>
            <option value="1">Neutral</option>
            <option value="2">Unfavorable</option>
        </select>
        
        <h3>Personal Factors:</h3>
        <select name="personalFactors">
            <option value="0">Positive</option>
            <option value="1">Neutral</option>
            <option value="2">Negative</option>
        </select>
        
        <br/><br/>
        <input type="submit" value="Calculate Fit for Duty">
    </form>
</body>
</html>
