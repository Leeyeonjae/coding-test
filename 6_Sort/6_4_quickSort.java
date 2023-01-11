public class Main
{
	public static void main(String[] args) {
		  int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		  
		  quickSort(arr, 0, arr.length-1);
		  
		  for(int num : arr){
            System.out.print(num + " ");
		  }
	}
	
	public static void quickSort(int[] arr, int start, int finish){
	    if(start >= finish){
	        return ; 
	    }
	    
	    int pivot = start;
	    int left = start + 1; 
	    int right = finish;
	    
	    while(left <= right){
	        // 피벗보다 큰 데이터를 찾을 때까지 반복
	        while(left <= finish && arr[left] <= arr[pivot]) left++;
	        // 피벗보다 작은 데이터를 찾을 때까지 반복
	        while(right > start && arr[right] >= arr[pivot]) right--;
	        
	        int temp = arr[right];
	        
	        if(left > right){
	            arr[right] = arr[pivot];
	            arr[pivot] = temp;
	        }else{
	            arr[right] = arr[left];
	            arr[left] = temp;
	        }
	    }
	    
	    quickSort(arr, start, right -1);
	    quickSort(arr, right + 1, finish);
	}
}
