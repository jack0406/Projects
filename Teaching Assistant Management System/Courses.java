import java.util.HashSet;

public class Courses {
	private int Course_ID;
	private String Course_Name;
	private int Instructor_ID;
	private HashSet<Integer> tas=new HashSet<Integer>();
	private HashSet<Integer> tests=new HashSet<Integer>();
	//Set Methods
	public void set_Course_ID(int Course_ID){
		this.Course_ID=Course_ID;
	}
	public void set_Course_Name(String Course_Name){
		this.Course_Name=Course_Name;
	}
	public void set_Instructor_ID(int Instructor_ID){
		this.Instructor_ID=Instructor_ID;
	}
	public void set_TA_to_course(int TA_ID){
		this.tas.add(TA_ID);
	}
	public void set_tests(int Test_ID){
		this.tests.add(Test_ID);
	}
	//Get Methods
	public int get_Course_ID(){
		return Course_ID;
	}
	public int get_Instructor_ID(){
		return Instructor_ID;
	}
	public String get_Course_Name(){
		return Course_Name;
	}
	public HashSet<Integer> get_TA_List(){
		return tas;
	}
	public HashSet<Integer> get_tests(){
		return tests;
	}
}
