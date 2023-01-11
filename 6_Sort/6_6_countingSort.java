public class Main
{
    public static final int MAX_VALUE = 9;
    
	public static void main(String[] args) {
	    int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
		  
		int count[] = new int[MAX_VALUE+1];
		  
		for(int num : arr){
		    count[num]++;
		}
		
		for(int i = 0; i < count.length; i++){
		    System.out.print((i + " ").repeat(count[i]));
		}
		
	}
}
