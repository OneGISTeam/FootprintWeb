package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Formdatatype entity. @author MyEclipse Persistence Tools
 */

public class Formdatatype implements java.io.Serializable {

	// Fields

	private String typeid;
	private String typename;
	private Set eventforms = new HashSet(0);

	// Constructors

	/** default constructor */
	public Formdatatype() {
	}

	/** minimal constructor */
	public Formdatatype(String typename) {
		this.typename = typename;
	}

	/** full constructor */
	public Formdatatype(String typename, Set eventforms) {
		this.typename = typename;
		this.eventforms = eventforms;
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

	public Set getEventforms() {
		return this.eventforms;
	}

	public void setEventforms(Set eventforms) {
		this.eventforms = eventforms;
	}

}