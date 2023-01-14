import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int distance;
    
    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    
    public int getIndex() { return this.index; } 
    public int getDistance() { return this.distance; }
    
    @Override
    public int compareTo(Node node){
        if(this.distance > node.getDistance()){
            return 1;
        }else if (this.distance < node.getDistance()){
            return -1;
        } else {
            return 0;
        }
    }
}

public class Main
{
	// 방문 정보 저장
	private static boolean[] visited;
	// 최단 거리 저장
	private static int[] shortestPath;
	// 간선 연결정보 저장
	private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	// 무한대 값 상수 
	private static final int INF = (int) 1e9;
	// 노드 개수
	private static int nodeCnt;
	// 간선 개수
	private static int edgeCnt;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		nodeCnt = scan.nextInt();
		edgeCnt = scan.nextInt();
		int startIdx = scan.nextInt();
		
		visited = new boolean[nodeCnt + 1];
		shortestPath = new int[nodeCnt + 1];
		
		Arrays.fill(shortestPath, INF);
		
		for(int i = 0; i <= nodeCnt; i++){
			graph.add(new ArrayList<Node>());
		}
		
		// 간선 정보 입력 받기
		for(int i = 0; i < edgeCnt; i++){
			int node = scan.nextInt();
			int target = scan.nextInt();
			int distance = scan.nextInt();
			
			graph.get(node).add(new Node(target, distance));
		}
		
		// 다익스트라 알고리즘 호출
		dijkstra(startIdx);
		
		Arrays.stream(shortestPath).skip(1).forEach(System.out::println);
	}
	
	// 다익스트라 알고리즘 수행
	public static void dijkstra(int startIdx){
		// 최단 거리에 따른 우선순위 큐
		private static PriorityQueue<Node> pQueue = new PriorityQueue<>();
		
		shortestPath[startIdx] = 0;
		pQueue.offer(new Node(startIdx, 0));
		
		while(!pQueue.isEmpty()){
			int now = pQueue.poll().getIndex();
			
			visited[now] = true;
			
			for(Node node : graph.get(now)){
				if(shortestPath[node.getIndex()] > shortestPath[now] + node.getDistance()){
					shortestPath[node.getIndex()] = shortestPath[now] + node.getDistance();
				}
				if(!visited[node.getIndex()]){
					pQueue.offer(new Node(node.getIndex(), shortestPath[node.getIndex()]));
				}
			}
		}
	}
}
