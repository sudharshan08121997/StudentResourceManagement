package Student.Management.System.Service;

import Student.Management.System.Dao.StudentDao;
import Student.Management.System.DataTransfer.Student;
import Student.Management.System.Factory.StudentDaoFactory;
// Service implementation class
public class StudentServiceImpl implements StudentService {

	@Override
	public String addStudent(Student student) {
		StudentDao studentdao=StudentDaoFactory.getStudentdao();
		String status=studentdao.add(student);
		return status;
	}

	@Override
	public Student searchStudent(String sid) {
		StudentDao studentdao=StudentDaoFactory.getStudentdao();
		Student student=studentdao.search(sid);
		return student;
	}

	@Override
	public String updateStudent(Student student) {
		StudentDao studentdao=StudentDaoFactory.getStudentdao();
		String status=studentdao.update(student);
		return status;
	}

	@Override
	public String deleteStudent(String sid) {
		StudentDao studentdao=StudentDaoFactory.getStudentdao();
		String status=studentdao.delete(sid);
		return status;
	}

}
