package hibernate;

import java.util.HashSet;
import java.util.Set;

/**
 * Hierarchy entity. @author MyEclipse Persistence Tools
 */

public class Hierarchy implements java.io.Serializable {

	// Fields

	private Integer hierachyid;
	private String hierachyname;
	private Integer hierarchydepth;
	private String hierarchyinfo;
	private Set travels = new HashSet(0);

	// Constructors

	/** default constructor */
	public Hierarchy() {
	}

	/** minimal constructor */
	public Hierarchy(String hierachyname, Integer hierarchydepth,
			String hierarchyinfo) {
		this.hierachyname = hierachyname;
		this.hierarchydepth = hierarchydepth;
		this.hierarchyinfo = hierarchyinfo;
	}

	/** full constructor */
	public Hierarchy(String hierachyname, Integer hierarchydepth,
			String hierarchyinfo, Set travels) {
		this.hierachyname = hierachyname;
		this.hierarchydepth = hierarchydepth;
		this.hierarchyinfo = hierarchyinfo;
		this.travels = travels;
	}

	// Property accessors

	public Integer getHierachyid() {
		return this.hierachyid;
	}

	public void setHierachyid(Integer hierachyid) {
		this.hierachyid = hierachyid;
	}

	public String getHierachyname() {
		return this.hierachyname;
	}

	public void setHierachyname(String hierachyname) {
		this.hierachyname = hierachyname;
	}

	public Integer getHierarchydepth() {
		return this.hierarchydepth;
	}

	public void setHierarchydepth(Integer hierarchydepth) {
		this.hierarchydepth = hierarchydepth;
	}

	public String getHierarchyinfo() {
		return this.hierarchyinfo;
	}

	public void setHierarchyinfo(String hierarchyinfo) {
		this.hierarchyinfo = hierarchyinfo;
	}

	public Set getTravels() {
		return this.travels;
	}

	public void setTravels(Set travels) {
		this.travels = travels;
	}

}