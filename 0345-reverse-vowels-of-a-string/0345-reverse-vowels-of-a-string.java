class Solution {
    public String reverseVowels(String s) {
        char[]arr=s.toCharArray();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(i<j && !isvowel(arr[i])){
                i++;
            }
            while(i<j && !isvowel(arr[j])){
                j--;
            }
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return new String(arr);
    }
    public boolean isvowel(char ch){
        return "aeiouAEIOU".indexOf(ch)!=-1;
    }
}