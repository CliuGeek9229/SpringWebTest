package web2017.team8.liucong.domain;

import java.io.Serializable;

/**
 *
 * @ClassName Customer.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月29日下午5:32:30
 * @Description 顾客类
 */

public class Customer implements Serializable {

	private int id;


	private String name;
	private String password;
	
	private String phonenum;
	private int age;
	
	private int credit;//积分转让功能


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

}
