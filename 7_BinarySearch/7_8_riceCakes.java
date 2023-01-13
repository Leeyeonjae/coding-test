import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int m = scan.nextInt();
        
        int[] riceCakes = new int[n];
        for (int i = 0; i < n; i++) {
            riceCakes[i] = scan.nextInt();
        }
    
        int result = binarySearch(riceCakes, m);
        if(result == -1){
            System.out.println("Impossible");
        } else {
            System.out.println("result = " + result);
        }
	}
	
	public static int binarySearch(int[] riceCakes, int total){
	    int start = 0;
        int finish = Arrays.stream(riceCakes).max().getAsInt();
        int result = -1;
        
        while(start <= finish){
            int mid = (start + finish) / 2;
            
            int cutTotal = 0;
            for(int riceCake : riceCakes){
                if (riceCake > mid){
                    cutTotal += (riceCake - mid);
                }
            }
            
            if(total == cutTotal) {
                result = mid;
                break;
            } else if(total < cutTotal) {
                start = mid + 1;
            } else {
                finish = mid -1;
            }
        }
        
        return result;
	}
}
