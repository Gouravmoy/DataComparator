package junit;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import dao.ColumnMetaDao;
import daoImpl.ColumnMetaDAOImpl;
import entity.ColumnMeta;
import exceptions.DAOException;
import exceptions.ReadEntityException;

public class ColumnMetaDAOTest extends TestCase {

	Logger logger = Logger.getLogger(ColumnMetaDAOTest.class);

	ColumnMetaDao columnMetaDao = new ColumnMetaDAOImpl();
	ColumnMeta saveColumnMeta;
	ColumnMeta ColumnMetaByIdColumnMeta;
	ColumnMeta updateColumnMeta;
	ColumnMeta removeTest;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		saveColumnMeta = new ColumnMeta("colMeta2001", "A,B,C", "|");
		ColumnMetaByIdColumnMeta = new ColumnMeta("colMeta2011", "A,B,C", "|");
		updateColumnMeta = new ColumnMeta("updateTest2021", "P,Q,R", "|");
		removeTest = new ColumnMeta("colMeta2031", "R,E,M,O,V,E", "%");
	}

	@Test
	public void testsaveColumnMeta() {
		logger.info("Trying to save ColumnMeta - " + saveColumnMeta);
		try {
			columnMetaDao.saveColumnMeta(saveColumnMeta);
			assertTrue(true);
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testgetColumnMetaById() {
		logger.info("Trying to getColumnMetaById ColumnMeta - "
				+ ColumnMetaByIdColumnMeta);
		try {
			columnMetaDao.saveColumnMeta(ColumnMetaByIdColumnMeta);
			ColumnMeta retrivedColumnMeta = columnMetaDao
					.getColumnMetaById(ColumnMetaByIdColumnMeta
							.getIdColumnMeta());
			assertEquals(ColumnMetaByIdColumnMeta.getColumnMetaName(),
					retrivedColumnMeta.getColumnMetaName());
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testgetAllColumnMetas() {
		logger.info("Trying to All ColumnMeta ");
		List<ColumnMeta> columnMetas;
		try {
			columnMetas = columnMetaDao.getAllColumnMetas();
			for (ColumnMeta columnMeta : columnMetas)
				logger.debug(columnMeta);
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testupdateColumnMeta() {
		try {
			columnMetaDao.saveColumnMeta(updateColumnMeta);
			updateColumnMeta.setSeparator("$");
			columnMetaDao.updateColumnMeta(updateColumnMeta.getIdColumnMeta(),
					updateColumnMeta);
			ColumnMeta newColMeta = columnMetaDao
					.getColumnMetaById(updateColumnMeta.getIdColumnMeta());
			assertEquals("$", newColMeta.getSeparator());
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testRemoveColumnMeta() {
		Long deletedId;
		try {
			columnMetaDao.saveColumnMeta(removeTest);
			deletedId = removeTest.getIdColumnMeta();
			columnMetaDao.removeColumnMeta(deletedId);
			assertNull(columnMetaDao.getColumnMetaById(deletedId));
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testgetColumnMetaNames() {
		List<String> colMetaNames;
		try {
			colMetaNames = columnMetaDao.getColumnMetaNames();
			assertTrue(true);
			for (String colMetaName : colMetaNames)
				logger.debug(colMetaName);
		} catch (ReadEntityException e) {
			logger.error(e);
			assertTrue(false);
		}
	}
}
