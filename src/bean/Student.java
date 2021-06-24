package bean;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import util.DBConnection;

public class Student
{
	private int rollno,otp;
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	private String name,address,contact,email,password;
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int addOTP() throws SQLException
	{
		Connection conn=(Connection) DBConnection.dbConnect();
		
		//SQL Queries
		String sql= "insert into otp values(?,?)";
		
		//Statements (Set Data) & Exceute
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1,email);
		ps.setInt(2, otp);
		
		  //ps.execute();
		int row=ps.executeUpdate();
		
		//Close Connections
		conn.close();
		return row;
	}
	public boolean matchOTP() throws SQLException
	{
		Connection conn=(Connection) DBConnection.dbConnect();
		
		//SQL Queries
		String sql= "select *from otp where email=? and code=?";
		
		//Statements (Set Data) & Exceute
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1,email);
		ps.setInt(2, otp);
		
		  //ps.execute();
		ResultSet rs=(ResultSet) ps.executeQuery();
		
		if(rs.next())
		{
			return true;
		}
		else 
			return false;
		
	}
	public int addStudent() throws SQLException
	{
		//register driver
//		DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
//		
//		//Connetion (user,password,url)
//		String url="jdbc:mysql://localhost:3306/techtreedb";
//		String user="root";
//		String password="";
//		Connection conn=(Connection) DriverManager.getConnection(url,user,password);
//		
		Connection conn=DBConnection.dbConnect();
		//SQL queries
		String sql="insert into student values(?,?,?,?,?,?)";
		
		//Statement (set data) and execute
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1,rollno);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.setString(4, contact);
		ps.setString(5, email);
		ps.setString(6,password);
		//ps.execute();
		int row=ps.executeUpdate();
		
		//close conection
		conn.close();
		return row;
	}
	public ArrayList<Student> getAllStudentsFromDB() throws SQLException
	{
//		DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
//		
//		//Connetion (user,password,url)
//		String url="jdbc:mysql://localhost:3306/techtreedb",user="root",password="";
//		Connection conn= (Connection) DriverManager.getConnection(url,user,password);
		Connection conn=DBConnection.dbConnect();
		
		String sql="select *from student";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs=(ResultSet) ps.executeQuery();
		
		
		ArrayList<Student> allStuds=new ArrayList<Student>();
		
		while(rs.next())
		{
			Student s1=new Student();
			s1.setEmail(rs.getString("email_id"));
			s1.setName(rs.getString("name"));
			s1.setAddress(rs.getString("address"));
			s1.setRollno(rs.getInt("rollno"));
			s1.setContact(rs.getString("contact"));
			
			allStuds.add(s1);
		}
		return allStuds;
	}
	public int deleteStudent() throws SQLException
	{
//		//Register Driver
//		DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
//		
//		//Connetion (user,password,url)
//		String url="jdbc:mysql://localhost:3306/techtreedb",user="root",password="";
//		Connection conn= (Connection) DriverManager.getConnection(url,user,password);
//		
		Connection conn=DBConnection.dbConnect();
		//SQL Queries
		String sql= "delete from student where rollno = ?";
		
		//Statements (Set Data) & Exceute
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, rollno);
		
		  //ps.execute();
		int row=ps.executeUpdate();
		
		//Close Connections
		conn.close();
		return row;
	}
//	public ArrayList<Student> getAllStudents()
//	{
//		ArrayList<Student> allStuds=new ArrayList<Student>();
//		Student s1=new Student();
//		s1.setEmail("sauravgupta@gmail.com");
//		s1.setName("Saurav Gupta");
//		s1.setAddress("Kolkata");
//		s1.setRollno(41);
//		s1.setContact("1234567899");
//		
//		Student s2=new Student();
//		s2.setEmail("nandita@gmail.cpom");
//		s2.setName("Nandita Saha");
//		s2.setAddress("Kolkata");
//		s2.setRollno(60);
//		s2.setContact("1234557899");
//		
//		allStuds.add(s1);
//		allStuds.add(s2);
//		
//		return allStuds;
//	}
	public boolean checkEmail() throws SQLException
	{
		Connection conn=DBConnection.dbConnect();
		String sql="select *from student where email_id = ? ";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs=(ResultSet) ps.executeQuery();
		Student s1=new Student();
		if(rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public ArrayList<String> getAllStates() throws SQLException
	{
		Connection conn=DBConnection.dbConnect();
		String sql="select *from state";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs=(ResultSet) ps.executeQuery();
		ArrayList<String> allStates= new ArrayList<String>();
		while(rs.next())
		{
			String n=rs.getString("StateName");
			allStates.add(n);
		}
		return allStates;
	}
	public Student getDetailsByEmail() throws SQLException
	{
		Connection conn=DBConnection.dbConnect();
		String sql="select *from student where email_id = ? ";
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs=(ResultSet) ps.executeQuery();
		Student s1=new Student();
		if(rs.next())
		{
			s1.setEmail(rs.getString("email_id"));
			s1.setName(rs.getString("name"));
			s1.setAddress(rs.getString("address"));
			s1.setRollno(rs.getInt("rollno"));
			s1.setContact(rs.getString("contact"));
		}
		else
		{
			s1=null;
		}
		return s1;
	}
	public int updateStudent() throws SQLException
	{
		Connection conn=DBConnection.dbConnect();
		//SQL queries
		String sql="update student set name=?, address=?, contact=? where email_id=?";
		
		//Statement (set data) and execute
		PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
		
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setString(3, contact);
		ps.setString(4, email);
		
		//ps.execute();
		int row=ps.executeUpdate();
		
		//close conection
		conn.close();
		return row;
	}
}
