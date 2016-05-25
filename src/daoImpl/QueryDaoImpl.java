package daoImpl;

import java.util.List;

import javax.persistence.PersistenceException;

import dao.QueryDao;
import entity.QueryEntity;
import exceptions.EntityNotPresent;
import exceptions.PersistException;
import exceptions.ReadEntityException;

public class QueryDaoImpl extends GenericDAOImpl<QueryEntity, Long> implements
		QueryDao {

	@Override
	public void addQuery(QueryEntity queryEntity) throws PersistException {
		try {
			save(queryEntity);
		} catch (PersistenceException p) {
			throw new PersistException();
		}
	}

	@Override
	public List<QueryEntity> getAllQueries() throws ReadEntityException {
		try {
			return readAll("QueryEntity.finadAll", QueryEntity.class);
		} catch (Exception e) {
			throw new ReadEntityException();
		}
	}

	@Override
	public QueryEntity getQueryByID(Long qId) throws EntityNotPresent {
		try {
			return readById(QueryEntity.class, qId);
		} catch (Exception e) {
			throw new EntityNotPresent();
		}
	}

	@Override
	public QueryEntity updateQuery(Long qId, QueryEntity queryEntity)
			throws EntityNotPresent {
		try {
			return update(QueryEntity.class, qId, queryEntity);
		} catch (Exception e) {
			throw new EntityNotPresent();
		}
	}

	@Override
	public List<QueryEntity> getQueryByCMId(Long cId) throws EntityNotPresent {
		try {
			String queryExecute = "SELECT q FROM QueryEntity q where q.queryColumnMeta.idColumnMeta=:arg0";
			Object[] pars = { cId };
			return getByQuery(queryExecute, pars, QueryEntity.class);
		} catch (Exception e) {
			throw new EntityNotPresent();
		}
	}
}
