class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = nextIndex(nums, slow, forward);
                if (slow == -1) break;

                fast = nextIndex(nums, fast, forward);
                if (fast == -1) break;

                fast = nextIndex(nums, fast, forward);
                if (fast == -1) break;

                if (slow == fast) {
                    return true;
                }
            }

            // mark visited as 0 
            int index = i;
            int dir = nums[i];
            while (true) {
                int next = ((index + nums[index]) % n + n) % n;
                nums[index] = 0;
                if (nums[next] == 0 || (nums[next] > 0) != (dir > 0)) break;
                index = next;
            }
        }
        return false;
    }

    private int nextIndex(int[] nums, int current, boolean forward) {
        boolean direction = nums[current] > 0;
        if (direction != forward) return -1;

        int n = nums.length;
        int next = ((current + nums[current]) % n + n) % n;

        // one element loop
        if (next == current) return -1;

        return next;
    }
}