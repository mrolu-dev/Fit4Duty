import java.util.Scanner;

public class FitForDutyApp {
    public static void main(String[] args) {
        // Get user inputs
        Scanner scanner = new Scanner(System.in);
        System.out.println("FIT FOR DUTY CALCULATOR");
        System.out.println("-----------------------");
        System.out.println("Please select the options for the following factors:");
        
        // Prompt and select options for each factor
        int physicalSymptoms = selectOption("Physical Symptoms", scanner, "None", "Mild", "Moderate", "Severe");
        int cognitiveFunction = selectOption("Cognitive Function", scanner, "Normal", "Slight impairment", "Moderate impairment", "Significant impairment");
        int emotionalState = selectOption("Emotional State", scanner, "Positive", "Neutral", "Negative");
        int workloadResponsibilities = selectOption("Workload Responsibilities", scanner, "Low", "Moderate", "High");
        int environmentalFactors = selectOption("Environmental Factors", scanner, "Favorable", "Neutral", "Unfavorable");
        int personalFactors = selectOption("Personal Factors", scanner, "Positive", "Neutral", "Negative");

        scanner.close();
        
        // Calculate fatigue and stress
        int fatigue = calculateFatigue(physicalSymptoms, cognitiveFunction, workloadResponsibilities);
        int stress = calculateStress(emotionalState, environmentalFactors, personalFactors);
        
        // Determine if user is fit for duty
        boolean fitForDuty = isFitForDuty(fatigue, stress);

        if (fitForDuty) {
            System.out.println("You are fit for duty.");
        } else {
            System.out.println("You are not fit for duty. Take appropriate measures before resuming work.");
        }
        
    }
    
    private static int selectOption(String factor, Scanner scanner, String... options) {
    
    int selectedOption;

    System.out.println(factor + ":");
    for (int i = 0; i < options.length; i++) {
        System.out.println((i + 1) + ". " + options[i]);
    }

    do {
        System.out.print("Enter your choice (1-" + options.length + "): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid choice.");
            System.out.print("Enter your choice (1-" + options.length + "): ");
            scanner.next();
        }
        selectedOption = scanner.nextInt();
    } while (selectedOption < 1 || selectedOption > options.length);

    scanner.nextLine(); // Consume the newline character

    return selectedOption - 1;
}
    
    private static int calculateFatigue(int physicalSymptoms, int cognitiveFunction, int workloadResponsibilities) {
        return physicalSymptoms + cognitiveFunction + workloadResponsibilities;
    }
    
    private static int calculateStress(int emotionalState, int environmentalFactors, int personalFactors) {
        return emotionalState + environmentalFactors + personalFactors;
    }
    
    private static boolean isFitForDuty(int fatigue, int stress) {
        return fatigue <= 6 && stress <= 6;
    }
    
    private static void renderAdvice(boolean fitForDuty) {
        System.out.println("\nFIT FOR DUTY RESULTS");
        System.out.println("--------------------");
        if (fitForDuty) {
            System.out.println("You are fit for duty.");
        } else {
            System.out.println("You are not fit for duty. Take appropriate measures before resuming work.");
        }
    }
}
