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
 * Fieldtype entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hibernate.Fieldtype
 * @author MyEclipse Persistence Tools
 */
public class FieldtypeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FieldtypeDAO.class);
	// property constants
	public static final String TYPENAME = "typename";

	public void save(Fieldtype transientInstance) {
		log.debug("saving Fieldtype instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Fieldtype persistentInstance) {
		log.debug("deleting Fieldtype instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Fieldtype findById(java.lang.String id) {
		log.debug("getting Fieldtype instance with id: " + id);
		try {
			Fieldtype instance = (Fieldtype) getSession().get(
					"hibernate.Fieldtype", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Fieldtype instance) {
		log.debug("finding Fieldtype instance by example");
		try {
			List results = getSession().createCriteria("hibernate.Fieldtype")
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
		log.debug("finding Fieldtype instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Fieldtype as model where model."
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
		log.debug("finding all Fieldtype instances");
		try {
			String queryString = "from Fieldtype";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Fieldtype merge(Fieldtype detachedInstance) {
		log.debug("merging Fieldtype instance");
		try {
			Fieldtype result = (Fieldtype) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Fieldtype instance) {
		log.debug("attaching dirty Fieldtype instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Fieldtype instance) {
		log.debug("attaching clean Fieldtype instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}