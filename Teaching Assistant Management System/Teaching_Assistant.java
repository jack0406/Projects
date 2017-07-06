
public class Teaching_Assistant {
	private int TA_ID;
	private String Name;
	private String password;
	private String Emailid;
	private int Number_of_course_taken;
	private int Number_of_leaves;
	public Teaching_Assistant(){
		Number_of_course_taken=0;
		Number_of_leaves=0;
	}
	//Set Methods
	public void set_TA_ID(int TA_ID){
		this.TA_ID=TA_ID;
	}
	public void set_Name(String Name){
		this.Name=Name;
	}
	public void set_Emailid(String Emailid){
		this.Emailid=Emailid;
	}
	public void set_Number_of_course_taken(int Number_of_course_taken){
		this.Number_of_course_taken=Number_of_course_taken;
	}
	public void set_Number_of_leaves(int Number_of_leaves){
		this.Number_of_leaves=Number_of_leaves;
	}
	public void set_password(String password){
		this.password=password;
	}
	//Get Methods 
	public int get_TA_ID(){
		return TA_ID;
	}
	public String get_Name(){
		return Name;
	}
	public String get_Emailid(){
		return Emailid;
	}
	public int get_Number_of_course_taken(){
		return Number_of_course_taken;
	}
	public int get_Number_of_leaves(){
		return Number_of_leaves;
	}
	public String get_password(){
		return password;
	}
}
