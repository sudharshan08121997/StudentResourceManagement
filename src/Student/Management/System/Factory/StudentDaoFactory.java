package Student.Management.System.Factory;

import Student.Management.System.Dao.StudentDao;
import Student.Management.System.Dao.StudentDaoImpl;

public class StudentDaoFactory {
	
	private static StudentDao studentdao;

	static {
		studentdao=new StudentDaoImpl();
	}

	public static StudentDao getStudentdao() {
		return studentdao;
	}
	
}
