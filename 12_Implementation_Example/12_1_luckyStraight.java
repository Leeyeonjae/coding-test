import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
	    String numStr = scan.next();
	    int summary = 0;
	    
	    for(int i = 0; i < numStr.length(); i++){
	        if(i < numStr.length() / 2){
	            summary += numStr.charAt(i) - '0';;
	        } else {
	            summary -= numStr.charAt(i) - '0';;
	        }
	    }

	    System.out.println(summary == 0 ? "LUCKY" : "READY");
	}
}
