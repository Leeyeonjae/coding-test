import java.util.*;

public class Main
{
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[] count = new int[m + 1];
		
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = scan.nextInt();
		}
		
		Arrays.fill(count, 1, count.length, 10001);
		
		for(int coin : coins){
			for(int j = coin; j <= m; j++){
				if(count[j-coin] != 10001){
					count[j] = Math.min(count[j], count[j-coin] + 1);
				}
			}    
		}
		
		if (count[m] == 10001) {
			System.out.println("Impossible");
		} else {
			System.out.println("result = " + count[m]);
		}
	}

}
