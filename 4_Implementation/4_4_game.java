import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    // 입력 값 받기
	    Scanner scan = new Scanner(System.in);
	    
	    int mapRow = scan.nextInt();
        int mapColumn = scan.nextInt();
	   
	    int positionX = scan.nextInt();
	    int positionY = scan.nextInt();
	    int direction = scan.nextInt();
	    
	    int visitedIsland = 1;
	    int map[][] = new int[mapRow][mapColumn];
	    int visitedMap[][] = new int[mapRow][mapColumn];
	    
	    // 방향에 따른 위치 이동 정의
        int directionMoveX[] = {-1, 0, 1, 0};
        int directionMoveY[] = {0, 1, 0, -1};
	    
	    for(int i = 0; i < mapRow; i++){
	        for(int j = 0; j < mapColumn; j++){    
	            map[i][j] = scan.nextInt();
	        }
	    }
	  
	    while(true){
            int moveTargetX = positionX;
	        int moveTargetY = positionY;

	        // 왼쪽으로 방향 변경
	        direction = (direction == 0 ? 3 : direction - 1);
	        visitedMap[positionX][positionY]++;

	        // 4방향을 모두 돈 경우
	        if (visitedMap[positionX][positionY] > 4){
	            moveTargetX -= directionMoveX[direction];
	            moveTargetY -=  directionMoveY[direction];
    	        
    	        if(map[moveTargetX][moveTargetY] == 1){
    	            break;
    	        }else{
    	            positionX = moveTargetX;
	                positionY = moveTargetY;
	                continue;
    	        }
	        }
	        
	        // 이동 가능한 위치인지 확인
	        moveTargetX += directionMoveX[direction];
	        moveTargetY +=  directionMoveY[direction];
    	    
	        if(map[moveTargetX][moveTargetY] == 0 && visitedMap[moveTargetX][moveTargetY] == 0){
	            positionX = moveTargetX;
	            positionY = moveTargetY;
	            visitedIsland++;
	        }
	    }
	    
	    System.out.println("result = " + visitedIsland);
	}
}

