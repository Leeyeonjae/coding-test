import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        Integer arrA[] = new Integer[n];
        Integer arrB[] = new Integer[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = scan.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            arrB[i] = scan.nextInt();
        }
        
        Arrays.sort(arrA); // 오름차순 정렬
        Arrays.sort(arrB, Comparator.reverseOrder()); // 내림차순 정렬
        
        for(int i = 0; i < k; i++){
            if(arrA[i] >= arrB[i]) break;
            
            int temp = arrA[i];
            arrA[i] = arrB[i];
            arrB[i] = temp;
        }
        
        long result = Arrays.stream(arrA).mapToInt(i -> i).sum();
        
        System.out.println("result = " + result);
	}
}
