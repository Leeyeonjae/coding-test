import java.util.*;

// 학생 클래스
class Student{
    String name; 
    int score;
    
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getScore(){
        return this.score;
    }
}


public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = scan.next();
            int score = scan.nextInt();
            students.add(new Student(name, score));
        }
        
        // 정렬 후 출력
        students.stream().sorted(Comparator.comparing(Student::getScore))
                         .forEach(s -> System.out.print(s.getName() + " "));
        

	}
}
