package interf;

/**
 *
 *@ClassName 
 *@author Leno E-mail:cliugeek@us-forever.com
 *@date 2017年10月24日下午12:50:29
 *@Description 
 */

public class Order {

	private database db;
	
	public void  injectOrder(database db) {
		this.db = db;
	}
	
	public void  Add() {
		db.Add();
	}
}
