package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Fieldtype entity. @author MyEclipse Persistence Tools
 */

public class Fieldtype implements java.io.Serializable {

	// Fields

	private String typeid;
	private String typename;
	private Set eventattrs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Fieldtype() {
	}

	/** minimal constructor */
	public Fieldtype(String typename) {
		this.typename = typename;
	}

	/** full constructor */
	public Fieldtype(String typename, Set eventattrs) {
		this.typename = typename;
		this.eventattrs = eventattrs;
	}

	// Property accessors

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Set getEventattrs() {
		return this.eventattrs;
	}

	public void setEventattrs(Set eventattrs) {
		this.eventattrs = eventattrs;
	}

}