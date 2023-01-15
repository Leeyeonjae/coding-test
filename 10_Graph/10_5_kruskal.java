import java.util.*;

class Edge { 
    private int nodeX;
    private int nodeY;
    private int cost;
    
    public Edge(int nodeX, int nodeY, int cost) {
        this.nodeX = nodeX;
        this.nodeY = nodeY;
        this.cost = cost;
    }
    
    public int getNodeX() { return this.nodeX; }
    public int getNodeY() { return this.nodeY; }
    public int getCost() { return this.cost; }
}

public class Main
{
    public static int[] parents;
    public static ArrayList<Edge> edges = new ArrayList<>();
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int nodeCnt = scan.nextInt();
		int edgeCnt = scan.nextInt();
		
		parents = new int[nodeCnt + 1];
		
		for(int i = 0; i < parents.length; i++){
		    parents[i] = i;
		}
		
	    for(int i = 0; i < edgeCnt; i++){
	        int x = scan.nextInt();
	        int y = scan.nextInt();
	        int cost = scan.nextInt();
	        
	        edges.add(new Edge(x, y, cost));
	    }
	    
        edges.sort(Comparator.comparing(Edge::getCost));
        
        int resultSum = 0;
        
        for(Edge edge : edges){
            int x = edge.getNodeX();
            int y = edge.getNodeY();

            //사이클이 생기는 경우 스킵
            if (findParent(x) != findParent(y)) {
                unionParent(x, y);
                resultSum += edge.getCost();
            }
        }
        
        System.out.println("result = " + resultSum);
    }
	
	public static void unionParent(int x, int y){
	    int rootX = findParent(x);
	    int rootY = findParent(y);
	    
	    if(rootX < rootY){
	        parents[rootY] = rootX;
	    }else{
	        parents[rootX] = rootY;
	    }
	}
	
	public static int findParent(int node){
	    // 루트 노드를 찾을 때까지 재귀 호출
	    if(node != parents[node]) {
	        parents[node] = findParent(parents[node]);
	    }
	    
	    return parents[node];
	}
}
