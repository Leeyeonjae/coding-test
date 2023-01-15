import java.util.*;

public class Main
{
    public static int[] parents;
    
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
	        
	        unionParent(x, y);
	    }
	    
	    System.out.print("각 원소가 속한 집합: ");
	    for(int i = 1; i < parents.length; i++){
	         System.out.print(findParent(i) + " ");
	    }
	    
	    System.out.print("\n부모 테이블: ");
	    for(int i = 1; i < parents.length; i++){
	         System.out.print(parents[i] + " ");
	    }
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
	    if(node != parents[node]) {
	        parents[node] = findParent(parents[node]);
	    }
	    
	    return parents[node];
	}
}
