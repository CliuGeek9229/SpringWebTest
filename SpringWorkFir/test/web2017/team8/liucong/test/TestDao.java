package web2017.team8.liucong.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import web2017.team8.liucong.dao.CustDao;
import web2017.team8.liucong.domain.Customer;

/**
 *
 * @ClassName TestDao.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年12月14日 上午10:53:59 
 * @Description 测试dao层的  简单测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestDao {
	@Autowired
	private CustDao custDao;
	
	@Test
	public void TestDemo() {
		Customer testCustomer = custDao.selectById(2);
		assertEquals(testCustomer.getName(), "Leno3");
	}
	
	
}
