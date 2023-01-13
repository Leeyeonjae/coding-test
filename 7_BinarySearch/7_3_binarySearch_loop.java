import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int target = scan.nextInt();

        // 정렬된 원소 입력받기 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int start = 0;
        int finish = n - 1;
        int result = -1;
        
        while(start <= finish){
            int mid = (start + finish) / 2;
            
            if(target == arr[mid]) {
                result = mid;
                break;
            } else if(target < arr[mid]) {
                finish = mid -1;
            } else {
                start = mid + 1;
            }
        }
      
        if (result == -1) {
            System.out.println(String.format("[%s] doesn't exit.", target));
        } else {
            System.out.println(result + 1);
        }
	}
}
