class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int h = 1 ; h <= yellow; h++){
            if(yellow % h == 0 && (h + yellow/h) * 2 + 4 == brown){
                answer[0] = (yellow/h) + 2;
                answer[1] = h + 2;
                break;
            } 
        }
        
        return answer;
    }
}