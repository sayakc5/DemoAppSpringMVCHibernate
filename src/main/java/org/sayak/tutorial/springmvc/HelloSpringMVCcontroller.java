package org.sayak.tutorial.springmvc;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sayak.tutorial.DAO.UserDAO;
import org.sayak.tutorial.DAO.UserDAOImplementation;
import org.sayak.tutorial.Service.UserService;
import org.sayak.tutorial.Service.UserServiceImplementation;
import org.sayak.tutorial.entity.User;
import org.sayak.tutorial.entity.UserPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

@Controller("hellospringmvccontroller")
public class HelloSpringMVCcontroller {
	
	ApplicationContext contxt;
	@Autowired
	UserService uservice;
	@Autowired
	UserDAO udao;
	
	@RequestMapping("/hello")
	public String hello()
	{
		return "helloworld";
	}
	@RequestMapping("/insert")
	public String registerform(Model model)
	{
		return "insert";
	}
	@RequestMapping("/Login")
	public String loginform(Model model)
	{
		return "Login";
	}
	
	@RequestMapping("/ChangePassword")
	public String changepasswordform(Model model)
	{
		return "changepassword";
	}
	
	
@RequestMapping(value="/display",method=RequestMethod.GET)
public ModelAndView showusers() throws Exception {
	
    ModelAndView mav = new ModelAndView("display");
    
    mav.addObject("users",uservice.getalluser_service());
    mav.setViewName("display");
    return mav;
}
@RequestMapping(value="/update",method=RequestMethod.GET)
public ModelAndView handleRequestupdateuser(HttpServletRequest request) throws Exception {
    
	ModelAndView mav = new ModelAndView("update");
    mav.addObject("user",uservice.getuser_service(Integer.parseInt(request.getParameter("id"))));
    mav.setViewName("update");
    return mav;     
}
@RequestMapping(value="/edit",method=RequestMethod.POST)
public ModelAndView saveandupdate(HttpServletRequest request) throws Exception {
	
	User u=new User();
    u.setUserid(Integer.parseInt(request.getParameter("userid")));
    u.setUsername(request.getParameter("username"));
    u.setUsertype(request.getParameter("usertype"));
    u.setGender(request.getParameter("usergender"));
    u.setAddress(request.getParameter("useraddress"));
    uservice.updateuser_service(u);
    
       	return new ModelAndView("redirect:/display");
   }
@RequestMapping(value="/add",method=RequestMethod.POST)
public ModelAndView newuser(HttpServletRequest request) throws Exception {
	
	User u=new User();
	UserPassword pass=new UserPassword();
	u.setUsername(request.getParameter("username"));
    u.setUsertype(request.getParameter("usertype"));
    u.setGender(request.getParameter("usergender"));
    u.setAddress(request.getParameter("useraddress"));
    pass.setPassword(request.getParameter("userpassword"));
    u.setUserPassword(pass);
    uservice.adduser_service(u);
    
       	return new ModelAndView("redirect:/Login");
   }
@RequestMapping(value="/delete",method=RequestMethod.GET)
public ModelAndView removeuser(HttpServletRequest request) throws Exception {
	
	ModelAndView mav = new ModelAndView("delete");
	uservice.deleteuser_service(Integer.parseInt(request.getParameter("id")));
	mav.addObject("users",uservice.getalluser_service());
    mav.setViewName("display");
    return mav;
   }
@RequestMapping(value="/login",method=RequestMethod.POST)
public ModelAndView loginuser(HttpServletRequest request) throws Exception {
	ModelAndView mav = new ModelAndView("display");
	if(""==request.getParameter("userid")||""==request.getParameter("userpassword"))
		return new ModelAndView("redirect:/Login");
	int userid=Integer.parseInt(request.getParameter("userid"));
	String password=request.getParameter("userpassword");
	if(uservice.loginuser_service(userid,password))
	{
		 mav.addObject("users",uservice.getalluser_service());
		    mav.setViewName("display");
		    return mav;
	}
	else
		return new ModelAndView("redirect:/Login");
   }
@RequestMapping(value="/changepassword",method=RequestMethod.POST)
public ModelAndView changepassword(HttpServletRequest request) throws Exception {
	
	ModelAndView mav = new ModelAndView("Login");
	if(request.getParameter("userpassword").equals(udao.getPasswordByUserId(Integer.parseInt(request.getParameter("userid"))))&& request.getParameter("newpassword").equals(request.getParameter("confirmpassword")))
	{
	uservice.setPassword(Integer.parseInt(request.getParameter("userid")),request.getParameter("newpassword"));
    mav.setViewName("Login");
    return mav;
	}
	else
	{
		return new ModelAndView("redirect:/hello");
	}
   }

}
