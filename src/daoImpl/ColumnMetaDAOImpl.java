package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.ColumnMetaDao;
import entity.ColumnMeta;
import exceptions.DAOException;
import exceptions.EntityAlreadyExists;
import exceptions.EntityNotPresent;
import exceptions.ReadEntityException;

public class ColumnMetaDAOImpl extends GenericDAOImpl<ColumnMeta, Long>
		implements ColumnMetaDao {
	static final Logger logger = Logger.getLogger(ColumnMetaDAOImpl.class);

	@Override
	public void saveColumnMeta(ColumnMeta columnMeta) throws DAOException {
		List<String> colMetanames;
		try {
			colMetanames = getColumnMetaNames();
			if (colMetanames.contains(columnMeta.getColumnMetaName())) {
				throw new EntityAlreadyExists("Column Meta wit Name - "
						+ columnMeta.getColumnMetaName() + " Already Exists");
			}
			save(columnMeta);
		} catch (ReadEntityException | EntityAlreadyExists e) {
			logger.error(e);
			throw new DAOException("Could not Persist Column Data - "
					+ e.getMessage(), e);
		}

	}

	@Override
	public ColumnMeta getColumnMetaById(Long id) throws DAOException {
		try {
			return readById(ColumnMeta.class, id);
		} catch (Exception err) {
			logger.error(err);
			throw new DAOException("Could not get ColumnMeta Data for ID - "
					+ id);
		}
	}

	@Override
	public List<ColumnMeta> getAllColumnMetas() throws DAOException {
		List<ColumnMeta> columnMetas;
		try {
			columnMetas = readAll("ColumnMeta.finadAll", ColumnMeta.class);
		} catch (Exception err) {
			logger.error(err);
			throw new DAOException("Could not get All ColumnMeta Information");
		}
		return columnMetas;
	}

	@Override
	public void updateColumnMeta(Long id, ColumnMeta newColumnMeta)
			throws DAOException {
		try {
			update(ColumnMeta.class, id, newColumnMeta);
		} catch (EntityNotPresent e) {
			logger.error(e);
			throw new DAOException("Entity to be updated not present in DB", e);
		}
	}

	@Override
	public void removeColumnMeta(Long id) throws DAOException {
		try {
			delete(ColumnMeta.class, id);
		} catch (Exception err) {
			logger.error(err);
			throw new DAOException("Column Meta Could not be Removed", err);
		}
	}

	@Override
	public List<String> getColumnMetaNames() throws ReadEntityException {
		List<ColumnMeta> columnMetas;
		List<String> colMetaNames;
		colMetaNames = new ArrayList<>();
		try {
			columnMetas = getAllColumnMetas();
			for (ColumnMeta columnMeta : columnMetas) {
				colMetaNames.add(columnMeta.getColumnMetaName());
			}
		} catch (Exception err) {
			logger.error(err);
			throw new ReadEntityException(
					"Could not get All ColMeta Information");
		}
		return colMetaNames;
	}

}
