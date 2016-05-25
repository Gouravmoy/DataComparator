package junit;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

import dao.ColumnMetaDao;
import dao.FileDAO;
import daoImpl.ColumnMetaDAOImpl;
import daoImpl.FileDAOImpl;
import entity.ColumnMeta;
import entity.FileTypes;
import entity.Files;
import exceptions.DAOException;

public class FileDAOTest extends TestCase {

	Logger logger = Logger.getLogger(FileDAOTest.class);
	FileDAO fileDao = new FileDAOImpl();
	ColumnMetaDao metaDao = new ColumnMetaDAOImpl();
	Files savefile;
	Files getFileIdfile;
	Files updatefile;
	Files removeFile;
	ColumnMeta colMeta;
	ColumnMeta getByIdColMeta;
	ColumnMeta updateColMeta;
	ColumnMeta newUpdateColMeta;
	ColumnMeta removeColMeta;

	@Override
	protected void setUp() throws Exception {
		colMeta = new ColumnMeta("colMeta2", "S,H,E,R", ",");
		getByIdColMeta = new ColumnMeta("colMeta3333", "S,H,E,R,L,O,C,K", ",");
		updateColMeta = new ColumnMeta("colMeta44", "S,H,E,R,L,O,C,K, ,H", ",");
		newUpdateColMeta = new ColumnMeta("colMeta444",
				"S,H,E,R,L,O,C,K, ,H,O,L,M,E,S", ",");
		removeColMeta = new ColumnMeta("removeColMeta33",
				"S,H,E,R,L,O,C,K, ,H,O,L,M,E,S", ",");
		savefile = new Files(FileTypes.TXT, "File2");
		getFileIdfile = new Files(FileTypes.TXT, "File3333");
		updatefile = new Files(FileTypes.TXT, "File44");
		removeFile = new Files(FileTypes.TXT, "RemoveFile33");
		super.setUp();
	}

	@Test
	public void testsaveFile() {
		try {
			metaDao.saveColumnMeta(colMeta);
			savefile.setFileColumnMeta(colMeta);
			fileDao.saveFile(savefile);
			assertTrue(true);
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testgetFilesById() {
		try {
			metaDao.saveColumnMeta(getByIdColMeta);
			getFileIdfile.setFileColumnMeta(getByIdColMeta);
			fileDao.saveFile(getFileIdfile);
			assertNotNull(fileDao.getFilesById(getFileIdfile.getFileId()));
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testgetAllFiles() {
		List<Files> files;
		try {
			files = fileDao.getAllFiles();
			logger.debug("Executing Get All Files");
			for (Files file : files)
				logger.debug(file.getFileId().toString() + " - "
						+ file.getFileName() + " - Col Meta ID - "
						+ file.getFileColumnMeta().getIdColumnMeta().toString()
						+ " - " + file.getFileColumnMeta().getColumnMetaName());
			assertTrue(files.size() > 0);
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testupdateFiles() {
		try {
			metaDao.saveColumnMeta(updateColMeta);
			updatefile.setFileColumnMeta(updateColMeta);
			fileDao.saveFile(updatefile);
			updatefile.setFileName("NEW_UPDATED");
			updatefile.setFileTypes(FileTypes.CSV);
			metaDao.saveColumnMeta(newUpdateColMeta);
			updatefile.setFileColumnMeta(newUpdateColMeta);
			fileDao.updateFiles(updatefile.getFileId(), updatefile);
			assertTrue(true);
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		}
	}

	@Test
	public void testremoveFiles() {
		Long id;
		try {
			metaDao.saveColumnMeta(removeColMeta);
			removeFile.setFileColumnMeta(removeColMeta);
			fileDao.saveFile(removeFile);
			id = removeFile.getFileId();
			fileDao.removeFiles(id);
			assertNull(fileDao.getFilesById(id));
		} catch (DAOException e) {
			logger.error(e);
			assertTrue(false);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
}
