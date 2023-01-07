import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
	    // 조건 값들 입력 받기
	    int n = scan.nextInt();
	    int k = scan.nextInt();
	    int result = 0;
	 
	    while(true){
	        // 나머지를 더한 후 나누기
	        result += (n % k) + 1;
	        n /= k;
	        
	        // 나눌 수 없어지면 종료
	        if(n < k) break;
	    }
	    
	    //1이 될때까지 남은 값을 연산 횟수에 포함
	    result += (n - 1);
	    
	    System.out.println("result = " + result);  
	}
}
