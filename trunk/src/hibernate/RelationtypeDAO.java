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
 * Relationtype entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hibernate.Relationtype
 * @author MyEclipse Persistence Tools
 */
public class RelationtypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RelationtypeDAO.class);
	// property constants
	public static final String TYPENAME = "typename";

	public void save(Relationtype transientInstance) {
		log.debug("saving Relationtype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Relationtype persistentInstance) {
		log.debug("deleting Relationtype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Relationtype findById(java.lang.Integer id) {
		log.debug("getting Relationtype instance with id: " + id);
		try {
			Relationtype instance = (Relationtype) getSession().get(
					"hibernate.Relationtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Relationtype instance) {
		log.debug("finding Relationtype instance by example");
		try {
			List results = getSession()
					.createCriteria("hibernate.Relationtype")
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
		log.debug("finding Relationtype instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Relationtype as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTypename(Object typename) {
		return findByProperty(TYPENAME, typename);
	}

	public List findAll() {
		log.debug("finding all Relationtype instances");
		try {
			String queryString = "from Relationtype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Relationtype merge(Relationtype detachedInstance) {
		log.debug("merging Relationtype instance");
		try {
			Relationtype result = (Relationtype) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Relationtype instance) {
		log.debug("attaching dirty Relationtype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Relationtype instance) {
		log.debug("attaching clean Relationtype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}