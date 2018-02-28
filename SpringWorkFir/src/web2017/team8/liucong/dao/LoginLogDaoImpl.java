package web2017.team8.liucong.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import web2017.team8.liucong.domain.LoginLog;

@Repository
public class LoginLogDaoImpl implements LoginLDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void insertLoginLog(LoginLog loginLog){
		String sqlStr="INSERT INTO t_login_log(user_id,ip,login_datetime) values(?,?,?)";
		
		Object[] args = { Integer.valueOf(loginLog.getUser_id()),loginLog.getIp(),loginLog.getLoginTime() };
		this.jdbcTemplate.update(sqlStr,args);
	}
	
}
