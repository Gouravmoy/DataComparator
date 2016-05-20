package test;

import java.util.List;

import org.junit.Test;

import dao.LookUpColumnDao;
import daoImpl.LookUpQueryDaoImpl;
import entity.ColumnMeta;
import entity.LookUpCols;
import entity.QueryEntity;
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
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testgetAllDatabaseInDB() {
		List<LookUpCols> lookUpCols;
		try {
			lookUpCols = lookUpColumnDao.getAllLookUpQueries();
			assertTrue(lookUpCols.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

	@Test
	public void testgetDatabaseByid() {
		LookUpCols lookUpCols;
		Long Id = new Long(601);
		try {
			lookUpCols = lookUpColumnDao.getLookUpQuriebyID(Id);
			assertNotNull(lookUpCols);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

}
