package org.sayak.tutorial.DAO;

import org.sayak.tutorial.entity.User;
import java.util.List;

public interface UserDAO {
	public List<User> getallusers() throws ClassNotFoundException;
	public User getuser(int userid)throws ClassNotFoundException;
	public int updateuser(User u)throws ClassNotFoundException;
	public int adduser(User u)throws ClassNotFoundException;
	public int deleteuser(int userid)throws ClassNotFoundException;
	public String getPasswordByUserId(int userid);
	public int setPassword(int userid, String password);
}
