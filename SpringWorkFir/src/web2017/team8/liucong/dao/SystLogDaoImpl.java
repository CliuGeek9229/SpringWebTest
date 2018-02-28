package web2017.team8.liucong.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import web2017.team8.liucong.domain.LoginLog;
import web2017.team8.liucong.domain.SystemLog;

/**
 *
 * @ClassName SystemLogDao.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年11月14日 上午10:46:57 
 * @Description 向数据库中添加用户操纵记录
 */
@Repository
public class SystLogDaoImpl implements SystLogDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insertSystemLog(SystemLog systemLog){
		String sqlStr="INSERT INTO t_system_log(operationModel,operationName,ip,createBy,date,description) values(?,?,?,?,?,?)";
		
		Object[] args = { systemLog.getOperationModel(),systemLog.getOperationName(),systemLog.getIp(),systemLog.getCreateBy(),systemLog.getDate(),systemLog.getDescription() };
		this.jdbcTemplate.update(sqlStr,args);
	}
}
