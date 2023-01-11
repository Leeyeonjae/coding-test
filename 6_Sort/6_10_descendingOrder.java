import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		Integer numbers[] = new Integer[n];
		
		for(int i = 0; i < n; i++){
		    numbers[i] = scan.nextInt();
		}
		
		Arrays.sort(numbers, Comparator.reverseOrder());
		
		for(int number : numbers){
		    System.out.print(number + " ");
		}
		
	}
}
