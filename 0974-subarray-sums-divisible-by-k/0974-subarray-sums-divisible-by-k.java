class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;

        // remainder frequency map
        int[] remainderCount = new int[k];
        remainderCount[0] = 1; // important

        for (int num : nums) {
            prefixSum += num;

            int rem = prefixSum % k;

            // handle negative remainder
            if (rem < 0) rem += k;

            count += remainderCount[rem];

            remainderCount[rem]++;
        }

        return count;
    }
}