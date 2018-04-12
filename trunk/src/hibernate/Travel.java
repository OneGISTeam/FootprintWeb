package hibernate;

/**
 * Travel entity. @author MyEclipse Persistence Tools
 */

public class Travel implements java.io.Serializable {

	// Fields

	private Integer travelid;
	private Hierarchy hierarchy;
	private User user;
	private Eventobject eventobject;
	private String travelname;
	private String des;

	// Constructors

	/** default constructor */
	public Travel() {
	}

	/** minimal constructor */
	public Travel(Hierarchy hierarchy, User user, String travelname) {
		this.hierarchy = hierarchy;
		this.user = user;
		this.travelname = travelname;
	}

	/** full constructor */
	public Travel(Hierarchy hierarchy, User user, Eventobject eventobject,
			String travelname, String des) {
		this.hierarchy = hierarchy;
		this.user = user;
		this.eventobject = eventobject;
		this.travelname = travelname;
		this.des = des;
	}

	// Property accessors

	public Integer getTravelid() {
		return this.travelid;
	}

	public void setTravelid(Integer travelid) {
		this.travelid = travelid;
	}

	public Hierarchy getHierarchy() {
		return this.hierarchy;
	}

	public void setHierarchy(Hierarchy hierarchy) {
		this.hierarchy = hierarchy;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Eventobject getEventobject() {
		return this.eventobject;
	}

	public void setEventobject(Eventobject eventobject) {
		this.eventobject = eventobject;
	}

	public String getTravelname() {
		return this.travelname;
	}

	public void setTravelname(String travelname) {
		this.travelname = travelname;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}