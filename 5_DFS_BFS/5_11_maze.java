import java.util.*;

// 좌표 저장을 위한 Class
class Position {
    int x;
    int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
}

public class Main
{
    public static int n;
    public static int m;
    public static int maze[][];
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		m = scan.nextInt();
		maze = new int[n][m];
		
		scan.nextLine();
		
		for(int i = 0; i < n; i++){
		    String row = scan.nextLine();
		    
		    for(int j = 0; j < m; j++){
		        maze[i][j] = Character.getNumericValue(row.charAt(j));
		    }
		}
		
		System.out.println("result = " + bfs(0, 0));
	}

	public static int bfs(int x, int y){
	    //상하 좌우 이동 방향 
	    int directionX[] = {-1, 0, 1, 0};
	    int directionY[] = {0, 1, 0, -1};
	    
	    Queue<Position> queue = new LinkedList<Position>();
	    queue.offer(new Position(x, y));
	    
	    while(!queue.isEmpty()){
	        Position now = queue.poll();
	        
	        for(int i = 0; i < directionX.length; i++){
	            int nextStepX  = now.getX() + directionX[i];
	            int nextStepY = now.getY() + directionY[i]; 
	            
	            // 범위를 넘어갈 경우 
	            if(nextStepX <= -1 || nextStepY <= -1 || nextStepX >= n || nextStepY >= m) continue;
	            
	            // 처음 방문하는 경우에만
	            if(maze[nextStepX][nextStepY] == 1){
	                maze[nextStepX][nextStepY] =  maze[now.getX()][now.getY()] + 1;
	                queue.offer(new Position(nextStepX, nextStepY));
	            }
	        }
	    }
	    
	    return maze[n-1][m-1];
	}
}
