package dao;

import java.util.List;

import entity.ColumnMeta;
import exceptions.DAOException;
import exceptions.ReadEntityException;

public interface ColumnMetaDao {

	public void saveColumnMeta(ColumnMeta columnMeta) throws DAOException;

	public ColumnMeta getColumnMetaById(Long id) throws DAOException;

	public List<ColumnMeta> getAllColumnMetas() throws DAOException;

	public void updateColumnMeta(Long id, ColumnMeta newColumnMeta)
			throws DAOException;

	public void removeColumnMeta(Long id);

	public List<String> getColumnMetaNames() throws ReadEntityException;
}
