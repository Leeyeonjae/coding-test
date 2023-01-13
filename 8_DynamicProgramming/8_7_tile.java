import java.util.*;

public class Main
{
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int count[] = new int[n+1];
		
		count[1] = 1;
		count[2] = 3;
		for (int i = 3; i <= n; i++) {
			count[i] = (count[i - 1] + 2 * count[i - 2]) % 796796;
		}
		
		System.out.println(count[n]);
	}

}
