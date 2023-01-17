import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
	    String numStr = scan.next();
	    int count[] = {0, 0};
	    
        count[numStr.charAt(0) - '0']++;
        
        for(int i = 1; i < numStr.length(); i++){
            if(numStr.charAt(i)!= numStr.charAt(i-1)) count[numStr.charAt(i) - '0']++;
        }
        
		System.out.println("result = " + Math.min(count[0], count[1]));
	}
}
