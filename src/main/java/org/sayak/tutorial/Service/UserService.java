package org.sayak.tutorial.Service;

import java.util.List;

import org.sayak.tutorial.entity.User;

public interface UserService {
	public List<User> getalluser_service() throws ClassNotFoundException;
	public User getuser_service(int userid)throws ClassNotFoundException;
	public int updateuser_service(User u)throws ClassNotFoundException;
	public int adduser_service(User u)throws ClassNotFoundException;
	public int deleteuser_service(int userid)throws ClassNotFoundException;
	public boolean loginuser_service(int userid, String password);
	public int setPassword(int userid, String password);
}
