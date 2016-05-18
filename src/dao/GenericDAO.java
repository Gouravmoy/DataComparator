package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	public T save(T t);

	public List<T> readAll(Class clazz);

	public T readById(ID id);

	public T update(T t);

	public void delete(T t);

}
