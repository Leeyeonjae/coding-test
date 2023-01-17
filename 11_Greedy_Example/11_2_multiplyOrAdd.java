import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int result = 0;
	    String numStr = scan.nextLine();
	    
	    for(char c : numStr.toCharArray()){
	        int num = c - '0';
	        
	        if(num <= 1 || result <= 1){
	            result += num;
	        }else{
	            result *= num;
	        }
	    }
		
		System.out.println("result = " + result);
	}
}
