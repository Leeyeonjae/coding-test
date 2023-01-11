import java.util.*;

public class Main
{
	public static void main(String[] args) {
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
        
        // 선택정렬 구현
        for(int i = 0; i < arr.length - 1; i++){
            // 가장 작은 원소의 Idx
            int minIdx = i;
            
            for(int j = i + 1; j < arr.length; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
        
        for(int num : arr){
            System.out.print(num + " ");    
        }
	}
}
