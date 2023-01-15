import java.util.*;

public class Main
{
    public static int[] parents;
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int nodeCnt = scan.nextInt();
		int edgeCnt = scan.nextInt();
		StringBuffer result = new StringBuffer();
		parents = new int[nodeCnt + 1];
		
		for(int i = 1; i < parents.length; i++){
		    parents[i] = i;
		}
		
	    for(int i = 0; i < edgeCnt; i++){
	        int action = scan.nextInt();
	        int x = scan.nextInt();
	        int y = scan.nextInt();
            
            if(action == 0){
                unionTeam(x, y);
            }else if(action == 1){
                result.append(findTeam(x) == findTeam(y) ? "YES" : "NO");
                result.append("\n");
            }
	    }
	    
	    System.out.println(result.toString());
    }
	
	public static void unionTeam(int x, int y) {
        int rootX = findTeam(x);
        int rootY = findTeam(y);
        
        if(rootX < rootY){ parents[rootX] = rootY; } 
        else { parents[rootY] = rootY; } 
	}
	
	public static int findTeam(int team) {
        if(team != parents[team]){
            parents[team] = findTeam(parents[team]);
        }
        return parents[team];
	}

}
