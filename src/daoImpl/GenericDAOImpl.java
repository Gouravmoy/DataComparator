package daoImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dao.GenericDAO;
import exceptions.EntityNotPresent;

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
	public List<T> readAll(String namedQueryName, Class clazz) {
		TypedQuery<T> query = entityManager.createNamedQuery(namedQueryName,
				clazz);
		return query.getResultList();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> getByQuery(String queryString) {
		entityTransaction.begin();
		Query query = entityManager.createQuery(queryString);
		List results = query.getResultList();
		entityTransaction.commit();
		return results;
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
	public T update(@SuppressWarnings("rawtypes") Class clazz, ID id, T updated)
			throws EntityNotPresent {
		if (isEntityExists(clazz, id)) {
			entityManager.merge(updated);
			return updated;
		} else {
			throw new EntityNotPresent(
					"Entity Not found, So Could not be updated");
		}

	}

	@Override
	public void delete(@SuppressWarnings("rawtypes") Class clazz, ID removeId) {

		if (isEntityExists(clazz, removeId)) {
			T old = readById(clazz, removeId);
			entityTransaction.begin();
			entityManager.remove(old);
			entityTransaction.commit();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isEntityExists(@SuppressWarnings("rawtypes") Class clazz,
			ID id) {
		return entityManager.find(clazz, id) != null;
	}

}
