package hibernate;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Hierarchy entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.Hierarchy
 * @author MyEclipse Persistence Tools
 */
public class HierarchyDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(HierarchyDAO.class);
	// property constants
	public static final String HIERACHYNAME = "hierachyname";
	public static final String HIERARCHYDEPTH = "hierarchydepth";
	public static final String HIERARCHYINFO = "hierarchyinfo";

	public void save(Hierarchy transientInstance) {
		log.debug("saving Hierarchy instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Hierarchy persistentInstance) {
		log.debug("deleting Hierarchy instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Hierarchy findById(java.lang.Integer id) {
		log.debug("getting Hierarchy instance with id: " + id);
		try {
			Hierarchy instance = (Hierarchy) getSession().get(
					"hibernate.Hierarchy", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Hierarchy instance) {
		log.debug("finding Hierarchy instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Hierarchy")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Hierarchy instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Hierarchy as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHierachyname(Object hierachyname) {
		return findByProperty(HIERACHYNAME, hierachyname);
	}

	public List findByHierarchydepth(Object hierarchydepth) {
		return findByProperty(HIERARCHYDEPTH, hierarchydepth);
	}

	public List findByHierarchyinfo(Object hierarchyinfo) {
		return findByProperty(HIERARCHYINFO, hierarchyinfo);
	}

	public List findAll() {
		log.debug("finding all Hierarchy instances");
		try {
			String queryString = "from Hierarchy";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Hierarchy merge(Hierarchy detachedInstance) {
		log.debug("merging Hierarchy instance");
		try {
			Hierarchy result = (Hierarchy) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Hierarchy instance) {
		log.debug("attaching dirty Hierarchy instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Hierarchy instance) {
		log.debug("attaching clean Hierarchy instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}