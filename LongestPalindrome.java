class Solution {
    public String longestPalindrome(String s) {
        //makes sure the string is not empty
        if(s.length() <  1)
            return "";

        //indexes for the substring we will return
        int start = 0;
        int end = 0;

        for(int i = 0; i < s.length(); i++){
            //findLongest(i,i,s) handles the case of 'bacab'
            //findLongest(i,i+1,s) handles the case of 'baab'
            int length = Math.max(findLongest(i, i, s), findLongest(i, i+1, s));

            //checks if the length of the palindrome is the max, and if it is, it assigns new
            //indexes to the start and the end
            if(length > end - start){
                start = i - ((length-1) / 2);
                end = i + (length / 2);
            }
        }

        return s.substring(start, end+1);

    }

    public int findLongest(int left, int right, String s){
        //checks that the string and the pointers to the indexes are valid
        if(s == null || left < 0 || right >= s.length())return 0;

        //finds the size of the biggest substring palindrome
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            right++;
            left--;
        }

        return right - left - 1;
    }
}