package Student.Management.System.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import Student.Management.System.DataTransfer.Student;
import Student.Management.System.Factory.StudentServicefactory;
import Student.Management.System.Service.StudentService;

public class StudentApplication {

	public static void main(String[] args) {
		BufferedReader br=null;
		System.out.println("Student Management System\n-------------------------------------");
		String sid="";
		String sname="";
		String saddress="";
		String status="";
		Student student=null;
		StudentService studentservice=StudentServicefactory.getStudentservice();
		try {
			br=new BufferedReader(new InputStreamReader(System.in));
			while(true)
			{
				System.out.println("1: Add Student Details");
				System.out.println("2: Search Student Details");
				System.out.println("3: Update Student details");
				System.out.println("4: Delete Student details");
				System.out.println("5: Exit");
				System.out.print("Your Option:");
				int option=Integer.parseInt(br.readLine());
				System.out.println();
				switch(option) {
				case 1:	System.out.print("Student Id:");
						sid=(br.readLine());
						System.out.print("Student Name:");
						sname=(br.readLine());
						System.out.print("Student Address");
						saddress=(br.readLine());
						student=new Student();
						student.setSaddress(saddress);
						student.setSid(sid);
						student.setSname(sname);
						status=studentservice.addStudent(student);
						if(status.equalsIgnoreCase("SUCCESS"))
						{
							System.out.println("Student Added successfully");
						}
						else if(status.equalsIgnoreCase("EXISTED"))
						{
							System.out.println("Student Existed Already");
						}
						else 
						{
							System.out.println("FAILURE");
						}
				break;
				case 2:System.out.println("Selected Search");
				System.out.println("Student Id:");
				sid=br.readLine();
				student=studentservice.searchStudent(sid);
				if(student==null)
				{
					System.out.println("Status:Student not Existed");
				}
				else
				{
					System.out.println("S_id:"+student.getSid());
					System.out.println("S_name:"+student.getSname());
					System.out.println("S_address:"+student.getSaddress());
				}
				break;
				case 3:System.out.println("Selected Update");
				System.out.println("Student Id:");
				sid=br.readLine();
				student=studentservice.searchStudent(sid);
				if(student==null)
				{
					System.out.println("Status:Student not Existed");
				}
				else
				{
					System.out.println("S_id[old]:"+student.getSid());
					System.out.println("S_name[old]:"+student.getSname());
					System.out.println("S_address[old]:"+student.getSaddress());
					
					System.out.println("Enter New Student Name:");
					sname=br.readLine();
					System.out.println("Enter New Student Address");
					saddress=br.readLine(); 
					Student newstudent=new Student();
					newstudent.setSid(sid);
					newstudent.setSaddress(saddress);
					newstudent.setSname(sname);
					status=studentservice.updateStudent(newstudent);
					if(status.equalsIgnoreCase("SUCCESS"))
					{
						System.out.println("Student Updated successfully");
					}
					else 
					{
						System.out.println("FAILURE");
					}
				}
				break;
				case 4:System.out.println("Selected Delete");
				System.out.println("student Id:");
				sid=br.readLine();
				status=studentservice.deleteStudent(sid);
				if(status.equalsIgnoreCase("SUCCESS")) {
					System.out.println("Student deleted successfully");
				}
				else 
				{
					System.out.println("Student deletion Failed");
				}
				break;
				case 5:System.out.println("---*****--- Application Exited Successfully---*****---");
				System.exit(0);
				default:
					System.out.println("INVALID SELECTION");
				break;
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
