import java.math.BigInteger;

class Solution {
    public int solution(int n) {
        long answer = 0L;
        long preOne = 1L;
        long preTwo = 1L;
        
        for(int i = 1; i<=n-2; i++){
            answer = (preOne + preTwo)%1234567;
            preOne = preTwo;
            preTwo = answer;
        }
        
        return (int)(answer);
    }
}