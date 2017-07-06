import java.util.*;
public class Instructor {
	
	private int Instructor_ID;
	private String Name;
	private String Emailid;
	private String password;
	private HashSet<Integer> courses=new HashSet<Integer>();
	
	//Set Methods
	public void set_Instructor_ID(int Instructor_ID){
		this.Instructor_ID=Instructor_ID;
	}
	public void set_Name(String Name){
		this.Name=Name;
	}
	public void set_Emailid(String Emailid){
		this.Emailid=Emailid;
	}
	public void set_courses(int course_id){
		this.courses.add(course_id);
	}
	public void set_password(String password){
		this.password=password;
	}
	//Get Methods 
	public int get_Instructor_ID(){
		return Instructor_ID;
	}
	public String get_Name(){
		return Name;
	}
	public String get_Emailid(){
		return Emailid;
	}
	public HashSet<Integer> get_courses(){
		return courses;
	}
	public String get_password(){
		return password;
	}
}
