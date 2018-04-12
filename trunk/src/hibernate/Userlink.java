package hibernate;

import java.sql.Timestamp;

/**
 * Userlink entity. @author MyEclipse Persistence Tools
 */

public class Userlink implements java.io.Serializable {

	// Fields

	private UserlinkId id;
	private Timestamp linktime;

	// Constructors

	/** default constructor */
	public Userlink() {
	}

	/** full constructor */
	public Userlink(UserlinkId id, Timestamp linktime) {
		this.id = id;
		this.linktime = linktime;
	}

	// Property accessors

	public UserlinkId getId() {
		return this.id;
	}

	public void setId(UserlinkId id) {
		this.id = id;
	}

	public Timestamp getLinktime() {
		return this.linktime;
	}

	public void setLinktime(Timestamp linktime) {
		this.linktime = linktime;
	}

}