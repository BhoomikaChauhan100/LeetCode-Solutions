class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            
            // Check valid subarray
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - dq.pollFirst());
            }

            // Maintain increasing order
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}