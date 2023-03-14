import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        char lastAlp = words[0].charAt(words[0].length()-1);
        ArrayList<String> preWord = new ArrayList<>(Arrays.asList(words[0]));
        
        for(int i = 1; i < words.length; i++){
            String nowWord = words[i];
            
            if(nowWord.charAt(0) != lastAlp || preWord.contains(nowWord)){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
            
            preWord.add(nowWord);
            lastAlp = nowWord.charAt(nowWord.length()-1);
        }
        
        return answer;
    }
}