package serviceImpl;

import java.util.List;

import dao.GenericDAO;
import dao.QueryDao;
import daoImpl.GenericDAOImpl;
import daoImpl.QueryDaoImpl;
import entity.ColumnMeta;
import entity.QueryEntity;
import service.QueryService;

public class QueryServiceImpl implements QueryService {
	QueryDao queryDao;
	GenericDAO<ColumnMeta, Long> gD = new GenericDAOImpl<ColumnMeta, Long>();

	@Override
	public void addQuery(Long cId, String type) {
		queryDao = new QueryDaoImpl();
		QueryEntity queryEntity = new QueryEntity();
		ColumnMeta c = gD.getFirstRecord(ColumnMeta.class);
		queryEntity.setQueryColumnMeta(c);
		queryDao.addQuery(queryEntity);

	}

	@Override
	public List<QueryEntity> getAllQuries() {
		queryDao = new QueryDaoImpl();
		return queryDao.getAllQueries();
	}

	@Override
	public QueryEntity getQueryByID(Long qId) {
		queryDao = new QueryDaoImpl();
		return queryDao.getQueryByID(qId);
	}

	@Override
	public QueryEntity updateQueryEntity(Long qId, QueryEntity queryEntity) {
		queryDao = new QueryDaoImpl();
		return queryDao.updateQuery(qId, queryEntity);
	}

}
