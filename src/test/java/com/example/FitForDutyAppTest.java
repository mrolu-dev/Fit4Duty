import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FitForDutyAppTest {
    
    @Test
    public void testFitForDuty() {
        // Test case 1: Fit for duty
        int fatigue1 = 4;
        int stress1 = 3;
        boolean fitForDuty1 = FitForDutyApp.isFitForDuty(fatigue1, stress1);
        Assertions.assertTrue(fitForDuty1, "Fit for duty test case failed.");
        
        // Test case 2: Not fit for duty
        int fatigue2 = 7;
        int stress2 = 8;
        boolean fitForDuty2 = FitForDutyApp.isFitForDuty(fatigue2, stress2);
        Assertions.assertFalse(fitForDuty2, "Not fit for duty test case failed.");
    }
    
    @Test
    public void testCalculateFatigue() {
        int physicalSymptoms = 2;
        int cognitiveFunction = 1;
        int workloadResponsibilities = 3;
        int expectedFatigue = 6;
        
        int calculatedFatigue = FitForDutyApp.calculateFatigue(physicalSymptoms, cognitiveFunction, workloadResponsibilities);
        Assertions.assertEquals(expectedFatigue, calculatedFatigue, "Fatigue calculation test case failed.");
    }
    
    @Test
    public void testCalculateStress() {
        int emotionalState = 2;
        int environmentalFactors = 1;
        int personalFactors = 3;
        int expectedStress = 6;
        
        int calculatedStress = FitForDutyApp.calculateStress(emotionalState, environmentalFactors, personalFactors);
        Assertions.assertEquals(expectedStress, calculatedStress, "Stress calculation test case failed.");
    }
}

