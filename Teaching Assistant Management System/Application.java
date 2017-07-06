
public class Applications {
	private int TA_ID;
	private int Course_ID;
	private String status;
	public Applications(){
		this.status="Pending Approval";
	}
	//Set Methods
	public void set_TA_ID(int TA_ID){
		this.TA_ID=TA_ID;
	}
	
	public void set_Course_ID(int Course_ID){
		this.Course_ID=Course_ID;
	}
	
	public void set_approved(){
		this.status="Approved";
	}
	
	public void set_Not_Approved(){
		this.status="Not Approved";
	}
	
	//Get Methods
	public int get_TA_ID(){
		return TA_ID;
	}
	
	public int get_Course_ID(){
		return Course_ID;
	}
	
	public String get_status(){
		return status;
	}
	
}
