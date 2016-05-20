package daoImpl;

import java.util.List;

import dao.QueryDao;
import entity.QueryEntity;
import exceptions.EntityNotPresent;

public class QueryDaoImpl extends GenericDAOImpl<QueryEntity, Long> implements
		QueryDao {

	@Override
	public void addQuery(QueryEntity queryEntity) {
		save(queryEntity);
	}

	@Override
	public List<QueryEntity> getAllQueries() {
		return readAll("QueryEntity.finadAll", QueryEntity.class);
	}

	@Override
	public QueryEntity getQueryByID(Long qId) {

		return readById(QueryEntity.class, qId);
	}

	@Override
	public QueryEntity updateQuery(Long qId, QueryEntity queryEntity) {
		try {
			return update(QueryEntity.class, qId, queryEntity);
		} catch (EntityNotPresent e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryEntity;
	}

	@Override
	public List<QueryEntity> getQueryByCMId(Long cId) {
		String queryExecute = "SELECT q FROM QueryEntity q where q.queryColumnMeta.idColumnMeta=:arg0";
		Object[] pars = { cId };
		return getByQuery(queryExecute, pars, QueryEntity.class);
	}
}
