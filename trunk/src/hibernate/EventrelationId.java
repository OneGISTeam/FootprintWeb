package hibernate;

/**
 * EventrelationId entity. @author MyEclipse Persistence Tools
 */

public class EventrelationId implements java.io.Serializable {

	// Fields

	private Eventobject eventobject;
	private Eventobject eventobject_1;

	// Constructors

	/** default constructor */
	public EventrelationId() {
	}

	/** full constructor */
	public EventrelationId(Eventobject eventobject, Eventobject eventobject_1) {
		this.eventobject = eventobject;
		this.eventobject_1 = eventobject_1;
	}

	// Property accessors

	public Eventobject getEventobject() {
		return this.eventobject;
	}

	public void setEventobject(Eventobject eventobject) {
		this.eventobject = eventobject;
	}

	public Eventobject getEventobject_1() {
		return this.eventobject_1;
	}

	public void setEventobject_1(Eventobject eventobject_1) {
		this.eventobject_1 = eventobject_1;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EventrelationId))
			return false;
		EventrelationId castOther = (EventrelationId) other;

		return ((this.getEventobject() == castOther.getEventobject()) || (this
				.getEventobject() != null && castOther.getEventobject() != null && this
				.getEventobject().equals(castOther.getEventobject())))
				&& ((this.getEventobject_1() == castOther.getEventobject_1()) || (this
						.getEventobject_1() != null
						&& castOther.getEventobject_1() != null && this
						.getEventobject_1()
						.equals(castOther.getEventobject_1())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getEventobject() == null ? 0 : this.getEventobject()
						.hashCode());
		result = 37
				* result
				+ (getEventobject_1() == null ? 0 : this.getEventobject_1()
						.hashCode());
		return result;
	}

}