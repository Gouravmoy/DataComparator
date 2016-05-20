package daoImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import dao.GenericDAO;

public class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected EntityTransaction entityTransaction;

	public GenericDAOImpl() {
		super();
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("persistenceUnit");
		this.entityManager = factory.createEntityManager();
		entityTransaction = this.entityManager.getTransaction();

	}

	@Override
	public T save(T t) {
		entityTransaction.begin();
		entityManager.persist(t);
		entityManager.flush();
		entityTransaction.commit();
		return t;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> readAll(Class clazz) {
		entityTransaction.begin();
		Session session = entityManager.unwrap(Session.class);
		Criteria queryCriteria = session.createCriteria(clazz);
		List<T> t = (List<T>) queryCriteria.list();
		entityTransaction.commit();
		return t;

	}

	@SuppressWarnings("unchecked")
	@Override
	public T readById(@SuppressWarnings("rawtypes") Class clazz, ID id) {
		entityTransaction.begin();
		T t = (T) entityManager.find(clazz, id);
		entityTransaction.commit();
		return t;
	}

	@Override
	public T update(@SuppressWarnings("rawtypes") Class clazz, ID id, T updated) {
		save(updated);
		return updated;
	}

	@Override
	public void delete(T t) {

	}

	@SuppressWarnings("unchecked")
	@Override
	public T getFirstRecord(Class<?> clazz) {
		entityTransaction.begin();
		Session session = entityManager.unwrap(Session.class);
		Criteria queryCriteria = session.createCriteria(clazz);
		queryCriteria.setFirstResult(0);
		queryCriteria.setMaxResults(1);
		T t = (T) queryCriteria.list().get(0);
		entityTransaction.commit();
		return t;

	}
}
