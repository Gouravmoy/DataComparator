package daoImpl;

import java.util.List;

import dao.LookUpColumnDao;
import entity.LookUpCols;
import exceptions.EntityNotPresent;

public class LookUpQueryDaoImpl extends GenericDAOImpl<LookUpCols, Long>
		implements LookUpColumnDao {

	@Override
	public void addLookUpQuery(LookUpCols lookUpCols) {
		save(lookUpCols);
	}

	@Override
	public LookUpCols getLookUpQuriebyID(Long qID) {
		return readById(LookUpCols.class, qID);
	}

	@Override
	public List<LookUpCols> getAllLookUpQueries() {
		return readAll("LookUpCols.finadAll", LookUpCols.class);
	}

	@Override
	public LookUpCols updateLookUpquery(Long id, LookUpCols lookUpCols) {
		try {
			return update(LookUpCols.class, id, lookUpCols);
		} catch (EntityNotPresent e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lookUpCols;
	}

}
