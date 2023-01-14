import java.util.*;

class City implements Comparable<City> {
    int index;
    int time;
    
    public City(int index, int time){
        this.index = index;
        this.time = time;
    }
    
    public int getIndex() { return this.index; } 
    public int getTime() { return this.time; }
    
    @Override
    public int compareTo(City city){
        if(this.time > city.getTime()){
            return 1;
        }else if (this.time < city.getTime()){
            return -1;
        } else {
            return 0;
        }
    }
}

public class Main
{
    private static final int INF = (int) 1e9;
    
    private static int cityCnt;
	private static int pathCnt;
	private static int startCity;
	private static int[] shortestPath;
	private static boolean[] visited;
	private static ArrayList<ArrayList<City>> paths = new ArrayList<>();

	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
		cityCnt = scan.nextInt();
		pathCnt = scan.nextInt();
		startCity = scan.nextInt();
		
		visited = new boolean[cityCnt + 1];
		shortestPath = new int[cityCnt + 1];
		
		Arrays.fill(shortestPath, INF);
	
	    for(int i = 0; i <= cityCnt; i++){
	        paths.add(new ArrayList<City>());
	    }

		for(int i = 0; i < pathCnt; i++){
		    int cityA = scan.nextInt();
		    int cityB = scan.nextInt();
		    int time = scan.nextInt();
		    
		    paths.get(cityA).add(new City(cityB, time));
		}
		
		dijkstra();

        int count = 0;
        int maxTime = 0;
        
        for (int i = 1; i <= cityCnt; i++) {
            if (shortestPath[i] != INF && i != startCity) {
                count += 1;
                maxTime = Math.max(maxTime, shortestPath[i]);
            }
        }

        System.out.println("result = " + count + " " + maxTime);
	}
	
	public static void dijkstra(){
	    PriorityQueue<City> qQueue = new PriorityQueue<>();
	    
	    shortestPath[startCity] = 0;
	    qQueue.offer(new City(startCity, 0));
	        
	    while(!qQueue.isEmpty()){
	        int now = qQueue.poll().getIndex();
	        
	        visited[now] = true;
	        
	        for(City dest : paths.get(now)){
	            if(shortestPath[dest.getIndex()] > shortestPath[now] + dest.getTime()){
	                shortestPath[dest.getIndex()] = shortestPath[now] + dest.getTime();
	            }
	            
	            if(!visited[dest.getIndex()]){
	                qQueue.offer(new City(dest.getIndex(), shortestPath[dest.getIndex()]));
	            }
	        }
	    }
	}
}
