import java.util.*;

public class Main
{
	public static int nodeCnt;
	public static int[] time;
	public static int[] input;
	public static ArrayList<ArrayList<Integer>> required= new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		nodeCnt = scan.nextInt();
		time = new int[nodeCnt + 1];
		input = new int[nodeCnt + 1];
		
		for(int i = 0; i <= nodeCnt; i++){
			required.add(new ArrayList<Integer>());
			
			if(i != 0){
				time[i] = scan.nextInt();
				
				while(true){
					int x = scan.nextInt();
					
					if(x == -1){ break; }
					
					input[i]++;
					required.get(x).add(i);
				}
			}
		}
		
		topologySort();
	}
	
	public static void topologySort(){
		int[] result = Arrays.copyOf(time, nodeCnt+1);
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1 ; i <= nodeCnt; i++){
			if(input[i] == 0){
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()){
			int now = queue.poll();
		
			for(Integer subject : required.get(now)){
				result[subject] = Math.max(result[subject], result[now] + time[subject]);
				input[subject]--;
				if(input[subject] == 0){
					queue.offer(subject); 
				}
			}
		}
		
		Arrays.stream(result).skip(1).forEach(System.out::println);
	}
}
