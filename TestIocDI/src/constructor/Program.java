package constructor;

/**
 *
 *@ClassName Program.java
 *@author Leno E-mail:cliugeek@us-forever.com
 *@date 2017年10月24日下午12:12:50
 *@Description 
 */

public class Program {

	public static void main(String[] args) {
		database db = new SqlServerDal();
		database db1 = new AccessDal();
		
		Order or = new Order(db1);
		or.Add();

	}

}
