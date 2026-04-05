class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        // Step 1: total sum
        for(int num : nums){
            sum += num;
        }

        int left = 0;

        // Step 2: find pivot
        for(int i = 0; i < nums.length; i++){
            int right = sum - left - nums[i];

            if(left == right){
                return i;
            }

            left += nums[i];
        }

        return -1;
        }
}
    
