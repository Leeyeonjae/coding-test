import java.util.*;

public class Main
{
	public static void main(String[] args) {
		// 입력 값 받기
		Scanner scan = new Scanner(System.in);
	    
	    int n = scan.nextInt();
		scan.nextLine();
		String route = scan.nextLine().replaceAll(" ", "");
	
		// 이동 명령어에 따라 좌표 이동
		int x = 1, y = 1;
		
		for(char direction : route.toCharArray()){
		    switch(direction){
		        case 'U':
		            x = (x - 1 < 1 ? x : x - 1);
		            break;
		        case 'D':
		            x = (x + 1 > n ? x : x + 1);
		            break;
		        case 'L':
		            y = (y - 1 < 1 ? y : y - 1);
		            break;
		        case 'R':
		            y = (y + 1 > n ? y : y + 1);
		            break;
		    }
		}
		
		System.out.println(String.format("result point = (%d, %d)", x, y));
	}
}
