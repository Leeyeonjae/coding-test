import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int[] count = new int[x+1];
		int[] divisors = {2, 3, 5};
		
		count[1] = 0;
		count[2] = 1;
		
		for(int i = 3; i <= x; i++){
			count[i] = count[i-1] + 1;
			
			for(int divisor : divisors){
				if(i % divisor == 0) count[i] = Math.min(count[i], count[i/divisor] + 1);
			}
		}
		
		System.out.println("result = " + count[x]);
	}
}
