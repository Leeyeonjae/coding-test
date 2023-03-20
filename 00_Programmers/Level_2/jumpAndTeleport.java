import java.util.*;

public class Solution {
    public int solution(int n) {
        int battery = 1;
        
        while(n > 1){
            battery += (n%2);
            n /= 2;
        }

        return battery;
    }
}