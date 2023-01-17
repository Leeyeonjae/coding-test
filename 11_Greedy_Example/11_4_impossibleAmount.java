import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	    int n = scan.nextInt();
	    int coins[] = new int[n];
	    int result = 1;
	    
	    for(int i = 0; i < n; i++){
	        coins[i] = scan.nextInt(); 
	    }
	    
	    Arrays.sort(coins);
	    
	    for(int i = 0; i < n; i++){
	        if(result < coins[i]) break;
	        result += coins[i];
	    }
	    
	    System.out.println("result = " + result);
	}
}
