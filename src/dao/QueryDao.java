package dao;

import java.util.List;

import entity.QueryEntity;
import exceptions.EntityNotPresent;
import exceptions.PersistException;
import exceptions.ReadEntityException;

public interface QueryDao {

	void addQuery(QueryEntity queryEntity) throws PersistException;

	List<QueryEntity> getAllQueries() throws ReadEntityException;

	QueryEntity getQueryByID(Long qId) throws EntityNotPresent;

	QueryEntity updateQuery(Long qId, QueryEntity queryEntity)
			throws EntityNotPresent;

	List<QueryEntity> getQueryByCMId(Long cId) throws EntityNotPresent;

}
