package web2017.team8.liucong.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import web2017.team8.liucong.dao.UsersDaoImpl;
import web2017.team8.liucong.domain.User;
import web2017.team8.liucong.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void testHasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("houyuchen", "1111");
		//断言
		assertTrue(b1);
		assertTrue(!b2);
	}

	@Test
	public void testFindUserByUserName() {
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUsername(), "admin");
	}

	@Test
	public void testAddLoginLog() {
		User user = userService.findUserByUserName("admin");
		user.setUserId(1);
		user.setUsername("liucong");
		user.setLastIP("192.168.12.7");
		user.setLastVisitTime(new Date());
		userService.loginSuccess(user);
	}
	@Test
	public void testUpdateLoginInfo(){
		User user = userService.findUserByUserName("admin");
		user.setLastVisitTime(new Date());
		user.setLastIP("testIp");
		userService.updateLoginInfo(user);
	}
}
