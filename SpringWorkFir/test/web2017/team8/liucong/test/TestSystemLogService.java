package web2017.team8.liucong.test;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import web2017.team8.liucong.dao.SystLogDaoImpl;
import web2017.team8.liucong.domain.SystemLog;
import web2017.team8.liucong.service.SystemLogService;

/**
 *
 * @ClassName TestSystemLogService.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年11月14日 上午11:02:52 
 * @Description 系统日志服务层测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class TestSystemLogService {
	@Autowired
	private SystemLogService systemLogService;
	@Test
	public void testInsertLog() {
		SystemLog systemLog = new SystemLog();
		systemLog.setOperationModel("测试1");
		systemLog.setOperationName("测试2");
		systemLog.setIp("测试3");
		systemLog.setCreateBy("测试4");
		systemLog.setDate(new Date());
		systemLogService.insertSystemLogInfo(systemLog);
	}
}
