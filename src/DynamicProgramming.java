public class DynamicProgramming {
    public static int[] maxSubArray(int[] nums) {
        int duration;
        int[] result = {0, 0};
        long startTime = System.nanoTime();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSoFar = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxSoFar = Math.max(maxSoFar, dp[i]);
        }
        long endTime = System.nanoTime();
        duration = (int)(endTime - startTime);
        result[0] = maxSoFar;
        result[1] = duration;
        return result;
    }

    // A space-optimized version that uses only constant extra space.
    public static int[] maxSubArrayOptimized(int[] nums) {
        int duration;
        int[] result = {0, 0};
        long startTime = System.nanoTime();

        if (nums == null || nums.length == 0) {
            return result;
        }

        int currentMax = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        long endTime = System.nanoTime();
        duration = (int)(endTime - startTime);
        result[0] = maxSoFar;
        result[1] = duration;
        return result;
    }
}
