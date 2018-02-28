package web2017.team8.liucong.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int UserId;
	private String Username;
	private String Password;
	private Date LastVisitTime;
	private String LastIP;
	
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Date getLastVisitTime() {
		return LastVisitTime;
	}
	public void setLastVisitTime(Date lastVisitTime) {
		LastVisitTime = lastVisitTime;
	}
	public String getLastIP() {
		return LastIP;
	}
	public void setLastIP(String lastIP) {
		LastIP = lastIP;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	
}
