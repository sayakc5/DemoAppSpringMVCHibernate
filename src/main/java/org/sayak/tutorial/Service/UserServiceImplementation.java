package org.sayak.tutorial.Service;

import java.util.List;
import org.sayak.tutorial.DAO.UserDAO;
import org.sayak.tutorial.DAO.UserDAOImplementation;
import org.sayak.tutorial.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service("userservice")
public class UserServiceImplementation implements UserService {

	@Autowired
	UserDAO udao;
	
	public List<User> getalluser_service() throws ClassNotFoundException {
		return udao.getallusers();
	}

	public User getuser_service(int userid) throws ClassNotFoundException {
		return udao.getuser(userid);
	}

	public int updateuser_service(User u) throws ClassNotFoundException {
		return udao.updateuser(u);
	}

	public int adduser_service(User u) throws ClassNotFoundException {
		return udao.adduser(u);
		}

	public int deleteuser_service(int userid) throws ClassNotFoundException {
		return udao.deleteuser(userid);
	}

	public boolean loginuser_service(int userid, String password) {
		if(udao.getPasswordByUserId(userid).equals(password))
			return true;
		else
		return false;
	}

	public int setPassword(int userid, String password) {
		return udao.setPassword(userid,password);
	}

}
