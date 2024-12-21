package Model;
import java.sql.*;

public class DAOServiceImpl implements DAOService{
	
	Connection con;
	Statement stmnt;
	@Override
	public void connectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/regi_pro","root","test");
			stmnt=con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean verifylogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email = '"+email+"' and password='"+password+"'");
			return result.next();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveReg(String name, String course, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registrations values('"+name+"','"+course+"','"+email+"','"+mobile+"')");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet allRegistration() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registrations");
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("delete from registrations where email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReg(String email, String mobile) {
		try {
			stmnt.executeUpdate("update registrations set mobile = '"+mobile+"' where email='"+email+"'");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
