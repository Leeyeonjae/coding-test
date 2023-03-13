import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        StringTokenizer splitedStr = new StringTokenizer(s, " ", true);
        
        while(splitedStr.hasMoreTokens()){
            String word = splitedStr.nextToken();

            answer.append(word.substring(0, 1).toUpperCase());

            if(word.length() > 1){
                answer.append(word.substring(1).toLowerCase());
            } 
        }
        
        return answer.toString();
    }
}