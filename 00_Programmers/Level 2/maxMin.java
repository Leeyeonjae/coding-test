import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] numArr = Arrays.stream(s.split(" "))
                        .mapToInt(Integer::parseInt)
                        .sorted()
                        .toArray();
        
        return (numArr[0] + " " + numArr[numArr.length - 1]);
    }
}