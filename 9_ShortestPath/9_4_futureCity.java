import java.util.*;

public class Main
{
    // 무한대 값 상수 
    private static final int INF = (int) 1e9;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int campanyCnt = scan.nextInt();
		int roadCnt = scan.nextInt();
		
		// 최단 거리 저장
		int[][] shortestPath = new int[campanyCnt + 1][campanyCnt + 1];
		
		for(int[] row : shortestPath){
			Arrays.fill(row, INF);
		}
		
		for(int i = 1; i <= campanyCnt; i++){
			shortestPath[i][i] = 0;
		}
		
		// 간선 정보 입력 받기
		for(int i = 0; i < roadCnt; i++){
			int companyA = scan.nextInt();
			int companyB = scan.nextInt();
			
			shortestPath[companyA][companyB] = 1;
			shortestPath[companyB][companyA] = 1;
		}
		
		int second = scan.nextInt();
		int first = scan.nextInt();
		
		// 플로이드 워셜 알고리즘
		for(int i = 1; i <= campanyCnt; i++){
			for (int j = 1; j <= campanyCnt; j++){
				for (int k = 1; k <= campanyCnt; k++){
					if(i == j || i == k || j == k ) continue;
					
					if(shortestPath[j][k] > shortestPath[j][i] + shortestPath[i][k]){
						shortestPath[j][k] = shortestPath[j][i] + shortestPath[i][k];
					}
				}
			}
		}
		
		int result = shortestPath[1][first] + shortestPath[first][second];
		result = result >= INF ? -1 : result;
		
		System.out.println("result = " + result);
	}
}
