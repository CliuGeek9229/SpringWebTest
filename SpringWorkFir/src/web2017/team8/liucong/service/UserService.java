package web2017.team8.liucong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web2017.team8.liucong.dao.LoginLDao;
import web2017.team8.liucong.dao.LoginLogDaoImpl;
import web2017.team8.liucong.dao.UsersDao;
import web2017.team8.liucong.dao.UsersDaoImpl;
import web2017.team8.liucong.domain.LoginLog;
import web2017.team8.liucong.domain.User;

@Service
public class UserService {
    @Autowired
   // private UsersDaoImpl userdao;
    private UsersDao userdao;
    //UsersDao userdao=new UserDaoImol();

    @Autowired
   // private LoginLogDaoImpl loginLogDao;
    private LoginLDao loginLogDao;
    
    public boolean hasMatchUser(String userName, String password) {
        int matchCount = userdao.getMatchCount(userName, password);
        return matchCount > 0;
    }
    public User findUserByUserName(String userName) {
        return userdao.findUserByUserName(userName);
    }
    public void updateLoginInfo(User user){
        userdao.updateLoginInfo(user);
    }

    public void loginSuccess(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUser_id(user.getUserId());
        loginLog.setIp(user.getLastIP());
        loginLog.setLoginTime(user.getLastVisitTime());
        loginLogDao.insertLoginLog(loginLog);

    }
}
