import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);	    
	    
	    // 조건 값들 입력 받기
	    int n = scan.nextInt();
	    int m = scan.nextInt();
	    int k = scan.nextInt();
	    int numArr[] = new int[n];
	 
	    for(int i = 0; i < n; i++){
	        numArr[i] = scan.nextInt();
	    }
	    
	    // 배열 내림차순 정렬
	    numArr = Arrays.stream(numArr)
                	    .boxed()
                	    .sorted(Comparator.reverseOrder())
                	    .mapToInt(i -> i)
                	    .toArray();
	    
	    //첫번재 값이 더해지는 횟수 계산
	    int first = (m / (k+1) * k) + (m % (k+1));
	    int second = m - first;
	    int result = (numArr[0] * first) + (numArr[1] * second);
	 
        System.out.println("result =" + result);
	}
}
