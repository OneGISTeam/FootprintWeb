package hibernate;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Eventform entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.Eventform
 * @author MyEclipse Persistence Tools
 */
public class EventformDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EventformDAO.class);
	// property constants
	public static final String DATA = "data";
	public static final String SRSID = "srsid";

	public void save(Eventform transientInstance) {
		log.debug("saving Eventform instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Eventform persistentInstance) {
		log.debug("deleting Eventform instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Eventform findById(java.lang.Long id) {
		log.debug("getting Eventform instance with id: " + id);
		try {
			Eventform instance = (Eventform) getSession().get(
					"hibernate.Eventform", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Eventform instance) {
		log.debug("finding Eventform instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Eventform")
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
		log.debug("finding Eventform instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Eventform as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByData(Object data) {
		return findByProperty(DATA, data);
	}

	public List findBySrsid(Object srsid) {
		return findByProperty(SRSID, srsid);
	}

	public List findAll() {
		log.debug("finding all Eventform instances");
		try {
			String queryString = "from Eventform";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Eventform merge(Eventform detachedInstance) {
		log.debug("merging Eventform instance");
		try {
			Eventform result = (Eventform) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Eventform instance) {
		log.debug("attaching dirty Eventform instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Eventform instance) {
		log.debug("attaching clean Eventform instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}