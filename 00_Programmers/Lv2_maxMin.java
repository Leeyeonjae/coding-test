import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] numArr = Arrays.stream(s.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        
        Arrays.sort(numArr);
        
        return (numArr[0] + " " + numArr[numArr.length - 1]);
    }
}