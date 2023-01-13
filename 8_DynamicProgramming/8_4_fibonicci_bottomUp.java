import java.util.*;

public class Main
{
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		long[] fibo = new long[num + 1];
		fibo[1] = 1;
		fibo[2] = 1;
		
		for(int i = 3; i < fibo.length; i++){
			fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		System.out.println("result = " + fibo[num]);
	}

}
