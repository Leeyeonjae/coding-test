import java.util.*;

public class Main
{
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		
		int count[] = new int[n+1];
		int[] food = new int[n];
		for (int i = 0; i < n; i++) {
			food[i] = scan.nextInt();
		}
		
		count[0] = food[0];
		count[1] = Math.max(food[0], food[1]);
		
		for(int i = 2; i <n; i++){
			// i-1과 i-2 중 큰 값을 결정
			count[i] = Math.max(count[i-1], count[i-2] + food[i]);
		}
		
		System.out.println("result = " + count[n-1]);
	}

}
