class Solution {
    public boolean isPalindrome(String s) {
        // using regex to filter alphanumeric
        String result = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        // actual comparison of character
        for(int i=0, j=result.length()-1; i<=j; i++, j--){
            if(result.charAt(i) == result.charAt(j))
                continue;
            return false;
        }
        return true;
    }
}