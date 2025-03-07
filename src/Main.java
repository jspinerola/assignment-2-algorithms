import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Define data to be used for problems
        int[] exampleOneData = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] exampleTwoData = generateRandomData();

        //Store results in variables to be printed. Each method returns an integer array, with first value being solution and second being execution time
        int[] problemTwoResultDaC = DivideAndConquer.maxSubArray(exampleTwoData);
        int[] problemOneResultDaC = DivideAndConquer.maxSubArray(exampleOneData);

        int[] problemTwoResultDP = DynamicProgramming.maxSubArray(exampleTwoData);
        int[] problemOneResultDP = DynamicProgramming.maxSubArray(exampleOneData);

        int[] problemTwoResultDPO = DynamicProgramming.maxSubArrayOptimized(exampleTwoData);
        int[] problemOneResultDPO = DynamicProgramming.maxSubArrayOptimized(exampleOneData);

        //Print out results to a formatted string
        System.out.printf("%-40s|%-25s|%-25s|%-25s|%-25s\n", "Approach", "Problem One Solution", "Problem One Exec. Time", "Problem Two Solution", "Problem Two Exec. Time");
        System.out.printf("%-40s|%-25d|%-25d|%-25d|%-25d\n", "Divide and Conquer", problemOneResultDaC[0], problemOneResultDaC[1], problemTwoResultDaC[0], problemTwoResultDaC[1]);
        System.out.printf("%-40s|%-25d|%-25d|%-25d|%-25d\n", "Dynamic Programming", problemOneResultDP[0], problemOneResultDP[1], problemTwoResultDP[0], problemTwoResultDP[1]);
        System.out.printf("%-40s|%-25d|%-25d|%-25d|%-25d\n", "Dynamic Programming", problemOneResultDPO[0],  problemOneResultDPO[1],  problemTwoResultDPO[0], problemTwoResultDPO[1]);
    }
    public static int[] generateRandomData() {
        final int NUM_DAYS = 100;
        int[] prices = new int[NUM_DAYS];
        int[] dailyChange = new int[NUM_DAYS - 1];
        Random random = new Random();

        for (int i = 0; i < NUM_DAYS; i++) {
            prices[i] = 50 + random.nextInt(100);
        }
        for (int i = 1; i < prices.length; i++) {
            dailyChange[i - 1] = prices[i - 1] - prices[i];
        }
        return dailyChange;
    }
}