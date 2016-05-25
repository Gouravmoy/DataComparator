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
import exceptions.EntityNotPresent;
import exceptions.PersistException;
import exceptions.ReadEntityException;
import exceptions.ServiceException;

public class QueryServiceImpl implements QueryService {
	QueryDao queryDao;
	GenericDAO<ColumnMeta, Long> gD = new GenericDAOImpl<ColumnMeta, Long>();

	@Override
	public void addQuery(Long cId, QueryEntity queryEntity)
			throws ServiceException {
		try {
			queryDao = new QueryDaoImpl();
			queryEntity.setQueryColumnMeta(gD.readById(ColumnMeta.class, cId));
			queryDao.addQuery(queryEntity);
		} catch (PersistException p) {
			throw new ServiceException();
		}

	}

	@Override
	public List<QueryEntity> getAllQuries() throws ServiceException {
		try {
			queryDao = new QueryDaoImpl();
			return queryDao.getAllQueries();
		} catch (ReadEntityException r) {
			throw new ServiceException();
		}
	}

	@Override
	public QueryEntity getQueryByID(Long qId) throws ServiceException {
		try {
			queryDao = new QueryDaoImpl();
			return queryDao.getQueryByID(qId);
		} catch (EntityNotPresent e) {
			throw new ServiceException();
		}
	}

	@Override
	public QueryEntity updateQueryEntity(Long qId, QueryEntity queryEntity)
			throws ServiceException {
		try {
			queryDao = new QueryDaoImpl();
			return queryDao.updateQuery(qId, queryEntity);
		} catch (EntityNotPresent e) {
			throw new ServiceException();
		}
	}

	@Override
	public ArrayList<String> getQueryByName() throws ServiceException {
		try {
			ArrayList<String> queryStringList = new ArrayList<String>();
			queryDao = new QueryDaoImpl();
			List<QueryEntity> queriesList = queryDao.getAllQueries();
			for (QueryEntity q : queriesList) {
				queryStringList.add(q.getQueryName());
			}
			return queryStringList;
		} catch (ReadEntityException r) {
			throw new ServiceException();
		}
	}

	@Override
	public List<QueryEntity> getQueryByColumnId(Long cID)
			throws ServiceException {
		try {
			queryDao = new QueryDaoImpl();
			return queryDao.getQueryByCMId(cID);
		} catch (EntityNotPresent e) {
			throw new ServiceException();
		}

	}

}
