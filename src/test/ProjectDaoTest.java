package test;

import junit.framework.TestCase;
import dao.ProjectDao;
import daoImpl.ProjectDaoImpl;
import entity.ColumnMeta;
import entity.Project;
import exceptions.PersistException;
import exceptions.ReadEntityException;

public class ProjectDaoTest extends TestCase {

	ProjectDao projectDao = new ProjectDaoImpl();
	ColumnMeta columnMeta;
	Project project;
	Long id;

	@Override
	protected void setUp() throws Exception {
		String Id = "301";
		id = Long.parseLong(Id);
		super.setUp();
		columnMeta = new ColumnMeta();
		project = new Project();
	}

	public void testAddProject() {
		try {
			projectDao.addProject(project);
			assertTrue(true);
		} catch (PersistException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public void testGetProjectById() {
		try {
			Project p = projectDao.getProjectByID(id);
			assertTrue(!p.equals(null));
		} catch (ReadEntityException e) {
			fail();
			e.printStackTrace();
		}
	}

	public void testGetAllProject() {
		try {
			assertTrue(projectDao.getAllProjects().size() > 0);
		} catch (ReadEntityException e) {
			fail();
			e.printStackTrace();
		}
	}

}
