package daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import dao.FileDAO;
import entity.ColumnMeta;
import entity.Files;
import exceptions.DAOException;
import exceptions.EntityAlreadyExists;
import exceptions.EntityNotPresent;
import exceptions.ReadEntityException;

public class FileDAOImpl extends GenericDAOImpl<Files, Long> implements FileDAO {
	static final Logger logger = Logger.getLogger(FileDAOImpl.class);

	@Override
	public void saveFile(Files file) throws DAOException {
		List<String> fileNames;
		try {
			fileNames = getAllFilesnames();
			if (fileNames.contains(file.getFileName())) {
				throw new EntityAlreadyExists("File with Name - "
						+ file.getFileName() + " Already Exists");
			}
			save(file);
		} catch (ReadEntityException | EntityAlreadyExists e) {
			logger.error(e);
			throw new DAOException("Could not Persist File Data - "
					+ e.getMessage(), e);
		}
	}

	@Override
	public Files getFilesById(Long id) throws DAOException {
		try {
			return readById(Files.class, id);
		} catch (Exception err) {
			logger.error(err);
			throw new DAOException("Could not get Files Data for ID - " + id);
		}
	}

	@Override
	public List<Files> getAllFiles() throws DAOException {
		List<Files> files;
		try {
			files = readAll("Files.finadAll", Files.class);
		} catch (Exception err) {
			logger.error(err);
			throw new DAOException("Could not get All Files Information");
		}
		return files;
	}

	@Override
	public void updateFiles(Long id, Files file) throws DAOException {
		try {
			update(Files.class, id, file);
		} catch (EntityNotPresent e) {
			logger.error(e);
			throw new DAOException("Filese to be updated not present in DB", e);
		}
	}

	@Override
	public void removeFiles(long id) throws DAOException {
		try {
			delete(ColumnMeta.class, id);
		} catch (Exception err) {
			logger.error(err);
			throw new DAOException("File Could not be Removed", err);
		}
	}

	@Override
	public List<String> getAllFilesnames() throws DAOException {
		List<Files> files;
		List<String> fileNames;
		fileNames = new ArrayList<>();
		try {
			files = getAllFiles();
			for (Files file : files) {
				fileNames.add(file.getFileName());
			}
		} catch (Exception err) {
			logger.error(err);
			throw new ReadEntityException("Could not get All Files Information");
		}
		return fileNames;
	}
}
