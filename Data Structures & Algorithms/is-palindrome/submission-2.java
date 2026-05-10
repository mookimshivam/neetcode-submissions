class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        char[] arr = new char[s.length()];

        // filtering alphanumeric
        int valid = -1;
        for(int i = 0; i < s.length(); i++){
            char c = str.charAt(i);
            int num = c - '0';
            int letter = c - 'a';

            if((num >= 0 && num <= 9) || (letter >= 0 && letter <= 25))
                arr[++valid] = c;
        }

        // actual comparison of character
        int i = 0, j = valid;
        while(i < j){
            if(arr[i] != arr[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}