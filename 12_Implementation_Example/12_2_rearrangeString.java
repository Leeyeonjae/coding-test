import java.util.*;

public class Main
{
	public static void main(String[] args) {
	   Scanner scan = new Scanner(System.in);
	   
	   String str = scan.next();
	   String num = str.replaceAll("[^0-9]", "");
	   char alpha[] = str.replaceAll("[^A-Z]", "").toCharArray();
	   
	   Arrays.sort(alpha);
	   
	   int sum = 0; 
	   for(char c : num.toCharArray()){
	       sum += c - '0';
	   }
	   
	   String sortedAlpha = new String(alpha);
	   String addedNum = (sum == 0 ? "" : String.valueOf(sum));
	   
	   
	   System.out.println("result = " + sortedAlpha + sum);
	}
}
