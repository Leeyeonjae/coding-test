import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        //Sort Arrays
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[A.length-i-1];
        }

        return answer;
    }
}