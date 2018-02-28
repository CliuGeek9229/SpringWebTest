package web2017.team8.liucong.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import web2017.team8.liucong.domain.Customer;
import web2017.team8.liucong.service.CustomerService;

/**
 *
 * @ClassName TestCustomerService.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月29日 下午9:00:22
 * @Description 测试客户类业务层
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestCustomerService {

	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testDeleteById() {
		customerService.deleteCustomer(14);
	}

//	@Test
//	public void testSelectbyId() {
//		Customer customer = customerService.selectById(2);
//		assertEquals(customer.getId(), 2);
//		assertEquals(customer.getAge(), 22);
//		assertEquals(customer.getName(), "Leno3");
//		assertEquals(customer.getPassword(), "1234");
//		assertEquals(customer.getPhonenum(), "123456");
//	}
	
//	@Test
//	public void testInsertInfo() {
//		Customer customer = new Customer();
//		customer.setName("msi1234567890");
//		customer.setPassword("1234");
//		customer.setPhonenum("15335582002");
//		customer.setAge(23);
//		
//		customerService.insertCustomerInfo(customer);
//	}

//	@Test
//	public void testGetMatchCount() {
//
//		boolean test1 = customerService.hasMatchUser("刘聪");
//		boolean test2 = customerService.hasMatchUser("admin");
//		assertTrue(test1);
//		assertTrue(!test2);
//	}

//	@Test
//	public void testFindCustomerbyName() {
//		Customer customer = new Customer();
//
//		customer = customerService.findCustomerByPH("15335582485");
//		assertEquals(customer.getAge(), 23);
//		assertEquals(customer.getName(), "刘聪");
//		assertEquals(customer.getPassword(), "1234");
//		assertEquals(customer.getPhonenum(), "15335582485");
//		
//	}
//	@Test
//	public void Modify() {
//		Customer customer = new Customer();
//		customer.setName("msi1234");
//		customer.setPassword("1234");
//		customer.setPhonenum("15335582002");
//		customer.setAge(99);
//		
//		customerService.modifyCustomerInfo(customer);
//	}

}
