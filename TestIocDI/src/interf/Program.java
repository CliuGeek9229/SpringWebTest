package interf;

/**
 *
 *@ClassName 
 *@author Leno E-mail:cliugeek@us-forever.com
 *@date 2017年10月24日下午12:55:40
 *@Description 
 */

public class Program {

	public static void main(String[] args) {
		database db = new AccessDal();
		
		Order or = new Order();
		or.injectOrder(db);
		or.Add();

	}

}
