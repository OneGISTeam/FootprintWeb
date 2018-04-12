package hibernate;

/**
 * Eventattr entity. @author MyEclipse Persistence Tools
 */

public class Eventattr implements java.io.Serializable {

	// Fields

	private Long attrid;
	private Eventobject eventobject;
	private Fieldtype fieldtype;
	private String attrname;
	private String value;

	// Constructors

	/** default constructor */
	public Eventattr() {
	}

	/** minimal constructor */
	public Eventattr(String attrname) {
		this.attrname = attrname;
	}

	/** full constructor */
	public Eventattr(Eventobject eventobject, Fieldtype fieldtype,
			String attrname, String value) {
		this.eventobject = eventobject;
		this.fieldtype = fieldtype;
		this.attrname = attrname;
		this.value = value;
	}

	// Property accessors

	public Long getAttrid() {
		return this.attrid;
	}

	public void setAttrid(Long attrid) {
		this.attrid = attrid;
	}

	public Eventobject getEventobject() {
		return this.eventobject;
	}

	public void setEventobject(Eventobject eventobject) {
		this.eventobject = eventobject;
	}

	public Fieldtype getFieldtype() {
		return this.fieldtype;
	}

	public void setFieldtype(Fieldtype fieldtype) {
		this.fieldtype = fieldtype;
	}

	public String getAttrname() {
		return this.attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}