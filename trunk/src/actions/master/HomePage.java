package actions.master;

import hibernate.Master;
import hibernate.MasterDAO;
import hibernate.Role;
import hibernate.RoleDAO;

public class HomePage extends MasterInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * 访问超级管理员登录页面
	 */
	@Override
	public String execute(){		
		//查询是否有超级超级管理员，如果没有则进入超级管理员注册页面
		MasterDAO masterDao = new MasterDAO();
		if(masterDao.findAll().size() == 0){
			return INPUT;
		}else
			return SUCCESS;
	}
}
