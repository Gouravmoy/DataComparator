package dao;

import java.io.Serializable;
import java.util.List;

import exceptions.EntityNotPresent;

public interface GenericDAO<T, ID extends Serializable> {

	public T save(T t);

	public List<T> readAll(String namedQueryName,
			@SuppressWarnings("rawtypes") Class clazz);

	public T readById(@SuppressWarnings("rawtypes") Class clazz, ID id);

	public T update(@SuppressWarnings("rawtypes") Class clazz, ID id, T t)
			throws EntityNotPresent;

	public void delete(@SuppressWarnings("rawtypes") Class clazz, ID removeId);

	public List<T> getByQuery(String query, Object[] pars, @SuppressWarnings("rawtypes") Class clzz);

	public boolean isEntityExists(@SuppressWarnings("rawtypes") Class clazz,
			ID id);

	T getFirstRecord(Class<?> clazz);

}
