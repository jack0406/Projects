/*
 * DA-IICT
 * Author: Jugal Kalal
 */
import java.util.*;
import java.io.*;
public class Main{
	static long MOD=(long)Math.pow(10,9)+7;
	static final int lint=Integer.MAX_VALUE;
	static final double ldouble=Double.MAX_VALUE;
	public static void main(String args[]) {
        new Thread(null, new Runnable() {
            public void run() {
                try{
                    solve();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
	}
	static int Th_N_lea=10;
	static int Th_N_App=10;
	static int N_Students=10;
	//////Main class Starts Here//////
	static InputReader in;
    static PrintWriter w;
    static void solve(){
        in = new InputReader(System.in);
        w = new PrintWriter(System.out);
        System.out.println("Welcome to Teaching Assistant Management System !!!");
        HashMap<Integer,Teaching_Assistant> Users=new HashMap<Integer,Teaching_Assistant>();
        HashMap<Integer,Instructor> Instructors=new HashMap<Integer,Instructor>();
        HashMap<Integer,Courses> courses=new HashMap<Integer,Courses>();//Course_Ids, course object
        HashMap<Integer,Test> tests=new HashMap<Integer,Test>();//Test_Id,test object
        HashMap<Integer,HashSet<Applications>> apply=new HashMap<Integer,HashSet<Applications>>();//Courses,Applications
//        HashMap<Integer,HashSet<Applications>> taapplied=new HashMap<Integer,HashSet<Applications>>();//TA_ID,Applications
        HashMap<Integer,HashSet<LeaveApplication>> leaveapply=new HashMap<Integer,HashSet<LeaveApplication>>();//Course,LeaveApplication
//        HashMap<Integer,HashSet<LeaveApplication>> leaveapplied=new HashMap<Integer,HashSet<LeaveApplication>>();//TA_ID,LeaveApplication
        while(true){
        	System.out.println();
        	System.out.println("Choose User Type : ");
        	System.out.println("1. For TA\n2. For Instructor");
        	int type=in.nextInt();
        	switch(type){
        	case 1:
        		System.out.println();
        		System.out.println("Choose type of operation : ");
        		System.out.println("1. Login\n2. Sign Up\n3. Forgot Password");
        		switch(in.nextInt()){
        		case 1:
        			System.out.println("Enter User id (Must be Integer): ");
        			int user_id=in.nextInt();
        			if(Users.containsKey(user_id)){
        				System.out.println("Enter password : ");
            			String password=in.nextLine();
        				if(Users.get(user_id).get_password().compareTo(password)==0){
        					Teaching_Assistant ta=Users.get(user_id);
        					boolean breakwhile=false;
        					while(!breakwhile){
        						System.out.println();
        		        		System.out.println("Choose type of operation : ");
        		        		System.out.println("1. Update Profile\n2. Apply for courses\n3. Request for leave\n4. Grade Test\n5. Check status of course application\n6. Check status of leave applied\n7. Logout");
        		        		switch(in.nextInt()){
        		        		case 1:
        		        			System.out.println("Choose type of information you want to update : ");
        		        			System.out.println("1. Name\n2. Password\n3. Emailid");
        		        			switch(in.nextInt()){
        		        			case 1:
        		        				System.out.println("Enter New Name : ");
        		        				String name=in.nextLine();
        		        				ta.set_Name(name);
        		        				break;
        		        			case 2:
        		        				System.out.println("Enter New Password : ");
        		        				String pass=in.nextLine();
        		        				ta.set_password(pass);
        		        				break;
        		        			case 3:
        		        				System.out.println("Enter New Emailid : ");
        		        				String emailid=in.nextLine();
        		        				ta.set_Emailid(emailid);
        		        				break;
        		        			default:
        		        				System.out.println("Choose valid option.");
        		        				break;
        		        			}
        		        			break;
        		        		case 2:
        		        			if(ta.get_Number_of_course_taken()<Th_N_App){
	        		        			System.out.println("Choose from given courses (Enter course's ID) : ");
	        		        			if(courses.size()==0){
	        		        				System.out.println("No courses Available");
	        		        				break;
	        		        			}
	        		        			for(Map.Entry<Integer, Courses> entry:courses.entrySet()){
	        		        				int idc=entry.getKey();
	        		        				String namec=entry.getValue().get_Course_Name();
	        		        				System.out.println(idc+" "+namec);
	        		        			}
	        		        			int cid=in.nextInt();
	        		        			if(courses.containsKey(cid)){
		        		        			if(apply.containsKey(cid)){
		        		        				HashSet<Applications> app=apply.get(cid);
		        		        				boolean flag=false;
		        		        				for(Applications app_object:app){
		        		        					if(app_object.get_TA_ID()==user_id&&app_object.get_status()=="Pending Approval"){
//		        		        						System.out.println(taapplied.toString());
		        		        						System.out.println(apply.toString());
		        		        						System.out.println("You can't re-apply for this course. Your request is already pending for approval.");
		        		        						flag=true;
		        		        						break;
		        		        					}
		        		        					if(app_object.get_TA_ID()==user_id&&app_object.get_status()=="Approved"){
		        		        						System.out.println("You can't re-apply for this course. Your request is already approved by instructor.");
		        		        						flag=true;
		        		        						break;
		        		        					}
		        		        				}
		        		        				if(!flag){
			        		        				Applications ap=new Applications();
			        		        				ap.set_TA_ID(user_id);
			        		        				ap.set_Course_ID(cid);
			        		        				app.add(ap);
			        		        				apply.put(cid,app);
		        		        				}
		        		        			}else{
		        		        				HashSet<Applications> app=new HashSet<Applications>();
		        		        				Applications ap=new Applications();
		        		        				ap.set_TA_ID(user_id);
		        		        				ap.set_Course_ID(cid);
		        		        				app.add(ap);
		        		        				apply.put(cid,app);
		        		        			}
//		        		        			if(taapplied.containsKey(user_id)){
//		        		        				HashSet<Applications> app=taapplied.get(user_id);
//		        		        				boolean flag=false;
//		        		        				for(Applications app_object:app){
//		        		        					if(app_object.get_TA_ID()==user_id&&(app_object.get_status()=="Pending Approval"||app_object.get_status()=="Approved")){
//		        		        						flag=true;
//		        		        						break;
//		        		        					}
//		        		        				}
//		        		        				if(!flag){
//			        		        				Applications ap=new Applications();
//			        		        				ap.set_TA_ID(user_id);
//			        		        				ap.set_Course_ID(cid);
//			        		        				app.add(ap);
//			        		        				taapplied.put(user_id, app);
//		        		        				}
//		        		        			}else{
//		        		        				HashSet<Applications> app=new HashSet<Applications>();
//		        		        				Applications ap=new Applications();
//		        		        				ap.set_TA_ID(user_id);
//		        		        				ap.set_Course_ID(cid);
//		        		        				app.add(ap);
//		        		        				taapplied.put(user_id, app);
//		        		        			}
	        		        			}
	        		        			else{
	        		        				System.out.println("Choose valid course id.");
	        		        			}
        		        			}else{
        		        				System.out.println("Application limit of "+Th_N_App+" exceeded. Sorry you can't apply.!!");
        		        			}
        		        			break;
        		        		case 3:
        		        			if(ta.get_Number_of_leaves()<Th_N_lea){
        		        				System.out.println("Choose from given courses (Enter course's ID) : ");
        		        				boolean flag=false;
	        		        			for(Map.Entry<Integer, Courses> entry:courses.entrySet()){
	        		        				int idc=entry.getKey();
	        		        				HashSet<Integer> tas=entry.getValue().get_TA_List();
	        		        				if(tas.contains(user_id)){
	        		        					System.out.println(idc+" "+entry.getValue().get_Course_Name());
	        		        					flag=true;
	        		        				}
	        		        			}
	        		        			if(!flag){
	        		        				System.out.println("You have not registered for any course.");
	        		        				break;
	        		        			}
	        		        			int cid=in.nextInt();
	        		        			if(courses.get(cid).get_TA_List().contains(user_id)){
		        		        			if(leaveapply.containsKey(cid)){
		        		        				HashSet<LeaveApplication> app=leaveapply.get(cid);
		        		        				flag=false;
		        		        				for(LeaveApplication obj:app){
		        		        					if(obj.get_TA_ID()==user_id&&obj.get_status()=="Pending Approval"){
		        		        						System.out.println("You can't re-request for leave. Your request is already pending for approval.");
		        		        						flag=true;
		        		        						break;
		        		        					}
		        		        				}
		        		        				if(!flag){
			        		        				LeaveApplication ap=new LeaveApplication();
			        		        				ap.set_TA_ID(user_id);
			        		        				ap.set_Course_ID(cid);
			        		        				app.add(ap);
			        		        				leaveapply.put(cid,app);
		        		        				}
		        		        			}else{
		        		        				HashSet<LeaveApplication> app=new HashSet<LeaveApplication>();
		        		        				LeaveApplication ap=new LeaveApplication();
		        		        				ap.set_TA_ID(user_id);
		        		        				ap.set_Course_ID(cid);
		        		        				app.add(ap);
		        		        				leaveapply.put(cid,app);
		        		        			}
//		        		        			if(leaveapplied.containsKey(user_id)){
//		        		        				HashSet<LeaveApplication> app=leaveapplied.get(user_id);
//		        		        				flag=false;
//		        		        				for(LeaveApplication obj:app){
//		        		        					if(obj.get_TA_ID()==user_id&&obj.get_status()=="Pending Approval"){
//		        		        						flag=true;
//		        		        						break;
//		        		        					}
//		        		        				}
//		        		        				if(!flag){
//			        		        				LeaveApplication ap=new LeaveApplication();
//			        		        				ap.set_TA_ID(user_id);
//			        		        				ap.set_Course_ID(cid);
//			        		        				app.add(ap);
//			        		        				leaveapplied.put(user_id, app);
//		        		        				}
//		        		        			}else{
//		        		        				HashSet<LeaveApplication> app=new HashSet<LeaveApplication>();
//		        		        				LeaveApplication ap=new LeaveApplication();
//		        		        				ap.set_TA_ID(user_id);
//		        		        				ap.set_Course_ID(cid);
//		        		        				app.add(ap);
//		        		        				leaveapplied.put(user_id, app);
//		        		        			}
	        		        			}else{
	        		        				System.out.println("You are not registered for this course.");
	        		        			}
        		        			}else{
        		        				System.out.println("Application limit of "+Th_N_lea+" exceeded. Sorry you can't request for leave.!!");
        		        			}
        		        			break;
        		        		case 4:
        		        			boolean flag=false;
        		        			System.out.println("Choose from given courses (Enter course's ID) : ");
        		        			for(Map.Entry<Integer, Courses> entry:courses.entrySet()){
        		        				int idc=entry.getKey();
        		        				HashSet<Integer> tas=entry.getValue().get_TA_List();
        		        				if(tas.contains(user_id)){
        		        					flag=true;
        		        					System.out.println(idc+" "+entry.getValue().get_Course_Name());
        		        				}
        		        			}
        		        			if(!flag){
        		        				System.out.println("You have not registered for any course.");
        		        				break;
        		        			}
        		        			int cid=in.nextInt();
        		        			if(courses.get(cid).get_TA_List().contains(user_id)){
	        		        			Courses cc=courses.get(cid);
	        		        			System.out.println("Choose from given test (Enter test's ID) :");
	        		        			HashSet<Integer> tts=cc.get_tests();
	        		        			if(tts.size()==0){
	        		        				System.out.println("Sorry..!! No tests in this course.");
	        		        				break;
	        		        			}
	        		        			for(int tt:tts){
	        		        				System.out.println(tt);
	        		        			}
	        		        			int test=in.nextInt();
	        		        			if(tts.contains(test)){
		        		        			Test tt=tests.get(test);
		        		        			HashMap<Integer,Integer> grades=tt.get_list_of_students();
		        		        			for(Map.Entry<Integer, Integer> entry:grades.entrySet()){
		        		        				System.out.println("Enter score for id "+entry.getKey());
		        		        				int score=in.nextInt();
		        		        				tt.set_Score_of_student(entry.getKey(),score);
		        		        			}
	        		        			}
	        		        			else{
	        		        				System.out.println("Choose valid test id.");
	        		        			}
        		        			}else{
        		        				System.out.println("Choose valid course id.");
        		        			}
        		        			break;
        		        		case 5:
        		        			boolean flag1=false;
        		        			for(Map.Entry<Integer, HashSet<Applications>> entry:apply.entrySet()){
        		        				int course_id=entry.getKey();
        		        				HashSet<Applications> temp=entry.getValue();
        		        				for(Applications obj:temp){
        		        					if(obj.get_TA_ID()==user_id){
        		        						System.out.println("For course id "+course_id+" your application status is "+obj.get_status());
        		        						flag1=true;
        		        					}
        		        				}
        		        			}
        		        			if(!flag1){
        		        				System.out.println("Sorry..!! You haven't applied for any course.");
        		        			}
        		        			break;
        		        		case 6:
        		        			boolean flag2=false;
        		        			for(Map.Entry<Integer, HashSet<LeaveApplication>> entry:leaveapply.entrySet()){
        		        				int course_id=entry.getKey();
        		        				HashSet<LeaveApplication> temp=entry.getValue();
        		        				for(LeaveApplication obj:temp){
        		        					if(obj.get_TA_ID()==user_id){
        		        						System.out.println("For course id "+course_id+" your leave request status is "+obj.get_status());
        		        						flag2=true;
        		        					}
        		        				}
        		        			}
        		        			if(!flag2){
        		        				System.out.println("Sorry..!! You haven't requested leave for any course.");
        		        			}
        		        			break;
        		        		case 7:
        		        			System.out.println("GoodBye..!!");
        		        			breakwhile=true;
        		        			break;
        		        		}
        					}
        				}else{
        					System.out.println("Invalid Password.");
        				}
        			}else{
        				System.out.println("Invalid User ID.");
        			}
        			break;
        		case 2:
        			Teaching_Assistant ta=new Teaching_Assistant();
					System.out.println("Enter Your TA ID (Must be Integer):");
					int id;
					while(true){
						id=in.nextInt();
						if(Users.containsKey(id)){
							System.out.println("TA ID is already existed. Try Another.");
						}else{
							ta.set_TA_ID(id);
							break;
						}
					}
					Users.put(id, ta);
					System.out.println("Enter Your Name :");
					ta.set_Name(in.readString());
					System.out.println("Enter Your email address :");
					ta.set_Emailid(in.readString());
					System.out.println("Enter Your Password :");
					ta.set_password(in.readString());
					break;
        		case 3:
        			System.out.println("Enter your TA_ID (Must be Integer):");
					int forgotid=in.nextInt();
					System.out.println("Enter your registered email address :");
					String mail=in.readString();
					if(Users.containsKey(forgotid)){
						if(Users.get(forgotid).get_Emailid().equals(mail)){
							System.out.println("Enter New Password :");
							Users.get(forgotid).set_password(in.readString());
						}else{
							System.out.println("Invalid email address");
						}
					}else{
						System.out.println("You are not registered in the system.");
					}
        			break;
        		default:
        			System.out.println("Choose Valid Option.");
        			break;
        		}
        		break;
        	case 2:
        		System.out.println();
        		System.out.println("Choose type of operation : ");
				System.out.println("1. Login\n2. Sign Up\n3. Forgot Password");
				switch(in.nextInt()){
				case 1:
					System.out.println("Enter User id (Must be Integer): ");
					int user_id=in.nextInt();
					if(Instructors.containsKey(user_id)){
						System.out.println("Enter password : ");
						String password=in.nextLine();
						if(Instructors.get(user_id).get_password().compareTo(password)==0){
							Instructor inst=Instructors.get(user_id);
							boolean logout=false;
							while(!logout){
								System.out.println();
								System.out.println("Choose type of operation : ");
								System.out.println("1. Approve Applications\n2. Approve Leaves\n3. Update Profile\n4. Create test\n5. Check Test Grades\n6. Logout");
								switch(in.nextInt()){
								case 1:
									for(Map.Entry<Integer, Courses> cour:courses.entrySet()){
										Courses c=cour.getValue();
										if(c.get_Instructor_ID()==user_id){
											if(!apply.containsKey(c.get_Course_ID())){
												System.out.println("No Applications are pending for course id "+c.get_Course_ID());
												continue;
											}
											HashSet<Applications> set=apply.get(c.get_Course_ID());
											if(set.isEmpty()){
												System.out.println("No Applications are pending for course id "+c.get_Course_ID());
												continue;
											}
											for(Applications app:set){
												boolean flag=false;
												while(!flag){
													if(app.get_status().equals("Pending Approval")){
														System.out.println("Choose actions to performed for each application of: "+app.get_TA_ID()+" for the course:"+app.get_Course_ID());
														System.out.println("1. Approve\n2. Disapprove");
														switch(in.nextInt()){
														case 1:
															app.set_approved();
															int nn=Users.get(app.get_TA_ID()).get_Number_of_course_taken();
															Users.get(app.get_TA_ID()).set_Number_of_course_taken(nn+1);
															courses.get(app.get_Course_ID()).set_TA_to_course(app.get_TA_ID());
															flag=true;
															break;
														case 2:
															app.set_Not_Approved();
															flag=true;
															break;
														default:
															System.out.println("Invalid Option");
															break;
														}
													}
												}
											}
										}
									}
									break;
								case 2:
									for(Map.Entry<Integer, Courses> cour:courses.entrySet()){
										Courses c=cour.getValue();
										if(c.get_Instructor_ID()==user_id){
											if(!leaveapply.containsKey(c.get_Course_ID())){
												System.out.println("No leave Applications are pending for course id "+c.get_Course_ID());
												continue;
											}
											HashSet<LeaveApplication> set=leaveapply.get(c.get_Course_ID());
											if(set.size()==0){
												System.out.println("No leave Applications are pending for course id "+c.get_Course_ID());
												continue;
											}
											for(LeaveApplication app:set){
												boolean flag=false;
												while(!flag){
													if(app.get_status().equals("Pending Approval")){
														System.out.println("Choose actions to performed for each application of:"+app.get_TA_ID()+" for the course:"+app.get_Course_ID());
														System.out.println("1.Approve\n2.Disapprove");
														switch(in.nextInt()){
														case 1:
															app.set_approved();
															int nn=Users.get(app.get_TA_ID()).get_Number_of_leaves();
															Users.get(app.get_TA_ID()).set_Number_of_leaves(nn+1);
															flag=true;
															break;
														case 2:
															app.set_Not_Approved();
															flag=true;
															break;
														default:
															System.out.println("Invalid Option");
															break;
														}
													}
												}
											}
										}
									}
									break;
								case 3:
									System.out.println("Choose type of information you want to update : ");
        		        			System.out.println("1. Name\n2. Password\n3. Emailid");
        		        			switch(in.nextInt()){
        		        			case 1:
        		        				System.out.println("Enter New Name : ");
        		        				String name=in.nextLine();
        		        				inst.set_Name(name);
        		        				break;
        		        			case 2:
        		        				System.out.println("Enter New Password : ");
        		        				String pass=in.nextLine();
        		        				inst.set_password(pass);
        		        				break;
        		        			case 3:
        		        				System.out.println("Enter New Emailid : ");
        		        				String emailid=in.nextLine();
        		        				inst.set_Emailid(emailid);
        		        				break;
        		        			default:
        		        				System.out.println("Invalid option.");
        		        				break;
        		        			}
									break;
								case 4:
									if(inst.get_courses().size()==0){
										System.out.println("You are not taking any course.");
										break;
									}
									System.out.println("Choose Course ID:");
									for(Integer in:inst.get_courses()){
										System.out.println(in);
									}
									int cid=in.nextInt();
									if(inst.get_courses().contains(cid)){
										boolean flag=false;
										while(!flag){
											System.out.println();
											System.out.println("Enter Test ID (Must be Integer):");
											int tid=in.nextInt();
											if(tests.containsKey(tid)){
												System.out.println("Test ID already exist");
											}else{
												courses.get(cid).set_tests(tid);
												Test t=new Test();
												t.set_Course_ID(cid);
												tests.put(tid, t);
												flag=true;
											}
										}
									}
									else{
										System.out.println("Not your course");
									}
									break;
								case 5:	
									if(inst.get_courses().size()==0){
										System.out.println("You are not taking any course.");
										break;
									}
									System.out.println("Choose Course ID (Must be Integer):");
									for(Integer in:inst.get_courses()){
										System.out.println(in+" "+courses.get(in).get_Course_Name());
									}
									int cid1=in.nextInt();
									if(inst.get_courses().contains(cid1)){
										Courses c=courses.get(cid1);
										HashSet<Integer> tt=c.get_tests();
										if(tt.size()==0){
											System.out.println("No tests for this course.");
											break;
										}
										System.out.println("Choose test id from given test ids: ");
										for(int jj:tt){
											System.out.println(jj);
										}
										int testid=in.nextInt();
										if(tt.contains(testid)){
											Test ttt=tests.get(testid);
											ttt.print_list_of_students_with_score();
										}else{
											System.out.println("Wrong testid.");
										}
									}else{
										System.out.println("Not your course");
									}
									break;
								case 6:System.out.println("GoodBye!");
								logout=true;
								break;
								default:System.out.println("Enter Valid Option");
								break;
								}
							}
						}else{
							System.out.println("Wrong Password");
						}
					}else{
						System.out.println("Invalid User ID.");
					}
					break;
				case 2:
					Instructor ins=new Instructor();
					System.out.println("Enter Your Instructor ID (Must be Integer):");
					int id;
					while(true){
						id=in.nextInt();
						if(Instructors.containsKey(id)){
							System.out.println("Instructor ID is already existed. Try Another.");
						}else{
							ins.set_Instructor_ID(id);
							break;
						}
					}
					Instructors.put(id, ins);
					System.out.println("Enter Your Name :");
					ins.set_Name(in.readString());
					System.out.println("Enter Your email address :");
					ins.set_Emailid(in.readString());
					System.out.println("Enter Your Password :");
					ins.set_password(in.readString());
					System.out.println("Enter Number of courses you teach:");
					int cnt=in.nextInt();
					while(cnt-->0){
						while(true){
							Courses course=new Courses();
							System.out.println("Enter Course ID (Must be Integer):");
							int cid=in.nextInt();
							if(courses.containsKey(cid)){
								System.out.println("Course ID is already taken. Choose another course.");
								System.out.println();
							}else{
								ins.set_courses(cid);
								course.set_Course_ID(cid);
								System.out.println("Enter Course Name :");
								course.set_Course_Name(in.readString());
								course.set_Instructor_ID(ins.get_Instructor_ID());
								courses.put(cid, course);
								break;
							}
						}
					}
					break;
				case 3:
					System.out.println("Enter your Instructor ID (Must be Integer):");
					int forgotid=in.nextInt();
					System.out.println("Enter your registered email address :");
					String mail=in.readString();
					if(Instructors.containsKey(forgotid)){
						if(Instructors.get(forgotid).get_Emailid().equals(mail)){
							System.out.println("Enter New Password :");
							Instructors.get(forgotid).set_password(in.readString());
						}else{
							System.out.println("Invalid email address");
						}
					}else{
						System.out.println("You are not registered in the system.");
					}
					break;
				default:
					System.out.println("Choose Valid Option.");
					break;
				}
				break;
        	default:
        		System.out.println("Choose Valid Option.");
        		break;
        	}
        }
    }
    //////Main class Ends Here////////
    
    //Reader Class
	static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, numChars;
        private SpaceCharFilter filter;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
 
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
 
        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
 
        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
	}
} 
