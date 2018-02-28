package web2017.team8.liucong.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web2017.team8.liucong.domain.Customer;
import web2017.team8.liucong.domain.User;
import web2017.team8.liucong.service.CustomerService;
import web2017.team8.liucong.service.UserService;
import web2017.team8.liucong.web.UserCommand;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private CustomerService customerService;
	
	
	@RequestMapping(value="/index.html")
	public String LoginPage(){
		return "login";
	}
	
	@RequestMapping(value="/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, UserCommand userCommand){
		boolean isValidUser = userService.hasMatchUser(userCommand.getUserName(), userCommand.getPassword());
		//String TypedUserName = userCommand.getUserName();
		
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else {
			User user = userService.findUserByUserName(userCommand
					.getUserName());
			request.getSession().setAttribute("lasttime", user.getLastVisitTime());
			System.out.println(user.getLastVisitTime().toString());
			user.setLastIP(request.getLocalAddr());
			user.setLastVisitTime(new Date());
			request.getSession().setAttribute("user", user);
			userService.loginSuccess(user);
			userService.updateLoginInfo(user);
			
			
			List<Customer> customers = customerService.findCustomerByPH();
			request.setAttribute("Customer", customers);
			
			return new ModelAndView("main");
		}
	}
}
