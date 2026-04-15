class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        
        int left = -1; 
        int right = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // Left to Right
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        // Right to Left
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        if (right == -1) return 0;
        
        return right - left + 1;
    }
}