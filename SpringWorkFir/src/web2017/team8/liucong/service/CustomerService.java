package web2017.team8.liucong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web2017.team8.liucong.dao.CustDao;
import web2017.team8.liucong.dao.CustomerDaoImpl;
import web2017.team8.liucong.domain.Customer;

/**
 *
 * @ClassName CustomerService.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月29日 下午8:35:56
 * @Description 顾客类 服务层
 */
@Service
public class CustomerService {

	@Autowired
	//private CustomerDaoImpl customerDao;
	private CustDao customerDao;
	
	public void insertCustomerInfo(Customer customer) {
		customerDao.insertCustomer(customer);
	}
	public boolean hasMatchUser(String phonenum) {
		int matchCount = customerDao.getMatchCount(phonenum);
		return matchCount > 0;
	}
	public List<Customer> findCustomerByPH() {
		return customerDao.findCustomerByPH();
	}
	public void modifyCustomerInfo(Customer customer) {
		customerDao.updateCustomer(customer);
	}
	public Customer selectById(int id) {
		return customerDao.selectById(id);
	}
	public void deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
	}
	public int getCredit(int id) {
		int a = customerDao.getCredit(id);
		return a;
	}
	public void updateCredit(int id,int credit) {
		customerDao.updateCredit(id, credit);
	}
}
