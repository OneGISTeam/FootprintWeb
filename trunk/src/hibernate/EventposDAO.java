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
 * Eventpos entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.Eventpos
 * @author MyEclipse Persistence Tools
 */
public class EventposDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EventposDAO.class);
	// property constants
	public static final String X = "x";
	public static final String Y = "y";

	public void save(Eventpos transientInstance) {
		log.debug("saving Eventpos instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Eventpos persistentInstance) {
		log.debug("deleting Eventpos instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Eventpos findById(java.lang.Integer id) {
		log.debug("getting Eventpos instance with id: " + id);
		try {
			Eventpos instance = (Eventpos) getSession().get(
					"hibernate.Eventpos", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Eventpos instance) {
		log.debug("finding Eventpos instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Eventpos")
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
		log.debug("finding Eventpos instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Eventpos as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByX(Object x) {
		return findByProperty(X, x);
	}

	public List findByY(Object y) {
		return findByProperty(Y, y);
	}

	public List findAll() {
		log.debug("finding all Eventpos instances");
		try {
			String queryString = "from Eventpos";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Eventpos merge(Eventpos detachedInstance) {
		log.debug("merging Eventpos instance");
		try {
			Eventpos result = (Eventpos) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Eventpos instance) {
		log.debug("attaching dirty Eventpos instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Eventpos instance) {
		log.debug("attaching clean Eventpos instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}