package Student.Management.System.Factory;

import Student.Management.System.Service.StudentService;
import Student.Management.System.Service.StudentServiceImpl;

public class StudentServicefactory {
	private static StudentService studentservice;
	
	static 
		{
			studentservice=new StudentServiceImpl();
		}

	public static StudentService getStudentservice() {
		return studentservice;
	}
		
}
