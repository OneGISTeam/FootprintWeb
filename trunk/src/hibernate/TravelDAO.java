package hibernate;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Travel entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.Travel
 * @author MyEclipse Persistence Tools
 */
public class TravelDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TravelDAO.class);
	// property constants
	public static final String TRAVELNAME = "travelname";
	public static final String DES = "des";

	public void save(Travel transientInstance) {
		log.debug("saving Travel instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Travel persistentInstance) {
		log.debug("deleting Travel instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Travel findById(java.lang.Integer id) {
		log.debug("getting Travel instance with id: " + id);
		try {
			Travel instance = (Travel) getSession().get("hibernate.Travel", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Travel instance) {
		log.debug("finding Travel instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Travel")
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
		log.debug("finding Travel instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Travel as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTravelname(Object travelname) {
		return findByProperty(TRAVELNAME, travelname);
	}

	public List findByDes(Object des) {
		return findByProperty(DES, des);
	}

	public List findAll() {
		log.debug("finding all Travel instances");
		try {
			String queryString = "from Travel";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Travel merge(Travel detachedInstance) {
		log.debug("merging Travel instance");
		try {
			Travel result = (Travel) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Travel instance) {
		log.debug("attaching dirty Travel instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Travel instance) {
		log.debug("attaching clean Travel instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}