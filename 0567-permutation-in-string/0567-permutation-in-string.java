class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // s1 ka count
        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        int windowSize = s1.length();

        // sliding window
        for (int i = 0; i < s2.length(); i++) {

            // add cureent character
            count2[s2.charAt(i) - 'a']++;

            // maintain windiw size
            if (i >= windowSize) {
                count2[s2.charAt(i - windowSize) - 'a']--;
            }

            // compare arrays
            if (matches(count1, count2)) {
                return true;
            }
        }

        return false;
    }

    // helper function
    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}