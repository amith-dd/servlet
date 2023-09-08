package studentdetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import studentdetails.dto.Student;

public class StudentDao {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=root");
		
		return conn;
	}
	
	public int saveStudent(Student stu) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("insert into student values(?,?,?,?,?,?)");
		pst.setInt(1, stu.getId());
		pst.setString(2, stu.getName());
		pst.setString(3, stu.getDept());
		pst.setLong(4, stu.getContact());
		pst.setString(5, stu.getCity());
		pst.setString(6, stu.getPass());
		int res = pst.executeUpdate();
		return res;
		
	}
	
	public Student findbYiD(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from student where id =?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Student s = new Student();
		while(rs.next()) {
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setDept(rs.getString(3));
			s.setContact(rs.getLong(4));
			s.setCity(rs.getString(5));
			s.setPass(rs.getString(6));	
		}
		return s;
	}
	
	public int updateStudent(Student stu) throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("update student set name=?,dept=?,contact=?,city=?,pass=? where id=?");
		pst.setString(1, stu.getName());
		pst.setString(2, stu.getDept());
		pst.setLong(3, stu.getContact());
		pst.setString(4, stu.getCity());
		pst.setString(5, stu.getPass());
		pst.setInt(6, stu.getId());
		
		return pst.executeUpdate();
	}
	
	public int deleteSStudent(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("delete from student where id=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	
	public List<Student> getAllStudent() throws ClassNotFoundException, SQLException{
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from student");
		ResultSet rs = pst.executeQuery();
		
		List<Student> students = new ArrayList<>();
		
		while(rs.next()) {
			Student s = new Student();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setDept(rs.getString(3));
			s.setContact(rs.getLong(4));
			s.setCity(rs.getString(5));
			s.setPass(rs.getString(6));	
			students.add(s);
		}
		
		return students;
		
	}
	
	public Student findByName(String name) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pst = conn.prepareStatement("select * from student where name=?");
		pst.setString(1, name);
		ResultSet rs = pst.executeQuery();
		Student s = new Student();
		while(rs.next()) {
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setDept(rs.getString(3));
			s.setContact(rs.getLong(4));
			s.setCity(rs.getString(5));
			s.setPass(rs.getString(6));
		}
		return s;
		
		
	}
	

}
