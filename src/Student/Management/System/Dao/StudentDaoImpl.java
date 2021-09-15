package Student.Management.System.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Student.Management.System.DataTransfer.Student;
import Student.Management.System.Factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student student) {
		String status="";
		try 
			{
				Connection con= ConnectionFactory.getConnection();
				Statement st=con.createStatement();
				Student std=search(student.getSid());
				//System.out.println("insert into StudentDetails values('"+student.getSid()+"','"+student.getSname()+"','"+student.getSaddress()+"')");
				if(std==null)
				{
					int rowcount=st.executeUpdate("insert into StudentDetails values('"+student.getSid()+"','"+student.getSname()+"','"+student.getSaddress()+"')");
					if(rowcount==1)
					{
						status="SUCCESS";
					}
					else 
					{
						status="FAILURE";
					}
				}
				else {
					status="EXISTED";
				}
			} 
		catch (Exception e) 
			{
				status="FAILURE";
				e.printStackTrace();
			}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student=null;
		try 
		{
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			//System.out.println("select * from StudentDetails where sid ='"+sid+"'");
			ResultSet rs=st.executeQuery("select * from StudentDetails where sid='"+sid+"'");
			boolean b=rs.next();
			if(b==true)
			{
				student=new Student();
				student.setSid(rs.getString("sid"));
				student.setSname(rs.getString("sname"));
				student.setSaddress(rs.getString("saddress"));
			}
			
			else
			{
			  student=null;	
			}
			System.out.println();
		} 
	catch (Exception e) 
		{
		e.printStackTrace();
		}
		return student;
	}

	@Override
	public String update(Student student) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			Student std=search(student.getSid());
			if(std==null)
			{
			 status="Not Existed";	
			}
			else {
				//System.out.println("update StudentDetails set sname='"+student.getSname()+"',saddress='"+student.getSaddress()+"'where sid='"+student.getSid()+"'");
			int rowcount=st.executeUpdate("update StudentDetails set sname='"+student.getSname()+"',saddress='"+student.getSaddress()+"'where sid='"+student.getSid()+"'");
			if(rowcount==1) {
				status="SUCCESS";
			}
			else
				status="FAILURE";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status="";
		try {
			Connection con=ConnectionFactory.getConnection();
			Statement st=con.createStatement();
			Student std=search(sid);
			if(std==null) {
				
			}
			else {
			int rowcount=st.executeUpdate("delete from StudentDetails where sid='"+sid+"'");
			if(rowcount==1) {
				status="SUCCESS";
			}
			else
				status="FAILURE";
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
		return status;
	}

}
