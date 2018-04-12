package hibernate;

/**
 * Eventrelation entity. @author MyEclipse Persistence Tools
 */

public class Eventrelation implements java.io.Serializable {

	// Fields

	private EventrelationId id;
	private Relationtype relationtype;

	// Constructors

	/** default constructor */
	public Eventrelation() {
	}

	/** minimal constructor */
	public Eventrelation(EventrelationId id) {
		this.id = id;
	}

	/** full constructor */
	public Eventrelation(EventrelationId id, Relationtype relationtype) {
		this.id = id;
		this.relationtype = relationtype;
	}

	// Property accessors

	public EventrelationId getId() {
		return this.id;
	}

	public void setId(EventrelationId id) {
		this.id = id;
	}

	public Relationtype getRelationtype() {
		return this.relationtype;
	}

	public void setRelationtype(Relationtype relationtype) {
		this.relationtype = relationtype;
	}

}