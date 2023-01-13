import java.util.*;

public class Main
{
    
	// 한 번 계산된 결과를 메모이제이션(Memoization)하기 위한 배열
	public static long[] cacheFibo;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		cacheFibo = new long[num + 1];
		
		System.out.println("result = " + fibonicci(num));
	}
	
	public static long fibonicci(int num){
		if(num <= 2)  return 1;
		
		if(cacheFibo[num] == 0){
			cacheFibo[num] = fibonicci(num -1) + fibonicci(num-2);
		}
		
		return cacheFibo[num];
	}
}
