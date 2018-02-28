package web2017.team8.liucong.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web2017.team8.liucong.domain.Customer;
import web2017.team8.liucong.domain.User;
import web2017.team8.liucong.service.CustomerService;
import web2017.team8.liucong.web.CostomerCommand;
import web2017.team8.liucong.web.ExchangeCommand;
import web2017.team8.liucong.web.ModifyCommand;
import web2017.team8.liucong.web.SelectByPH;
import web2017.team8.liucong.web.UserCommand;

/**
 *
 * @ClassName CustomerController.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月30日 下午7:20:36
 * @Description 顾客类控制层
 */
@Controller

public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/CustomerAdd.html")
	public String AddCustomer() {
		return "AddCustomer";
	}
	@RequestMapping(value="/ExchangeCredit.html")
	public String JumpEC() {
		return "ExchangeCredit";
	}
	/**
	 * propagation属性：用来设置事物的传播行为
	 * 		--Propagation.REQUIRES:默认，使用事务者的事物
	 * 		--Propagation.REQUIRES_NEW:开启一个新事物
	 * solation属性：用来设置事务的隔离级别
	 * 		-Isolation.REPEATABLE_READ：可重复读，Mysql默认的隔离级别
	 *      -Isolation.READ_COMMITTED：读已提交
	 *		noRollbackFor属性：用来设置出现什么异常不回滚，值是一个数组，里面放的是异常的类型
	 * 		rollbackFor......
	 * */
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.REPEATABLE_READ,
			rollbackFor= {ArithmeticException.class})
	@RequestMapping(value="/Change.html")
	public ModelAndView Change(HttpServletRequest request,ExchangeCommand exchangeCommand) {
		int a = exchangeCommand.getName1();
		int b = exchangeCommand.getName2();
		int credit1 = customerService.getCredit(a);
		int credit2 = customerService.getCredit(b);
		credit1-=5;
		credit2+=5;
		customerService.updateCredit(a, credit1);
		//int c = 1/0;
		customerService.updateCredit(b, credit2);
		
		
		return new ModelAndView("success");
	}
	
	@RequestMapping(value="/AddCusCheck.html")
	public ModelAndView addCheck(HttpServletRequest request, CostomerCommand customerCommand) {
		boolean isValidUser = customerService.hasMatchUser(customerCommand.getPhonenum());
		
		if (isValidUser) {
			return new ModelAndView("AddCustomer", "error", "该用户已经存在！");
		}
		else {
			Customer customer = new Customer();
			customer.setAge(customerCommand.getAge());
			customer.setName(customerCommand.getName());
			customer.setPassword(customerCommand.getPassword());
			customer.setPhonenum(customerCommand.getPhonenum());
			
			
			customerService.insertCustomerInfo(customer);
			
			List<Customer> customers = customerService.findCustomerByPH();
			request.setAttribute("Customer", customers);
			

			return new ModelAndView("main");
		}
	}
	
	@RequestMapping(value="/Customermodify.html")
	public ModelAndView modifyCustomer(HttpServletRequest request,CostomerCommand customerCommand) {
		
		Customer customer = customerService.selectById(customerCommand.getId());
		request.setAttribute("Customer", customer);
		
		return new ModelAndView("ModifyCustomer");
	}
	
	
	@RequestMapping(value="/Modify.html")
	public ModelAndView Modify(HttpServletRequest request,CostomerCommand customerCommand) {

		Customer customer =new Customer();
		customer.setId(customerCommand.getId());
		customer.setAge(customerCommand.getAge());
		customer.setName(customerCommand.getName());
		customer.setPassword(customerCommand.getPassword());
		customer.setPhonenum(customerCommand.getPhonenum());
		customerService.modifyCustomerInfo(customer);
		
		List<Customer> customers = customerService.findCustomerByPH();
		request.setAttribute("Customer", customers);
		return new ModelAndView("main");
	}
	
	@RequestMapping(value="/Customerdelete.html")
	public ModelAndView Delete(HttpServletRequest request,CostomerCommand customerCommand) {
		
		customerService.deleteCustomer(customerCommand.getId());
		
		List<Customer> customers = customerService.findCustomerByPH();
		request.setAttribute("Customer", customers);
		return new ModelAndView("main");
	}
	
}