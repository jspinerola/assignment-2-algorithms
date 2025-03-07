public class DivideAndConquer {
    static int duration;
    public static int[] maxSubArray(int[] nums) {
        int duration;
        int[] result = {0, 0};
        long startTime = System.nanoTime();

        if (nums == null || nums.length == 0) {
            return result;
        }
        long endTime = System.nanoTime();
        duration = (int)(endTime - startTime);
        result[0] = findMaxSubArray(nums, 0, nums.length - 1);
        result[1] = duration;
        return result;
    }

    private static int findMaxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int maxLeftSum = findMaxSubArray(nums, left, mid);
        int maxRightSum = findMaxSubArray(nums, mid + 1, right);
        int maxCrossingSum = findMaxCrossingSubArray(nums, left, mid, right);

        return Math.max(Math.max(maxLeftSum, maxRightSum), maxCrossingSum);
    }

    private static int findMaxCrossingSubArray(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMaxSum = Math.max(leftMaxSum, sum);
        }

        sum = 0;
        int rightMaxSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMaxSum = Math.max(rightMaxSum, sum);
        }

        return leftMaxSum + rightMaxSum;
    }

}
