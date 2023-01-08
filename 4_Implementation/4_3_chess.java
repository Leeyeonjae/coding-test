import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    // 체스판 사이즈 정의 
	    final int MAP_SIZE = 8;
	    
	    // 입력 값 받기
	    Scanner scan = new Scanner(System.in);
	    
	    String position = scan.next();
	    int cases = 0;
	    int x = Character.getNumericValue(position.charAt(1));
	    int y = Integer.valueOf(position.charAt(0) - ('a' - 1));

	    // 4가지 방향에 대한 이동 확인
	    if(y - 2 >= 1){
	        cases += (x == 1 || x == MAP_SIZE) ? 1 : 2;
	    }
	    
	    if(y + 2 <= MAP_SIZE){
	       cases += (x == 1 || x == MAP_SIZE) ? 1 : 2;
	    }
	    
	    if(x - 2 >= 1){
	        cases += (y == 1 || y == MAP_SIZE) ? 1 : 2;
	    }
	    
	    if(x + 2 <= MAP_SIZE){
	        cases += (y == 1 || y == MAP_SIZE) ? 1 : 2;
	    }
	    
	    System.out.println("result = " + cases);
	}
}

