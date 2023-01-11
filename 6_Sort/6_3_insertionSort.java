public class Main
{
	public static void main(String[] args) {
		  int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
		  
		  for(int i = 1; i < arr.length; i++){
		      for(int j = i; j > 0; j--){
		          if(arr[j] < arr[j-1]){
		              int temp = arr[j];
		              arr[j] = arr[j-1];
		              arr[j-1] = temp;    
		          } else {
		              // 기준 숫자의 왼쪽은 이미 정렬된 상태이기 때문에 중지
		              break;
		          }
		      }
		  }
		  
		  for(int num : arr){
            System.out.print(num + " ");
		  }
	}
}
