package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Eventpos entity. @author MyEclipse Persistence Tools
 */

public class Eventpos implements java.io.Serializable {

	// Fields

	private Integer posid;
	private Double x;
	private Double y;
	private Set eventobjects = new HashSet(0);

	// Constructors

	/** default constructor */
	public Eventpos() {
	}

	/** minimal constructor */
	public Eventpos(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	/** full constructor */
	public Eventpos(Double x, Double y, Set eventobjects) {
		this.x = x;
		this.y = y;
		this.eventobjects = eventobjects;
	}

	// Property accessors

	public Integer getPosid() {
		return this.posid;
	}

	public void setPosid(Integer posid) {
		this.posid = posid;
	}

	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Set getEventobjects() {
		return this.eventobjects;
	}

	public void setEventobjects(Set eventobjects) {
		this.eventobjects = eventobjects;
	}

}