package hibernate;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Eventattr entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.Eventattr
 * @author MyEclipse Persistence Tools
 */
public class EventattrDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EventattrDAO.class);
	// property constants
	public static final String ATTRNAME = "attrname";
	public static final String VALUE = "value";

	public void save(Eventattr transientInstance) {
		log.debug("saving Eventattr instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Eventattr persistentInstance) {
		log.debug("deleting Eventattr instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Eventattr findById(java.lang.Long id) {
		log.debug("getting Eventattr instance with id: " + id);
		try {
			Eventattr instance = (Eventattr) getSession().get(
					"hibernate.Eventattr", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Eventattr instance) {
		log.debug("finding Eventattr instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Eventattr")
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
		log.debug("finding Eventattr instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Eventattr as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAttrname(Object attrname) {
		return findByProperty(ATTRNAME, attrname);
	}

	public List findByValue(Object value) {
		return findByProperty(VALUE, value);
	}

	public List findAll() {
		log.debug("finding all Eventattr instances");
		try {
			String queryString = "from Eventattr";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Eventattr merge(Eventattr detachedInstance) {
		log.debug("merging Eventattr instance");
		try {
			Eventattr result = (Eventattr) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Eventattr instance) {
		log.debug("attaching dirty Eventattr instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Eventattr instance) {
		log.debug("attaching clean Eventattr instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}