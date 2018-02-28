package constructor;

/**
 *
 *@ClassName Order.java
 *@author Leno E-mail:cliugeek@us-forever.com
 *@date 2017年10月24日下午12:04:10
 *@Description 
 */

public class Order {
	private database db;
	public Order(database db){
		this.db = db;
	}
	public void Add(){
		db.Add();
	}
}
