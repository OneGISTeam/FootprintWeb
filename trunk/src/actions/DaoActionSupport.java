package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Dao Action类的基类，用于定义一些如传递消息的变量信息
 */
public class DaoActionSupport extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
}
