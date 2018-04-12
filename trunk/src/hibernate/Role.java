package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer roleid;
	private String name;
	private String des;
	private Set masters = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String name) {
		this.name = name;
	}

	/** full constructor */
	public Role(String name, String des, Set masters, Set users) {
		this.name = name;
		this.des = des;
		this.masters = masters;
		this.users = users;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set getMasters() {
		return this.masters;
	}

	public void setMasters(Set masters) {
		this.masters = masters;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}