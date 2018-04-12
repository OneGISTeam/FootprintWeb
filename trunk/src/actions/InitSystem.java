package actions;

import com.opensymphony.xwork2.ActionSupport;
import hibernate.MasterDAO;

public class InitSystem extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute() throws Exception {
		MasterDAO dao = new MasterDAO();
		
		//如果数据库中不存在超级管理员用户，则需要新创建一个
		if(dao.findAll().size() == 0)
			return "masterRegister";
		else
			return "userLogin";
	}
}
