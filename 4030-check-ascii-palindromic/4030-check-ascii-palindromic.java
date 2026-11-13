
class Solution {
    public boolean isPalindromic(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            String binary = Integer.toBinaryString(ch);

            sb.append("0".repeat(8 - binary.length()));
            sb.append(binary);
        }

        String str = sb.toString();

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
