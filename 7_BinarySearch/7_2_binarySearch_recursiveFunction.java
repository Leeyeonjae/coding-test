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

        int result = binarySearch(arr, target, 0, n - 1);
        
        if (result == -1) {
            System.out.println(String.format("[%s] doesn't exit.", target));
        } else {
            System.out.println(result + 1);
        }
	}
	
	public static int binarySearch(int arr[], int target, int start, int finish){
	    if(finish <= start) return -1; 
	    
	    int mid =  (start + finish) / 2;
	    
	    if (arr[mid] == target) return mid;
	    
	    // 검색 대상이 중간값모다 작을 경우 왼쪽은 그렇지 않을 경우 오른쪽을 검색
	    if(target < arr[mid]) {
	        return binarySearch(arr, target, start, mid -1);
	    } else {
	        return binarySearch(arr, target, mid +1, finish);
	    }
	}
}
