package org.sayak.tutorial.DAO;

/*import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

/*import javax.sql.DataSource;*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.sayak.tutorial.entity.User;
import org.sayak.tutorial.entity.UserPassword;
/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;*/
import org.springframework.stereotype.Repository;

/*import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;*/

@Repository("userdao")
public class UserDAOImplementation implements UserDAO {

	public UserDAOImplementation() {
	sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	/*Connection con = null;
    Statement st = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs=null;*/
    SessionFactory sessionFactory;
    Session session;
    
    /*String url="jdbc:mysql://localhost/db_demo";
    String user="root";
    String password="admin";
    String driver="com.mysql.jdbc.Driver";*/
    
    /*@Autowired
    private DataSource dataSource;*/
    
	public List<User> getallusers() throws ClassNotFoundException
	{
	    List<User> alluser=new ArrayList<User>();
	    User u;
         /* try {
        	  Class.forName(driver);
	        con = (Connection)DriverManager.getConnection(url, user, password);
	        st = (Statement) con.createStatement();
	        rs = st.executeQuery("SELECT * FROM userdetail ORDER BY id;");

	        while (rs.next()) {
	        	u=new User();
	        	u.setUserid(rs.getInt(1));
	        	u.setUsername(rs.getString(4));
	        	u.setUsertype(rs.getString(5));
	        	u.setGender(rs.getString(3));
	        	u.setAddress(rs.getString(2));
	        	alluser.add(u);
	        }
return alluser;
	    } catch (SQLException ex) {
	        
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (st != null) {
	                st.close();
	            }
	            if (con != null) {
	                con.close();
	            }

	        } catch (SQLException ex) {
	           
	        }
	        
	}*/
	    try{
	    session=sessionFactory.openSession();
	    session.beginTransaction();
	    Criteria cr=session.createCriteria(User.class);
	    alluser=cr.addOrder(Order.asc("id")).list();
	    //alluser=session.createCriteria(User.class).list();
	    session.getTransaction().commit();
	    return alluser;
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    return null;
	}

	public User getuser(int userid)throws ClassNotFoundException {
		User u=new User();
		/*
		try {
			Class.forName(driver);
	        con = (Connection)DriverManager.getConnection(url, user, password);
	        st = (Statement) con.createStatement();
	        rs = st.executeQuery("SELECT * FROM user where id="+userid);

	        while (rs.next()) {
	           	u.setUserid(rs.getInt(1));
	        	u.setUsername(rs.getString(2));
	        	u.setUsertype(rs.getString(3));
	        	u.setGender(rs.getString(4));
	        	u.setAddress(rs.getString(5));
	        	
	        }
return u;
	    } catch (SQLException ex) {
	        
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (st != null) {
	                st.close();
	            }
	            if (con != null) {
	                con.close();
	            }

	        } catch (SQLException ex) {
	           
	        }
	        
	}*/
		try{
		session=sessionFactory.openSession();
		session.beginTransaction();
		u=(User)session.get(User.class, userid);
		session.getTransaction().commit();
		return u;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally{
		}
		
	    return null;
	}

	public int updateuser(User u)throws ClassNotFoundException {
		
		/*String updateTableSQL = "UPDATE userdetail SET id= ? ,username = ? ,usertype = ?,gender = ?,address = ?" + " WHERE id = ?";
		try
		{
			Class.forName(driver);
	        	con = (Connection)DriverManager.getConnection(url, user, password);
		        preparedStatement = (PreparedStatement) con.prepareStatement(updateTableSQL);
		        preparedStatement.setInt(1,u.getUserid());
				preparedStatement.setString(2,u.getUsername());
				preparedStatement.setString(3,u.getUsertype());
				preparedStatement.setString(4,u.getGender());
				preparedStatement.setString(5,u.getAddress());	
				preparedStatement.setInt(6,u.getUserid());// execute update SQL stetement
				preparedStatement.executeUpdate();
				return 1;
		}

catch (SQLException ex) {
	        
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (st != null) {
	                st.close();
	            }
	            if (con != null) {
	                con.close();
	            }

	        } catch (SQLException ex) {
	           
	        }	
	}*/ try{
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(u);
		session.getTransaction().commit();
		return 1;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
		return 0;
}
public int adduser(User u)throws ClassNotFoundException {
		
		/*String updateTableSQL = "Insert into user(username,usertype,gender,address)" + " Values(?,?,?,?)";
		try
		{
			Class.forName(driver);
	        	con = (Connection)DriverManager.getConnection(url, user, password);
		        preparedStatement = (PreparedStatement) con.prepareStatement(updateTableSQL);
				preparedStatement.setString(1,u.getUsername());
				preparedStatement.setString(2,u.getUsertype());
				preparedStatement.setString(3,u.getGender());
				preparedStatement.setString(4,u.getAddress());	
				preparedStatement.executeUpdate();
				return 1;
		}

catch (SQLException ex) {
	        
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (st != null) {
	                st.close();
	            }
	            if (con != null) {
	                con.close();
	            }

	        } catch (SQLException ex) {
	           
	        }	
	}
		return 0;*/
		try
		{
			
			session=sessionFactory.openSession();
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			session.close();
			return 1;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
		finally{
		}
	
}
public int deleteuser(int userid)throws ClassNotFoundException {
	
	/*String updateTableSQL = "Delete from userdetail where id=" +userid+"";
	try
	{
		
		Class.forName(driver);
        	con = (Connection)DriverManager.getConnection(url, user, password);
	        st = (Statement) con.createStatement();
			st.executeUpdate(updateTableSQL);
			return 1;
	}

catch (SQLException ex) {
        
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
           
        }	
}*/
	try{
	session=sessionFactory.openSession();
	session.beginTransaction();
	User u=(User)session.get(User.class,userid);
	session.delete(u);
	session.getTransaction().commit();
	return 1;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	return 0;
}

public String getPasswordByUserId(int userid) {
	try{
		session=sessionFactory.openSession();
		session.beginTransaction();
		User u=(User) session.createQuery("from User user where user.password.pass_id =:userid").setInteger("userid",userid).uniqueResult();
		return u.getUserPassword().getPassword();
		}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		session.getTransaction().commit();
	}
	
	return null;
}

public int setPassword(int userid, String password) {
	
	
	try{
		User u=getuser(userid);
		UserPassword pass=new UserPassword();
		pass.setPass_id(userid);
		pass.setPassword(password);
		u.setUserPassword(pass);
		session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(u);
		return 1;
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	finally
	{
		session.getTransaction().commit();
	}
	
	return 0;
}


}