package web2017.team8.liucong.domain;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable{
	private int loginLogId;
	private int user_id;
	private String ip;
	private Date LoginTime;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginTime() {
		return LoginTime;
	}
	public void setLoginTime(Date loginTime) {
		LoginTime = loginTime;
	}
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	
	
}
