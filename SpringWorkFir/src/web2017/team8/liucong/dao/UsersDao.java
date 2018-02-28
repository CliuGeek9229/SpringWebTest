package web2017.team8.liucong.dao;

import web2017.team8.liucong.domain.User;

public interface UsersDao {
	public int getMatchCount(String userName, String password);
	public User findUserByUserName(final String userName);
	public void updateLoginInfo(User user);
}
