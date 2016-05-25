package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import dao.LookUpColumnDao;
import daoImpl.LookUpQueryDaoImpl;
import service.LookUpQueryService;
import entity.LookUpCols;
import exceptions.PersistException;
import exceptions.ServiceException;

public class LookUpQueryServiceImpl implements LookUpQueryService {

	LookUpColumnDao lookUpDao;

	@Override
	public void addQuery(LookUpCols lookUpCols) throws ServiceException {
		try {
			lookUpDao = new LookUpQueryDaoImpl();
			lookUpDao.addLookUpQuery(lookUpCols);
		} catch (PersistException e) {
			throw new ServiceException();
		}
	}

	@Override
	public List<LookUpCols> getQueryByColumnId(Long Id) throws ServiceException {
		return null;
		
	}

	@Override
	public ArrayList<String> getQueryNameByColumnId(Long Id)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LookUpCols updateQueryEntity(Long qId, LookUpCols lookUpCols)
			throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}
}
