package hibernate;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userid;
	private Role role;
	private String name;
	private String password;
	private Blob portrait;
	private Boolean sex;
	private Set userlinksForSponsorid = new HashSet(0);
	private Set userlinksForReceiverid = new HashSet(0);
	private Set travels = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Role role, String name, String password) {
		this.role = role;
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public User(Role role, String name, String password, Blob portrait,
			Boolean sex, Set userlinksForSponsorid, Set userlinksForReceiverid,
			Set travels) {
		this.role = role;
		this.name = name;
		this.password = password;
		this.portrait = portrait;
		this.sex = sex;
		this.userlinksForSponsorid = userlinksForSponsorid;
		this.userlinksForReceiverid = userlinksForReceiverid;
		this.travels = travels;
	}

	// Property accessors

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Blob getPortrait() {
		return this.portrait;
	}

	public void setPortrait(Blob portrait) {
		this.portrait = portrait;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Set getUserlinksForSponsorid() {
		return this.userlinksForSponsorid;
	}

	public void setUserlinksForSponsorid(Set userlinksForSponsorid) {
		this.userlinksForSponsorid = userlinksForSponsorid;
	}

	public Set getUserlinksForReceiverid() {
		return this.userlinksForReceiverid;
	}

	public void setUserlinksForReceiverid(Set userlinksForReceiverid) {
		this.userlinksForReceiverid = userlinksForReceiverid;
	}

	public Set getTravels() {
		return this.travels;
	}

	public void setTravels(Set travels) {
		this.travels = travels;
	}

}