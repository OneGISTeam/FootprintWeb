package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Eventobject entity. @author MyEclipse Persistence Tools
 */

public class Eventobject implements java.io.Serializable {

	// Fields

	private Long objectid;
	private Eventpos eventpos;
	private String name;
	private Long pobjectid;
	private String srsid;
	private Set eventforms = new HashSet(0);
	private Set eventattrs = new HashSet(0);
	private Set eventrelationsForEndobjectid = new HashSet(0);
	private Set travels = new HashSet(0);
	private Set eventrelationsForFromobjectid = new HashSet(0);

	// Constructors

	/** default constructor */
	public Eventobject() {
	}

	/** minimal constructor */
	public Eventobject(String name) {
		this.name = name;
	}

	/** full constructor */
	public Eventobject(Eventpos eventpos, String name, Long pobjectid,
			String srsid, Set eventforms, Set eventattrs,
			Set eventrelationsForEndobjectid, Set travels,
			Set eventrelationsForFromobjectid) {
		this.eventpos = eventpos;
		this.name = name;
		this.pobjectid = pobjectid;
		this.srsid = srsid;
		this.eventforms = eventforms;
		this.eventattrs = eventattrs;
		this.eventrelationsForEndobjectid = eventrelationsForEndobjectid;
		this.travels = travels;
		this.eventrelationsForFromobjectid = eventrelationsForFromobjectid;
	}

	// Property accessors

	public Long getObjectid() {
		return this.objectid;
	}

	public void setObjectid(Long objectid) {
		this.objectid = objectid;
	}

	public Eventpos getEventpos() {
		return this.eventpos;
	}

	public void setEventpos(Eventpos eventpos) {
		this.eventpos = eventpos;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPobjectid() {
		return this.pobjectid;
	}

	public void setPobjectid(Long pobjectid) {
		this.pobjectid = pobjectid;
	}

	public String getSrsid() {
		return this.srsid;
	}

	public void setSrsid(String srsid) {
		this.srsid = srsid;
	}

	public Set getEventforms() {
		return this.eventforms;
	}

	public void setEventforms(Set eventforms) {
		this.eventforms = eventforms;
	}

	public Set getEventattrs() {
		return this.eventattrs;
	}

	public void setEventattrs(Set eventattrs) {
		this.eventattrs = eventattrs;
	}

	public Set getEventrelationsForEndobjectid() {
		return this.eventrelationsForEndobjectid;
	}

	public void setEventrelationsForEndobjectid(Set eventrelationsForEndobjectid) {
		this.eventrelationsForEndobjectid = eventrelationsForEndobjectid;
	}

	public Set getTravels() {
		return this.travels;
	}

	public void setTravels(Set travels) {
		this.travels = travels;
	}

	public Set getEventrelationsForFromobjectid() {
		return this.eventrelationsForFromobjectid;
	}

	public void setEventrelationsForFromobjectid(
			Set eventrelationsForFromobjectid) {
		this.eventrelationsForFromobjectid = eventrelationsForFromobjectid;
	}

}