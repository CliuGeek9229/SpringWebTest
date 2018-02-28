package web2017.team8.liucong.domain;
/**
 *
 * @ClassName SystemLog
 * @author Leno E-mail:cliugeek@us-forever.com
 * @date 2017年11月14日 上午10:25:12 
 * @Description 系统日志实体类
 */

import java.util.Date;

public class SystemLog {
	private int Id;
	private String operationModel;
	private String operationName;
	private String ip;
	private String createBy;
	private Date date;
	private String description;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getOperationModel() {
		return operationModel;
	}
	public void setOperationModel(String operationModel) {
		this.operationModel = operationModel;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
