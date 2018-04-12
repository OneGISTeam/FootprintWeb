package hibernate;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Eventrelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.Eventrelation
 * @author MyEclipse Persistence Tools
 */
public class EventrelationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EventrelationDAO.class);

	// property constants

	public void save(Eventrelation transientInstance) {
		log.debug("saving Eventrelation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Eventrelation persistentInstance) {
		log.debug("deleting Eventrelation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Eventrelation findById(hibernate.EventrelationId id) {
		log.debug("getting Eventrelation instance with id: " + id);
		try {
			Eventrelation instance = (Eventrelation) getSession().get(
					"hibernate.Eventrelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Eventrelation instance) {
		log.debug("finding Eventrelation instance by example");
		try {
			List results = getSession()
					.createCriteria("hibernate.Eventrelation")
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
		log.debug("finding Eventrelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Eventrelation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Eventrelation instances");
		try {
			String queryString = "from Eventrelation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Eventrelation merge(Eventrelation detachedInstance) {
		log.debug("merging Eventrelation instance");
		try {
			Eventrelation result = (Eventrelation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Eventrelation instance) {
		log.debug("attaching dirty Eventrelation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Eventrelation instance) {
		log.debug("attaching clean Eventrelation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}