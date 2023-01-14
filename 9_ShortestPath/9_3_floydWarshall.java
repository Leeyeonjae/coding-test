import java.util.*;

public class Main
{
    // 무한대 값 상수 
    private static final int INF = (int) 1e9;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 노드 개수
		int nodeCnt = scan.nextInt();
		// 간선 개수
		int edgeCnt = scan.nextInt();
		// 최단 거리 저장
		int[][] shortestPath = new int[nodeCnt + 1][nodeCnt + 1];
		
		for(int[] row : shortestPath){
			Arrays.fill(row, INF);
		}
		
		for(int i = 1; i <= nodeCnt; i++){
			shortestPath[i][i] = 0;
		}
		
		// 간선 정보 입력 받기
		for(int i = 0; i < edgeCnt; i++){
			int node = scan.nextInt();
			int target = scan.nextInt();
			int distance = scan.nextInt();
			
			shortestPath[node][target] = distance;
		}
		
		// 플로이드 워셜 알고리즘
		for(int i = 1; i <= nodeCnt; i++){
			for (int j = 1; j <= nodeCnt; j++){
				for (int k = 1; k <= nodeCnt; k++){
					if(i == j || i == k || j == k ) continue;
					
					if(shortestPath[j][k] > shortestPath[j][i] + shortestPath[i][k]){
						shortestPath[j][k] = shortestPath[j][i] + shortestPath[i][k];
					}
				}
			}
		}
		
		// 결과 출력
		for(int i = 1; i <= nodeCnt; i++){
			for (int j = 1; j <= nodeCnt; j++){
				System.out.print(String.format("%2d", shortestPath[i][j]) + " ");
			}
			System.out.println();
		}
	}
}
