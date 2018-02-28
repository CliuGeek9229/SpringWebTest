package web2017.team8.liucong.web;

/**
 *
 * @ClassName CostomerCommand.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月29日 下午8:32:12
 * @Description 获取界面信息
 */

public class CostomerCommand {

	private int id;
	private String confirmpw;
	private String name;
	private String password;
	private int age;
	private String phonenum;

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



	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getConfirmPW() {
		return confirmpw;
	}

	public void setConfirmPW(String confirmPW) {
		confirmpw = confirmPW;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
