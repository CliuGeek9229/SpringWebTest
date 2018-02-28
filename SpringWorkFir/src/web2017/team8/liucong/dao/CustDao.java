package web2017.team8.liucong.dao;

import java.util.List;

import web2017.team8.liucong.domain.Customer;

/**
 *
 * @ClassName CustDao.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年11月20日 下午8:10:14 
 * @Description 顾客类接口
 */
public interface CustDao {
	public List<Customer> findCustomerByPH();
	public void insertCustomer(Customer customer);
	public int getMatchCount(String phonenum);
	public void updateCustomer(Customer customer);
	public Customer selectById(final int id);
	public void deleteCustomer(final int id);
	
	//查询积分
	public int getCredit(final int id);
	//积分修改
	public void updateCredit(final int id,final  int credit);
}
