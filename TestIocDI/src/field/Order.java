package field;

/**
 *
 *@ClassName Order.java
 *@author Leno E-mail:cliugeek@us-forever.com
 *@date 2017年10月24日下午12:28:30
 *@Description 
 */

public class Order {

	private database db;

	public database getDb() {
		return db;
	}

	public void setDb(database db) {
		this.db = db;
	}
	public void Add(){
		db.Add();
	}
}
