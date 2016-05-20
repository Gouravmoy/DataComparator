package test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import dao.QueryDao;
import daoImpl.QueryDaoImpl;
import entity.ColumnMeta;
import entity.QueryEntity;

public class QueryDAOTest extends TestCase {
	QueryEntity queryEntity;
	ColumnMeta columnMeta;
	QueryDao queryDao = new QueryDaoImpl();

	public void setUp() {
		try {
			super.setUp();
			columnMeta = new ColumnMeta("", "", null, null, null);
			String l = "-21474836480";
			Long l1 = Long.parseLong(l);
			columnMeta.setIdColumnMeta(l1);
			queryEntity = new QueryEntity(columnMeta, null, "", "", null, "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testAddQuery() {
		try {
			queryDao.addQuery(queryEntity);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

	@Test
	public void testgetAllDatabaseInDB() {
		List<QueryEntity> queryEntities;
		try {
			queryEntities = queryDao.getAllQueries();
			assertTrue(queryEntities.size() > 0);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	@Test
	public void testgetDatabaseByid() {
		QueryEntity queryEntity;
		Long Id = new Long(2);
		try {
			queryEntity = queryDao.getQueryByID(Id);
			assertNotNull(queryEntity);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	@Test
	public void testGetByColumnId() {
		List<QueryEntity> queryEntities;
		try {
			String l = "-21474830480";
			Long cId = Long.parseLong(l);
			queryEntities = queryDao.getQueryByCMId(cId);
			assertTrue(queryEntities.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
