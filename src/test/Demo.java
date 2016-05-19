package test;

import org.apache.log4j.Logger;

import dao.DatabaseDao;
import dao.GenericDAO;
import daoImpl.DatabaseDAOImpl;
import daoImpl.GenericDAOImpl;
import entity.ColumnMeta;
import entity.DBTypes;
import entity.Database;
import exceptions.PersistException;

public class Demo {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger("Main");
		Database db = new Database("DB1", "sName", "U", "P", "P", DBTypes.MYSQL);
		logger.info("Inserting Entity " + db);

		DatabaseDao databaseDao = new DatabaseDAOImpl();
		try {
			databaseDao.saveDatabse(db);
		} catch (PersistException e) {
			logger.error(e);
		}

		ColumnMeta columnMeta = new ColumnMeta();
		columnMeta.setColNames("C");
		columnMeta.setSeparator("|");
		GenericDAO<ColumnMeta, Long> dao1 = new GenericDAOImpl<ColumnMeta, Long>();
		dao1.save(columnMeta);

	}
}
