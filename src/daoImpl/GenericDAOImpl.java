package daoImpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

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

	@Override
	public List<T> readAll(Class clazz) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(clazz);
		// return entityManager.createQuery(cq).getResultList();
		System.out.println(this.entityManager.createQuery(
				"select r from Database r").getResultList());
		
		return null;

	}

	@Override
	public T readById(ID id) {
		return null;
	}

	@Override
	public T update(T t) {
		return null;
	}

	@Override
	public void delete(T t) {

	}

}
