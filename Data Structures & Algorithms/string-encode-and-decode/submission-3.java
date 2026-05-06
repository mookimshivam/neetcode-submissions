class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s: strs){
            str.append(s.length()+"#"+s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j)!='#' && str.charAt(j)>=48 && str.charAt(j)<=57)
                j++;
            int length = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+length;

            result.add(str.substring(i,j));
            i = j;
        }
        return result;
    }
}