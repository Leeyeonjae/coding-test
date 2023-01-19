class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++){
            StringBuffer compressedStr = new StringBuffer();
            int now = 0;
            int mok = s.length() / i;
            
            while(now < mok*i){
                String nowStr = s.substring(now, now+i);
                int repeat = 1;
                
                while(true){
                    int start = now + (i * repeat);
                    int end = start + i;
                    
                    if(start >= mok*i) { 
                        now = start;   
                        break; 
                    } else if(nowStr.equals(s.substring(start, end))) { 
                        repeat++; 
                    } else { 
                        now = start;   
                        break;
                    }
                }
                compressedStr.append(repeat > 1 ? repeat : "");
                compressedStr.append(nowStr);
            }
    
            compressedStr.append(s.substring(mok*i, s.length()));
            
            if(answer > compressedStr.length()){
                answer = compressedStr.length();
            }
        }
        
        return answer;
    }
}