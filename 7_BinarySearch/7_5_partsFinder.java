import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int[] parts = new int[n];
        for (int i = 0; i < n; i++) {
            parts[i] = scan.nextInt();
        }
        
        // 부품 목록 오름차순 정렬
        Arrays.sort(parts);
        
        int m = scan.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = scan.nextInt();
        }

        for (int target : targets) { 
            System.out.print(binarySearch(parts, target) + " ");
        }
	}
	
	public static String binarySearch(int[] parts, int target){
	    int start = 0;
        int finish = parts.length - 1;
        int result = -1;
        
        while(start <= finish){
            int mid = (start + finish) / 2;
            
            if(target == parts[mid]) {
                result = mid;
                break;
            } else if(target < parts[mid]) {
                finish = mid -1;
            } else {
                start = mid + 1;
            }
        }
        
        return (result != -1 ? "yes" : "no");
	}
}
