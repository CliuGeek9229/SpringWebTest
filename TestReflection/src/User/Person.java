package User;

import java.lang.reflect.AccessibleObject;

/**
 *
 * @ClassName Person.java
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年10月22日下午4:50:30
 * @Description 测试类Person
 */

public class Person extends AccessibleObject {

	// 测试私有属性
	private String name;
	private String sex;
	private int age;

	// 测试类构造
	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public Person(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	// 测试类方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void PrintInfo() {
		System.out.println("name = " + name + ";sex = " + sex + ";age = " + age);
	}

	private int judge(int i) {
		return 1;
	}

}
