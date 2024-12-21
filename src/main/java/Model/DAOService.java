package Model;

import java.sql.ResultSet;

public interface DAOService {
	public void connectDb();
	public boolean verifylogin(String email,String password);
	public void saveReg(String name,String course,String email,String mobile);
	public ResultSet allRegistration();
	public void deleteReg(String email);
	public void updateReg(String email,String mobile);
}
