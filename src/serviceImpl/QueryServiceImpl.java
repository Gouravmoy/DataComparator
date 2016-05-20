package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import service.QueryService;
import dao.GenericDAO;
import dao.QueryDao;
import daoImpl.GenericDAOImpl;
import daoImpl.QueryDaoImpl;
import entity.ColumnMeta;
import entity.QueryEntity;

public class QueryServiceImpl implements QueryService {
	QueryDao queryDao;
	GenericDAO<ColumnMeta, Long> gD = new GenericDAOImpl<ColumnMeta, Long>();

	@Override
	public void addQuery(Long cId, QueryEntity queryEntity) {
		queryDao = new QueryDaoImpl();
		queryEntity.setQueryColumnMeta(gD.readById(ColumnMeta.class, cId));
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

	@Override
	public ArrayList<String> getQueryByName() {
		ArrayList<String> queryStringList = new ArrayList<String>();
		queryDao = new QueryDaoImpl();
		List<QueryEntity> queriesList = queryDao.getAllQueries();
		for (QueryEntity q : queriesList) {
			queryStringList.add(q.getQueryName());
		}
		return queryStringList;
	}

	@Override
	public List<QueryEntity> getQueryByColumnId(Long cID) {
		queryDao = new QueryDaoImpl();
		return queryDao.getQueryByCMId(cID);
	}

}
