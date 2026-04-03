class Solution {
    public int maximumSum(int[] arr) {
       int n = arr.length;
        int noDel = arr[0];      // max sum without deletion
        int oneDel = 0;          // max sum with one deletion
        int res = arr[0];

        for (int i = 1; i < n; i++) {
            oneDel = Math.max(oneDel + arr[i], noDel); // delete current or continue previous deletion
            noDel = Math.max(noDel + arr[i], arr[i]); // normal Kadane

            res = Math.max(res, Math.max(noDel, oneDel));
        }

        return res;
    }
}
