package web2017.team8.liucong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import web2017.team8.liucong.domain.Customer;
import web2017.team8.liucong.domain.User;

/**
 *
 * @ClassName CustomerDao.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月29日下午5:36:26
 * @Description 顾客类持久层
 */
@Repository
public class CustomerDaoImpl implements CustDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> findCustomerByPH() {
		String sqlStr = "SELECT id,name,age,phonenum,password " + "FROM t_customer";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sqlStr);
		List<Customer> customers = new ArrayList<Customer>();
		
		for (Map<String, Object> map : list) {  
			Customer customer =  CustomerDaoImpl.toObject(map);  
	        if (customer != null) {  
	        	customers.add(customer);  
	        }  
	    }
		
		return customers;
	}
	public static Customer toObject(Map<String, Object> map){
		Customer customer = new Customer();
		customer.setId((int) map.get("id"));
		customer.setName((String) map.get("name"));
		customer.setPassword((String) map.get("password"));
		customer.setAge((int) map.get("age"));
		customer.setPhonenum((String) map.get("phonenum"));
		
		return customer;
	}
	
	@Override
	public void insertCustomer(Customer customer) {
		String sqlStr = "INSERT INTO t_customer(name,password,phonenum,age) values(?,?,?,?)";

		Object[] args = { customer.getName(), customer.getPassword(), customer.getPhonenum(),
				Integer.toString(customer.getAge()) };
		this.jdbcTemplate.update(sqlStr, args);
	}
	@Override
	public int getMatchCount(String phonenum) {
		String sqlStr = "SELECT count(*) FROM t_customer " + "WHERE phonenum=? ";

		return jdbcTemplate.queryForInt(sqlStr, new Object[] { phonenum });
	}
	@Override
	public void updateCustomer(Customer customer) {
		String sqlStr = "Update t_customer set name=?,password=?,age=?,phonenum=? "
				+ "where id=?" ;
		Object[] args = { customer.getName(),customer.getPassword(),customer.getAge(),customer.getPhonenum(),customer.getId()};
		this.jdbcTemplate.update(sqlStr,args);
	}
	@Override
	public Customer selectById(final int id) {
		String sqlStr="SELECT name,age,phonenum,password "
				+ "FROM t_customer WHERE id=?";
		
		final Customer cus = new Customer();
		jdbcTemplate.query(sqlStr, new Object[]{id},
				new RowCallbackHandler() {
					
					@Override
					public void processRow(java.sql.ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						cus.setId(id);
						cus.setName(rs.getString("name"));
						cus.setAge(rs.getInt("age"));
						cus.setPassword(rs.getString("password"));
						cus.setPhonenum(rs.getString("phonenum"));
				};
			
		});
		return cus;
		
	}
	@Override
	public void deleteCustomer(final int id) {
		String sqlStr ="DELETE FROM t_customer WHERE id=?";
		Object[] args = {id};
		this.jdbcTemplate.update(sqlStr,args);
	}
	@Override
	public int getCredit(int id) {
		String sqlStr = "select credit from t_customer where id=?";
		final Customer cus = new Customer();
		jdbcTemplate.query(sqlStr, new Object[]{id},
				new RowCallbackHandler() {
					
					@Override
					public void processRow(java.sql.ResultSet rs) throws SQLException {
						cus.setCredit(rs.getInt("credit"));
				};
			
		});
		return cus.getCredit();
	}
	@Override
	public void updateCredit(int id, int credit) {
		String sqlStr = "Update t_customer set credit=? "
				+ "where id=?" ;
		Object[] args = { credit,id};
		this.jdbcTemplate.update(sqlStr,args);
		
	}


}
