package daoImpl;

import java.util.List;

import dao.QueryDao;
import entity.QueryEntity;

public class QueryDaoImpl extends GenericDAOImpl<QueryEntity, Long> implements
		QueryDao {

	@Override
	public void addQuery(QueryEntity queryEntity) {
		save(queryEntity);
	}

	@Override
	public List<QueryEntity> getAllQueries() {
		return readAll(QueryEntity.class);
	}

	@Override
	public QueryEntity getQueryByID(Long qId) {

		return readById(QueryEntity.class, qId);
	}

	@Override
	public QueryEntity updateQuery(Long qId, QueryEntity queryEntity) {
		return update(QueryEntity.class, qId, queryEntity);
	}

}
