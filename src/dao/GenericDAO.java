package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	public T save(T t);

	@SuppressWarnings("rawtypes")
	public List<T> readAll(Class clazz);

	public void delete(T t);

	T readById(Class<?> clazz, ID id);
	
	T getFirstRecord(Class<?> clazz);

	T update(@SuppressWarnings("rawtypes") Class clazz, ID id, T updated) ;

}
