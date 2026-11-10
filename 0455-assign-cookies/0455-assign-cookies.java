
import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // Children pointer
        int j = 0; // Cookies pointer

        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                i++;
            }

            j++;
        }

        return i;
    }
}
