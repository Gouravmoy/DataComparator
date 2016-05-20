package service;

import java.util.List;

import entity.QueryEntity;

public interface QueryService {

	void addQuery(Long cId, String type);

	List<QueryEntity> getAllQuries();

	QueryEntity getQueryByID(Long qId);

	QueryEntity updateQueryEntity(Long qId, QueryEntity queryEntity);

}
