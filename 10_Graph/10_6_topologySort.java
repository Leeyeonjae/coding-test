import java.util.*;

public class Main
{
    public static int nodeCnt;
    public static int edgeCnt;
    public static int[] indegree;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static Queue<Integer> queue = new LinkedList<>();
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		nodeCnt = scan.nextInt();
		edgeCnt = scan.nextInt();
		indegree = new int[nodeCnt + 1];
		
		for(int i = 0; i <= nodeCnt; i++){
		    graph.add(new ArrayList<Integer>());
		}
		
	    for(int i = 0; i < edgeCnt; i++){
	        int x = scan.nextInt();
	        int y = scan.nextInt();
	   
	        indegree[y]++;
	        graph.get(x).add(y);
	    }
	    
	    topologySort();
    }
	
	public static void topologySort() {
	    for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
	   
	   while(!queue.isEmpty()){
	       int now = queue.poll();
	       
	       System.out.print(now + " ");
	       
	       for(Integer child : graph.get(now)){
	           indegree[child]--;
	           
	           if(indegree[child] == 0){
	               queue.offer(child);
	           }
	       }
	   }
	}
	

}
