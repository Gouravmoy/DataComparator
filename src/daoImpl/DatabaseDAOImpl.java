package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.DatabaseDao;
import entity.Database;
import exceptions.EntityAlreadyExists;
import exceptions.PersistException;
import exceptions.ReadEntityException;

public class DatabaseDAOImpl extends GenericDAOImpl<Database, Long> implements
		DatabaseDao {

	Logger logger = Logger.getLogger(getClass());

	@Override
	public void saveDatabse(Database databse) throws PersistException {
		try {
			List<String> dbNames = getAllDBNames();
			if (dbNames.contains(databse.getDatabaseName())) {
				throw new EntityAlreadyExists("Database - "
						+ databse.getDatabaseName()
						+ " already exists in the databse");
			}
			save(databse);
		} catch (Exception err) {
			logger.error(err);
			throw new PersistException("Could not persist Database Data - "
					+ databse);
		}
	}

	@Override
	public Database getDatabaseByid(Long id) throws ReadEntityException {
		try {
			return readById(Database.class, id);
		} catch (Exception err) {
			logger.error(err);
			throw new ReadEntityException(
					"Could not get Database Data for ID - " + id);
		}
	}

	@Override
	public List<Database> getAllDatabaseinDB() throws ReadEntityException {
		List<Database> databases;
		try {
			databases = readAll("Database.finadAll", Database.class);
		} catch (Exception err) {
			logger.error(err);
			throw new ReadEntityException(
					"Could not get All Database Information");
		}
		return databases;
	}

	@Override
	public List<String> getAllDBNames() throws ReadEntityException {
		List<Database> databases;
		List<String> dbNames;
		dbNames = new ArrayList<>();
		try {
			databases = getAllDatabaseinDB();
			for (Database database : databases) {
				dbNames.add(database.getDatabaseName());
			}
		} catch (Exception err) {
			logger.error(err);
			throw new ReadEntityException(
					"Could not get All Database Information");
		}
		return dbNames;
	}

}
