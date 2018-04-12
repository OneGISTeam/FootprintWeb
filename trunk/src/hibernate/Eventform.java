package hibernate;

/**
 * Eventform entity. @author MyEclipse Persistence Tools
 */

public class Eventform implements java.io.Serializable {

	// Fields

	private Long formid;
	private Formdatatype formdatatype;
	private Eventobject eventobject;
	private String data;
	private String srsid;

	// Constructors

	/** default constructor */
	public Eventform() {
	}

	/** minimal constructor */
	public Eventform(Formdatatype formdatatype, String srsid) {
		this.formdatatype = formdatatype;
		this.srsid = srsid;
	}

	/** full constructor */
	public Eventform(Formdatatype formdatatype, Eventobject eventobject,
			String data, String srsid) {
		this.formdatatype = formdatatype;
		this.eventobject = eventobject;
		this.data = data;
		this.srsid = srsid;
	}

	// Property accessors

	public Long getFormid() {
		return this.formid;
	}

	public void setFormid(Long formid) {
		this.formid = formid;
	}

	public Formdatatype getFormdatatype() {
		return this.formdatatype;
	}

	public void setFormdatatype(Formdatatype formdatatype) {
		this.formdatatype = formdatatype;
	}

	public Eventobject getEventobject() {
		return this.eventobject;
	}

	public void setEventobject(Eventobject eventobject) {
		this.eventobject = eventobject;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSrsid() {
		return this.srsid;
	}

	public void setSrsid(String srsid) {
		this.srsid = srsid;
	}

}