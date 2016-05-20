package dao;

import java.util.List;

import entity.QueryEntity;

public interface QueryDao {

	void addQuery(QueryEntity queryEntity);

	List<QueryEntity> getAllQueries();

	QueryEntity getQueryByID(Long qId);
	
	QueryEntity updateQuery(Long qId,QueryEntity queryEntity);
}
