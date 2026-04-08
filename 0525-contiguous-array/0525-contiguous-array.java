class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLength = 0;
        
        // Important: sum 0 at index -1
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            // Convert 0 → -1
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(sum, i);
            }
        }
        
        return maxLength;
    }
}