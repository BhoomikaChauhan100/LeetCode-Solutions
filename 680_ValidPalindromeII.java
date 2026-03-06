// Problem : 680. Valid Palindrome II
// Difficulty : Easy
// Platform : LeetCode
class Solution {
public boolean helperpalindrome(int i,int j,String s){
    while(i<j){
        if(s.charAt(i)!=s.charAt(j)){
            return false;
        }
        i++;
        j--;
    }
    return true;
}
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char left=s.charAt(i);
            char right=s.charAt(j);
            if(left!=right){
                //use superpower
                return helperpalindrome(i++,j,s)||helperpalindrome(i,j--,s);
            
           } else{
                i++;
                j--;
            }
        }
        return true;
    }
}