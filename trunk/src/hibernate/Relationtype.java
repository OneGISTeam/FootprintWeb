package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Relationtype entity. @author MyEclipse Persistence Tools
 */

public class Relationtype implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String typename;
	private Set eventrelations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Relationtype() {
	}

	/** minimal constructor */
	public Relationtype(String typename) {
		this.typename = typename;
	}

	/** full constructor */
	public Relationtype(String typename, Set eventrelations) {
		this.typename = typename;
		this.eventrelations = eventrelations;
	}

	// Property accessors

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Set getEventrelations() {
		return this.eventrelations;
	}

	public void setEventrelations(Set eventrelations) {
		this.eventrelations = eventrelations;
	}

}