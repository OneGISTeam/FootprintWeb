package actions.master;

import org.hibernate.Transaction;

import actions.DaoActionSupport;
import hibernate.Master;
import hibernate.MasterDAO;
import hibernate.Role;
import hibernate.RoleDAO;

public class MasterInfo extends DaoActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getPassword(){
		return this.password;
	}

	/*
	 * 超级管理员注册
	 */
	public String Register() throws Exception {
		
		if(!name.isEmpty() && !password.isEmpty()){
			MasterDAO dao = new MasterDAO();
			//如果存在同名超管用户，则返回错误
			if(dao.findById(name) != null){
				this.setMessage("已存在:" + name);
				return ERROR;
			}
			
			RoleDAO roleDao = new RoleDAO();
			Role masterRole = roleDao.findById(1);
			
			Master master = new Master(name, masterRole, password);
			
			Transaction tx = dao.getSession().beginTransaction();
			dao.save(master);
			tx.commit();
			
			return SUCCESS;
		}else{
			this.setMessage("用户名或密码不可以为空!");
			return ERROR;
		}
			
	}

	/*
	 * 超级管理员注销
	 */
	public String Delete() throws Exception{
		
		return SUCCESS;
	}
	
	/*
	 * 超级管理员登录
	 */
	public String login(){
		RoleDAO roleDao = new RoleDAO();
		Role masterRole = roleDao.findById(1);
		//构造master
		Master master = new Master(this.getName(), masterRole, this.getPassword());
		MasterDAO masterDao = new MasterDAO();
		
		if(masterDao.findByExample(master).size() == 0){
			this.setMessage("用户名或密码错误！");
			return ERROR;
		}else 
			return SUCCESS;
	}
}
