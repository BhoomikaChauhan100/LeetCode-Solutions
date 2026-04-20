class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        
        int maxSum = nums[0];
        int curMax = 0;
        
        int minSum = nums[0];
        int curMin = 0;
        
        for (int num : nums) {
            // Kadane for max
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            
            // Kadane for min
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            
            total += num;
        }
        
        // Edge case: all negative
        if (maxSum < 0) {
            return maxSum;
        }
        
        return Math.max(maxSum, total - minSum);
    }
}