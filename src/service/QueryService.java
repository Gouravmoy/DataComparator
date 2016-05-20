package service;

import java.util.ArrayList;
import java.util.List;

import entity.QueryEntity;

public interface QueryService {

	void addQuery(Long cId, QueryEntity queryEntity);

	List<QueryEntity> getAllQuries();

	QueryEntity getQueryByID(Long qId);

	QueryEntity updateQueryEntity(Long qId, QueryEntity queryEntity);

	ArrayList<String> getQueryByName();

	List<QueryEntity> getQueryByColumnId(Long cID);

}
