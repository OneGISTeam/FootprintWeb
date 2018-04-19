package actions.master;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
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
		//获取session对象，当session为空时不要创建新的session
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if(session == null){
			this.setMessage("会话过期，请重新登陆！");
			return ERROR;
		}
		
		RoleDAO roleDao = new RoleDAO();
		Role masterRole = roleDao.findById(1);
		Master master = null;
		MasterDAO masterDao = new MasterDAO();
		//如果session中存在name，则说明已登录
		if(session.getAttribute("name") != null){
			//从session中取出master的登陆信息
			String name = (String)session.getAttribute("name");
			String password = (String)session.getAttribute("password");
			master = new Master(name, masterRole, password);
			
		}else{//如果未登陆，则需要获取从页面传输的登陆信息
			master = new Master(this.getName(), masterRole, this.getPassword());
		}
		
		@SuppressWarnings("unchecked")
		List<Master> masters = masterDao.findByExample(master);
		if(masters.size() == 0){
			this.setMessage("用户名或密码错误！");
			return ERROR;
		}else{
			//将登陆信息存储至session
			session.setAttribute("name", masters.get(0).getName());
			session.setAttribute("password", masters.get(0).getPassword());
			return SUCCESS;
		}
	}
}
