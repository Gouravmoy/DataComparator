package dao;

import java.util.List;

import entity.Files;
import exceptions.DAOException;

public interface FileDAO {

	public void saveFile(Files file) throws DAOException;

	public Files getFilesById(Long id) throws DAOException;

	public List<Files> getAllFiles() throws DAOException;

	public void updateFiles(Long id, Files file) throws DAOException;

	public void removeFiles(long id) throws DAOException;

	public List<String> getAllFilesnames() throws DAOException;

}
