import java.util.*;

public class Main
{
    public static int[] parents;
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int nodeCnt = scan.nextInt();
		int edgeCnt = scan.nextInt();
		boolean hasCycle = false;
		
		parents = new int[nodeCnt + 1];
		
		for(int i = 0; i < parents.length; i++){
		    parents[i] = i;
		}
		
	    for(int i = 0; i < edgeCnt; i++){
	        int x = scan.nextInt();
	        int y = scan.nextInt();
	        
	        if(findParent(x) == findParent(y)){
	             hasCycle = true;
	             break;
	        }
	        
	        unionParent(x, y);
	    }
	    
	    if (hasCycle) {
            System.out.println("사이클이 발생했습니다.");
        } else {
            System.out.println("사이클이 발생하지 않았습니다.");
        }
	}
	
	public static void unionParent(int x, int y){
	    int rootX = findParent(x);
	    int rootY = findParent(y);
	    
	    if(rootX < rootY){
	        parents[y] = rootX;
	    }else{
	        parents[x] = rootY;
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
