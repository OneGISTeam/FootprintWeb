package hibernate;

/**
 * Master entity. @author MyEclipse Persistence Tools
 */

public class Master implements java.io.Serializable {

	// Fields

	private String name;
	private Role role;
	private String password;

	// Constructors

	/** default constructor */
	public Master() {
	}

	/** minimal constructor */
	public Master(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public Master(String name, Role role, String password) {
		this.name = name;
		this.role = role;
		this.password = password;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}