package test;

import java.util.List;

import org.junit.Test;

import dao.LookUpColumnDao;
import daoImpl.LookUpQueryDaoImpl;
import entity.ColumnMeta;
import entity.LookUpCols;
import entity.QueryEntity;
import exceptions.EntityNotPresent;
import exceptions.PersistException;
import exceptions.ReadEntityException;
import junit.framework.TestCase;

public class LookUpQueryDaoTest extends TestCase {
	ColumnMeta columnMeta;
	QueryEntity queryEntity;
	LookUpCols lookUpCols;
	LookUpColumnDao lookUpColumnDao = new LookUpQueryDaoImpl();

	public void setUp() {
		try {
			super.setUp();
			columnMeta = new ColumnMeta("", "", null, null, null);
			String l = "-21474836480";
			Long l1 = Long.parseLong(l);
			columnMeta.setIdColumnMeta(l1);
			queryEntity = new QueryEntity(columnMeta, null, "", "", null, "");
			queryEntity.setQueryId((long) 2);
			lookUpCols = new LookUpCols(queryEntity, "", "");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testAddQuery() {
		try {
			lookUpColumnDao.addLookUpQuery(lookUpCols);
			assertTrue(true);
		} catch (PersistException e) {
			assertTrue(false);
			e.printStackTrace();
		}

	}

	@Test
	public void testgetAllQueryInDB() {
		List<LookUpCols> lookUpCols;
		try {
			lookUpCols = lookUpColumnDao.getAllLookUpQueries();
			assertTrue(lookUpCols.size() > 0);
		} catch (ReadEntityException e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

	@Test
	public void testgetQueryByID() {
		LookUpCols lookUpCols;
		Long Id = new Long(601);
		try {
			lookUpCols = lookUpColumnDao.getLookUpQuriebyID(Id);
			assertNotNull(lookUpCols);
		} catch (EntityNotPresent e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

}
