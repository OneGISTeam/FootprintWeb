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
 * Eventobject entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.Eventobject
 * @author MyEclipse Persistence Tools
 */
public class EventobjectDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EventobjectDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String POBJECTID = "pobjectid";
	public static final String SRSID = "srsid";

	public void save(Eventobject transientInstance) {
		log.debug("saving Eventobject instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Eventobject persistentInstance) {
		log.debug("deleting Eventobject instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Eventobject findById(java.lang.Long id) {
		log.debug("getting Eventobject instance with id: " + id);
		try {
			Eventobject instance = (Eventobject) getSession().get(
					"hibernate.Eventobject", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Eventobject instance) {
		log.debug("finding Eventobject instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Eventobject")
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
		log.debug("finding Eventobject instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Eventobject as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPobjectid(Object pobjectid) {
		return findByProperty(POBJECTID, pobjectid);
	}

	public List findBySrsid(Object srsid) {
		return findByProperty(SRSID, srsid);
	}

	public List findAll() {
		log.debug("finding all Eventobject instances");
		try {
			String queryString = "from Eventobject";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Eventobject merge(Eventobject detachedInstance) {
		log.debug("merging Eventobject instance");
		try {
			Eventobject result = (Eventobject) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Eventobject instance) {
		log.debug("attaching dirty Eventobject instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Eventobject instance) {
		log.debug("attaching clean Eventobject instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}