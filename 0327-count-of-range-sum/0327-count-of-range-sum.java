class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        return mergeSort(prefix, 0, prefix.length - 1, lower, upper);
    }

    private int mergeSort(long[] sum, int left, int right, int lower, int upper) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int count = mergeSort(sum, left, mid, lower, upper) +
                    mergeSort(sum, mid + 1, right, lower, upper);

        int j = mid + 1, k = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (k <= right && sum[k] - sum[i] < lower) k++;
            while (j <= right && sum[j] - sum[i] <= upper) j++;
            count += (j - k);
        }

        // merge step
        long[] temp = new long[right - left + 1];
        int i = left, p = mid + 1, t = 0;

        while (i <= mid && p <= right) {
            if (sum[i] <= sum[p]) temp[t++] = sum[i++];
            else temp[t++] = sum[p++];
        }

        while (i <= mid) temp[t++] = sum[i++];
        while (p <= right) temp[t++] = sum[p++];

        System.arraycopy(temp, 0, sum, left, temp.length);

        return count;
    }
}