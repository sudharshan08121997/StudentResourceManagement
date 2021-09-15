package Student.Management.System.Dao;

import Student.Management.System.DataTransfer.Student;

public interface StudentDao {

	public String add(Student student);
	public Student search(String sid);
	public String update(Student student);
	public String delete(String sid);

}
