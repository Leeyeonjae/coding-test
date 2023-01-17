import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	    int ballCnt = scan.nextInt();
	    int maxWeight = scan.nextInt();
	    int count[] = new int[maxWeight+1];
	    int result = 0;
	    
	    for(int i = 0; i < ballCnt; i++){
	        int weight = scan.nextInt();
	        
	        count[weight]++;
	    }
	    
	    for(int i = 1; i <= maxWeight; i++){ 
	        ballCnt -= count[i]; // A가 선택할 수 있는 개수 제외
	        result += (ballCnt * count[i]); // B가 선택하는 경우의 수와 곱해주기
	    }
	    
	    System.out.println("result = " + result);
	}
}
