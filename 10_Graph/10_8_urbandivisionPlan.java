import java.util.*;

class Edge{
    int cityA;
    int cityB;
    int cost;
    
    public Edge(int cityA, int cityB, int cost){
        this.cityA = cityA;
        this.cityB = cityB;
        this.cost = cost;
    }
    
    public int getCityA(){ return this.cityA; }
    public int getCityB(){ return this.cityB; }
    public int getCost(){ return this.cost; }
}

public class Main
{
    public static int[] parents;
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int nodeCnt = scan.nextInt();
		int edgeCnt = scan.nextInt();
		parents = new int[nodeCnt + 1];
		
		ArrayList<Edge> edges = new ArrayList<>();
		
		for(int i = 1; i <= nodeCnt; i++){
		     parents[i] = i;
		}
		
		for(int i = 1; i <= edgeCnt; i++){
		    int cityA = scan.nextInt();
		    int cityB = scan.nextInt();
		    int cost = scan.nextInt();
		    
		    edges.add(new Edge(cityA, cityB, cost));
		}
		
		edges.sort(Comparator.comparing(Edge::getCost));
		
		int resultSum = 0;
		int maxCost = -1;
		
		for(Edge edge : edges){
		    int cityA = edge.getCityA();
		    int cityB = edge.getCityB();
		    int cost  = edge.getCost();
		    
		    if(findParent(cityA) == findParent(cityB)) continue;
		    
		    unionParent(cityA, cityB);
		    resultSum += cost;
		    
		    maxCost = Math.max(maxCost, cost);
		}
	    
	    System.out.println("result = " + (resultSum - maxCost));
    }
	
    public static void unionParent(int a, int b){
        int rootA = findParent(a);
        int rootB = findParent(b);
        
        if(rootA < rootB){
            parents[rootA] = rootB;
        } else {
            parents[rootB] = rootA;
        }
    }
    
    public static int findParent(int city){
        if(city != parents[city]) {
            parents[city] = findParent(parents[city]);
        }
        
        return parents[city];
    }
}
