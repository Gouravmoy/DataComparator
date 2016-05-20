package dao;

import java.util.List;

import entity.LookUpCols;

public interface LookUpColumnDao {

	public void addLookUpQuery(LookUpCols lookUpCols);

	public LookUpCols getLookUpQuriebyID(Long qID);

	public List<LookUpCols> getAllLookUpQueries();

	public LookUpCols updateLookUpquery(Long iD,LookUpCols lookUpCols);

}
