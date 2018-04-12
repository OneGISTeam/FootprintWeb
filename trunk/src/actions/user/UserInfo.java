package actions.user;

import hibernate.Role;
import hibernate.RoleDAO;
import hibernate.User;
import hibernate.UserDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;

import actions.DaoActionSupport;

public class UserInfo extends DaoActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户名
	private String name; 
	//密码
	private String password;
	//性别 true:男性, false:女性
	private Boolean sex; 
	//表单映射的文件字段
	private File portrait;
	//struts2文件上传时提供的属性
	private String portraitFileName;
	//文件上传的MIME类型
	private String portraitContentType;
	
	
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
	
	public void setSex(Boolean sex){
		this.sex = sex;
	}
	
	public Boolean getSex(){
		return this.sex;
	}
	
	public File getPortrait(){
		return this.portrait;
	}
	
	public void setPortrait(File portrait){
		this.portrait = portrait;
	}
	
	public String getPortraitFileName(){
		return this.portraitFileName;
	}
	
	public void setPortraitFileName(String portraitFileName){
		this.portraitFileName = portraitFileName;
	}
	
	public String getPortraitContentType(){
		return this.portraitContentType;
	}
	
	public void setPortraitContentType(String portraitContentType){
		this.portraitContentType = portraitContentType;
	}
	
	/*
	 * 用户注册操作
	 */
	public String Register() throws Exception{
		//查询普通用户角色
		RoleDAO roleDao = new RoleDAO();
		Role role = roleDao.findById(3);
		
		//构造user
		User user = new User(role, this.name, this.password);
		user.setSex(this.sex);
		UserDAO userDao = new UserDAO();
		
		//如果存在用户则输出错误信息，并返回错误页面
		if(userDao.findByName(this.name).size() > 0){
			this.setMessage("已存在用户：" + this.name);
			return ERROR;
		}
		
		try{
			//将文件流转为blob存储到user的portrait字段中
			InputStream iStream = new FileInputStream(this.portrait);
			Blob portrait = Hibernate.getLobCreator(userDao.getSession()).createBlob(iStream, iStream.available());
			user.setPortrait(portrait);
			
			Transaction tx = userDao.getSession().beginTransaction();
			userDao.save(user);
			tx.commit();
			
		}catch(Exception e){
			throw e;
		}
		
		return SUCCESS;
	}
	
	//用户登录操作
	public String login(){
		UserDAO userDao = new UserDAO();
		List<User> result = userDao.findByName(this.name);
		//如果查询结果为空，则说明用户不存在
		if(result.size() == 0){
			this.setMessage("不存在用户：" + this.name);
			return ERROR;
		}else{
			//在查询结果中对比密码
			for(int i=0; i<result.size(); i++){
				if(result.get(i).getPassword().equals(this.password)){
					return SUCCESS;
				}
			}
			this.setMessage("用户名为" + this.name + "的密码输入不正确!");
			return ERROR;
		}
	}
	
}
