public class UlamFunction {
    public static void main(String[] args) {
        System.out.println("Testing Ulam Function for numbers 1 to 999,999");
        System.out.println("Starting test...");
        
        int maxSteps = 0;
        int numberWithMaxSteps = 0;
        int testLimit = 999999;
        
        // Test all numbers from 1 to 999,999
        for (int n = 1; n <= testLimit; n++) {
            int steps = testUlamFunction(n);
            
            if (steps == -1) {
                System.out.println("ERROR: Number " + n + " did not reach 1!");
                return;
            }
            
            // Track the number that takes most steps
            if (steps > maxSteps) {
                maxSteps = steps;
                numberWithMaxSteps = n;
            }
            
            // Show progress every 100,000 numbers
            if (n % 100000 == 0) {
                System.out.println("Tested " + n + " numbers so far...");
            }
        }
        
        System.out.println("\n=== RESULTS ===");
        System.out.println("✓ All " + testLimit + " numbers reached 1!");
        System.out.println("Maximum steps needed: " + maxSteps);
        System.out.println("Number that took most steps: " + numberWithMaxSteps);
        System.out.println("Ulam function terminates for all tested numbers.");
    }
    
    /**
     * Tests the Ulam function for a given number
     * Returns number of steps to reach 1, or -1 if it doesn't reach 1
     */
    public static int testUlamFunction(int n) {
        long num = n;  // Use long to prevent overflow
        int steps = 0;
        int maxStepsAllowed = 10000; // Increased safety limit for larger numbers
        
        while (num != 1 && steps < maxStepsAllowed) {
            if (num % 2 == 0) {
                num = num / 2;  // If even, divide by 2
            } else {
                num = num * 3 + 1;  // If odd, multiply by 3 and add 1
            }
            steps++;
        }
        
        // Return -1 if we didn't reach 1 within the step limit
        if (num != 1) {
            return -1;
        }
        
        return steps;
    }
}