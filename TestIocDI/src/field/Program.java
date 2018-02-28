package field;

/**
 *
 *@ClassName 
 *@author Leno E-mail:cliugeek@us-forever.com
 *@date 2017年10月24日下午12:32:09
 *@Description 
 */

public class Program {

	public static void main(String[] args) {
		database db = new SqlServerDal();
		database db1 = new AccessDal();
		Order or = new Order();
		or.setDb(db1);
		
		or.Add();

	}

}
