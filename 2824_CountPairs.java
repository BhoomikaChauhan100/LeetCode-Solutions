
// Problem : 2824. Count pairs Whose Sum is Less than Target
// Difficulty : Easy
// Platform : LeetCode
 class Solution {
    public int countPairs(List<Integer> nums, int target) {
         Collections.sort(nums); 
        int i=0;
        int j = nums.size() - 1;
        int count=0;
        while(i<j){
            if(nums.get(i) + nums.get(j)<target){
                count=count+(j-i);
                i++;
            }
            else{
                j--;
            }
        }
        return count;
    }
}