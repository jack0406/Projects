import java.util.*;
public class Test {
	private int Test_ID;
	private int Course_ID;
	private String isGraded="Not Graded";
	private HashMap<Integer,Integer> grades=new HashMap<Integer,Integer>();//Student_Id,Score
	public Test(){
		HashMap<Integer,Integer> gr=new HashMap<Integer,Integer>();
		for(int i=1;i<=10;i++){
			gr.put(i, 0);
		}
		this.grades=gr;
	}
	//Set Methods
	public void set_Test_ID(int Test_ID){
		this.Test_ID=Test_ID;
	}
	public void set_Course_ID(int Course_ID){
		this.Course_ID=Course_ID;
	}
	public void set_Student_given_test(int Student_ID){
		this.grades.put(Student_ID, 0);
	}
	public void set_Score_of_student(int Student_ID, int Score){
		this.isGraded="Graded";
		this.grades.put(Student_ID, Score);
	}
	
	//Get Methods
	public int get_Test_ID(){
		return Test_ID;
	}
	public int get_Course_ID(){
		return Course_ID;
	}
	public boolean is_Student_given_test(int Student_ID){
		if(grades.containsKey(Student_ID)){
			return true;
		}
		return false;
	}
	public void get_Score_of_student(int Student_ID){
		if(grades.containsKey(Student_ID)){
			System.out.println("Score of student having ID as "+Student_ID+" is "+grades.get(Student_ID));
		}else{
			System.out.println("Student id "+Student_ID+" had not given test");
		}
	}
	public void print_list_of_students(){
		for(Map.Entry<Integer, Integer> entry:grades.entrySet()){
			System.out.println("ID = "+entry.getKey());
		}
	}
	public void print_list_of_students_with_score(){
		System.out.println("This test is "+isGraded+".");
		if(isGraded.compareTo("Graded")==0){
			for(Map.Entry<Integer, Integer> entry:grades.entrySet()){
				System.out.println("ID = "+entry.getKey()+" Score = "+entry.getValue());
			}
		}
	}
	public HashMap<Integer,Integer> get_list_of_students(){
		return grades;
	}
}
