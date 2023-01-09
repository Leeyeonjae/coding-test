import java.util.*;

public class Main
{
    public static int n;
    public static int m;
    public static int frame[][];
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		frame = new int[n][m];
		
		scan.nextLine();
		
		for(int i = 0; i < n; i++){
		    String row = scan.nextLine();
		    
		    for(int j = 0; j < m; j++){
		        frame[i][j] = Character.getNumericValue(row.charAt(j));
		    }
		}
		
		int iceCnt = 0;
		
		// 모든 칸에 음료수 채우기
	    for(int x = 0; x < n; x++){
		    for(int y = 0; y < m; y++){
		        if(dfs(x, y)){
		          iceCnt++;            
		        }
		    }
		}
		
		System.out.println("result = " + iceCnt);
	}
	
	public static boolean dfs(int x, int y){
	    // 범위를 넘어갈 경우 처리
	    if(x <= -1 || y <= -1 || x >= n || y >= m) return false;
	   
	    if(frame[x][y] == 0){
	        // 방문 처리
	        frame[x][y] = 1; 
	        
	        dfs(x - 1, y);
	        dfs(x + 1, y);
	        dfs(x, y - 1);
	        dfs(x, y + 1);
	        
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
