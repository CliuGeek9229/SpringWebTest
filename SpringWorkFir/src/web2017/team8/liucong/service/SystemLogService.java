package web2017.team8.liucong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web2017.team8.liucong.dao.SystLogDao;
import web2017.team8.liucong.dao.SystLogDaoImpl;
import web2017.team8.liucong.domain.Customer;
import web2017.team8.liucong.domain.SystemLog;

/**
 *
 * @ClassName SystemLogService.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年11月14日 上午10:57:18 
 * @Description 系统日志类  服务层
 */
@Service
public class SystemLogService {
	@Autowired
	//private SystLogDaoImpl systemLogDao;
	private SystLogDao systemLogDao;
	/*
	 * 插入系统日志
	 */
	public void insertSystemLogInfo(SystemLog systemLog) {
		systemLogDao.insertSystemLog(systemLog);
	}
}
