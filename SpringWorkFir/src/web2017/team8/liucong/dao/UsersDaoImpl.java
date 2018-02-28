package web2017.team8.liucong.dao;
/**
 *
 * @ClassName UserDao.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月29日 下午9:31:03 
 * @Description 管理员持久层
 */
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import web2017.team8.liucong.domain.User;

@Repository
public class UsersDaoImpl implements UsersDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int getMatchCount(String userName, String password){
		String sqlStr="SELECT count(*) FROM t_user "
				+ "WHERE user_name=? and password=? ";
		return jdbcTemplate.queryForInt(sqlStr,new Object[]{userName,password});
	}
	
	@Override
	public User findUserByUserName(final String userName){
		String sqlStr = "SELECT user_id,user_name,last_visit "
				+ "FROM t_user WHERE user_name=? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[]{userName},
				new RowCallbackHandler() {
					
					@Override
					public void processRow(java.sql.ResultSet rs) throws SQLException {
						// TODO Auto-generated method stub
						user.setUserId(rs.getInt("user_id"));
						user.setUsername(userName);
						user.setLastVisitTime(rs.getDate(3));
				};
			
		});
		return user;
	}
	@Override
	public void updateLoginInfo(User user){
		String sqlStr = "Update t_user set last_visit=?,last_ip=?"
				+ "where user_id=?" ;
		Object[] args = { user.getLastVisitTime(),user.getLastIP(),user.getUserId()};
		this.jdbcTemplate.update(sqlStr,args);
	}
	
}
